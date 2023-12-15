package com.nexia.nexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexia.nexia.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
