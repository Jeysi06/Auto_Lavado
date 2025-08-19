/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autolavado.controller;

import com.mycompany.autolavado.conexion.conexionDB;
import com.mycompany.autolavado.model.rolModel;
import com.mycompany.autolavado.model.serviciosModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC-17
 */
public class serviciosController {
     public static boolean insertarServicio(serviciosModel servicio){
        String sql="INSERT INTO tbc_servicios(nombre, descripcion, precio, estatus) values(?,?,?,?)";
        try(Connection con=conexionDB.obtenerConexion();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,servicio.getNombre());
            ps.setString(2,servicio.getDescripcion());
            ps.setString(3,servicio.getPrecio());
            ps.setString(4,servicio.getEstatus());
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
           
        }
        return false;
    
    }
      public static List<serviciosModel> obtenerTodos(){
        var lista=new ArrayList<serviciosModel>();
        String sql="SELECT*FROM tbc_servicios";
         try(Connection con=conexionDB.obtenerConexion();
                 Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql)){
         while(rs.next()){
             lista.add(new serviciosModel(rs.getInt("idServicio"),rs.getString("nombre"),rs.getString("descripcion"),rs.getString("precio"),rs.getString("estatus")));
         }
         }catch(SQLException ex){
                ex.printStackTrace();
                }
        return lista;
    }
          public static List<serviciosModel> buscarServicioNombre(String nombre) {
        var lista = new ArrayList<serviciosModel>();
        String sql= "SELECT * FROM tbc_servicios WHERE nombre LIKE ?" ;
        try(Connection con = conexionDB.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, "%"+nombre+"%");
            ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new serviciosModel(rs.getInt("idServicio"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("precio"), rs.getString("estatus")));
            }
       
        }catch(SQLException e){
        e.printStackTrace();
        }
    return lista;
    }
          
            public static boolean eliminarServicio(int idServicio){
        String sql="DELETE FROM tbc_servicios WHERE idServicio=?";
        try(Connection con= conexionDB.obtenerConexion();
                PreparedStatement ps= con.prepareStatement(sql)){
            ps.setInt(1,idServicio);
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
              return false;
        }
      
    }
    
   public static boolean actualizarServicio(serviciosModel servicio){
        String sql="UPDATE tbc_servicios SET nombre=?, descripcion=?,precio=?, estatus=? WHERE idServicio=?";
        boolean actualizado= false;
        try(Connection con= conexionDB.obtenerConexion();
                
               PreparedStatement ps= con.prepareStatement(sql) ){
            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setString(3, servicio.getPrecio());
            ps.setString(4, servicio.getEstatus());
            ps.setInt(5,servicio.getIdServicio());
            int filasAfectadas = ps.executeUpdate();
            actualizado=filasAfectadas>0;
           
        }catch(SQLException ex){
            ex.printStackTrace();
        }
       return actualizado;
    }
}
