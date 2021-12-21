package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void entrar(View view) {
        Intent intent = new Intent(this,activity_gestion.class);
        startActivity(intent);
    }
}