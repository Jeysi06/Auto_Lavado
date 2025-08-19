/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autolavado.controller;

import com.mycompany.autolavado.conexion.conexionDB;
import com.mycompany.autolavado.model.clientesModel;
import com.mycompany.autolavado.model.usuarioModel;
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
public class clientesController {
        public static boolean insertarCliente(clientesModel cliente){
        String sql="INSERT INTO tbc_clientes(nombre, primerApellido, segundoApellido, direccion,telefono,correo, password) values(?,?,?,?,?,?,?)";
        try(Connection con=conexionDB.obtenerConexion();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,cliente.getNombre());
           ps.setString(2,cliente.getPrimerApellido());
           ps.setString(3,cliente.getSegundoApellido());
           ps.setString(4,cliente.getDireccion());
           ps.setString(5,cliente.getTelefono());
           ps.setString(6,cliente.getCorreo());
           ps.setString(7,cliente.getPassword());
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
           return false;
        }
        
    
    }
      public static List<clientesModel> obtenerTodos(){
        var lista=new ArrayList<clientesModel>();
        String sql="SELECT*FROM tbc_clientes";
         try(Connection con=conexionDB.obtenerConexion();
                 Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql)){
         while(rs.next()){
             lista.add(new clientesModel(rs.getInt("idCliente"),rs.getString("nombre"),rs.getString("primerApellido"),rs.getString("segundoApellido"),rs.getString("direccion"),rs.getString("telefono"),rs.getString("correo"),rs.getString("password")));
         }
         }catch(SQLException ex){
                ex.printStackTrace();
                }
        return lista;
    }
      
    public static List<clientesModel> buscarClienteNombre(String nombre){
       var lista=new ArrayList<clientesModel>();
       String sql="SELECT*FROM tbc_clientes WHERE nombre LIKE ?";
       try(Connection con=conexionDB.obtenerConexion();
               PreparedStatement ps= con.prepareStatement(sql)){
           ps.setString(1,"%"+nombre+"%");
           ResultSet rs= ps.executeQuery();
            while (rs.next()) {
            lista.add(new clientesModel(rs.getInt("idCliente"), rs.getString("nombre"), rs.getString("primerApellido"), rs.getString("segundoApellido"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo"),rs.getString("password")));
            }
       }catch(SQLException e){
           e.printStackTrace();
       }
       return lista;
    }
        public static boolean eliminarClientes(int idCliente){
        String sql="DELETE FROM tbc_clientes WHERE idCliente=?";
        try(Connection con= conexionDB.obtenerConexion();
                PreparedStatement ps= con.prepareStatement(sql)){
            ps.setInt(1,idCliente);
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
              return false;
        }
      
    }
    
   public static boolean actualizarUsuario(clientesModel cliente){
        String sql="UPDATE tbc_clientes SET nombre=?, primerApellido=?,segundoApellido=?, direccion=?,telefono=?,correo=?,password=? WHERE idCliente=?";
        boolean actualizado= false;
        try(Connection con= conexionDB.obtenerConexion();
                
               PreparedStatement ps= con.prepareStatement(sql) ){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getPrimerApellido());
            ps.setString(3, cliente.getSegundoApellido());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
            ps.setString(8, cliente.getPassword());
            ps.setInt(10, cliente.getIdCliente());
            int filasAfectadas = ps.executeUpdate();
            actualizado=filasAfectadas>0;
           
        }catch(SQLException ex){
            ex.printStackTrace();
        }
       return actualizado;
    }
}
