package ro.agilehub.javacourse.car.hire.rental.service.domain;

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
    private CountryDO countryDO;
    private long driverlicensenumber;
}
