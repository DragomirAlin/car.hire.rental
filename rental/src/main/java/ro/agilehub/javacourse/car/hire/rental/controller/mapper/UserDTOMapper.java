package ro.agilehub.javacourse.car.hire.rental.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.api.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.CountryDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.service.mapper.ObjectIdMapper;


@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public interface UserDTOMapper {


    @Mapping(target = "id", source = "userDO.id")
    @Mapping(target = "email", source = "userDO.email")
    @Mapping(target = "username", source = "userDO.username")
    @Mapping(target = "firstname", source = "userDO.firstname")
    @Mapping(target = "lastname", source = "userDO.lastname")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "driverLicense", source = "userDO.driverLicense")
    @Mapping(target = "status", source = "userDO.status")
    @Mapping(target = "title", source = "userDO.title")
    UserResponseDTO toUserResponseDTO(UserDO userDO);

    @Mapping(target = "id", source = "userDTO.id")
    @Mapping(target = "email", source = "userDTO.email")
    @Mapping(target = "username", source = "userDTO.username")
    @Mapping(target = "firstname", source = "userDTO.firstname")
    @Mapping(target = "lastname", source = "userDTO.lastname")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "driverLicense", source = "userDTO.driverLicense")
    @Mapping(target = "status", source = "userDTO.status")
    @Mapping(target = "title", source = "userDTO.title")
    UserDO toUserDO(UserResponseDTO userDTO);

}
