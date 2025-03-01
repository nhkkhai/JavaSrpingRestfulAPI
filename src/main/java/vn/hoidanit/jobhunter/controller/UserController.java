package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.domain.User;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.fetchAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUserByID(@PathVariable("id") long id) {
        return this.userService.fetchUserByID(id);
    }

    @PutMapping("/user")
    public User updateUser(
            @RequestBody User postManUser) {
        return this.userService.handleUpdateUser(postManUser);
    }

    @PostMapping("/user")
    public User createNewUser(
            @RequestBody User postManUser) {
        return this.userService.handleCreateUser(postManUser);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "delete user";
    }

}
