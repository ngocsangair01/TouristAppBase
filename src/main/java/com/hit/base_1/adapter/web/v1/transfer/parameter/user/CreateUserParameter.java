package com.hit.base_1.adapter.web.v1.transfer.parameter.user;

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
public class CreateUserParameter {
    @NotBlank(message = AppStr.mustNotNull)
    private String firstName;
    @NotBlank(message = AppStr.mustNotNull)
    private String lastName;
    @NotBlank(message = AppStr.mustNotNull)
    private String dateOfBirth;
    private String address;
    @NotBlank(message = AppStr.mustNotNull)
    private String telephone;
    @NotBlank(message = AppStr.mustNotNull)
    @Email(message = AppStr.incorrectFormat)
    private String email;
    @NotBlank(message = AppStr.mustNotNull)
    private String password;
}
