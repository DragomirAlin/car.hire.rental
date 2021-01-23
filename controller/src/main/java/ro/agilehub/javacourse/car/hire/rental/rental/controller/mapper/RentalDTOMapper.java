package ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.api.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;


@Mapper(componentModel = "spring")
public interface RentalDTOMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startDate", source = "rentalDTO.startDate")
    @Mapping(target = "endDate", source = "rentalDTO.endDate")
    @Mapping(target = "userDO", source = "userDO.id")
    @Mapping(target = "carDO", source = "carDO.id")
    @Mapping(target = "statusDO", source = "rentalDTO.status")
    RentalDO toRentalDO(RentalDTO rentalDTO, CarDO carDO, UserDO userDO);

    @Mapping(target = "id", source = "rentalDO.id")
    @Mapping(target = "startDate", source = "rentalDO.startDate")
    @Mapping(target = "endDate", source = "rentalDO.endDate")
    @Mapping(target = "user", source = "userDO")
    @Mapping(target = "car", source = "carDO")
    @Mapping(target = "status", source = "rentalDO.statusDO")
    RentalResponseDTO toRentalResponseDTO(RentalDO rentalDO, CarDO carDO, UserDO  userDO);
}
