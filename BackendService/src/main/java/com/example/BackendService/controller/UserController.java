package com.example.BackendService.controller;

import com.example.BackendService.dto.UserCreationDTO;
import com.example.BackendService.dto.UserDTO;
import com.example.BackendService.dto.UserUpdateDTO;
import com.example.BackendService.dto.util.DTOMapper;
import com.example.BackendService.model.User;
import com.example.BackendService.services.IUserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "帳號")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    DTOMapper dtoMapper;

    @Operation(summary = "列表", description = "取得會員列表")
    @GetMapping("/list")
    protected ResponseEntity<List<UserDTO>> list() {

        List<User> userList = userService.findUserListByIsNotDeleted();

        return ResponseEntity.ok(dtoMapper.toUserDTOs(userList));
    }

    @Operation(summary = "新增", description = "新增會員")
    @PostMapping()
    protected ResponseEntity<JsonNode> create(
            @RequestBody UserCreationDTO userCreationDTO) {

        User user = dtoMapper.toUser(userCreationDTO);
        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);

        //檢查 email 是否已存在
        if (userService.checkIfUserEmailExist(user.getEmail())) {

            response.put("status", "fail");
            response.put("message", "email 已存在");

            return ResponseEntity.ok(response);
        }

        user.setEmail(user.getEmail().toLowerCase());

        //儲存 user
        userService.save(user);

        URI createdLocation =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(user.getId())
                        .toUri();

        response.put("status", "success");
        response.put("message", "新增成功");

        return ResponseEntity.created(createdLocation).body(response);
    }

    @Operation(summary = "更新", description = "更新會員資料")
    @PatchMapping(value = "/{id}")
    protected ResponseEntity<JsonNode> update(
            @PathVariable String id
            , @RequestBody UserUpdateDTO userUpdateDTO) {

        User userUpdate = dtoMapper.toUser(userUpdateDTO);
        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);

        User user = userService.findById(id);

        if (user == null) {

            response.put("status", "fail");
            response.put("message", "user 不存在");

            return ResponseEntity.ok(response);
        }

        user.setName(userUpdate.getName());

        userService.save(user);

        response.put("status", "success");
        response.put("message", "更新成功");

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "刪除", description = "刪除會員")
    @DeleteMapping(value = "/{id}")
    protected ResponseEntity<JsonNode> delete(
            @PathVariable String id) {

        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);

        User user = userService.findById(id);

        if (user == null) {

            response.put("status", "fail");
            response.put("message", "user 不存在");

            return ResponseEntity.ok(response);
        }

        userService.deleteUser(user);

        response.put("status", "success");
        response.put("message", "刪除成功");

        return ResponseEntity.ok(response);
    }
}
