package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.domain.User;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String createNewUser() {
        User user = new User();
        user.setName("Ninh  Hoàng Khải");
        user.setPassword("123456");
        user.setEmail("nhkkhai@gmail.com");
        this.userService.handleCreateUser(user);
        return "create user";
    }

}
