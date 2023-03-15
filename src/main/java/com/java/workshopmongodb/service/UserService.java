package com.java.workshopmongodb.service;

import com.java.workshopmongodb.model.User;
import com.java.workshopmongodb.repository.UserRepository;
import com.java.workshopmongodb.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object Not Found! ID: " + id + " Type:" + User.class.getSimpleName()));
    }
}
