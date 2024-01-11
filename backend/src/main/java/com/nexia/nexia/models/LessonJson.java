package com.nexia.nexia.models;

import java.util.List;
import java.util.Map;

public class LessonJson {
    private String lessonName;

    private Map<String, Map<String, String>> keywords;

    public LessonJson() {
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Map<String, Map<String, String>> getKeywords() {
        return keywords;
    }

    public void setKeywords(Map<String, Map<String, String>> keywords) {
        this.keywords = keywords;
    }

}
