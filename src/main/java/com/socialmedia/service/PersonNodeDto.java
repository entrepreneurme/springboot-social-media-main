package com.socialmedia.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialmedia.domain.FollowRelation;
import com.socialmedia.domain.PersonNode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class PersonNodeDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String email;

    public PersonNodeDto() { }

    public PersonNodeDto(Long id, String firstName, String lastName, String username,
                         String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    public static  PersonNodeDto fromPersonNode(PersonNode person){
        return new PersonNodeDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getUsername(),
                person.getEmail());
    }

    public PersonNode toPersonNode(){
        var person = PersonNode.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .email(email)
                .build();

        person.setId(id);

        return person;
    }

    public PersonNode mergeWith(PersonNode person){
        PersonNode personR = PersonNode.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .email(email)
                .build();

        personR.setId(person.getId());

        return personR;
    }

    public PersonNode follows(PersonNodeDto followedPerson){
        var person = this.toPersonNode();

        person.followsPerson(FollowRelation.builder()
                .followsSince(LocalDate.now())
                .person(followedPerson.toPersonNode())
                .build());

        return person;
    }

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public static PersonNodeDto fromJsonAttributes(
            @JsonProperty("id") Long id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("username") String username,
            @JsonProperty("email") String email){
        return new PersonNodeDto(id,firstName,lastName,username,email);
    }

}

