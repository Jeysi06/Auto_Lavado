/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autolavado.model;

/**
 *
 * @author PC-17
 */
public class serviciosModel {

    public  int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public  String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public  String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public  String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    private  int idServicio;
    private  String nombre;
    private  String descripcion;
    private  String precio;
    private  String estatus;

    public serviciosModel(int idServicio, String nombre, String descripcion, String precio, String estatus) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estatus = estatus;
    }

    public serviciosModel(String nombre, String descripcion, String precio, String estatus) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estatus = estatus;
    }

    public serviciosModel() {
    }
    
    
    
}
