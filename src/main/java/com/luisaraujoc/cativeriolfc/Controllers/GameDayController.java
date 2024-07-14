package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Sevices.GameDayService;
import com.luisaraujoc.cativeriolfc.Sevices.TeamService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

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



}
