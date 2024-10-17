package com.session.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.session.graphql.dto.UserDTO;
import com.session.graphql.entity.User;
import com.session.graphql.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found" + id));
    }

    public List<User> finAllUsers() {
        return userRepository.findAll();
    }

    public User upadateUserById(UserDTO userDTO, int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id :" + id));
        user.setName(userDTO.name());
        user.setPhone(userDTO.phone());
        user.setEmail(userDTO.email());
        return userRepository.save(user);
    }

    public String deleteUserByid(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id :" + id));
        userRepository.delete(user);
        return "User deleted successfully...";
    }
}