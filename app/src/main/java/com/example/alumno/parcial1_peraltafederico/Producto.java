package com.example.alumno.parcial1_peraltafederico;

/**
 * Created by alumno on 09/05/2019.
 */

public class Producto {

    String id;
    String nombre;
    String precio;
    String cantidad;

    public Producto()
    {
    }

    public Producto(String id, String nombre, String precio, String cantidad)
    {
        this.id=id;
        this.nombre = nombre;
        this.precio=precio;
        this.cantidad= cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Nombre :" +  this.getNombre() + " Precio :" + this.getPrecio() + " Cantidad :" + this.getCantidad();
    }
}
