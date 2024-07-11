package com.luisaraujoc.cativeriolfc.Controllers;


import com.luisaraujoc.cativeriolfc.DTO.UserRequest;
import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Sevices.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> uList = UserService.findAll();
        return ResponseEntity.ok().body(uList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = UserService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        UserService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        return ResponseEntity.ok().body(UserService.update(id, obj));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<User> insert(@RequestBody UserRequest userRequest) {
        User obj = userRequest.getUser();
        Person person = userRequest.getPerson();

        User user = UserService.insert(obj, person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

}