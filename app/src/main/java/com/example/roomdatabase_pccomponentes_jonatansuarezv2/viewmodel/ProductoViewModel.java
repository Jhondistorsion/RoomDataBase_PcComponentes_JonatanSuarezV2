package com.example.roomdatabase_pccomponentes_jonatansuarezv2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.ProductoRepository;

import java.util.List;

public class ProductoViewModel extends AndroidViewModel {

    private ProductoRepository mRepository;
    private LiveData<List<Producto>> mAllproductos;

    public ProductoViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new ProductoRepository(application);
        this.mAllproductos = mRepository.getmAllproductos();
    }

    public LiveData<List<Producto>> obtenerProductos(){

        LiveData<List<Producto>> mAllproductos = mRepository.getmAllproductos();
        return mAllproductos;
    }

    public boolean insertarProducto(Producto p){

        boolean insercionOK = mRepository.insertarProducto(p);
        return insercionOK;
    }

    public boolean borrarProducto(Producto p){
        boolean borradoOK = mRepository.borrarProducto(p);
        return borradoOK;
    }

    public boolean actualizarProducto(Producto p){

        boolean actualizadoOK = mRepository.actualizarProducto(p);
        return actualizadoOK;
    }
}
