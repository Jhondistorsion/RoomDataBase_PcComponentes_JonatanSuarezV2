package com.example.roomdatabase_pccomponentes_jonatansuarezv2.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;

import java.util.List;

@Dao
public interface DAOProducto {

    @Insert
    void insert(Producto producto);

    @Delete
    void delete(Producto producto);

    @Query("DELETE FROM productos")
    void deleteAll();

    @Update
    void update(Producto producto);

    @Query("SELECT * from productos ORDER BY producto ASC")
    LiveData<List<Producto>> cogerTodosLosProductos();


    @Query("SELECT * FROM productos WHERE producto like :producto")
    LiveData<Producto> CogerProducto(String producto);
    
}
