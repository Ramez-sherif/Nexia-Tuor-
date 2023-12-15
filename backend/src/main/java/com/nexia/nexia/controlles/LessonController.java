package com.nexia.nexia.controlles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexia.nexia.services.LessonsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    
    @Autowired
    private LessonsService lessonsService;

    // TODO: add a method to get all lessons
    @GetMapping("/getAllLessons")
    public ResponseBody getAllLessons() {
        // return new SomeData();
        return null;
    }
    
}
