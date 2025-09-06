package application.dao;

import application.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDao  implements UserDataStorage{

    public static UserDataStorage instanse = new UserDao(new ArrayList<>());

    private final List<UserEntity> users;
    private Integer userId;

    public UserDao(List<UserEntity> users) {
        this.users = users;
        userId = 1;
    }


    @Override
    public UserEntity save(UserEntity user){
        user.setId(userId++);
        users.add(user);
        return user;
    }

    @Override
    public UserEntity getById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<UserEntity> getAll() {
        return users;
    }
}
