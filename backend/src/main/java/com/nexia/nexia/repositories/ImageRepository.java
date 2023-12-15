package com.nexia.nexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexia.nexia.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
