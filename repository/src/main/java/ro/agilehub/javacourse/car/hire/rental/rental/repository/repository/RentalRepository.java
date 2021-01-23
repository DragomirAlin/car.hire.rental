package ro.agilehub.javacourse.car.hire.rental.rental.repository.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.entity.Rental;

@Repository
public interface RentalRepository extends MongoRepository<Rental, ObjectId> {
}
