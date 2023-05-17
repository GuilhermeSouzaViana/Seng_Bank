package Entidades;

public class Extrato {
 public String TipoOperacao;
 public  String descricao;
 public Double valor;
 public Extrato(String TipoOperacao,String descricao,Double valor) {
  this.valor = valor;
  this.descricao=descricao;
  this.TipoOperacao=TipoOperacao;
 }

 public  String toString(){
  return " \n"+ TipoOperacao +
           "\n"+descricao+ valor;
}
}
