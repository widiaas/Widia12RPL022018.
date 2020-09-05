package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView dataList;
    List<String> titles;
    List<String> prices;
    List<Integer> images;
    Adapter adapter;

    Button btn;
   boolean sds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_home);
        dataList = findViewById(R.id.dataList);
        btn = findViewById(R.id.btnprofil);

        titles = new ArrayList<>();
        images = new ArrayList<>();
        prices = new ArrayList<>();

        titles.add("Pacific satu");
        titles.add("Pacific dua");
        titles.add("Pacific tiga");
        titles.add("Pacific empat");

        prices.add("5000");
        prices.add("8000");
        prices.add("7000");
        prices.add("9000");

        images.add(R.drawable.pacificoriblue);
        images.add(R.drawable.bromptonrodaor);
        images.add(R.drawable.pacificorblack);
        images.add(R.drawable.pacificputihbiru);

        adapter = new Adapter(this,titles,images,prices);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
    }

    public void btnprofil(View view){
        Intent intent = new Intent(HomeActivity.this,DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Keluar")
                .setMessage("Apakah anda yakin mau keluar?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).create().show();
    }
}