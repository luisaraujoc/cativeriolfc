package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.DTO.CurrentPlayersRequest;
import com.luisaraujoc.cativeriolfc.DTO.SortTeamRequest;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Services.GameDayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/gameday")
public class GameDayController {

    @Autowired
    private GameDayService gameDayService;
    
    @GetMapping(value = "/date")
    public ResponseEntity<GameDay> findByDate(@RequestParam String date) {
        GameDay gList = gameDayService.findByDate(date);
        return ResponseEntity.ok().body(gList);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<GameDay> insert(@RequestBody GameDay gameDay) {
        GameDay newGameDay = gameDayService.insert(gameDay);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newGameDay.getId()).toUri();
        return ResponseEntity.created(uri).body(newGameDay);
    }

    @PostMapping(value = "/addplayers")
    public ResponseEntity<List<Person>> insertPlayers(@RequestBody CurrentPlayersRequest cpRequest) {
        List<Person> currentPlayers = gameDayService.addPlayers(cpRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(currentPlayers);
    }

    @PostMapping(value = "/sortTeam")
    public ResponseEntity<List<Team>> sortTeam(@RequestBody SortTeamRequest sortTeamRequestRequest) {
        List<Team> Teams = gameDayService.sortTeam(sortTeamRequestRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(Teams);
    }

    @DeleteMapping(value = "del/{id}")
    public ResponseEntity<Void> deletePlayers(@PathVariable Long id){
        gameDayService.deletePlayers(id);
        return ResponseEntity.noContent().build();
    }


}
