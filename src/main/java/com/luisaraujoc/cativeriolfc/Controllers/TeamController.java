package com.luisaraujoc.cativeriolfc.Controllers;

import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Services.TeamService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/team")
public class TeamController {

    @GetMapping(value = "/gd/{id}")
    public ResponseEntity<List<Team>> findByGameDay(@PathVariable Long id) {
        List<Team> uList = TeamService.findAllByGameDay(id);
        return ResponseEntity.ok().body(uList);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        Team uList = TeamService.findById(id);
        return ResponseEntity.ok().body(uList);
    }


}