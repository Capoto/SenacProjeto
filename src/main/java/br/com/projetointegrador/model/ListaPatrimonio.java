package br.com.projetointegrador.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListaPatrimonio {

    private List<Patrimonio> patrimonioList = new ArrayList<Patrimonio>();

    public void adiconaPatrimonio(Patrimonio patrimonio){

        patrimonioList.add(patrimonio);
    }

    public List<Patrimonio> listaPatrimonio(){

        return this.patrimonioList;
    }

    public List<Patrimonio> filtroPatrimonioCodigo(Integer filtro){

            
            return patrimonioList.stream().filter(p -> Objects.equals(p.getCodigoPatrimonio(), filtro)).collect(Collectors.toList());
    }

}
