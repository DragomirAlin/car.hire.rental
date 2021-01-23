package ro.agilehub.javacourse.car.hire.rental.rental.service.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

import java.util.List;
import java.util.Optional;

public interface RentalManager {
    String addRental(RentalDO rentalDO);
    RentalDO getById(String id);
    void deleteById(String id);
    List<RentalDO> getAll();
    RentalDO update(String id, List<JsonPatch> jsonPatch) throws JsonPatchException, JsonProcessingException;
}
