/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autolavado.controller;

import com.mycompany.autolavado.conexion.conexionDB;
import com.mycompany.autolavado.model.usuarioModel;
import com.mycompany.autolavado.model.ventaServicioModel;
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
public class ventasController {

    public static boolean insertarVenta(ventaServicioModel venta) {
        String sql = "INSERT INTO tbd_venta_servicio(idUsuarioC,idUsuarioL,idServicio,idVehiculo,fecha,hora,estatus,pagado) values(?,?,?,?,?,?,?,?)";

        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdUsuarioC());
            ps.setInt(2, venta.getIdUsuarioL());
            ps.setInt(3, venta.getIdServicio());
            ps.setInt(4, venta.getIdVehiculo());
            ps.setString(5, venta.getFecha());
            ps.setString(6, venta.getHora());
            ps.setString(7, venta.getEstatus());
            ps.setString(8, venta.getPagado());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }

    public static List<ventaServicioModel> obtenerTodos() {
        var lista = new ArrayList<ventaServicioModel>();
        String sql = "SELECT*FROM tbd_venta_servicio";
        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new ventaServicioModel(rs.getInt("id_ventaServicio"), rs.getInt("idUsuarioC"), rs.getInt("idUsuarioL"), rs.getInt("idServicio"), rs.getInt("idVehiculo"), rs.getString("fecha"), rs.getString("hora"), rs.getString("estatus"), rs.getString("pagado")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public static List<ventaServicioModel> buscarVentaNombre(String idServicio) {
        var lista = new ArrayList<ventaServicioModel>();
        String sql = "SELECT * FROM tbd_venta_servicio WHERE fecha LIKE ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + idServicio + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new ventaServicioModel(rs.getInt("id_ventaServicio"), rs.getInt("idUsuarioC"), rs.getInt("idUsuarioL"), rs.getInt("idServicio"), rs.getInt("idVehiculo"), rs.getString("fecha"), rs.getString("hora"), rs.getString("estatus"), rs.getString("pagado")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean eliminarVenta(int idVenta) {
        String sql = "DELETE FROM tbd_venta_servicio WHERE id_ventaServicio=?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public static boolean actualizarVenta(ventaServicioModel venta) {
        String sql = "UPDATE tbd_venta_servicio SET idUsuarioC=?, idUsuarioL=?,idServicio=?, idVehiculo=?,fecha=?,hora=?,estatus=?,pagado=?, WHERE id_ventaServicio";
        boolean actualizado = false;
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdUsuarioC());
            ps.setInt(2, venta.getIdUsuarioL());
            ps.setInt(3, venta.getIdServicio());
            ps.setInt(4, venta.getIdVehiculo());
            ps.setString(5, venta.getFecha());
            ps.setString(6, venta.getHora());
            ps.setString(7, venta.getEstatus());
            ps.setString(8, venta.getPagado());
            ps.setInt(9, venta.getIdVentaServicio());
            int filasAfectadas = ps.executeUpdate();
            actualizado = filasAfectadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return actualizado;
    }
}
