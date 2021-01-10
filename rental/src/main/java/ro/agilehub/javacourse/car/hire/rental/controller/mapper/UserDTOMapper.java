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
    @Mapping(target = "title", source = "userDO.title")
    @Mapping(target = "countryofresidence", source = "userDO.countryDO.isoCode")
    UserResponseDTO toUserResponseDTO(UserDO userDO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", source = "userDTO.email")
    @Mapping(target = "username", source = "userDTO.username")
    @Mapping(target = "firstname", source = "userDTO.firstname")
    @Mapping(target = "lastname", source = "userDTO.lastname")
    @Mapping(target = "title", source = "userDTO.title")
    @Mapping(target = "countryDO", source = "countryDO")
    @Mapping(target = "driverlicensenumber", source = "userDTO.driverlicensenumber")
    UserDO toUserDO(UserDTO userDTO, CountryDO countryDO);

}
