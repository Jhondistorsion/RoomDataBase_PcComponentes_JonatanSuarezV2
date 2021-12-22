package com.example.roomdatabase_pccomponentes_jonatansuarezv2.clases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "productos")
public class Producto implements Serializable
{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "producto")
    private int idProducto;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "cantidad")
    private int cantidad;

    @NonNull
    @ColumnInfo(name = "almacen")
    private String almacen;

    @NonNull
    @ColumnInfo(name = "estado")
    private String estado;

    public Producto(@NonNull String nombre, int cantidad, @NonNull String almacen, @NonNull String estado) {
        this.idProducto = 0;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.almacen = almacen;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @NonNull
    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(@NonNull String almacen) {
        this.almacen = almacen;
    }

    @NonNull
    public String getEstado() {
        return estado;
    }

    public void setEstado(@NonNull String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", almacen='" + almacen + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return idProducto == producto.idProducto && nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombre);
    }
}
