package com.example.ex10_listfromdb;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executor;

public class UsersViewModel extends ViewModel {
    private final Executor mExecutor;
    private UserRepository mRepository;
    private int adapterPosition;

    public UsersViewModel(UserRepository userRepository, Executor executor) {
        mRepository = userRepository;
        mExecutor = executor;
    }

    public LiveData<List<User>> getAllUsers() {
        return mRepository.getAllUsers();
    }

    public void createUser(User user) {
        mExecutor.execute(() -> mRepository.createUser(user));
    }

    public void removeUser(User user) {
        mExecutor.execute(() -> mRepository.removeUser(user));
    }

    public void updateUser(User user) {
        mExecutor.execute(() -> mRepository.updateUser(user));
    }

    public void setAdapterPosition(int adapterPosition) {
        this.adapterPosition = adapterPosition;
    }

    public int getAdapterPosition() {
        return adapterPosition;
    }
}