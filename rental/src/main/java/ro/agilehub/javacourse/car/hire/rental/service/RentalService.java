package ro.agilehub.javacourse.car.hire.rental.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import ro.agilehub.javacourse.car.hire.rental.service.domain.RentalDO;

import java.util.List;

public interface RentalService {

    String addRental(RentalDO rentalDO);
    void removeRental(String id);
    RentalDO findById(String id);
    List<RentalDO> findAll();
    RentalDO updateRental(String id, List<JsonPatch> jsonPatch) throws JsonPatchException, JsonProcessingException;
}
