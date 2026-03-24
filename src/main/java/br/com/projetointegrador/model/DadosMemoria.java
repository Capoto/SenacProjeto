/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetointegrador.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author heitor
 */
public class DadosMemoria {
    public static List<Patrimonio> patrimonios = new ArrayList<>();
    public static List<Bolsista> bolsista = new ArrayList<>();
    public static List<Responsavel> responsavel = new ArrayList<>();
    
    public static Patrimonio  p1 = new Patrimonio("B3ET476442XN","Notebook","BNDES","22/07/2023","Boa","União",1,"Disponível");
    public static  Patrimonio p2 = new Patrimonio("Y8139NQL8OYL","Computador","BNDES","01/09/2024","Ruim","União",1,"Disponível");
    
    static {
    patrimonios.add(p1);
    patrimonios.add(p2);
    }
}
