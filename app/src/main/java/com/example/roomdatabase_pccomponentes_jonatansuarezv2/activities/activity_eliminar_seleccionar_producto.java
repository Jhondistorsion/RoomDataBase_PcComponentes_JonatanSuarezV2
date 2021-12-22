package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.viewmodel.ProductoViewModel;

import java.util.List;

public class activity_eliminar_seleccionar_producto extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_PRODUCTO = "miProducto";

    private TextView txt_titulo_modificar_borrar;
    private Spinner sp_productos;
    private Button btn_modificar_borrar;

    ProductoViewModel mProductoViewModel;
    static Producto pseleccionado;
    static ArrayAdapter<Producto> adapter;
    LiveData<List<Producto>> productos;

    String modo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_seleccionar_producto);

        txt_titulo_modificar_borrar = (TextView) findViewById(R.id.txt_titulo_modificar_borrar);
        sp_productos = (Spinner) findViewById(R.id.sp_productos);
        btn_modificar_borrar = (Button) findViewById(R.id.btn_modificar_borrar);

        mProductoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);

        LiveData<List<Producto>> productosLive = mProductoViewModel.obtenerProductos();
        if(productosLive != null){
            productosLive.observe(this, new Observer<List<Producto>>() {
                @Override
                public void onChanged(@Nullable final List<Producto> losproductos) {
                    asignarAdaptadorSpinnerProductos(losproductos);
                }
            });
        }else{
            Toast.makeText(this,"No se han encontrado productos", Toast.LENGTH_SHORT).show();
        }

        Intent intent = getIntent();
        if(intent != null){
            modo = intent.getStringExtra(activity_gestion.EXTRA_MODO);
            aplicaModo(modo);

        }
    }

    private void asignarAdaptadorSpinnerProductos(List<Producto> losproductos) {

        adapter = new ArrayAdapter<Producto>(this,R.layout.item_producto, losproductos);
        sp_productos.setAdapter(adapter);

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

        if(modo.equals("borrar")){

            //METODO BORRAR//////////////


            AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
            alerta1.setTitle("Deseas eliminar el producto?");
            //alerta1.setMessage(" no -> cancelar, si-> guardar");
            alerta1.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(pseleccionado == null)
                    {
                        mostrarToast("Selecciona un producto");
                        return;
                    }
                    //borrar provincia
                    boolean borradoOK = mProductoViewModel.borrarProducto(pseleccionado);
                    if(borradoOK)
                    {
                        mostrarToast("Producto borrado con éxito");
                    }
                    else{
                        mostrarToast("Error al borrar el producto");
                    }
                }
            });
            alerta1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alerta1.show();



        }else if(modo.equals("modificar")){

            //METODO MODIFICAR//////////////

            if(pseleccionado == null){

                mostrarToast("Selecciona un producto");
                return;
            }

            Intent intent = new Intent(this, activity_nuevo_modifica_producto.class);
            intent.putExtra(EXTRA_OBJETO_PRODUCTO, pseleccionado);
        }


    }

    private void mostrarToast(String mensaje) {

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Producto p = (Producto) sp_productos.getItemAtPosition(i);
        pseleccionado = p;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}