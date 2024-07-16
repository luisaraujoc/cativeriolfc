package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.Entity.Scout;
import com.luisaraujoc.cativeriolfc.Services.ScoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/scout")
public class ScoutController {
/*
    @Autowired
    ScoutService scoutService;

    @PostMapping("/add")
    public ResponseEntity<Scout> createScout(@RequestBody Scout scout) {
        Scout createdScout = scoutService.createScout(scout);
        URI uri = URI.create(String.format("/api/scout/%s", createdScout.getId()));
        return ResponseEntity.created(uri).body(createdScout);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scout> getScoutById(@PathVariable Long id) {
        Scout scout = scoutService.getScoutById(id);
        return ResponseEntity.ok().body(scout);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Scout>> getAllScouts() {
        List<Scout> scouts = scoutService.getAllScouts();
        return ResponseEntity.ok().body(scouts);
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Scout>> getScoutsByTeam(@PathVariable Long teamId) {
        List<Scout> scouts = scoutService.getScoutsByTeam(teamId);
        return ResponseEntity.ok().body(scouts);
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<Scout>> getScoutsByGame(@PathVariable Long gameId) {
        List<Scout> scouts = scoutService.getScoutsByGame(gameId);
        return ResponseEntity.ok().body(scouts);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Scout>> getScoutsByPlayer(@PathVariable Long playerId) {
        List<Scout> scouts = scoutService.getScoutsByPlayer(playerId);
        return ResponseEntity.ok().body(scouts);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Scout> updateScout(@PathVariable Long id, @RequestBody Scout scout) {
        Scout updatedScout = scoutService.updateScout(id, scout);
        return ResponseEntity.ok().body(updatedScout);
    }

    // @DeleteMapping("/del/{id}")
    // public ResponseEntity<Void> deleteScout(@PathVariable Long id) {
    //     scoutService.deleteScout(id);
    //     return ResponseEntity.noContent().build();
    // }

 */
}
