package com.example.BackendService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserCreationDTO {

    @NotNull
    @Schema(type = "java.lang.String", example = "BaLL")
    private String name;

    @NotNull
    @Schema(type = "java.lang.String", example = "ball@example.com")
    private String email;
}
