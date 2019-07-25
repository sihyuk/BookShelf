package com.example.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

SharedPreferenceconfig sharedPreferenceconfig;
TextInputEditText edusername;
EditText eduserpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferenceconfig = new SharedPreferenceconfig(getApplicationContext());
        edusername = findViewById(R.id.username);
        eduserpwd = findViewById(R.id.password);
        //checks for token of login
        if (sharedPreferenceconfig.ReadLoginStatus()){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    public void loginbutton(View view) {
        String username = edusername.getText().toString();
        String userpwd = eduserpwd.getText().toString();

        if(username.equals(getResources().getString(R.string.username))
        && userpwd.equals(getResources().getString(R.string.password))){
            startActivity(new Intent(this,MainActivity.class));
            sharedPreferenceconfig.WriteLoginStatus(true);
            finish();
        }
        else {
            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
            edusername.setText("");
            eduserpwd.setText("");
        }
    }
}
