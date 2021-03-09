package com.example.ex10_listfromdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUsersFragment();

        UserRepository userRepository = new UserRepository(getApplication());
        findViewById(R.id.AM_add_btn).setOnClickListener(view -> {
            userRepository.createUser(new User("User " + ++counter, 10 + counter));
        });
    }

    private void initUsersFragment() {
        UsersFragment usersFragment = new UsersFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.AM_container, usersFragment, UsersFragment.TAG).commit();
    }

}