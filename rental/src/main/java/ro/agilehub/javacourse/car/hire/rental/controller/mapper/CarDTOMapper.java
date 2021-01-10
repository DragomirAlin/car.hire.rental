package ro.agilehub.javacourse.car.hire.rental.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.api.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.MakeDO;
import ro.agilehub.javacourse.car.hire.rental.service.mapper.ObjectIdMapper;


@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public interface CarDTOMapper {

    @Mapping(target = "id", source = "carDO.id")
    @Mapping(target = "make", source = "carDO.makeDO.makeName")
    @Mapping(target = "model", source = "carDO.model")
    @Mapping(target = "year", source = "carDO.year")
    @Mapping(target = "mileage", source = "carDO.mileage")
    @Mapping(target = "fuel", source = "carDO.fuel")
    @Mapping(target = "carClazz", source = "carDO.carClazz")
    CarResponseDTO toCarResponseDTO(CarDO carDO);

    @Mapping(target = "makeDO", source = "makeDO")
    @Mapping(target = "model", source = "carDTO.model")
    @Mapping(target = "year", source = "carDTO.year")
    @Mapping(target = "mileage", source = "carDTO.mileage")
    @Mapping(target = "fuel", source = "carDTO.fuel")
    @Mapping(target = "carClazz", source = "carDTO.carClazz")
    CarDO toCarDO(CarDTO carDTO, MakeDO makeDO);

}
