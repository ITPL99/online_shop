package application.dao;

import application.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final List<UserEntity> users;
    private Integer userId;

    public UserDao() {
        this.users = new ArrayList<>();
        userId = 1;
    }


    public UserEntity save(UserEntity user){
        user.setId(userId++);
        users.add(user);
        return user;
    }
}
