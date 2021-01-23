package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.rental.service.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.UserManager;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultRentalService implements RentalService {
    private final UserManager userManager;
    private final CarManager carManager;
    private final RentalManager rentalManager;

    @Override
    public String addRental(RentalDO rentalDO) {
        userManager.getUser(rentalDO.getUserDO());
        carManager.getCar(rentalDO.getCarDO());

        return rentalManager.addRental(rentalDO);
    }

    @Override
    public void removeRental(String id) {
        rentalManager.deleteById(id);
    }

    @Override
    public RentalDO getById(String id) {
        return rentalManager.getById(id);
    }

    @Override
    public List<RentalDO> getAll() {
        return rentalManager.getAll();
    }

    @Override
    public RentalDO updateRental(String id, List<JsonPatch> jsonPatch) throws JsonPatchException, JsonProcessingException {
        return rentalManager.update(id, jsonPatch);
    }
}
