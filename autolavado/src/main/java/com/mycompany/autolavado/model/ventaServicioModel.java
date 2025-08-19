/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autolavado.model;

/**
 *
 * @author PC-17
 */
public class ventaServicioModel {

    public int getIdVentaServicio() {
        return idVentaServicio;
    }

    public void setIdVentaServicio(int idVentaServicio) {
        this.idVentaServicio = idVentaServicio;
    }

    public int getIdUsuarioC() {
        return idUsuarioC;
    }

    public void setIdUsuarioC(int idUsuarioC) {
        this.idUsuarioC = idUsuarioC;
    }

    public int getIdUsuarioL() {
        return idUsuarioL;
    }

    public void setIdUsuarioL(int idUsuarioL) {
        this.idUsuarioL = idUsuarioL;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

  
   
    private int idVentaServicio;
    private int idUsuarioC;
    private int idUsuarioL;
    private int idServicio;
    private int idVehiculo;
    private String fecha;
    private String hora;
    private String estatus;
    private String pagado;
    
      public ventaServicioModel(int idVentaServicio, int idUsuarioC, int idUsuarioL, int idServicio, int idVehiculo, String fecha, String hora, String estatus, String pagado) {
        this.idVentaServicio = idVentaServicio;
        this.idUsuarioC = idUsuarioC;
        this.idUsuarioL = idUsuarioL;
        this.idServicio = idServicio;
        this.idVehiculo = idVehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.estatus = estatus;
        this.pagado = pagado;
    }

    public ventaServicioModel(int idUsuarioC, int idUsuarioL, int idServicio, int idVehiculo, String fecha, String hora, String estatus, String pagado) {
        this.idUsuarioC = idUsuarioC;
        this.idUsuarioL = idUsuarioL;
        this.idServicio = idServicio;
        this.idVehiculo = idVehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.estatus = estatus;
        this.pagado = pagado;
    }

    public ventaServicioModel() {
    }
      
}
