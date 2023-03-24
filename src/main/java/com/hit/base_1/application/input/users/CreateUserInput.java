package com.hit.base_1.application.input.users;

import com.hit.base_1.application.constants.AppStr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserInput {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String telephone;
    private String email;
    private String password;
}
