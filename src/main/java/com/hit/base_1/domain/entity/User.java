package com.hit.base_1.domain.entity;

import com.hit.base_1.application.constants.AppStr;
import com.hit.base_1.domain.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = AppStr.tableUser)
public class User extends BaseEntity {

    @Column(name = AppStr.firstName)
    @Nationalized
    private String firstName;
    @Column(name = AppStr.lastName)
    @Nationalized
    private String lastName;
    @Column(name = AppStr.dateOfBirth)
    private LocalDate dateOfBirth;
    @Column(name = AppStr.address)
    @Nationalized
    private String address;
    @Column(name = AppStr.telephone)
    private String telephone;
    @Column(name = AppStr.email)
    private String email;
    @Column(name = AppStr.password)
    private String password;
}