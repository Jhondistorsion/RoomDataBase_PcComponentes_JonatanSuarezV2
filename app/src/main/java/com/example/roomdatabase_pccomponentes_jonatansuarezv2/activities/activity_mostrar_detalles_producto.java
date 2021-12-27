package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;

public class activity_mostrar_detalles_producto extends AppCompatActivity {

    private TextView txt_nombre, txt_almacen1, txt_cantidad, txt_estado1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_producto);

        txt_nombre = (TextView) findViewById(R.id.txt_nombre);
        txt_almacen1 = (TextView) findViewById(R.id.txt_almacen1);
        txt_cantidad = (TextView) findViewById(R.id.txt_cantidad);
        txt_estado1 = (TextView) findViewById(R.id.txt_estado1);

        Intent intent = getIntent();
        if (intent != null) {

            Producto p = (Producto) intent.getSerializableExtra(ProductoViewHolder.EXTRA_OBJETO_PRODUCTO);
            txt_nombre.setText(p.getNombre());
            txt_almacen1.setText("Almacén: " + p.getAlmacen());
            txt_cantidad.setText(p.getCantidad() + " unds");
            txt_estado1.setText(p.getEstado());
        }

    }

    public void volver(View view) {
        Intent intent = new Intent(this,activity_gestion.class);
        startActivity(intent);
    }
}