package ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper;

import com.github.fge.jsonpatch.JsonPatch;
import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.JsonPatchDTO;

@Mapper(componentModel = "spring")
public interface JsonPatchDTOMapper {

    JsonPatch toJsonPatch(JsonPatchDTO jsonPatchDTO);
}
