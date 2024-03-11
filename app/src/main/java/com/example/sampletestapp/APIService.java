package com.example.sampletestapp;

import com.example.sampletestapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/users")
    Call<List<User>> getUsers();
}
