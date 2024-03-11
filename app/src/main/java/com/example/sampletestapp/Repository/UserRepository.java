package com.example.sampletestapp.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.sampletestapp.APIService;
import com.example.sampletestapp.RetrofitClient;
import com.example.sampletestapp.model.User;

import java.util.List;

public class UserRepository {
    private APIService apiInterface;

    public UserRepository(APIService apiInterface) {
        this.apiInterface = apiInterface;
    }

    public MutableLiveData<List<User>>  getAllUsers() {
        return (MutableLiveData<List<User>>) apiInterface.getUsers();
    }


}
