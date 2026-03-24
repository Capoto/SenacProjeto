/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetointegrador.model;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author heitor
 */
public class Conexao {
     private static final String URL = "jdbc:mysql://localhost:3306/senac";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão: " + e.getMessage());
        }
    }
}
