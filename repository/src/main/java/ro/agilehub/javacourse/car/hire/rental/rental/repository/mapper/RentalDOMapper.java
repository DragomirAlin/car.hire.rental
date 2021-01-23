package ro.agilehub.javacourse.car.hire.rental.rental.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ro.agilehub.javacourse.car.hire.rental.rental.repository.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Mapper(componentModel = "spring", uses = {ObjectIdRentalMapper.class})
public interface RentalDOMapper {

    @Mapping(target = "id", source = "rental._id")
    @Mapping(target = "startDate", source = "rental.startDate")
    @Mapping(target = "endDate", source = "rental.endDate")
    @Mapping(target = "userDO", source = "rental.userId")
    @Mapping(target = "carDO", source = "rental.carId")
    @Mapping(target = "statusDO", source = "rental.status")
    RentalDO toRentalDO(Rental rental);

    @Mapping(target = "_id", source = "rentalDO.id")
    @Mapping(target = "startDate", source = "rentalDO.startDate")
    @Mapping(target = "endDate", source = "rentalDO.endDate")
    @Mapping(target = "userId", source = "rentalDO.userDO")
    @Mapping(target = "carId", source = "rentalDO.carDO")
    @Mapping(target = "status", source = "rentalDO.statusDO")
    Rental toRental(RentalDO rentalDO);

}
