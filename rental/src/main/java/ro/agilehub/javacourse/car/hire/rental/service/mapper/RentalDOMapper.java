package ro.agilehub.javacourse.car.hire.rental.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.CarDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.UserDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.service.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.UserDO;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class, UserDTOMapper.class, CarDTOMapper.class})
public interface RentalDOMapper {

    @Mapping(target = "id", source = "rental._id")
    @Mapping(target = "startDate", source = "rental.startDate")
    @Mapping(target = "endDate", source = "rental.endDate")
    @Mapping(target = "userDO", source = "userDO")
    @Mapping(target = "carDO", source = "carDO")
    RentalDO toRentalDO(Rental rental, CarDO carDO, UserDO userDO);

    @Mapping(target = "_id", source = "rentalDO.id")
    @Mapping(target = "startDate", source = "rentalDO.startDate")
    @Mapping(target = "endDate", source = "rentalDO.endDate")
    @Mapping(target = "user_id", source = "rentalDO.userDO.id")
    @Mapping(target = "car_id", source = "rentalDO.carDO.id")
    Rental toRental(RentalDO rentalDO);

}
