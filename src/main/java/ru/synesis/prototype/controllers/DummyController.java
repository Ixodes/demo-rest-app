package ru.synesis.prototype.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Test controller")
public class DummyController {

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    @ApiOperation("${methodDesc}")
    public String index() {
        return "Greetings from Spring Boot!\n";
    }

}
