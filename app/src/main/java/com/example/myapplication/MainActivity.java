package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.androidnetworking.interfaces.JSONObjectRequestListener;
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
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText logEmail,logPassword;
    private Button logBtnLog;
    private boolean isForm = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);

        logEmail = findViewById(R.id.logEmail);
        logPassword = findViewById(R.id.logPassword);
        logBtnLog = findViewById(R.id.logBtnLog);

        logBtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isForm = true;
                final String email = logEmail.getText().toString();
                final String password = logPassword.getText().toString();

                if (isForm) {
                HashMap<String, String> body = new HashMap<>();
                body.put("email", email);
                body.put("password", password);



                    AndroidNetworking.post(Config.BASE_URL + "login")
                            .addBodyParameter(body)
                            .setPriority(Priority.MEDIUM)
                            .setOkHttpClient(((RS) getApplication()).getOkHttpClient())
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {


//                                    String status = response.optString(Config.RESPONSE_STATUS_FIELD);
                                    String message = response.optString(Config.RESPONSE_MESSAGE_FIELD);
                                    if (message.equalsIgnoreCase(Config.RESPONSE_STATUS_VALUE_SUCCESS)) {
                                        String role = response.optString("role");
//                                    String U_ID = payload.optString("U_ID");
//                                    String U_NAME = payload.optString("U_NAME");
//                                    String U_PHONE = payload.optString("U_PHONE");
//                                    String U_EMAIL = payload.optString("U_EMAIL");

//                                    preferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
//                                    preferences.edit()
//                                            .putString(Config.LOGIN_ID_SHARED_PREF, U_ID)
//                                            .putString(Config.LOGIN_NAME_SHARED_PREF, U_NAME)
//                                            .putString(Config.LOGIN_PHONE_SHARED_PREF, U_PHONE)
//                                            .putString(Config.LOGIN_GROUP_ID_SHARED_PREF, U_GROUP_ROLE)
//                                            .putString(Config.LOGIN_EMAIL_SHARED_PREF, U_EMAIL)
//                                            .apply();

                                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);//CUSTOMER
                                        if (role.equalsIgnoreCase("2"))
                                            intent = new Intent(MainActivity.this, DetailActivity.class);
Log.d("YZD", "respon : " + role);
                                        startActivity(intent);
                                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                        finish();
                                        finishAffinity();
//                                    } else {
//                                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//                                    }

//                                    mProgress.dismiss();
                                    }
                                }

                                @Override
                                public void onError(ANError anError) {
//                                    mProgress.dismiss();
                                    Toast.makeText(MainActivity.this, Config.TOAST_AN_EROR, Toast.LENGTH_SHORT).show();
                                    Log.d("HBB", "onError: " + anError.getErrorBody());
                                    Log.d("HBB", "onError: " + anError.getLocalizedMessage());
                                    Log.d("HBB", "onError: " + anError.getErrorDetail());
                                    Log.d("HBB", "onError: " + anError.getResponse());
                                    Log.d("HBB", "onError: " + anError.getErrorCode());
                                }
                            });
                }
            }
        });
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