package com.nexia.nexia.services;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexia.nexia.models.User;
import com.nexia.nexia.repositories.DyslexiaTypeRepository;
import com.nexia.nexia.repositories.UserRepository;
import com.nexia.nexia.models.DyslexiaType;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DyslexiaTypeRepository dyslexiaTypeRepository;

    // TODO: get user by userID
    User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
