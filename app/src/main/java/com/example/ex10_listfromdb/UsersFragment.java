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

import com.example.ex10_listfromdb.databinding.FragmentUsersBinding;
import com.example.ex10_listfromdb.injection.Injection;
import com.example.ex10_listfromdb.injection.ViewModelFactory;

import java.util.List;

public class UsersFragment extends Fragment {


    public static final String TAG = UsersFragment.class.getSimpleName();
    private UserAdapter mUserAdapter;
    private FragmentUsersBinding binding;

    public static UsersFragment newInstance() {
        UsersFragment usersFragment = new UsersFragment();
        return usersFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory viewModelFactory = Injection.provideViewModelFactory(getContext());
        UsersViewModel usersViewModel = viewModelFactory.create(UsersViewModel.class);

        usersViewModel.getAllUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (mUserAdapter == null) {
                    mUserAdapter = initAdapter(view, users);
                } else {
                    mUserAdapter.setData(users);
                    mUserAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private UserAdapter initAdapter(@NonNull View view, List<User> users) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        UserAdapter userAdapter = new UserAdapter(users);
        binding.recyclerView.setAdapter(userAdapter);
        return userAdapter;
    }
}
