package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Sevices.GameDayServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/gamedays")
public class GameDayController {

//    @GetMapping
//    public ResponseEntity<List<GameDay>> findAll() {
//        List<GameDay> gdList = GameDayServices.findAll();
//        return ResponseEntity.ok().body(gdList);
//    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<GameDay> findById(@PathVariable Long id){
//        GameDay gameDay = GameDayServices.findById(id);
//        return ResponseEntity.ok().body(gameDay);
//    }

//    @DeleteMapping(value = "del/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        GameDayServices.delete(id);
//        return ResponseEntity.noContent().build();
//    }

//    @PutMapping(value = "/update/{id}")
//    public ResponseEntity<GameDay> update(@PathVariable Long id, @RequestBody GameDay obj){
//        return ResponseEntity.ok().body(GameDayServices.update(id, obj));
//    }

    @PostMapping(value = "/add")
    public ResponseEntity<GameDay> insert(@RequestBody GameDay gameDay) {
        GameDay newGameDay = GameDayServices.insert(gameDay);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newGameDay.getId()).toUri();
        return ResponseEntity.created(uri).body(newGameDay);
    }

//    @GetMapping(value = "/{id}/players")
//    public ResponseEntity<List<Person>> findCurrentPlayers(@PathVariable Long id) {
//        GameDay gameDay = GameDayServices.findById(id);
//        List<Person> players = GameDayServices.findCurrentPlayers(gameDay);
//        return ResponseEntity.ok().body(players);
//    }

//    @GetMapping(value = "/{id}/teams")
//    public ResponseEntity<List<Team>> findTeams(@PathVariable Long id) {
//        GameDay gameDay = GameDayServices.findById(id);
//        List<Team> teams = GameDayServices.findTeams(gameDay);
//        return ResponseEntity.ok().body(teams);
//    }
}
