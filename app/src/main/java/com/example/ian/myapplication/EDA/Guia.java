package com.example.ian.myapplication.EDA;

import java.io.Serializable;

/**
 * Created by Ian on 12-05-2017.
 */
public class Guia implements Serializable{
    private String nombre;
    private String descripcion;
    private int estrellas;
    private String locacion;
    private int tours;

    public Guia(String nombre, String descripcion, int estrellas, String locacion, int tours){
        setNombre(nombre);
        setDescripcion(descripcion);
        setEstrellas(estrellas);
        setLocacion(locacion);
        setTours(tours);
    }


    public void setNombre(String nombre){this.nombre=nombre;}
    public void setDescripcion(String descripcion){this.descripcion=descripcion;}
    public void setEstrellas(int estrellas){this.estrellas=estrellas;}
    public void setLocacion(String locacion){this.locacion=locacion;}
    public void setTours(int tours){this.tours=tours;}

    public String getNombre(){return nombre;}
    public String getDescripcion(){return descripcion;}
    public int getEstrellas(){return estrellas;}
    public String getLocacion(){return locacion;}
    public int getTours(){return tours;}
}
