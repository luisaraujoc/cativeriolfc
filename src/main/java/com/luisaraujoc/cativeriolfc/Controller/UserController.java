package com.luisaraujoc.cativeriolfc.Controller;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUserAndPerson(@RequestBody User user, @RequestBody Person person) {
        userService.createUserAndPerson(user, person);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findPersonById(id));
    }
}
