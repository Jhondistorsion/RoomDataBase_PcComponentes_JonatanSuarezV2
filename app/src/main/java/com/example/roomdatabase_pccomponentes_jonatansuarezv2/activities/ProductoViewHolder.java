package com.example.roomdatabase_pccomponentes_jonatansuarezv2.activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.R;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.google.android.gms.analytics.ecommerce.Product;

import java.util.List;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String EXTRA_OBJETO_PRODUCTO = "miViewHolderProducto";
    public TextView txt_rv_idProducto;
    public TextView txt_rv_nombreProducto;
    public TextView txt_rv_cantidadProducto;
    ListaProductosAdapter lcAdapter;

    public ProductoViewHolder(@NonNull View itemView, ListaProductosAdapter lcAdapter) {
        super(itemView);
        txt_rv_idProducto = (TextView) itemView.findViewById(R.id.txt_rv_idProducto);
        txt_rv_nombreProducto = (TextView) itemView.findViewById(R.id.txt_rv_nombreProducto);
        txt_rv_cantidadProducto = (TextView) itemView.findViewById(R.id.txt_rv_cantidadProducto);
        this.lcAdapter = lcAdapter;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int mPosition = getAdapterPosition();
        List<Producto> productos = this.lcAdapter.getListaProductos();
        Producto producto = productos.get(mPosition);
        Intent intent = new Intent(lcAdapter.getP(), activity_mostrar_detalles_producto.class);
        intent.putExtra(EXTRA_OBJETO_PRODUCTO, producto);
        lcAdapter.getP().startActivity(intent);

    }
}
