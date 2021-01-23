package ro.agilehub.javacourse.car.hire.rental.rental.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.rental.api.model.CreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.JsonPatchDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentalApi;
import ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper.JsonPatchDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper.RentalDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.UserManager;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentalApi {
    private final RentalService rentalService;
    private final CarManager carManager;
    private final UserManager userManager;
    private final RentalDTOMapper mapper;
    private final JsonPatchDTOMapper jsonPatchDTOMapper;

    @Override
    public ResponseEntity<CreatedDTO> addRental(@Valid RentalDTO rentalDTO) {
        var rentalDO = map(rentalDTO);
        var rentalID = rentalService.addRental(rentalDO);
        CreatedDTO createdDTO = new CreatedDTO();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdDTO.id(rentalID));
    }

    @Override
    public ResponseEntity<Void> cancelRental(String id) {
        rentalService.removeRental(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<RentalResponseDTO> getRental(String id) {
        var rentalResponseDTO = map(rentalService.getById(id));

        return ResponseEntity.ok(rentalResponseDTO);
    }

    @Override
    public ResponseEntity<List<RentalResponseDTO>> getRentals() {
        var listRentalsReponseDTO = rentalService.getAll()
                .stream()
                .map(this::map)
                .collect(toList());

        return ResponseEntity.ok(listRentalsReponseDTO);
    }

    @Override
    public ResponseEntity<RentalResponseDTO> updateRental(String id, @Valid List<JsonPatchDTO> jsonPatchDTO) {
        List<JsonPatch> jsonPatchList = jsonPatchDTO.stream().map(jsonPatchDTOMapper::toJsonPatch).collect(toList());
        RentalDO rentalDO = null;
        try {
            rentalDO = rentalService.updateRental(id, jsonPatchList);
        } catch (JsonPatchException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .ok()
                .body(map(rentalDO));
    }

    private RentalDO map(RentalDTO rentalDTO) {
        var userDO = userManager.getUser(rentalDTO.getUser());
        var carDO = carManager.getCar(rentalDTO.getCar());

        if (userDO.isEmpty() && carDO.isEmpty()) {
            // throw exception
        }

        return mapper.toRentalDO(rentalDTO, carDO.get(), userDO.get());
    }

    private RentalResponseDTO map(RentalDO rentalDO) {
        var userDO = userManager.getUser(rentalDO.getUserDO());
        var carDO = carManager.getCar(rentalDO.getCarDO());

        return mapper.toRentalResponseDTO(rentalDO, carDO.get(), userDO.get());
    }


}
