package ro.agilehub.javacourse.car.hire.rental.rental.repository.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.RentalManager;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultRentalManager implements RentalManager {
    private final RentalRepository rentalRepository;
    private final RentalDOMapper rentalDOMapper;
    private final ObjectMapper objectMapper;

    @Override
    public String addRental(RentalDO rentalDO) {
        var rental = rentalDOMapper.toRental(rentalDO);
        return rentalRepository.save(rental)
                .get_id()
                .toString();

    }

    @Override
    public RentalDO getById(String id) {
        var rental = rentalRepository.findById(new ObjectId(id));

        if (rental.isEmpty()) {
            // throw
        }

        return rentalDOMapper.toRentalDO(rental.get());
    }

    @Override
    public void deleteById(String id) {
        rentalRepository.findById(new ObjectId(id))
                .ifPresentOrElse(rentalRepository::delete,
                        () -> System.out.println("exception"));
    }

    @Override
    public List<RentalDO> getAll() {
        return rentalRepository.findAll().stream()
                .map(rentalDOMapper::toRentalDO)
                .collect(Collectors.toList());
    }

    @Override
    public RentalDO update(String id, List<JsonPatch> jsonPatch) throws JsonPatchException, JsonProcessingException {
        com.github.fge.jsonpatch.JsonPatch patch = objectMapper.convertValue(jsonPatch, com.github.fge.jsonpatch.JsonPatch.class);
        var rental = rentalRepository.findById(new ObjectId(id)).orElseThrow();

        var rentalPatched = applyPatchToUser(patch, rental);
        rentalPatched.set_id(rental.get_id());

        var rentalUpdated = rentalRepository.save(rentalPatched);
        return rentalDOMapper.toRentalDO(rentalUpdated);
    }

    private Rental applyPatchToUser(com.github.fge.jsonpatch.JsonPatch patch, Rental targetRental) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetRental, JsonNode.class));

        return objectMapper.treeToValue(patched, Rental.class);
    }
}
