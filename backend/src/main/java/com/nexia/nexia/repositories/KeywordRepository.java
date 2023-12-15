package com.nexia.nexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexia.nexia.models.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

}
