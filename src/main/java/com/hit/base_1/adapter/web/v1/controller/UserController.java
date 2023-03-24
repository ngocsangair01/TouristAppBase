package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.ResponseUtil;
import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.v1.transfer.parameter.user.CreateUserParameter;
import com.hit.base_1.adapter.web.v1.transfer.parameter.user.GetAllUserParameter;
import com.hit.base_1.application.constants.UrlConst;
import com.hit.base_1.application.input.users.CreateUserInput;
import com.hit.base_1.application.input.users.GetAllUserInput;
import com.hit.base_1.application.mapper.UserMapper;
import com.hit.base_1.application.output.user.GetListUserOutput;
import com.hit.base_1.application.output.user.GetUserDataOutput;
import com.hit.base_1.application.service.UserService;
import com.hit.base_1.domain.entity.User;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestApiV1
public class UserController {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(UrlConst.User.users)
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserParameter parameter) {
        CreateUserInput input = userMapper.createUserInput(parameter);

        GetUserDataOutput output = userService.createUser(input);

        return ResponseUtil.restSuccess(output);
    }

    @GetMapping(UrlConst.User.users)
    public ResponseEntity<?> getAllUser(@Valid GetAllUserParameter parameter){
        GetAllUserInput input = new GetAllUserInput(parameter.getPage(), parameter.getSize(), parameter.getName());
        List<GetUserDataOutput> output = userService.getAllUserOutPut(input);
        return ResponseUtil.restSuccess(output);
    }

    @GetMapping(UrlConst.User.getUserById)
    public ResponseEntity<?> getUserData(@PathVariable("id")Long id){
        GetUserDataOutput userDataOutput = userService.getUserDataOutput(id);
        return ResponseUtil.restSuccess(userDataOutput);
    }

    @PutMapping(UrlConst.User.getUserById)
    public ResponseEntity<?> updateUser(@PathVariable("id")Long id,@Valid @RequestBody CreateUserParameter parameter){
        CreateUserInput input = userMapper.createUserInput(parameter);
        GetUserDataOutput userDataOutput = userService.editUser(id,input);
        return ResponseUtil.restSuccess(userDataOutput);
    }
}


