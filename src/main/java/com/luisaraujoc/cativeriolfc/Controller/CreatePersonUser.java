package com.luisaraujoc.cativeriolfc.Controller;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/createPerson")
public class CreatePersonUser {

    @PostMapping("/Create")
    public String createPerson(String name, String email, String password, String fullName, String surname) {
        try {
            Person person = new Person();
            person.setFullName(fullName);
            person.setSurname(surname);

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setPerson(person);

            return "User created successfully! " + user.toString();
        }catch (Exception e) {
            return "Error creating user: " + e.getMessage();
        }
    }

    // Test
    @RequestMapping("/test")
    public String test() {
        return "Test";
    }
}