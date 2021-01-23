package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalDO {

    private String id;

    private String userDO;

    private String carDO;

    private String startDate;

    private String endDate;

    private StatusDO statusDO;

    public enum StatusDO {
        ACTIVE, CANCELLED
    }
}

