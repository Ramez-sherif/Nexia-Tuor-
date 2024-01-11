package com.nexia.nexia.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexia.nexia.models.Lesson;
import com.nexia.nexia.models.LessonJson;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LessonJsonService {

    private final String filePath = "backend\\src\\main\\resources\\json\\lessons.json"; // Specify the
    // file path

    public void saveLessons(List<LessonJson> lessons, boolean overwrite) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<LessonJson> oldLessons = getLessons();
        if (oldLessons == null || overwrite) {
            oldLessons = lessons;
        } else {
            oldLessons.addAll(lessons);
        }
        try {
            // Write lessons to JSON file
            String allLessons = objectMapper.writeValueAsString(oldLessons);
            File file = new File(filePath);
            try (java.io.FileWriter fileWriter = new java.io.FileWriter(file)) {
                fileWriter.write(allLessons);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception as needed
        }
    }

    public List<LessonJson> getLessons() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read lessons from JSON file
            return objectMapper.readValue(new File(filePath), new TypeReference<List<LessonJson>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out
                    .println("sfbnvbvufbvusbvusfbvusbfvufuvbsfuvuvfbuvbuvfbuvfbuvfubufvfvufvufvuvfbufvbfbufvbvfufbvu");
            // Handle exception as needed
            return null;
        }
    }

    public Map<String, Map<String, String>> getLessonKeywords(String lessonName) {
        List<LessonJson> lessons = getLessons();
        if (lessons != null) {
            // Find the lesson by name and return its keywords
            return lessons.stream()
                    .filter(lesson -> lessonName.equals(lesson.getLessonName()))
                    .findFirst()
                    .map(LessonJson::getKeywords)
                    .orElse(null);
        }
        return null;
    }

    public void deleteLesson(String lessonName) {
        List<LessonJson> lessons = getLessons();
        if (lessons != null) {
            Optional<LessonJson> lessonOptional = lessons.stream()
                    .filter(lesson -> lessonName.equals(lesson.getLessonName()))
                    .findFirst();

            lessonOptional.ifPresent(lesson -> {
                lessons.remove(lesson);
                saveLessons(lessons, true);
            });
        }
    }

    public void editLesson(String lessonName, LessonJson updatedLesson) {
        List<LessonJson> lessons = getLessons();
        if (lessons != null) {
            for (int i = 0; i < lessons.size(); i++) {
                LessonJson lesson = lessons.get(i);
                if (lessonName.equals(lesson.getLessonName())) {
                    lessons.set(i, updatedLesson); // Update the lesson with the new information
                    saveLessons(lessons, true); // Save the updated list to the JSON file
                    return;
                }
            }
        }
        // Handle the case where the lesson with the given name is not found
        System.out.println("Lesson with name " + lessonName + " not found.");
    }
}
