package com.example.proyectofinalpmdm;

import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListadoCochesAct extends AppCompatActivity {

    List<Coche> misFilas = new ArrayList<Coche>();
    int posicionLongClick=0;


    AdaptadorRecycler adaptador;


    DBInterface dbInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_coches);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dbInterface = new DBInterface(this);
        dbInterface.abre();
        cargarCoches();

        adaptador = new AdaptadorRecycler(misFilas);
        RecyclerView miRecycler = findViewById(R.id.RecyclerViewCoches);
        miRecycler.setAdapter(adaptador);
        miRecycler.setLayoutManager(new LinearLayoutManager(this));
        adaptador.setOnItemLongClickListener
                (new OnRecyclerViewLongItemClickListener() {
                    @Override
                    public void onItemLongClick(View view, int pos) {
                        posicionLongClick = pos;
                        openContextMenu(view);
                    }
                });
        registerForContextMenu(miRecycler);
    }


    public void cargarCoches(){
        misFilas.clear();
        Cursor c = dbInterface.obtenerCoches();
        if (c==null){
            Toast.makeText(this,"Tabla vacía",Toast.LENGTH_LONG).show();
        }else{
            if (c.moveToFirst()){
                do{

                    misFilas.add(new Coche(c.getLong(0),
                            c.getString(1),
                            c.getString(2),
                            c.getString(3)));
                }while(c.moveToNext());
            }
        }
    }
    @Override
    public void onStop(){
        super.onStop();
        dbInterface.cierra();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.menuInsertar){
            startActivity(new Intent(this, InsertarBBDD.class));
        }


        return  true;
    }


    @Override
    public void onResume(){
        super.onResume();
        dbInterface.abre();
        cargarCoches();
        adaptador.notifyDataSetChanged();

    }


}