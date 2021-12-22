package com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.tareas;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.ProductoRepository;

import java.util.List;
import java.util.concurrent.Callable;

public class TareaObtenerProductos implements Callable<LiveData<List<Producto>>> {

    @Override
    public LiveData<List<Producto>> call() throws Exception {
        try{
            LiveData<List<Producto>> productos = ProductoRepository.mproductoDao.cogerTodosLosProductos();
            return productos;
        }catch (Exception e){
            return null;
        }
    }
}
