package ro.agilehub.javacourse.car.hire.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ro.agilehub.javacourse.car.hire.rental.api.model.CreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentalApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.FleetApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.JsonPatchDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.RentalDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;
import ro.agilehub.javacourse.car.hire.rental.service.domain.RentalDO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentalApi {

    private final RentalService rentalService;
    private final RentalDTOMapper mapper;
    private final JsonPatchDTOMapper mapperJsonPatch;
    private final UserApi userApi;
    private final FleetApi carApi;

    @Override
    public ResponseEntity<CreatedDTO> addRental(@Valid RentalDTO rentalDTO) {
        var rentalDO = map(rentalDTO);
        var rentalID = rentalService.addRent(rentalDO);
        CreatedDTO createdDTO = new CreatedDTO();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdDTO.id(rentalID));
    }

//    @Override
//    public ResponseEntity<Void> cancelRental(String id) {
//        rentalService.removeRent(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @Override
//    public ResponseEntity<RentalResponseDTO> getRental(String id) {
//        var rentalResponseDTO = mapper
//                .toRentalResponseDTO(rentalService.findById(id));
//
//        return ResponseEntity.ok(rentalResponseDTO);
//    }
//
//    @Override
//    public ResponseEntity<List<RentalResponseDTO>> getRentals() {
//        var listRentalsReponseDTO = rentalService.findAll()
//                .stream()
//                .map(mapper::toRentalResponseDTO)
//                .collect(toList());
//
//        return ResponseEntity.ok(listRentalsReponseDTO);
//    }
//
//    @Override
//    public ResponseEntity<RentalDTO> updateRental(String id, @Valid List<JsonPatchDTO> jsonPatchDTO) {
//        List<JsonPatch> jsonPatchList = jsonPatchDTO.stream().map(mapperJsonPatch::toJsonPatch).collect(toList());
//        RentalDO rentalDO = null;
//        try {
//            rentalDO = rentalService.updateRent(id, jsonPatchList);
//        } catch (JsonPatchException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok().build();
//    }

    private RentalDO map(RentalDTO rentalDTO) {
        var userDTO = userApi.getUser(rentalDTO.getUser());
        var carDTO = carApi.getCar(rentalDTO.getCar());

        return mapper.toRentalDO(rentalDTO, carDTO, userDTO);
    }


}
