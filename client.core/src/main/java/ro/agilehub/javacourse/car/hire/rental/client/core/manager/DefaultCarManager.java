package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.FleetApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.CarManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultCarManager implements CarManager {
    private final FleetApi carApi;
    private final CarDOMapper carDOMapper;

    @Override
    public Optional<CarDO> getCar(String id) {
        var carDTOResponse = carApi.getCar(id);
        var carDO = carDOMapper.toCarDO(carDTOResponse.getBody());

        return Optional.of(carDO);
    }
}
