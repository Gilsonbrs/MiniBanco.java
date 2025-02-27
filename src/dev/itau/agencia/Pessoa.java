package dev.itau.agencia;


public class Pessoa {

    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
    }


    public void testeNome(){
        System.out.println(nome);
    }

    public Pessoa(String nome, String cpf, String email){
        this.nome =  nome;
        this.email = email;

    }

    protected String getnome(){return nome;}

    protected void setNome(String nome){this.nome = nome;}

    protected String getEmail() {return email;}

    protected void setEmail(String email) {this.email = email;}

}
