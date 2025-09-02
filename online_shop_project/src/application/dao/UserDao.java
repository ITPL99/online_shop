package application.dao;

import application.model.UserEntity;

import java.util.List;

public class UserDao {

    private final List<UserEntity> users;
    private Integer userId;

    public UserDao(List<UserEntity> users) {
        this.users = users;
        userId = 1;
    }


    public UserEntity save(UserEntity user){
        user.setId(userId++);
        users.add(user);
        return user;
    }
}
