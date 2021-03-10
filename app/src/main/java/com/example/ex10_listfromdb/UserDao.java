package com.example.ex10_listfromdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void createUser(User user);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUsers();

    @Update
    void updateUser(User user);

    @Delete
    void removeUser(User user);

    @Query("SELECT * FROM user where id = :id")
    LiveData<User> getUserById(long id);
}
