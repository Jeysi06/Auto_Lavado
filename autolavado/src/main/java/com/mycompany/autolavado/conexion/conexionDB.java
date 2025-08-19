/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autolavado.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC-15
 */
public class conexionDB {
    public static final String URL= "jdbc:mysql://localhost:3306/autolavado";
    public static final String USER="root";
            public static final String PASSWORD="root";
            
            public static Connection obtenerConexion() throws SQLException{
                return DriverManager.getConnection(URL,USER,PASSWORD);
            }
}
