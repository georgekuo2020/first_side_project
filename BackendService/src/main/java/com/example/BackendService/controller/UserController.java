package com.example.BackendService.controller;

import com.example.BackendService.model.User;
import com.example.BackendService.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "帳號")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @ResponseBody
    @Operation(summary = "列表", description = "取得會員列表")
    @GetMapping("/all")
    protected Iterable<User> list(){
        return userService.findAll();
    }
}
