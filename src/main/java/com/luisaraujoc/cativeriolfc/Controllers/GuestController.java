package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.DTO.GuestRequest;
import com.luisaraujoc.cativeriolfc.Entity.Guest;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Services.GuestService;
import com.luisaraujoc.cativeriolfc.Services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Guest>> findAll() {
        List<Guest> guests = guestService.findAll();
        return ResponseEntity.ok().body(guests);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Guest> findById(@PathVariable Long id) {
        Guest guest = guestService.findById(id);
        return ResponseEntity.ok().body(guest);
    }

    @DeleteMapping(value = "del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guestService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Guest> update(@PathVariable Long id, @RequestBody Guest guest) {
        return ResponseEntity.ok().body(guestService.update(id, guest));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Guest> insert(@RequestBody GuestRequest guestRequest) {
        // Create Host Person
        Person host = guestRequest.getHost();
        host = personService.insert(host);

        // Create Guest with the created Host Person ID
        Guest guest = new Guest();
        guest.setName(guestRequest.getGuestName());
        guest.setHost(host);

        guest = guestService.insert(guest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(guest.getId()).toUri();
        return ResponseEntity.created(uri).body(guest);
    }
}
