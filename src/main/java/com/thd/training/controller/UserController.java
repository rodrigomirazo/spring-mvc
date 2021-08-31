package com.thd.training.controller;

import com.thd.training.model.TraineeUser;
import com.thd.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    List<TraineeUser> getUsers() {
        return userService.getAllUsers();
    }

    // localhost:8080/user/get?name=name1
    @GetMapping("/get")
    List<TraineeUser> getUsersByName(@RequestParam(name = "name") String name) {
        return userService.getByName(name);
    }

    //localhost:8080/user/get/marioUserName
    @GetMapping("/get/{username}")
    List<TraineeUser> getUsersByUserName(@PathVariable String username) {
        return userService.getByUserName(username);
    }

    //localhost:8080/user/get/marioUserName
    @GetMapping("/getByCompanyId/{companyId}")
    List<TraineeUser> getUsersByCompanyId(@PathVariable String companyId) {
        return userService.getByCompanyId(companyId);
    }

    //
    @PostMapping("/save")
    TraineeUser getSave(@RequestBody TraineeUser traineeUser) {
        return userService.save(traineeUser);
    }
}
