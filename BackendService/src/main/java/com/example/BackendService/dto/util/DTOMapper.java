package com.example.BackendService.dto.util;

import com.example.BackendService.dto.UserCreationDTO;
import com.example.BackendService.dto.UserDTO;
import com.example.BackendService.dto.UserUpdateDTO;
import com.example.BackendService.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    User toUser(UserCreationDTO userCreationDTO);

    User toUser(UserUpdateDTO userUpdateDTO);

    List<UserDTO> toUserDTOs(List<User> userList);

}
