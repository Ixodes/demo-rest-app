package ru.synesis.prototype.controllers;

import com.querydsl.core.types.dsl.BooleanExpression;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.synesis.prototype.dto.StudentFilter;
import ru.synesis.prototype.model.QStudent;
import ru.synesis.prototype.model.Student;
import ru.synesis.prototype.repository.StudentRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
@Api(description = "Student controller")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private EntityManager manager;

    @RequestMapping(
            value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get student")
    public ResponseEntity<Student> get(@PathVariable("id") Integer id) {

        Optional<Student> student = repository.findById(id);
        return ResponseEntity.ok(student.orElseThrow(IllegalStateException::new));
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get students")
    public ResponseEntity<Iterable<Student>> get(StudentFilter filter) {

        QStudent qStudent = QStudent.student;
        BooleanExpression namePredicate = qStudent.name.eq(filter.getName());

        Iterable<Student> students = repository.findAll(namePredicate);
        return ResponseEntity.ok(students);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Create student")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student saved = repository.save(student);
        return ResponseEntity.ok(saved);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update student")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student saved = repository.save(student);
        return ResponseEntity.ok(saved);
    }

}
