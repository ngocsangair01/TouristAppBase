package com.hit.base_1.application.dai;

import com.hit.base_1.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByTelephone(String telephone);

    @Query("select u from User u where upper(u.firstName) like upper(concat('%', ?1, '%'))")
    User findByFirstNameContainingIgnoreCase(String name);
}
