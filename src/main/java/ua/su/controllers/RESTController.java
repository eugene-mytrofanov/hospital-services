package ua.su.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RESTController {
    @GetMapping
    public String hello() {
        return "This is 'Hospital Services' project";
    }

}
