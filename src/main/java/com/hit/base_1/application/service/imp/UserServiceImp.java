package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.constants.AppStr;
import com.hit.base_1.application.dai.UserRepository;
import com.hit.base_1.application.input.users.CreateUserInput;
import com.hit.base_1.application.input.users.GetAllUserInput;
import com.hit.base_1.application.mapper.UserMapper;
import com.hit.base_1.application.output.user.GetListUserOutput;
import com.hit.base_1.application.output.user.GetUserDataOutput;
import com.hit.base_1.application.service.UserService;
import com.hit.base_1.config.exception.BadRequestException;
import com.hit.base_1.config.exception.NotFoundException;
import com.hit.base_1.domain.entity.User;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private boolean checkUserEmailExists(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;

    }

    private boolean checkUserTelephoneExists(String telephone) {
        User user = userRepository.findByTelephone(telephone);
        return user != null;
    }

    private boolean checkUserExists(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent();
    }

    @Override
    public GetUserDataOutput createUser(CreateUserInput input) {
        if (checkUserTelephoneExists(input.getTelephone())) {
            throw new BadRequestException(AppStr.user + " " + AppStr.duplicate);
        }
        if (checkUserEmailExists(input.getEmail())) {
            throw new BadRequestException(AppStr.user + " " + AppStr.duplicate);
        }
        System.out.println(1);
        User user = new User();
        user = userMapper.toUser(input,user);
        userRepository.save(user);
        return new GetUserDataOutput(user.getId(), user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getAddress(), user.getTelephone(), user.getEmail(), user.getPassword());
    }

    @Override
    public List<GetUserDataOutput> getAllUserOutPut(GetAllUserInput input) {
        List<User> users = userRepository.findAll(PageRequest.of(input.getPage(), input.getSize())).getContent();
        List<GetUserDataOutput> userDataOutputs = new ArrayList<>();
        for (User u : users) {
            GetUserDataOutput userDataOutput = userMapper.toUserDataOutput(u);
            userDataOutputs.add(userDataOutput);
        }
        return userDataOutputs;
    }

    @Override
    public GetUserDataOutput getUserDataOutput(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!checkUserExists(id)) {
            throw new NotFoundException(AppStr.user + " " + AppStr.notFound);
        }
        GetUserDataOutput userDataOutput = userMapper.toUserDataOutput(user.get());
        return userDataOutput;
    }

    @Override
    public GetUserDataOutput editUser(Long id, CreateUserInput input) {
        Optional<User> user = userRepository.findById(id);
        if (!checkUserExists(id)) {
            throw new NotFoundException(AppStr.user + " " + AppStr.notFound);
        }
        userRepository.save(userMapper.toUser(input,user.get()));
        GetUserDataOutput userDataOutput = userMapper.toUserDataOutput(userMapper.toUser(input,user.get()));
        return userDataOutput;
    }

    @Override
    public GetUserDataOutput deleteUser(Long id) {
        return null;
    }


}
