package ro.agilehub.javacourse.car.hire.rental.rental.repository.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.repository.RentalRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = RentalRepository.class)
public class RepositoryConfig {

}
