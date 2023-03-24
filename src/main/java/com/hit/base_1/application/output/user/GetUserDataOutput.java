package com.hit.base_1.application.output.user;

import com.hit.base_1.application.constants.AppStr;
import com.hit.base_1.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDataOutput {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String telephone;
    private String email;
    private String password;

}

