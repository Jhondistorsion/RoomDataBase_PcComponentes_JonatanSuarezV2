package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;

public class activity_nuevo_modifica_producto extends AppCompatActivity {

    private TextView txt_titulo_prod;
    private EditText edt_nombre, edt_cantidad;
    private Spinner sp_almacen;
    private RadioButton rad_nuevo, rad_react;
    private Button btn_crear_modificar;

    private String modo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_modifica_producto);

        txt_titulo_prod = (TextView) findViewById(R.id.txt_titulo_prod);
        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        edt_cantidad = (EditText) findViewById(R.id.edt_cantidad);
        sp_almacen = (Spinner) findViewById(R.id.sp_almacen);
        rad_nuevo = (RadioButton) findViewById(R.id.rad_nuevo);
        rad_react = (RadioButton) findViewById(R.id.rad_react);
        btn_crear_modificar = (Button) findViewById(R.id.btn_crear_modificar);

        Intent intent = getIntent();
        if(intent !=null){
            modo = intent.getStringExtra(activity_gestion.EXTRA_MODO);
            aplicaModo(modo);

        }


    }

    private void aplicaModo(String modo) {

        if(modo.equals("crear")){

            txt_titulo_prod.setText("NUEVO PRODUCTO");
            btn_crear_modificar.setText("CREAR");

        }else if(modo.equals("modificar")){
            txt_titulo_prod.setText("MODIFICAR PRODUCTO");
            btn_crear_modificar.setText("MODIFICAR");
        }
    }

    public void crea_modifica(View view) {

        if(modo.equals("crear")){

            //Metodo crear

        }else if(modo.equals("modificar")){

            //Metodo modificar

        }
    }
}