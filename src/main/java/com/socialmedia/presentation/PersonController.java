package com.socialmedia.presentation;

import com.socialmedia.service.PersonNodeDto;
import com.socialmedia.service.PersonService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PersonController.PERSON_ROUTE)
public class PersonController {

    public static final String PERSON_ROUTE = "/people";

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonNodeDto> findAll(){
        return personService.findAll();
    }

    @GetMapping(path = "/{username}")
    public PersonNodeDto findOne(@PathVariable @NonNull String username){
        return  personService.findOne(username);
    }

    @PostMapping
    public PersonNodeDto insert(@RequestBody PersonNodeDto person){
        return personService.insert(person);
    }

    @PutMapping("/{username}")
    public PersonNodeDto replace(@PathVariable String username, @RequestBody PersonNodeDto person){
        return personService.replace(username, person);
    }

    @PutMapping("/follows/{followUsername}")
    public PersonNodeDto follows(@PathVariable String followUsername, @RequestBody PersonNodeDto person){
        return personService.follows(person,followUsername);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username){
        personService.delete(username);
    }

}
