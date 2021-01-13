package ro.agilehub.javacourse.car.hire.rental.service.domain;

import lombok.*;
import ro.agilehub.javacourse.car.hire.rental.entity.Status;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalDO {

    private String id;

    private UserDO userDO;

    private CarDO carDO;

    private String startDate;

    private String endDate;

}

