package com.nexia.nexia.controlles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexia.nexia.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/games")
public class GameController {
    @Autowired
    private GameService gameService;

    // TODO: get all games for specific lesson and specific dyslexia type
    @GetMapping("/getGames")
    public ResponseEntity getGamesForLesson(@RequestParam String param) {
        return null;
    }
}
