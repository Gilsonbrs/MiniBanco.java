import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.Validator;
import dev.itau.agencia.Conta;
import dev.itau.agencia.Pessoa;
import dev.itau.agencia.PessoaFisica;
import dev.itau.agencia.PessoaJuridica;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
//        PessoaFisica pf = new PessoaFisica("Gilson", "98765432100", "gilson@.com");
//        System.out.println(pf);
//        PessoaJuridica pj = new PessoaJuridica("Gilson", "20051889000145", "gilson@.com");
//        System.out.println(pj);
//
//        NomeClase nomeObjeto = new NomeClase();
//        PessoaFisica pessoaFisica = new PessoaFisica();
//        PessoaFisica pessoaFisica1 = new PessoaFisica();
//
//        Conta contaFisica = new Conta(pf);
//        contaFisica.depositar(100.00);
//
//        contaFisica.depositar(900.0);
//
//        contaFisica.sacar(500.0);
//
//        contaFisica.transferir(contaFisica, 900.0);
//
//

        ArrayList<String> ListaNomes;
        ListaNomes = new ArrayList<>();
        ListaNomes.add("Jeova");
        ListaNomes.add("Gilson");
        ListaNomes.add("Kissia");
        ListaNomes.add("Barbara");
        ListaNomes.add("Julio");
        ListaNomes.add("Guilherme");
        System.out.println(ListaNomes);
        System.out.println(ListaNomes.size() +  " -- Nomes " );
        System.out.println(ListaNomes.get(0));

 }
}
