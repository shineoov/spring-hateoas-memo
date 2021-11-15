package me.springhateoasmemo;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Link;

import static org.junit.jupiter.api.Assertions.*;

class PersonModelTest {

    @Test
    public void basicModel() throws Exception {
        PersonModel personModel = new PersonModel();
        personModel.setFirstname("Oh");
        personModel.setLastname("Tom");
        personModel.add(Link.of("https://localhost/person/42"));
        System.out.println(personModel);
    }

}