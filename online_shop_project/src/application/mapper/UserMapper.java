package application.mapper;

import application.dto.UserDTORegister;
import application.dto.UserDtoResponse;
import application.model.UserEntity;

public class UserMapper {

    public static UserEntity mapModelToEntity(UserDTORegister register){
        UserEntity user = new UserEntity();
        user.setUsername(register.getUsername());
        user.setPassword(register.getPassword());

        return user;
    }

    public static UserDtoResponse mapEntotyToModel(UserEntity user){
        UserDtoResponse response = new UserDtoResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        return response;
    }
}
