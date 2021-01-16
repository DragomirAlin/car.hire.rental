package ro.agilehub.javacourse.car.hire.rental.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.ResponseEntity;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.CarDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.UserDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.service.domain.RentalDO;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class, UserDTOMapper.class, CarDTOMapper.class})
public interface RentalDOMapper {

    @Mapping(target = "id", source = "rental._id")
    @Mapping(target = "startDate", source = "rental.startDate")
    @Mapping(target = "endDate", source = "rental.endDate")
    @Mapping(target = "userDO", source = "userDTO")
    @Mapping(target = "carDO", source = "carDTO")
    RentalDO toRentalDO(Rental rental, UserResponseDTO userDTO, CarResponseDTO carDTO);


    @Mapping(target = "_id", source = "rentalDO.id")
    @Mapping(target = "startDate", source = "rentalDO.startDate")
    @Mapping(target = "endDate", source = "rentalDO.endDate")
    @Mapping(target = "user_id", source = "rentalDO.userDO.id")
    @Mapping(target = "car_id", source = "rentalDO.carDO.id")
    Rental toRental(RentalDO rentalDO);
}
