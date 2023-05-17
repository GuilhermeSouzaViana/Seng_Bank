package Entidades;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Pessoa {
private String name;
private String cpf;
private Integer idade;
private String endereco;
private String senha;
private String email;
private String telefone;
private Double salarioBase=null;
public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
public Integer getIdade() {
        return idade;
    }
public void setIdade(Integer idade) {
        this.idade = idade;
    }
public String getSenha() {
        return senha;
    }
public void setSenha(String senha) {
        this.senha = senha;
    }
public Double getSalarioBase() {
        return salarioBase;
    }
public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }
public String getName() {
        return name;
    }
public void setName(String name) {
        this.name = name;
    }
public String getCpf() {
        return cpf;
    }
public void setCpf(String cpf) {
        this.cpf = cpf;
    }
public String getEmail() {
        return email;
    }
public void setEmail(String email) {
        this.email = email;
    }
public String getTelefone() {
        return telefone;
    }
public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
public int calculoIdade(int dia, int mes, int ano) {
        return (int) ChronoUnit.YEARS.between(LocalDate.of(ano, mes, dia), LocalDate.now());
    }
public Pessoa() { }

public String toString() {
        return  "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nIdade: " + this.getIdade() +
                "\nSenha: " + this.getSenha() +
                "\nEmail: " + this.getEmail()+
                "\nTelefone: " + this.getTelefone();
}}