package application.service;

import application.dao.UserDao;
import application.model.UserEntity;

import java.lang.reflect.Field;

public class UserServiceImpl {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    public UserEntity save(UserEntity user){
        if(user.getPassword().length()<3){
            System.out.println("не коректный пароль");
            return null;
        }
        return userDao.save(user);
    }
}
