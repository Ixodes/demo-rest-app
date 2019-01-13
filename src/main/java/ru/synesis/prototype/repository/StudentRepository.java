package ru.synesis.prototype.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.synesis.prototype.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>,
        QuerydslPredicateExecutor<Student> {
}
