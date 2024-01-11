package com.nexia.nexia.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nexia.nexia.models.LessonJson;
import com.nexia.nexia.services.LessonJsonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lessons/json")
public class LessonJsonController {

    @Autowired
    private LessonJsonService lessonService;

    @PostMapping("/save")
    public ResponseEntity<List<LessonJson>> saveLessons(@RequestBody List<LessonJson> lessons) {
        lessonService.saveLessons(lessons, false);
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<LessonJson>> getLessons() {
        List<LessonJson> lessons = lessonService.getLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping("/{lessonName}/keywords")
    public ResponseEntity<Map<String, Map<String, String>>> getLessonKeywords(@PathVariable String lessonName) {
        Map<String, Map<String, String>> keywords = lessonService.getLessonKeywords(lessonName);
        return new ResponseEntity<>(keywords, HttpStatus.OK);
    }

    @DeleteMapping("/{lessonName}")
    public ResponseEntity<String> deleteLesson(@PathVariable String lessonName) {
        try {
            lessonService.deleteLesson(lessonName);
            return new ResponseEntity<>("Lesson deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete lesson: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{lessonName}")
    public ResponseEntity<String> editLesson(@PathVariable String lessonName, @RequestBody LessonJson updatedLesson) {
        try {
            lessonService.editLesson(lessonName, updatedLesson);
            return new ResponseEntity<>("Lesson edited successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to edit lesson: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
