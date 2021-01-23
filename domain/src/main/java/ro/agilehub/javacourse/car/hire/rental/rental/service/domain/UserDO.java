package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.*;


@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    private String id;
    private String email;
    private String password;
    private String username;
    private String firstname;
    private String lastname;
    private String title;
    private String country;
    private long driverLicense;
    private String status;
}
