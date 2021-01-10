package ro.agilehub.javacourse.car.hire.rental.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.JsonPatchDTO;
import ro.agilehub.javacourse.car.hire.rental.service.model.JsonPatch;

@Mapper(componentModel = "spring")
public interface JsonPatchDTOMapper {

    JsonPatch toJsonPatch(JsonPatchDTO jsonPatchDTO);
}
