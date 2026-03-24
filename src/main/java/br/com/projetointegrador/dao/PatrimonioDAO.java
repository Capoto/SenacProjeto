/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetointegrador.dao;
import br.com.projetointegrador.model.Patrimonio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.projetointegrador.model.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author heitor
 */
public class PatrimonioDAO {
    
    public void inserirPatrimonio(Patrimonio p,int id) {
        String sql = "INSERT INTO patrimonio (codigoPatrimonio, tipoPatrimonio, agentePatrimonial, lancamento, situacao, esferaAdministrativa,responsavelId, statusEmprestimo) VALUES (?, ?, ?, ?, ?, ? , ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1, p.getCodigoPatrimonio());
            stmt.setString(2, p.getTipoPatrimonio());
            stmt.setString(3, p.getAgentePatrimonial());
            stmt.setString(4, p.getLancamento());
            stmt.setString(5, p.getSituacao());
            stmt.setString(6, p.getEsferaAdministrativa());
            stmt.setInt(7, id);
            stmt.setString(8, "Disponível");
            stmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
     public List<Patrimonio> listar() {
        String sql = "SELECT tipoPatrimonio, situacao,statusEmprestimo FROM patrimonio";
        List<Patrimonio> lista = new ArrayList<>();

        try (Connection c = Conexao.conectar();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Patrimonio p = new Patrimonio();
                p.setTipoPatrimonio(rs.getString("tipoPatrimonio"));
                p.setSituacao(rs.getString("situacao"));
                p.setStatusEmprestimo(rs.getString("statusEmprestimo"));
                lista.add(p);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
     
     
     public int count() {
        String sql = "SELECT count(*) as cont FROM patrimonio";
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
