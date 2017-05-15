package com.example.ian.myapplication.EDA;

/**
 * Created by Ian on 12-05-2017.
 */
public class Tour {
    private String titulo;
    private int precio;
    private String descripcion;
    private String ciudad;
    private int duracion;
    private int estrellas;


    public Tour(String titulo, int precio, String descripcion, String ciudad, int duracion, int estrellas){
        setTitulo(titulo);
        setPrecio(precio);
        setDescripcion(descripcion);
        setCiudad(ciudad);
        setDuracion(duracion);
        setEstrellas(estrellas);
    }


    public void setTitulo(String titulo){this.titulo=titulo;}
    public void setPrecio(int precio){this.precio=precio;}
    public void setDescripcion(String descripción){this.descripcion=descripción;}
    public void setCiudad(String ciudad){this.ciudad=ciudad;}
    public void setDuracion(int duracion){this.duracion=duracion;}
    public void setEstrellas(int estrellas){this.estrellas=estrellas;}

    public String getTitulo(){return titulo;}
    public int getPrecio(){return precio;}
    public String getDescripcion(){return descripcion;}
    public String getCiudad(){return ciudad;}
    public int getDuracion(){return duracion;}
    public int getEstrellas(){return estrellas;}
}
