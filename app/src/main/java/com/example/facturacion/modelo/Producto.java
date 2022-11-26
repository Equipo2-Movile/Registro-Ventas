package com.example.facturacion.modelo;

public class Producto {

    private String identificacion;
    private String precio;

    public Producto() {
    }

    public Producto(String identificacion, String precio) {
        this.identificacion = identificacion;
        this.precio = precio;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "producto{" +
                "identificacion='" + identificacion + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
