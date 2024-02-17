package com.example.furreverrfinds_backend1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String mobileNo;

    @NotNull
    private String password;

    @NotNull
    private String cpassword;
}
