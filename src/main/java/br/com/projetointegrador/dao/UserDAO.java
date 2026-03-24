/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetointegrador.dao;
import br.com.projetointegrador.model.Bolsista;
import br.com.projetointegrador.model.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.projetointegrador.model.Conexao;
import java.sql.ResultSet;
/**
 *
 * @author heitor
 */
public class UserDAO {
    
    public void inserirBolsista(Bolsista p) {
        String sql = "INSERT INTO users (nome, email, cpf, nascimento, telefone, senha, perfil) VALUES (?, ?, ?, ?, ?, ? , ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getNascimento());
            stmt.setString(5, p.getTelefone());
            stmt.setString(6, p.getSenha());
            stmt.setString(7, "Bolsista");
            stmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inserirResponsavel(Responsavel p) {
        String sql = "INSERT INTO users (nome, email, cpf, nascimento, telefone, senha, perfil) VALUES (?, ?, ?, ?, ?, ? , ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getNascimento());
            stmt.setString(5, p.getTelefone());
            stmt.setString(6, p.getSenha());
            stmt.setString(7, "Responsavel");
            stmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public Bolsista logarBolsista(String email,String senha) {
        String sql = "SELECT * FROM users where email=? and senha=? and perfil=?";
        Bolsista p = null;
       

        try (Connection c = Conexao.conectar();
              PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1,email);
            stmt.setString(2, senha);
            stmt.setString(3, "Bolsista");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            p = new Bolsista(rs.getString("nome"),rs.getString("email"),rs.getString("cpf"),rs.getString("nascimento"),rs.getString("telefone"),rs.getString("senha"));
            p.setId(rs.getInt("id"));
        }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return p;
    }
    
    
    public Responsavel logarResponsavel(String email,String senha) {
        String sql = "SELECT * FROM users where email=? and senha=? and perfil=?";
        Responsavel p = null;
       

        try (Connection c = Conexao.conectar();
              PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1,email);
            stmt.setString(2, senha);
            stmt.setString(3, "Responsavel");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            p = new Responsavel(rs.getString("nome"),rs.getString("email"),rs.getString("cpf"),rs.getString("nascimento"),rs.getString("telefone"),rs.getString("senha"));
            p.setId(rs.getInt("id"));
        }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return p;
    }
    
    
    public int countBolsista() {
        String sql = "SELECT count(*) as cont FROM users where perfil='Bolsista'";
        int cont=0;

        try (Connection c = Conexao.conectar();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                
              cont = rs.getInt("cont");
                
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cont;
    }
    
    public int countResponsavel() {
        String sql = "SELECT count(*) as cont FROM users where perfil='Responsavel'";
        int cont=0;

        try (Connection c = Conexao.conectar();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                
              cont = rs.getInt("cont");
                
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cont;
    }
}
