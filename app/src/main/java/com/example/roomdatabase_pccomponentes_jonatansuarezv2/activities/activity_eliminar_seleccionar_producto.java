package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;

public class activity_eliminar_seleccionar_producto extends AppCompatActivity {

    private TextView txt_titulo_modificar_borrar;
    private Spinner sp_productos;
    private Button btn_modificar_borrar;

    String modo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_seleccionar_producto);

        txt_titulo_modificar_borrar = (TextView) findViewById(R.id.txt_titulo_modificar_borrar);
        sp_productos = (Spinner) findViewById(R.id.sp_productos);
        btn_modificar_borrar = (Button) findViewById(R.id.btn_modificar_borrar);

        Intent intent = getIntent();
        if(intent != null){
            modo = intent.getStringExtra(activity_gestion.EXTRA_MODO);
            aplicaModo(modo);

        }
    }

    private void aplicaModo(String modo) {

        if(modo.equals("borrar")){

            txt_titulo_modificar_borrar.setText("BORRAR PRODUCTO");
            btn_modificar_borrar.setText("BORRAR");

        }else if(modo.equals("modificar")){
            txt_titulo_modificar_borrar.setText("MODIFICAR PRODUCTO");
            btn_modificar_borrar.setText("SIGUIENTE");
        }
    }

    public void modificar_borrar(View view) {


    }
}