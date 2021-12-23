package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.viewmodel.ProductoViewModel;

import java.util.Collections;
import java.util.List;

public class activity_mostrar_productos extends AppCompatActivity {

    private RecyclerView rv_productos;
    private ListaProductosAdapter mAdapter;
    private List<Producto> productos;
    ProductoViewModel mProductoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_productos);

        rv_productos = findViewById(R.id.rv_productos);
        mProductoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        mAdapter = new ListaProductosAdapter(this);
        LiveData<List<Producto>> productosLive = mProductoViewModel.obtenerProductos();
        if (productosLive != null) {
            productosLive.observe(this, new Observer<List<Producto>>() {
                @Override
                public void onChanged(@Nullable final List<Producto> losproductos) {
                    productos = losproductos;
                    mAdapter.setListaProductos(losproductos);
                }
            });
        }

        rv_productos.setAdapter(mAdapter);
        rv_productos.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(productos, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction == ItemTouchHelper.LEFT) {
                    mostrarToast("ha pulsado izquierda");

                    productos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if (direction == ItemTouchHelper.RIGHT) {
                    mostrarToast("ha pulsado derecha");
                    productos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }

            }

        });
        helper.attachToRecyclerView(rv_productos);
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }

}
