package com.example.sampletestapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sampletestapp.APIService;
import com.example.sampletestapp.R;
import com.example.sampletestapp.RetrofitClient;
import com.example.sampletestapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPwd;
    private Button buttonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editTextUserName = findViewById(R.id.text_view_username);
        editTextPwd = findViewById(R.id.text_view_password);
        buttonLogin = findViewById(R.id.button_id);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUserName.getText().toString().trim();
                String password = editTextPwd.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginScreen.this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                loginUser();
            }
        });
    }

    private void loginUser() {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }


}
