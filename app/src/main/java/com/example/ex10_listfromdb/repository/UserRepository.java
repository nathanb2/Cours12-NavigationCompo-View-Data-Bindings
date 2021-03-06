package com.example.ex10_listfromdb.repository;

import androidx.lifecycle.LiveData;

import com.example.ex10_listfromdb.dao.UserDao;
import com.example.ex10_listfromdb.model.User;

import java.util.List;

public class UserRepository {

    UserDao userDao;

    public UserRepository(UserDao userDao){
        this.userDao = userDao;
    }

    public void createUser(User user){
        userDao.createUser(user);
    }

    public LiveData<List<User>> getAllUsers(){
        return userDao.getAllUsers();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    public LiveData<User> getUserById(long id) {
        return userDao.getUserById(id);
    }
}
