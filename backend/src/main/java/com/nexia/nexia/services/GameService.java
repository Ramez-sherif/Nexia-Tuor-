package com.nexia.nexia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nexia.nexia.models.Game;

@Service
public class GameService {
    @Autowired
    private UserService userService;

    @Autowired
    private KeywordService keywordService;

    @Autowired
    private LessonsService lessonsService;
    
    ResponseEntity getGamesForLesson(Long lessonId, Long userId) {
        // 1. get all keywords for lesson

        // 2. get user dyslexia types

        // 3. get all games for dyslexia types (loop)

        // 4. return games
        return null;
    }

    // TODO: get all games for specific dyslexia type
    List<Game> getGamesForDyslexiaType(Long dyslexiaTypeId) {
        return null;
    }
}
