package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDO {

    private String id;
    private String make;
    private String model;
    private int year;
    private int mileage;
    private String fuel;
    private String carClazz;
    private String registrationNumber;
    private String status;

}
