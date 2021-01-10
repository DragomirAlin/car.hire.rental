package ro.agilehub.javacourse.car.hire.rental.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.service.mapper.ObjectIdMapper;


@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class, UserDTOMapper.class,
        CarDTOMapper.class, UserDTOMapper.class, CarDTOMapper.class})
public interface RentalDTOMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startDate", source = "rentalDTO.startDate")
    @Mapping(target = "endDate", source = "rentalDTO.endDate")
    @Mapping(target = "userDO", source = "user")
    @Mapping(target = "carDO", source = "car")
    RentalDO toRentalDO(RentalDTO rentalDTO, CarDO car, UserDO user);

    @Mapping(target = "id", source = "rentalDO.id")
    @Mapping(target = "startDate", source = "rentalDO.startDate")
    @Mapping(target = "endDate", source = "rentalDO.endDate")
    @Mapping(target = "user", source = "rentalDO.userDO")
    @Mapping(target = "car", source = "rentalDO.carDO")
    RentalResponseDTO toRentalResponseDTO(RentalDO rentalDO);
}
