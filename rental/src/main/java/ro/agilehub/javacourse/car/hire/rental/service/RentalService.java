package ro.agilehub.javacourse.car.hire.rental.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import ro.agilehub.javacourse.car.hire.rental.service.domain.RentalDO;

import java.util.List;

public interface RentalService {

    String addRent(RentalDO rentalDO);
    void removeRent(String id);
    RentalDO findById(String id);
    List<RentalDO> findAll();
    RentalDO updateRent(String id, List<JsonPatch> jsonPatch) throws JsonPatchException, JsonProcessingException;
}
