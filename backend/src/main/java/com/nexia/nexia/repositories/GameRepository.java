package com.nexia.nexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexia.nexia.models.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
