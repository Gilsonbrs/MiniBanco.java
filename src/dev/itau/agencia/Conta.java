package dev.itau.agencia;

import dev.itau.utils.Utils;

public class Conta {

   private static int contadorConta = 1;
   private int conta;
   private Pessoa titular;
   private String documento;
   private Double saldo = 0.0;

   public Conta(PessoaFisica titular) {
      this.conta = contadorConta;
      this.titular = titular;
      this.documento = titular.getCpf();
      contadorConta += 1;
   }

   public Conta(PessoaJuridica titular) {
      this.conta = contadorConta;
      this.titular = titular;
      this.documento = titular.getCnpj();
      contadorConta += 1;
   }

   protected int getConta() {
      return conta;
   }

   protected Pessoa getTitular() {
      return titular;
   }

   protected String getDocumento() {
      return documento;
   }

   protected Double getSaldo() {
      return saldo;
   }

   protected void setSaldo(Double saldo) {
      this.saldo = saldo;
   }

   public void depositar(Double valor) {
      if (valor > 0) {
         setSaldo(getSaldo() + valor);
         System.out.println("Deposito no valor de " + Utils.valorDoubleParaString(valor) + "Foi realizado com sucesso! " + this.documento );
         System.out.println("Saldo em conta atualizado: " + Utils.valorDoubleParaString(getSaldo()));
      } else {
         System.out.println("Valor do deposito deve ser maior que 0.0");

      }
   }

   public void sacar(Double valor) {
      if (valor > 0 && getSaldo() >= valor) {
         setSaldo(getSaldo() - valor);
         System.out.println("Saque no valor de " + Utils.valorDoubleParaString(valor) + "Foi realizado com sucesso!");
         System.out.println("Saldo disponivel atualizado " + consultaSaldo());
      } else {
         System.out.println("Você não possui saldo suficiente! saldo em conta: " + consultaSaldo());
      }
   }

   public String consultaSaldo(){
      return Utils.valorDoubleParaString(getSaldo());

   }

   public void transferir(Conta contaDestino, Double valor) {
      if (valor <= 0) {
         System.out.println("Valor não pode ser igual ou menor que 0.0!");
      } else if (this.getSaldo() >= valor) {
         this.setSaldo(this.getSaldo() - valor);
         contaDestino.setSaldo(contaDestino.getSaldo() + valor);
         System.out.println("Transferencia no valor de " + Utils.valorDoubleParaString(valor) + " realizado com sucesso! ");
      } else {
         System.out.println("Voce não tem saldo suficiente: saldo disponivel " + consultaSaldo());
      }
   }
      @Override
      public String toString() {
         return "Dados{" +
                 "Idconta =" + conta +
                 ", Nome do titular =" + titular.getnome() +
                 ", documento ='" + titular + '\'' +
                 ", saldo=" + Utils.valorDoubleParaString(saldo) +
                 '}';
      }
   }




