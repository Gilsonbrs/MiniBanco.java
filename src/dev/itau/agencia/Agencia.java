package dev.itau.agencia;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private static CPFValidator cpfValidator = new CPFValidator();
    private static CNPJValidator cnpjValidator = new CNPJValidator();

    private static ArrayList<Conta> listaContas;

    public static void main(String[] args) {
        listaContas = new ArrayList<>();
        validaLogin();
    }

    public static void validaLogin() {
        int qtdTentativas = 3;
        System.out.println("*********************************************************|");
        System.out.println("*Ola! Somos o MiniBanco, é um prazer ver você por aqui!**|");
        System.out.println("*********************************************************|");
        System.out.println("****Insira o perfil que você quer logar          ********|");
        System.out.println("|            GERENTE                 |");
        System.out.println("|            ADMINISTRADOR           |");

        String perfil = sc.next();

        while (qtdTentativas != 0) {

            System.out.println("Insira o login: ");
            String loginTela = sc.next();

            System.out.println("Insira a senha: ");
            String senhaTela = sc.next();

            if (loginTela.equals(Acessos.valueOf(perfil.toUpperCase()).usuario()) && senhaTela.equals(Acessos.valueOf(perfil.toUpperCase()).senha())) {

                operacoes();
            } else {
                System.out.println("Dados invalidos ou inexistentes! tente novamente");
                qtdTentativas--;
                System.out.println("Voce possui  " + qtdTentativas + "tentativas!");
            }
        }
    }

    public static void operacoes(){

        System.out.println("*********************************************************|");
        System.out.println("*Ola! Somos o MiniBanco, é um prazer ver você por aqui!**|");
        System.out.println("*********************************************************|");
        System.out.println("****Selecione uma das opções abaixo para começar ********|");
        System.out.println("---------------------------------------------------------|");
        System.out.println(" 1 - Criar conta pessoa fisica    |");
        System.out.println(" 2 - Criar conta pessoa juridica  |");
        System.out.println(" 3 - Depositar                    | ");
        System.out.println(" 4 - Sacar                        | ");
        System.out.println(" 5 - Transferir                   |");
        System.out.println(" 6 - Consulta saldo               |");
        System.out.println(" 7 - Listar                       |");
        System.out.println(" 8 - Sair                         |");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                criarContaPF();
                break;
            case 2:
                criarContaPJ();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                transferir();
                break;
            case 6:
                consultarSaldo();
                break;
            case 7:
                listar();
                break;
            case 8:
                System.out.println("Até logo");
                System.exit(0);

            default:
                System.out.println("Opção invalida ");
                operacoes();
                break;
        }
    }
        public static void criarContaPF() {
            boolean cpfValido = false;
            String cpf = null;
            System.out.println("Sistema de criação de conta para pessoa fisica! ");
            System.out.println("Preencha suas informações abaixo para criar sua conta no Minibanco!");

            System.out.println("\nNome: ");
            String nome = sc.next();

            while (!cpfValido){
                System.out.println("\nCpf: ");
                cpf = sc.next();
                cpfValido = cpfValidator.invalidMessagesFor(cpf).isEmpty();
                if (!cpfValido)
                    System.out.println("O cpf digitadoé invalido! Tente novamente! ");
            }
            System.out.println("\nEmail: ");
            String email = sc.next();

            PessoaFisica pessoaFisica = new PessoaFisica(nome, cpf, email);
            Conta conta = new Conta(pessoaFisica);

            listaContas.add(conta);
            System.out.println("Conta criada com sucesso!");
            System.out.println("o id da sua conta é: " + conta.getConta());

            operacoes();

        }

        public static void criarContaPJ(){
            boolean cnpjValido = false;
            String cnpj = null;
            System.out.println("Sistema de criação de conta para pessoa juridica! ");
            System.out.println("Preencha suas informações abaixo para criar sua conta no Minibanco!");

            System.out.println("\nNome: ");
            String nome = sc.next();

            while (!cnpjValido){
                System.out.println("\nCnpj: ");
                cnpj = sc.next();
                cnpjValido = cnpjValidator.invalidMessagesFor(cnpj).isEmpty();
                if (!cnpjValido)
                    System.out.println("O cnpj digitadoé invalido! Tente novamente! ");
            }


            System.out.println("\nEmail: ");
            String email = sc.next();

            PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, cnpj, email);
            Conta conta = new Conta(pessoaJuridica);

            listaContas.add(conta);
            System.out.println("Conta criada com sucesso!");
            System.out.println("o id da sua conta é: " + conta.getConta());

            operacoes();

        }

        public static void depositar(){
            System.out.println("Sistema de deposito.");
            System.out.println("Insira o id da conta que deseja depositar: ");
            int Idconta = sc.nextInt();
            Conta conta = validaExistenciaConta(Idconta);

            if(conta != null){
                System.out.println("Insira o valor do deposito: ");
                Double valorDeposito = sc.nextDouble();
                conta.depositar(valorDeposito);
            } else{
                System.out.println("valor não encontrado");
            }
            operacoes();

        }

    public static  void sacar (){
        System.out.println("Sistema de Saque: ");
        System.out.println("Insira o Id da conta e o valor do seu Saque: ");
        int Idconta = sc.nextInt();
        Conta conta = validaExistenciaConta(Idconta);

        if(conta != null){
            System.out.println("Insira o valor do saque: ");
            Double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada ");
        }
        operacoes();
    }

    public static void transferir (){
        System.out.println("Sistema de transferencia: ");
        System.out.println("Insira o Id da conta de origem: ");
        int IdContaOrigem = sc.nextInt();
        Conta contaOrigem= validaExistenciaConta(IdContaOrigem);

        if(contaOrigem != null){
            System.out.println("Insita o Id da conta de destino: ");
            int IdcontaDestino = sc.nextInt();
            Conta contaDestino = validaExistenciaConta(IdcontaDestino);
            if(contaDestino != null){
                System.out.println("Qual o Valor da transferencia: ");
                Double valorTransferencia = sc.nextDouble();
                System.out.println("Transferencia Realizada: ");

                contaOrigem.transferir(contaDestino, valorTransferencia);
            } else {
                System.out.println("Conta de destino invalida tente novamente: ");
            }
        } else{
            System.out.println("Conta de origem invalida tente novamente: ");
        }
        operacoes();
    }

    public static void consultarSaldo(){
        System.out.println(" Consulta de Saldo ");
        System.out.println(" Insira o Id da conta para consultar:");
        int Idconta = sc.nextInt();
        Conta conta = validaExistenciaConta(Idconta);

        if(conta != null){
            conta.consultaSaldo();
        } else {
            System.out.println("Conta não encontrada! ");
        }
            operacoes();
    }

    public  static  void listar(){
        if(listaContas.size() > 0){
            for (Conta conta: listaContas){
                System.out.println(conta);
            }
        } else  {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }

        public static Conta validaExistenciaConta(int idConta) {
            Conta contaValida = null;
            if (listaContas.size() > 0) {
                for (Conta conta : listaContas){
                    if (conta.getConta() == idConta){
                        contaValida = conta;
                    }
                }
            } else {
                System.out.println("Nenhuma conta foi criada com esse Id ");
            }

        return  contaValida;
    }


}
