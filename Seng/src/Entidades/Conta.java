package Entidades;
import utilitarios.Utils;

import javax.swing.*;
public class Conta {
private static int IdConta = 1;
private int numeroConta;
private Pessoa cliente;
private Double saldo=0.0 ;
private Double salario=0.0;
private String endereco;
private String senha;
private Double cartaoCredito= 0.0;
private Double cartaoVirtual= 0.0;
private String pixCpfCnpj ="Não cadastrada";
private String pixEmail ="Não cadastrada";
private String pixTelefone="Não cadastrada";
private String pixAleatoria="Não cadastrada";

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPixCpfCnpj() {
        return pixCpfCnpj;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setPixCpfCnpj(String pixCpfCnpj) {
        this.pixCpfCnpj = pixCpfCnpj;
    }
    public String getPixEmail() {
        return pixEmail;
    }

    public void setPixEmail(String pixEmail) {
        this.pixEmail = pixEmail;
    }

    public String getPixTelefone() {
        return pixTelefone;
    }

    public void setPixTelefone(String pixTelefone) {
        this.pixTelefone = pixTelefone;
    }

    public String getPixAleatoria() {
        return pixAleatoria;
    }

    public void setPixAleatoria(String pixAleatoria) {
        this.pixAleatoria = pixAleatoria;
    }

    public Double getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(Double cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Double getCartaoVirtual() {
        return cartaoVirtual;
    }

    public void setCartaoVirtual(Double cartaoVirtual) {
        this.cartaoVirtual = cartaoVirtual;
    }

    public Conta(Pessoa cliente) {
        this.numeroConta = Conta.IdConta;
        this.cliente = cliente;
        this.updateSaldo();
        Conta.IdConta += 1;
    }


    public int getNumeroConta() {
        return numeroConta;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

    public String toString() {

        return  "\nNúmero da conta: " + this.getNumeroConta() +
                "\nCliente: " + this.cliente.getName() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nSenha: " + this.getSenha() +
                "\nEmail: " + this.cliente.getEmail() +
                "\nTelefone: " + this.cliente.getTelefone() +
                "\nEndereço : " + this.getEndereco() +
                "\nSalario Base: "+ Utils.doubleToString(this.getSalario());

    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
        }else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor+5) {
            setSaldo(getSaldo() - valor-5);
        }else if(valor>0 && valor<=10 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
        }
    }
    public void emprestimo(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
        }
    }

    public void cartaoCredito(Double valor) {
        if(valor <1501) {
            setCartaoCredito(getCartaoCredito()+valor);
        }else {
            JOptionPane.showMessageDialog(null,"O limite requerido ultrapassa o limite do cartão de crédito");
        }
    }

    public void cartaoVirtual(Double valor) {
        if(valor <1000) {
            setCartaoVirtual(getCartaoVirtual()+valor);
        }else {
            JOptionPane.showMessageDialog(null,"O limite requerido ultrapassa o limite do cartão de crédito");
        }
    }

    public void excluirCartaoCredito(Double valor) {setCartaoCredito(valor);}

    public void excluirCartaoVirtual(Double valor){setCartaoVirtual(valor);}
public void LimiteCartoes(){
        JOptionPane.showMessageDialog(null,"Limite cartão de crédito: "+getCartaoCredito()+
                "\nLimite cartão virtual: "+getCartaoVirtual());
}

    public void cadastroPixCpfCnpj(String chave) {setPixCpfCnpj(chave);}
    public void cadastroPixEmail(String chave) {
        setPixEmail(chave);}
    public void cadastroPixTelefone(String chave) {setPixTelefone(chave);}
    public void cadastroPixAleatoria(String chave) {setPixAleatoria(chave);}
    public void excluirPixCpfCnpj(String chave) {setPixCpfCnpj(chave);}
    public void excluirPixEmail(String chave) {setPixEmail(chave);}
    public void excluirPixTelefone(String chave) {setPixTelefone(chave);}
    public void excluirPixAleatoria(String chave) {setPixAleatoria(chave);}





    public void transferenciaTed( Double valor) {
        if(valor > 0 && this.getSaldo() >= valor+13.70) {
            setSaldo(getSaldo() - valor-13.70);}}
    public void transferenciaPix( Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);}}
    public void transferenciaDoc(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor+11.90) {
            setSaldo(getSaldo() - valor-11.90);}}
    public void pagamentoBoleto(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);}}

    public void pagamentoCartaoVirtual(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor+0.50) {
            setSaldo(getSaldo() - valor-0.50);}}

    public void recargaChipTim(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);}}
    public void recargaChipOi(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);}}
    public void recargaChipVivo(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);}}
    public void recargaChipClaro(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);}}
public void alterarSenha(String alterar){setSenha(alterar);}
    public void alterarEmail(String alterar){
      cliente.setEmail(alterar);}
    public void alterarTelefone(String alterar){
        cliente.setTelefone(alterar);}
    public void alterarSalario(Double valor){setSalario(valor);}
    public void alterarEndereco(String alterar){setEndereco(alterar);}

}