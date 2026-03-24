package br.com.projetointegrador.model;

public class Responsavel {

    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String nascimento;
    private String telefone;
    private String senha;

    public Responsavel() {
    }


    public  Responsavel(String nome,String email, String cpf, String nascimento, String telefone, String senha){

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.senha = senha;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
    
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNascimento() {
        return this.nascimento;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getSenha() {
        return this.senha;
    }
}
