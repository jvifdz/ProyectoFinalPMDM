package com.example.proyectofinalpmdm;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickIniciar(View view) {

        Intent i = new Intent(this, ListadoCochesAct.class);
        startActivity(i);

    }
}