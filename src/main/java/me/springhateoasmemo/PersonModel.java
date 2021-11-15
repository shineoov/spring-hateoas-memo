package me.springhateoasmemo;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class PersonModel extends RepresentationModel<PersonModel> {
    String firstname;
    String lastname;
}
