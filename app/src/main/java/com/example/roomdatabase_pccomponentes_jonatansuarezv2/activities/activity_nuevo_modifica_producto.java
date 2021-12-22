package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.viewmodel.ProductoViewModel;

public class activity_nuevo_modifica_producto extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView txt_titulo_prod;
    private EditText edt_nombre, edt_cantidad;
    private Spinner sp_almacen;
    private RadioButton rad_nuevo, rad_react;
    private Button btn_crear_modificar;

    private String modo;

    private String almacen, estado, nombre, cantidad;

    ProductoViewModel mProductoViewModel;


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

        mProductoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);

        Intent intent = getIntent();
        if(intent !=null){
            modo = intent.getStringExtra(activity_gestion.EXTRA_MODO);
            aplicaModo(modo);

            if(sp_almacen!=null){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.almacenes, R.layout.item_almacen);
                sp_almacen.setAdapter(adapter);
                sp_almacen.setOnItemSelectedListener(this);
            }

        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        almacen = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void asignaEstado(View view) {

        RadioButton rb1 = (RadioButton) view;
        if(rb1.isChecked()){
            switch (rb1.getId()){
                case R.id.rad_nuevo:
                    estado = "Nuevo";
                    break;
                case R.id.rad_react:
                    estado = "Reacondicionado";
                    break;
            }
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

            //Metodo crear///////////////////////////

            obtenerInformacion();


            AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
            alerta1.setTitle("¿Deseas guardar el producto?");
            alerta1.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    int cantidadInt = Integer.parseInt(cantidad);
                    Producto p = new Producto(nombre,cantidadInt,almacen,estado);
                    boolean insertaOK = mProductoViewModel.insertarProducto(p);
                    mostrarToast(insertaOK, "creado","crear");
                }
            });
            alerta1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alerta1.show();



            }else if(modo.equals("modificar")){

            //Metodo modificar////////////////////////

            obtenerInformacion();

            AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
            alerta1.setTitle("¿Deseas modificar el producto?");
            alerta1.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    int cantidadInt = Integer.parseInt(cantidad);
                    Producto p = new Producto(nombre,cantidadInt,almacen,estado);
                    boolean insertaOK = mProductoViewModel.actualizarProducto(p);
                    mostrarToast(insertaOK, "modificado","modificar");
                }
            });
            alerta1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alerta1.show();

        }
    }

    private void obtenerInformacion(){

        nombre = String.valueOf(edt_nombre.getText());
        cantidad = String.valueOf(edt_cantidad.getText());
        boolean error = false;

        if(nombre.isEmpty()){
            edt_nombre.setError("El campo no puede estar vacío");
            error = true;
        }else if(cantidad.isEmpty()){
            edt_cantidad.setError("El campo no puede estar vacío");
            error = true;
        }
        if(error){

            return;

        }

    }


    private void mostrarToast(boolean insertaOK, String a, String b) {

        if(insertaOK){

            Toast.makeText(this,"Producto " + a + " con éxito",Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(this,"Error al " + b + " el producto",Toast.LENGTH_SHORT).show();

        }

    }


}