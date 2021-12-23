package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;

import java.util.ArrayList;
import java.util.List;

public class ListaProductosAdapter extends RecyclerView.Adapter<ProductoViewHolder> {

    private Context p;
    private List<Producto> listaProductos;
    private LayoutInflater mInflater;

    public void setP(Context p) {
        this.p = p;
        this.listaProductos = new ArrayList<Producto>();
    }

    public ListaProductosAdapter(Context p, List<Producto> listaProductos) {
        this.p = p;
        this.listaProductos = listaProductos;
        mInflater = LayoutInflater.from(p);
    }

    public Context getP() {
        return p;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        notifyDataSetChanged();
    }

    public ListaProductosAdapter(Context p) {
        this.p = p;
        mInflater = LayoutInflater.from(p);
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_producto, parent, false);
        return new ProductoViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        if (listaProductos != null) {
            Producto producto_actual = listaProductos.get(position);
            holder.txt_rv_idProducto.setText("Id " + producto_actual.getIdProducto());
            holder.txt_rv_nombreProducto.setText("Producto " + producto_actual.getNombre());
            holder.txt_rv_cantidadProducto.setText("Cantidad " + producto_actual.getCantidad());
        }
    }

    @Override
    public int getItemCount() {
        if (listaProductos != null) {
            return listaProductos.size();
        } else {
            return 0;
        }
    }
}


