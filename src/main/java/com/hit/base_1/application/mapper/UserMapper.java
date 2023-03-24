package com.hit.base_1.application.mapper;


import com.hit.base_1.adapter.web.v1.transfer.parameter.user.CreateUserParameter;
import com.hit.base_1.application.input.users.CreateUserInput;
import com.hit.base_1.application.output.user.GetUserDataOutput;
import com.hit.base_1.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target = "firstName",source = "input.firstName"),
            @Mapping(target = "lastName",source = "input.lastName"),
            @Mapping(target = "dateOfBirth",source = "input.dateOfBirth"),
            @Mapping(target = "address",source = "input.address"),
            @Mapping(target = "telephone",source = "input.telephone"),
            @Mapping(target = "email",source = "input.email"),
            @Mapping(target = "password",source = "input.password")
    })
    User toUser(CreateUserInput input,User user);

    CreateUserInput createUserInput(CreateUserParameter parameter);

    @Mappings({
            @Mapping(target = "firstName",source = "firstName"),
            @Mapping(target = "lastName",source = "lastName"),
            @Mapping(target = "dateOfBirth",source = "dateOfBirth"),
            @Mapping(target = "address",source = "address"),
            @Mapping(target = "telephone",source = "telephone"),
            @Mapping(target = "email",source = "email"),
            @Mapping(target = "password",source = "password")
    })
    GetUserDataOutput toUserDataOutput(User user);


}
