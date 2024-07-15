package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.DTO.CurrentPlayersRequest;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Sevices.GameDayService;
import com.luisaraujoc.cativeriolfc.Sevices.TeamService;
import com.luisaraujoc.cativeriolfc.Sevices.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/gameday")
public class GameDayController {

    @GetMapping(value = "/date")
    public ResponseEntity<GameDay> findByDate(@RequestParam String date) {
        GameDay gList = GameDayService.findByDate(date);
        return ResponseEntity.ok().body(gList);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<GameDay> insert(@RequestBody GameDay gameDay) {
        GameDay newGameDay = GameDayService.insert(gameDay);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newGameDay.getId()).toUri();
        return ResponseEntity.created(uri).body(newGameDay);
    }

    @PostMapping(value = "/addplayers")
    public ResponseEntity<List<Person>> insertPlayers(@RequestBody CurrentPlayersRequest cpRequest) {
        List<Person> currentPlayers = GameDayService.addPlayers(cpRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(currentPlayers);
    }
    @DeleteMapping(value = "del/{id}")
    public ResponseEntity<Void> deletePlayers(@PathVariable Long id){
        GameDayService.deletePlayers(id);
        return ResponseEntity.noContent().build();
    }


}
