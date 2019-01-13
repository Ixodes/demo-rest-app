package ru.synesis.prototype.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.synesis.prototype.model.Bottle;
import ru.synesis.prototype.model.Student;

@Repository
public interface BottleRepository extends CrudRepository<Bottle, Integer> {
}
