package com.biggamesurvey.biggamesurvey.controllers;

import com.biggamesurvey.biggamesurvey.dtos.GameDTO;
import com.biggamesurvey.biggamesurvey.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameServices services;

    public GameController(GameServices services) {
        this.services = services;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        return ResponseEntity.ok(services.findAll());
    }
}
