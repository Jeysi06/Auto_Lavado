/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autolavado.controller;

import com.mycompany.autolavado.conexion.conexionDB;
import com.mycompany.autolavado.model.usuarioModel;
import com.mycompany.autolavado.model.vehiculoModel;
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
public class vehiculoController {
     public static boolean insertarVehiculo(vehiculoModel vehiculo) {
        String sql = "INSERT INTO tbb_vehiculos(matricula,marca,modelo,color,anio,tipo,id_cliente) values(?,?,?,?,?,?,?)";

        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, vehiculo.getMatricula());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getColor());
            ps.setString(5, vehiculo.getAnio());
            ps.setString(6, vehiculo.getTipo());
            ps.setInt(7, vehiculo.getIdCliente());
           

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }

    public static List<vehiculoModel> obtenerTodos() {
        var lista = new ArrayList<vehiculoModel>();
        String sql = "SELECT*FROM tbb_vehiculos";
        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new vehiculoModel(rs.getInt("idVehiculo"), rs.getString("matricula"),rs.getString("marca"),rs.getString("modelo"),rs.getString("color"),rs.getString("anio"),rs.getString("tipo"),rs.getInt("id_cliente")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
     public static List<vehiculoModel> buscarVehiculoNombre(String matricula) {
        var lista = new ArrayList<vehiculoModel>();
        String sql= "SELECT * FROM tbb_vehiculos WHERE matricula LIKE ?" ;
        try(Connection con = conexionDB.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, "%"+matricula+"%");
            ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new vehiculoModel(rs.getInt("idVehiculo"), rs.getString("matricula"),rs.getString("marca"),rs.getString("modelo"),rs.getString("color"),rs.getString("anio"),rs.getString("tipo"),rs.getInt("id_cliente")));
            }
       
        }catch(SQLException e){
        e.printStackTrace();
        }
    return lista;
    }

     public static boolean eliminarVehiculo(int idVehiculo){
        String sql="DELETE FROM tbb_vehiculos WHERE idVehiculo=?";
        try(Connection con= conexionDB.obtenerConexion();
                PreparedStatement ps= con.prepareStatement(sql)){
            ps.setInt(1,idVehiculo);
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
              return false;
        }
      
    }
    
    public static boolean actualizarVehiculo(vehiculoModel vehiculo){
        String sql="UPDATE tbb_vehiculos SET matricula=?, marca=?,modelo=?, color=?,anio=?,tipo=?,id_cliente=? WHERE idVehiculo=?";
        boolean actualizado= false;
        try(Connection con= conexionDB.obtenerConexion();
                
               PreparedStatement ps= con.prepareStatement(sql) ){
            ps.setString(1, vehiculo.getMatricula());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
             ps.setString(4,vehiculo.getColor());
            ps.setString(5, vehiculo.getAnio());
            ps.setString(6, vehiculo.getTipo());
            ps.setInt(7, vehiculo.getIdCliente());
            ps.setInt(8,vehiculo.getIdVehiculo());
            int filasAfectadas = ps.executeUpdate();
            actualizado=filasAfectadas>0;
           
        }catch(SQLException ex){
            ex.printStackTrace();
        }
       return actualizado;
    }
}
