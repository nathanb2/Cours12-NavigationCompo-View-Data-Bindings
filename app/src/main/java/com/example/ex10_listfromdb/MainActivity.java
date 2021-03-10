package com.example.ex10_listfromdb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ex10_listfromdb.injection.Injection;

public class MainActivity extends AppCompatActivity {

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUsersFragment();

        UserRepository userRepository = Injection.provideUserRepository(this);
        findViewById(R.id.AM_add_btn).setOnClickListener(view -> {
            Injection.provideExecutor().execute(() ->
                    userRepository.createUser(new User("User " + ++counter, 10 + counter)));
        });
    }

    private void initUsersFragment() {
        UsersFragment usersFragment = UsersFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.AM_container, usersFragment, UsersFragment.TAG).commit();
    }

}