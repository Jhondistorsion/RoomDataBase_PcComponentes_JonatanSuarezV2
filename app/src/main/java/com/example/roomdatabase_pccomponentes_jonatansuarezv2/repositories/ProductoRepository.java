package com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases.Producto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.dao.DAOProducto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.tareas.TareaActualizarProducto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.tareas.TareaBorrarProducto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.tareas.TareaInsertarProducto;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.repositories.tareas.TareaObtenerProductos;
import com.example.roomdatabase_pccomponentes_jonatansuarezv2.roomDatabase.PcComponentesRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ProductoRepository {

    public static DAOProducto mproductoDao;
    private LiveData<List<Producto>> mAllproductos;

    public ProductoRepository(Application application) {
        PcComponentesRoomDatabase db = PcComponentesRoomDatabase.getDatabase(application);
        mproductoDao = db.ProductoDAO();
        mAllproductos = mproductoDao.cogerTodosLosProductos();
    }

    public LiveData<List<Producto>> getmAllproductos() {
        return mAllproductos;
    }

    public static  boolean insertarProducto(Producto p){
        FutureTask t = new FutureTask(new TareaInsertarProducto(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try{
            insercionOK = (boolean) t.get();
            es.shutdown();
            try{
                if(!es.awaitTermination(800, TimeUnit.MILLISECONDS)){
                    es.shutdownNow();
                }
            }catch(InterruptedException e){
                es.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        finally{
            return insercionOK;
        }
    }

    public static LiveData<List<Producto>> obtenerProductos(){

        LiveData<List<Producto>> productosDevueltos = null;
        FutureTask t = new FutureTask(new TareaObtenerProductos());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try{
            productosDevueltos = (LiveData<List<Producto>>)t.get();
            es.shutdown();
            try{
                if(es.awaitTermination(800, TimeUnit.MILLISECONDS)){
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return productosDevueltos;
    }

    public static boolean borrarProducto(Producto p){
        FutureTask t = new FutureTask(new TareaBorrarProducto(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try{
            borradoOK = (boolean) t.get();
            es.shutdown();
            try{
                if(!es.awaitTermination(800, TimeUnit.MILLISECONDS)){
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        finally{
            return borradoOK;
        }
    }

    public static boolean actualizarProducto(Producto p){
        FutureTask t = new FutureTask(new TareaActualizarProducto(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try{
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try{
                if(!es.awaitTermination(800, TimeUnit.MILLISECONDS)){
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }
}
