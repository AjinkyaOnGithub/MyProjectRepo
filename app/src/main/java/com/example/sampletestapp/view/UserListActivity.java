package com.example.sampletestapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampletestapp.APIService;
import com.example.sampletestapp.R;
import com.example.sampletestapp.RetrofitClient;
import com.example.sampletestapp.model.User;
import com.example.sampletestapp.view.adapter.MyAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist_layout);
        recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // or GridLayoutManager

        showUserList();
    }

    private void showUserList() {
        APIService userService = RetrofitClient.getClient().create(APIService.class);

        Call<List<User>> call = userService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {

                    List<User> users = response.body();
                    // Process the list of users here
                    recyclerView.setAdapter(new MyAdapter(users));
                    Toast.makeText(UserListActivity.this, "User List Fetched successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserListActivity.this, "Failed to fetch users", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(UserListActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
