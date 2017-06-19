package com.example.ian.myapplication.EDA;

import android.icu.text.DateFormat;

import java.io.Serializable;

/**
 * Created by Ian on 12-05-2017.
 */
public class Tour implements Serializable{
    private String titulo;
    private int precio;
    private String descripcion;
    private String ciudad;
    private int duracion;
    private int estrellas;
    private String nombreGuia;
    private int idGuia;
    private int calificacionTurista;
    private Boolean fueCalificada;
    private Double latitud;
    private Double longitud;


    public Tour(String titulo, int precio, String descripcion, String ciudad, int duracion,
                int estrellas, String nombreGuia, int idGuia){
        setTitulo(titulo);
        setPrecio(precio);
        setDescripcion(descripcion);
        setCiudad(ciudad);
        setDuracion(duracion);
        setEstrellas(estrellas);
        setNombreGuia(nombreGuia);
        setIdGuia(idGuia);
    }

    public Tour(String titulo, int precio, String descripcion, String ciudad, int duracion,
                int estrellas, String nombreGuia, int idGuia, int calificacionTurista, Boolean fueCalificada){
        setTitulo(titulo);
        setPrecio(precio);
        setDescripcion(descripcion);
        setCiudad(ciudad);
        setDuracion(duracion);
        setEstrellas(estrellas);
        setNombreGuia(nombreGuia);
        setIdGuia(idGuia);
        setCalificacionTurista(calificacionTurista);
        setFueCalificada(fueCalificada);
    }

    public Tour(String titulo, int precio, String descripcion, String ciudad, int duracion,
                int estrellas, String nombreGuia, int idGuia, int calificacionTurista, Boolean fueCalificada,
                double latitud, double longitud){
        setTitulo(titulo);
        setPrecio(precio);
        setDescripcion(descripcion);
        setCiudad(ciudad);
        setDuracion(duracion);
        setEstrellas(estrellas);
        setNombreGuia(nombreGuia);
        setIdGuia(idGuia);
        setCalificacionTurista(calificacionTurista);
        setFueCalificada(fueCalificada);
        setLatitud(latitud);
        setLongitud(longitud);
    }


    public void setTitulo(String titulo){this.titulo=titulo;}
    public void setPrecio(int precio){this.precio=precio;}
    public void setDescripcion(String descripción){this.descripcion=descripción;}
    public void setCiudad(String ciudad){this.ciudad=ciudad;}
    public void setDuracion(int duracion){this.duracion=duracion;}
    public void setEstrellas(int estrellas){this.estrellas=estrellas;}
    public void setNombreGuia(String nombreGuia){this.nombreGuia=nombreGuia;}
    public void setIdGuia(int idGuia){this.idGuia=idGuia;}
    public void setCalificacionTurista(int calificacionTurista){this.calificacionTurista=calificacionTurista;}
    public void setFueCalificada(Boolean fueCalificada){this.fueCalificada=fueCalificada;}
    public  void setLatitud(double latitud){this.latitud=latitud;}
    public void setLongitud(double longitud){this.longitud=longitud;}

    public String getTitulo(){return titulo;}
    public int getPrecio(){return precio;}
    public String getDescripcion(){return descripcion;}
    public String getCiudad(){return ciudad;}
    public int getDuracion(){return duracion;}
    public int getEstrellas(){return estrellas;}
    public String getNombreGuia(){return nombreGuia;}
    public int getIdGuia(){return idGuia;}
    public int getCalificacionTurista(){return calificacionTurista;}
    public Boolean getFueCalificada(){return fueCalificada;}
    public Double getLatitud(){return latitud;}
    public Double getLongitud(){return longitud;}
}
