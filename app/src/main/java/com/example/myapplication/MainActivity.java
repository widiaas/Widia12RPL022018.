package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.RS;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText logEmail,logPassword;
    Button logBtnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);

        logEmail = findViewById(R.id.logEmail);
        logPassword = findViewById(R.id.logPassword);
        logBtnLog = findViewById(R.id.logBtnLog);

//        logBtnLog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String email = logEmail.getText().toString();
//                final String password = logPassword.getText().toString();
//
//                HashMap<String, String> body = new HashMap<>();
//                body.put("email", email);
//                body.put("password",password);
//
//                AndroidNetworking.post("http://192.168.6.233:8000/api/login")
//                        .addBodyParameter(body)
//                        .setPriority(Priority.MEDIUM)
//                       // .setOkHttpClient(((RS) getApplication()) .getOkHttpClient())
//                        .build()
//                        .getAsJSONArray(new JSONArrayRequestListener() {
//                            @Override
//                            public void onResponse(JSONArray response) {
//                                try {
//                                    Toast.makeText(MainActivity.this, "This is my Toast message!",
//                                            Toast.LENGTH_LONG).show();
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                    Toast.makeText(MainActivity.this, "G",
//                                            Toast.LENGTH_LONG).show();
//                                }
//
//                            }
//
//                            @Override
//                            public void onError(ANError anError) {
//
//                            }
//                        });
//            }
//        });
    }

    public void register(View view){
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void home(View view){
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }



}