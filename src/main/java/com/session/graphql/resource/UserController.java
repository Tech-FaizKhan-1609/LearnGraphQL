package com.session.graphql.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.session.graphql.dto.UserDTO;
import com.session.graphql.entity.User;
import com.session.graphql.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String phone,
                           @Argument String password) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);

        return userService.createUser(user);
    }

    @MutationMapping
    public User createUserByObject(@Argument UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPhone(userDTO.phone());
        user.setPassword(userDTO.password());
        return userService.createUser(user);
    }

    @QueryMapping
    public User getUserById(@Argument int id) {
        return userService.findUserById(id);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.finAllUsers();
    }

    @MutationMapping
    public User updateUser(@Argument UserDTO userDTO, @Argument int id) {
        return userService.upadateUserById(userDTO, id);
    }

    @MutationMapping
    public String deleteUser(@Argument int id) {
        return userService.deleteUserByid(id);
    }

}