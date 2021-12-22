package com.example.roomdatabase_pccomponentes_jonatansuarezv2.roomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.dao.DAOProducto;

@Database(entities = {Producto.class}, version = 1, exportSchema = false)
public abstract class PcComponentesRoomDatabase extends RoomDatabase {
    public abstract DAOProducto ProductoDAO();

    private static PcComponentesRoomDatabase INSTANCE;

    public static PcComponentesRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PcComponentesRoomDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PcComponentesRoomDatabase.class, "pccomponentes_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
