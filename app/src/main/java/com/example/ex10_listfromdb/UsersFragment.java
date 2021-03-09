package com.example.ex10_listfromdb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsersFragment extends Fragment {


    public static final String TAG = UsersFragment.class.getSimpleName();
    private List<User> mUsers;
    private UserAdapter mUserAdapter;

    public static UsersFragment newInstance(){
        UsersFragment usersFragment = new UsersFragment();
        return usersFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if (getActivity() != null) {
            UserRepository userRepository = new UserRepository(getActivity().getApplication());
            userRepository.getAllUsers().observe(this, new Observer<List<User>>() {
                @Override
                public void onChanged(List<User> users) {
                    if (mUserAdapter == null) {
                        mUsers = users;
                        mUserAdapter = initAdapter(view, mUsers);
                    } else {
                        mUsers.clear();
                        mUsers.addAll(users);
                        mUserAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private UserAdapter initAdapter(@NonNull View view, List<User> users) {
        RecyclerView recyclerView = view.findViewById(R.id.FU_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        UserAdapter userAdapter = new UserAdapter(users);
        recyclerView.setAdapter(userAdapter);
        return userAdapter;
    }
}
