package com.example.proyectofinalpmdm;

public class Coche {

    long id;
    String marca;
    String modelo;
    String tipoCoche;

    public Coche(long id, String marca, String modelo, String tipoCoche) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCoche = tipoCoche;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoCoche() {
        return tipoCoche;
    }

    public void setTipoCoche(String tipoCoche) {
        this.tipoCoche = tipoCoche;
    }
}
