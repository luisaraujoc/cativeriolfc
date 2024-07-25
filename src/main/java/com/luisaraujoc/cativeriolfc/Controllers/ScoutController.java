package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.Entity.Scout;
import com.luisaraujoc.cativeriolfc.Services.ScoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/scout")
public class ScoutController {

    private final ScoutService scoutService;

    public ScoutController(ScoutService scoutService) {
        this.scoutService = scoutService;
    }

    @PostMapping("/add")
    public ResponseEntity<Scout> insert(@RequestBody Scout scout) {
        scoutService.insert(scout);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(scout.getId()).toUri();

        return ResponseEntity.created(uri).body(scout);
    }

    @PutMapping("/update")
    public ResponseEntity<Scout> update(@RequestBody Scout scout) {
        scoutService.update(scout);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(scout.getId()).toUri();

        return ResponseEntity.created(uri).body(scout);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Scout>> findAll() {
        List<Scout> scoutList = scoutService.findAll();
        return ResponseEntity.ok().body(scoutList);
    }

    @GetMapping("/findByGameId/{gameId}")
    public ResponseEntity<List<Scout>> findByGameId(@PathVariable Long gameId) {
        List<Scout> scoutList = scoutService.findByGameId(gameId);
        return ResponseEntity.ok().body(scoutList);
    }

    @GetMapping("/findByPersonId/{personId}")
    public ResponseEntity<List<Scout>> findByPersonId(@PathVariable Long personId) {
        List<Scout> scoutList = scoutService.findByPersonId(personId);
        return ResponseEntity.ok().body(scoutList);
    }

    @GetMapping("/findByTeamId/{teamId}")
    public ResponseEntity<List<Scout>> findByTeamId(@PathVariable Long teamId) {
        List<Scout> scoutList = scoutService.findByTeamId(teamId);
        return ResponseEntity.ok().body(scoutList);
    }

    // não temos o método delete, não é necessário implementar


}
