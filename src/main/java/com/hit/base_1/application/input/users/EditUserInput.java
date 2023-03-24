package com.hit.base_1.application.input.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditUserInput {
    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String telephone;
    private String email;
    private String password;
}
