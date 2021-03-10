package com.example.ex10_listfromdb;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex10_listfromdb.databinding.FragmentUserDetailsBinding;
import com.example.ex10_listfromdb.injection.Injection;
import com.example.ex10_listfromdb.injection.ViewModelFactory;

public class UserDetailsFragment extends Fragment {

    private @NonNull FragmentUserDetailsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        long userId = UserDetailsFragmentArgs.fromBundle(getArguments()).getUserId();

        ViewModelFactory viewModelFactory = Injection.provideViewModelFactory(getContext());
        UserDetailsViewModel userDetailsViewModel = new ViewModelProvider(this, viewModelFactory).get(UserDetailsViewModel.class);

        userDetailsViewModel.getUserById(userId).observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.setUser(user);
            }
        });
    }
}