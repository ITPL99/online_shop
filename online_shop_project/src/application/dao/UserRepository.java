package application.dao;

import application.model.UserEntity;

import java.util.List;

public class UserRepository implements UserDataStorage{
    @Override
    public UserEntity save(UserEntity entity) {
        return null;
    }

    @Override
    public UserEntity getById(Integer id) {
        return null;
    }

    @Override
    public List<UserEntity> getAll() {
        return List.of();
    }
}
