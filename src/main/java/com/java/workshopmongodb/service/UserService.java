package com.java.workshopmongodb.service;

import com.java.workshopmongodb.dto.UserDTO;
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

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        this.findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User currentUser = this.findById(user.getId());
        updateData(currentUser, user);
        return userRepository.save(currentUser);
    }

    private void updateData(User currentUser, User user) {
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
