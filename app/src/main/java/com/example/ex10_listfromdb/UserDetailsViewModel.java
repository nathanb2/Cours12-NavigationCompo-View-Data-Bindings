package com.example.ex10_listfromdb;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executor;

public class UserDetailsViewModel extends ViewModel {
    private UserRepository mRepository;

    public UserDetailsViewModel(UserRepository userRepository) {
        mRepository = userRepository;
    }

    public LiveData<User> getUserById(long id) {
        return mRepository.getUserById(id);
    }
}