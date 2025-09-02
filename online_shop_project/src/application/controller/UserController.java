package application.controller;

import application.dto.UserDTORegister;
import application.dto.UserDtoResponse;
import application.mapper.UserMapper;
import application.model.UserEntity;
import application.service.UserServiceImpl;

import java.util.Objects;

public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    public UserDtoResponse register(UserDTORegister register){
            if(
                    Objects.isNull(register)||
                            register.getUsername().isBlank()||
                            register.getPassword().isBlank()
            ){
                System.out.println("Неверный формат ввода данных для регистрации");
                return null;
            }

        UserEntity user = UserMapper.mapModelToEntity(register);
        user = userService.save(user);
        return UserMapper.mapEntotyToModel(user);
    }
}
