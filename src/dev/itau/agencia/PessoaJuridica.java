package dev.itau.agencia;

import br.com.caelum.stella.format.CNPJFormatter;

public class PessoaJuridica extends Pessoa{

    private String cnpj;
    private CNPJFormatter cnpjFormatter = new CNPJFormatter();

    public PessoaJuridica(String nome, String cnpj, String email){
        super(nome, email);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "CNPJ = " + cnpjFormatter.format(cnpj);

    }
}
