package com.hit.base_1.application.service;

import com.hit.base_1.application.input.users.CreateUserInput;
import com.hit.base_1.application.input.users.GetAllUserInput;
import com.hit.base_1.application.output.user.GetUserDataOutput;

import java.util.List;

public interface UserService {
    GetUserDataOutput createUser(CreateUserInput input);

    List<GetUserDataOutput> getAllUserOutPut(GetAllUserInput input);

    GetUserDataOutput getUserDataOutput(Long id);

    GetUserDataOutput editUser(Long id,CreateUserInput input);

    GetUserDataOutput deleteUser(Long id);
}