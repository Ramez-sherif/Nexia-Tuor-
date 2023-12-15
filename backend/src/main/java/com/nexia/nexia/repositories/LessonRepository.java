package com.nexia.nexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexia.nexia.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
