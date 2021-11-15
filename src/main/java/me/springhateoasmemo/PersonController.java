package me.springhateoasmemo;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
public class PersonController {

    @GetMapping("/personV1")
    public PersonModel basic() {
        PersonModel personModel = new PersonModel();
        personModel.setFirstname("Oh");
        personModel.setLastname("Tom");
        personModel.add(Link.of("https://localhost/person/42"));
        return personModel;
    }

    @GetMapping("/personV2")
    public EntityModel<Person> basic2() {
        Person person = new Person("Kim", "Do");
        EntityModel<Person> model = EntityModel.of(person);
        return model;
    }

    @GetMapping("/personV3")
    public CollectionModel<Person> basic3() {
        Collection<Person> people = Collections.singleton(new Person("Kim", "Do"));
        CollectionModel<Person> model = CollectionModel.of(people);
        return model;
    }

}
