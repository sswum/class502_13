package org.choongang.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=8)
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String userName;
    @AssertTrue
    private boolean agree; //약관 동의



}

/*
public class RequestJoin {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    //private String[] hobby;
    //private Set<String> hobby;
    // private List<String> hobby;
    private String hobby;
    private boolean agree; //약관 동의

    private Address addr;

}*/