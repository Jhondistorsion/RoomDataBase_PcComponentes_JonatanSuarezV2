package com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.tareas;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.ProductoRepository;

import java.util.concurrent.Callable;

public class TareaInsertarProducto implements Callable<Boolean> {

    private Producto p;

    public TareaInsertarProducto(Producto p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            ProductoRepository.mproductoDao.insert(p);
            return true;

        }catch(Exception e){
            return false;
        }
    }
}
