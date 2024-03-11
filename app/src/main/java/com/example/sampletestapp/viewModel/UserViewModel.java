package com.example.sampletestapp.viewModel;

import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sampletestapp.Repository.UserRepository;
import com.example.sampletestapp.model.User;

import java.util.List;

public class UserViewModel {
    private UserRepository userRepository;
    private MutableLiveData<List<User>> _users = new MutableLiveData<>();
    public LiveData<List<User>> users = _users;

    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<List<User>> getHolidays() {
        if(_users==null){
            _users = userRepository.getAllUsers();
        }
        return _users;
    }
}

