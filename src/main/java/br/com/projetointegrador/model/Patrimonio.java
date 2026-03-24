package br.com.projetointegrador.model;

public class Patrimonio {

    private int id;
    private String codigoPatrimonio;
    private String tipoPatrimonio;
    private String agentePatrimonial;
    private String lancamento;
    private String situacao;
    private String esferaAdministrativa;
    private int responsavelId;
    private String statusEmprestimo;

    public  Patrimonio(){


    }

    public  Patrimonio(String codigoPatrimonio,String tipoPatrimonio, String agentePatrimonial, String lancamento, String situacao, String esferaAdministrativa, int responsavelId, String statusEmprestimo){

            this.codigoPatrimonio = codigoPatrimonio;
            this.tipoPatrimonio = tipoPatrimonio;
            this.agentePatrimonial = agentePatrimonial;
            this.lancamento = lancamento;
            this.situacao = situacao;
            this.esferaAdministrativa = esferaAdministrativa;
            this.responsavelId = responsavelId;
            this.statusEmprestimo = statusEmprestimo;
    }
    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
    
        this.id = id;
    }

    public String getCodigoPatrimonio(){

        return  this.codigoPatrimonio;
    }

    public String getTipoPatrimonio(){
        return this.tipoPatrimonio;
    }

    public String getAgentePatrimonial(){

        return this.agentePatrimonial;
    }

    public String getLancamento(){

        return  this.lancamento;
    }

    public String getSituacao(){

        return this.situacao;
    }

    public String getEsferaAdministrativa(){

        return this.esferaAdministrativa;
    }

    public int getResponsavelId(){

        return this.responsavelId;
    }

    public String getStatusEmprestimo(){

        return this.statusEmprestimo;
    }
    
    public void setTipoPatrimonio(String tipoPatrimonio){
    
        this.tipoPatrimonio = tipoPatrimonio;
    }
    
    public void setSituacao(String situacao){
    
        this.situacao = situacao;
    }
    
    public void setStatusEmprestimo(String statusEmprestimo){
    
        this.statusEmprestimo = statusEmprestimo;
    }

}
