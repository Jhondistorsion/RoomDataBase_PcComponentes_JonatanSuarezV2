package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;

public class activity_gestion extends AppCompatActivity {

    public static final String EXTRA_MODO = "miModo";

    String modo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);
    }

    public void modificar(View view) {
        Intent intent = new Intent(this,activity_nuevo_modifica_producto.class);
        modo = "modificar";
        intent.putExtra(EXTRA_MODO,modo);
        startActivity(intent);
    }

    public void borrar(View view) {
        Intent intent = new Intent(this,activity_eliminar_seleccionar_producto.class);
        modo = "borrar";
        intent.putExtra(EXTRA_MODO,modo);
        startActivity(intent);
    }

    public void nuevo_producto(View view) {
        Intent intent = new Intent(this,activity_nuevo_modifica_producto.class);
        modo = "crear";
        intent.putExtra(EXTRA_MODO,modo);
        startActivity(intent);
    }

    public void almacen(View view) {
        Intent intent = new Intent(this,activity_mostrar_productos.class);
        startActivity(intent);
    }
}