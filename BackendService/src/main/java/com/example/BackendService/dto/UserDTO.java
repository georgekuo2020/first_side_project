package com.example.BackendService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @Id
    @NotNull
    @Schema(type = "java.lang.String", example = "ff80808182d3d24d0182d3d2a08f0000")
    private String id;

    @NotNull
    @Schema(type = "java.lang.String", example = "BaLL")
    private String name;

    @NotNull
    @Schema(type = "java.lang.String", example = "ball@example.com")
    private String email;
}
