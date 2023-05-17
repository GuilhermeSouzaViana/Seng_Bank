import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import Entidades.*;

public class Banco {

    static ArrayList<Conta> contasBancarias;
    static ArrayList<Extrato> Extratos;
    static int comprovanteDeposito=0;
    static int comprovanteSaque=0;
    static int comprovanteTransferencia=0;
    static int comprovantePagamento=0;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        Extratos= new ArrayList<Extrato>();
        Login();
    }


    public static void Login(){

        String Opcao= JOptionPane.showInputDialog("""
                  ---Seng Bank---
                  1 -Login
                  2 -Cadastrar nova conta""");


    while (Opcao.length()<1){
            JOptionPane.showMessageDialog(null,"Selecione uma opção");
            Opcao=JOptionPane.showInputDialog("""
                  ---Seng Bank---"
                  1 -Login
                  2 -Cadastrar nova conta""");
        }
        int Opcaologin=Integer.parseInt(Opcao);

        switch (Opcaologin) {
            case 1 -> {
                if (contasBancarias.size() > 0) {
                    operacoes();
                }
                JOptionPane.showMessageDialog(null, "Nenhuma conta cadastrada");
                Login();
            }
            case 2 -> {
                criarConta();
                operacoes();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção invallida");
                Login();
            }
        }
    }
    public static void operacoes() {

        String operacao = JOptionPane.showInputDialog(
                         """
                        99- Perfil\s
                        0 - Saldo\s
                        1 - Depósito\s
                        2 - Saque\s
                        3 - Área pix\s
                        4 - Transferências\s
                        5 - Pagamentos  \s
                        6 - Cartões \s
                        7 - Solicitar emprêstimos \s
                        8 - Solicitar imposto de renda\s
                        9 - Solicitar portabilidade de salario\s
                        10 -Solicitar renegociação de dividas \s
                        11- Solicitar comprovante\s
                        12- Recargas\s
                        13- Extrato\s
                        14- Contatar Suporte\s
                        15- Encerrar conta\s
                        16- Sair \s""");


        while (operacao.length()<1){
            JOptionPane.showMessageDialog(null,"Selecione um serviço");
            operacao=JOptionPane.showInputDialog("""
                     99- Perfil\s
                     0 - Saldo\s
                     1 - Depósito\s
                     2 - Saque\s
                     3 - Área pix\s
                     4 - Transferências \s
                     5 - Pagamentos   \s
                     6 - Cartões  \s
                     7 - Solicitar emprêstimos  \s
                     8 - Solicitar imposto de renda \s
                     9 - Solicitar portabilidade de salario \s
                     10 -Solicitar renegociação de dividas  \s
                     11- Solicitar comprovantes\s
                     12- Recargas\s
                     13- Extrato\s
                     14- Contatar Suporte \s
                     15- Encerrar conta\s
                     16- Sair\s""");
        }
        int operacaoEscolha=Integer.parseInt(operacao);


        switch (operacaoEscolha) {
            case 99 -> Perfil();
            case 0 -> Saldo();
            case 1 -> depositar();
            case 2 -> sacar();
            case 3 -> Pix();
            case 4 -> transferencias();
            case 5 -> Pagamentos();
            case 6 -> Cartoes();
            case 7 -> Emprestimo();
            case 8 -> impostoDeRenda();
            case 9 -> Portabilidade();
            case 10 -> RenegociacaoDividas();
            case 11 -> comprovantes();
            case 12 -> Recargas();
            case 13 -> Extratos();
            case 14 -> Suporte();
            case 15 -> encerrarConta();
            case 16 -> System.exit(0);
            default -> {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                operacoes();
            }
        }
    }
    public static void criarConta() {
        Pessoa cliente = new Pessoa();

        String name=JOptionPane.showInputDialog("Nome completo: ");
       while (name.length()<1){
           JOptionPane.showMessageDialog(null,"Campo obrigatório!");
           name=JOptionPane.showInputDialog("Nome Completo: ");
       }
       cliente.setName(name);

       String cpf=JOptionPane.showInputDialog("Cpf:");
        while (cpf.length()!=11){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!");
            cpf=JOptionPane.showInputDialog("Cpf: ");
        }
        cliente.setCpf(cpf);

         String nDia=JOptionPane.showInputDialog("Dia de nascimento: ");
        while (nDia.length()<1){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!");
            nDia=JOptionPane.showInputDialog("Dia de nascimento: ");
        }
         int dia=Integer.parseInt(nDia);

        String nMes=JOptionPane.showInputDialog("Mês de nascimento: ");
        while (nMes.length()<1){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!");
            nMes=JOptionPane.showInputDialog("Mês de nascimento: ");
        }
         int mes=Integer.parseInt(nMes);

        String nAno=JOptionPane.showInputDialog("Ano de nascimento: ");
        while (nAno.length()<1){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!");
            nAno=JOptionPane.showInputDialog("Ano de nascimento: ");
        }
         int ano=Integer.parseInt(nAno);

        if(cliente.calculoIdade(dia,mes,ano)>=18){
             cliente.setIdade(cliente.calculoIdade(dia,mes,ano));
       }else{
               JOptionPane.showMessageDialog(null,"Apenas maiores de 18 anos podem criar uma conta");
             Login();
       }

        String endereco=JOptionPane.showInputDialog("Endereço: ");
        while (endereco.length()<1){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!");
            endereco=JOptionPane.showInputDialog("Endereço: ");
        }
        cliente.setEndereco(endereco);


        String senha=JOptionPane.showInputDialog("Senha: ");
        while (senha.length()<7){
               JOptionPane.showMessageDialog(null,"A senha deve ter no mínimo 7 caracteres");
               senha=JOptionPane.showInputDialog("Senha: ");
        }
        cliente.setSenha(senha);

        String email=JOptionPane.showInputDialog("Email: ");
        while (email.length()<1){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!");
            email=JOptionPane.showInputDialog("Email: ");
        }
        cliente.setEmail(email);

        String telefone=JOptionPane.showInputDialog("Telefone: ");
        while (telefone.length()<1){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!!");
            telefone=JOptionPane.showInputDialog("Telefone: ");
        }
        cliente.setTelefone(telefone);

        String salarioBs=JOptionPane.showInputDialog("Sálario base: ");
        while (salarioBs.length()<1){
            JOptionPane.showMessageDialog(null,"Campo obrigatório!!");
            salarioBs=JOptionPane.showInputDialog("Sálario base: ");
        }
        Double salarioBase=Double.parseDouble(salarioBs);
        cliente.setSalarioBase(salarioBase);

        Conta conta = new Conta(cliente);

        conta.setEndereco(endereco);
        conta.setSenha(cliente.getSenha());
        conta.setSalario(cliente.getSalarioBase());

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

        operacoes();

    }
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta contaa : contasBancarias) {
                if (contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }
    public static void Perfil() {

        String opcao=JOptionPane.showInputDialog("""
               1-Ver dados da conta
               2-Alterar dados da conta
               0- Voltar""");

        while (opcao.length()<1){
            JOptionPane.showMessageDialog(null,"Selecione um serviço");
            opcao=JOptionPane.showInputDialog("""
                    1-Ver dados da conta
                    2-Alterar dados da conta" +
                    0- Voltar""");
        }
        int opcaoPerfil=Integer.parseInt(opcao);

        switch (opcaoPerfil) {
            case 0 -> operacoes();
            case 1 -> {
                if (contasBancarias.size() > 0) {
                    for (Conta conta : contasBancarias) {
                        JOptionPane.showMessageDialog(null, conta);
                    }
                }
                operacoes();
            }
            case 2 -> {
                int numeroConta = 1;
                Conta conta = encontrarConta(numeroConta);
                String altDados = JOptionPane.showInputDialog("""
                        1-Alterar senha
                        2-Alterar endereço
                        3-Alterar email
                        4-Alterar telefone
                        5-Alterar salario base""");
                while (altDados.length() < 1) {
                    JOptionPane.showMessageDialog(null, "Selecione um serviço!");
                    altDados = JOptionPane.showInputDialog("""
                            1-Alterar senha
                            2-Alterar endereço
                            3-Alterar email
                            4-Alterar telefone
                            5-Alterar salario base""");
                }
                int altDadosPerfil = Integer.parseInt(altDados);
                switch (altDadosPerfil) {
                    case 1 -> {
                        String senhaS = JOptionPane.showInputDialog("Senha: ");
                        if (senhaS.equals(conta.getSenha())) {

                            String senha = JOptionPane.showInputDialog("Nova senha: ");
                            while (senha.length() < 7) {
                                JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 7 caracteres");
                                senha = JOptionPane.showInputDialog("Nova senha: ");
                            }

                            conta.alterarSenha(senha);

                            JOptionPane.showMessageDialog(null, "Senha alterada");
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                        }
                    }
                    case 2 -> {
                        String senhaE = JOptionPane.showInputDialog("Senha: ");
                        if (senhaE.equals(conta.getSenha())) {

                            String endereco = JOptionPane.showInputDialog("Novo endereço: ");
                            while (endereco.length() < 1) {
                                JOptionPane.showMessageDialog(null, "Campo obrigatório!");
                                endereco = JOptionPane.showInputDialog("Novo endereço: ");
                            }
                            conta.alterarEndereco(endereco);
                            JOptionPane.showMessageDialog(null, "Endereço alterado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                        }
                    }
                    case 3 -> {
                        String senhaEm = JOptionPane.showInputDialog("Senha: ");
                        if (senhaEm.equals(conta.getSenha())) {

                            String email = JOptionPane.showInputDialog("Novo email: ");
                            while (email.length() < 1) {
                                JOptionPane.showMessageDialog(null, "Campo obrigatório!");
                                email = JOptionPane.showInputDialog("Novo email: ");
                            }

                            conta.alterarEmail(email);
                            JOptionPane.showMessageDialog(null, "Email alterado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                        }
                    }
                    case 4 -> {
                        String senhaT = JOptionPane.showInputDialog("Senha: ");
                        if (senhaT.equals(conta.getSenha())) {

                            String telefone = JOptionPane.showInputDialog("Novo telefone: ");
                            while (telefone.length() < 1) {
                                JOptionPane.showMessageDialog(null, "Campo obrigatório!!");
                                telefone = JOptionPane.showInputDialog("Novo telefone: ");
                            }

                            conta.alterarTelefone(telefone);
                            JOptionPane.showMessageDialog(null, "Telefone alterado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                        }
                    }
                    case 5 -> {
                        String senhaSal = JOptionPane.showInputDialog("Senha: ");
                        if (senhaSal.equals(conta.getSenha())) {

                            String salarioBs = JOptionPane.showInputDialog("Novo sálario base: ");
                            while (salarioBs.length() < 1) {
                                JOptionPane.showMessageDialog(null, "Campo obrigatório!!");
                                salarioBs = JOptionPane.showInputDialog("Novo sálario base: ");
                            }
                            Double salarioBase = Double.parseDouble(salarioBs);

                            conta.alterarSalario(salarioBase);
                            JOptionPane.showMessageDialog(null, "Salário Base alterado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                        }
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Opção invalida");
                        Perfil();
                    }
                }
            }
        }
        operacoes();
    }
    public static void Saldo() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                JOptionPane.showMessageDialog(null,conta.getSaldo());
            }
        }

        operacoes();
    }
    public static void depositar() {

        int numeroConta = 1;

            Conta conta = encontrarConta(numeroConta);

            Double valorDeposito = Double.parseDouble((JOptionPane.showInputDialog("Valor de deposito: ")));

            String senha=JOptionPane.showInputDialog("Senha: ");

            if(senha.equals(conta.getSenha())) {

                conta.depositar(valorDeposito);

                Extrato Extrato = new Extrato("Deposito", "Valor depositado: ", valorDeposito);

                Extratos.add(0, Extrato);

                JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");

                JOptionPane.showMessageDialog(null, Extratos.get(0));
                comprovanteDeposito++;

            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreta");
            }
        operacoes();
    }
    public static void sacar() {
        int numeroConta = 1;

        Conta conta = encontrarConta(numeroConta);

         Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Valor de saque: "));

         String senha=JOptionPane.showInputDialog("Senha: ");

         if(senha.equals(conta.getSenha())){

        if(valorSaque > 0 && conta.getSaldo() >= valorSaque+5 || valorSaque > 0 && valorSaque<=10 && conta.getSaldo() >= valorSaque ) {

            conta.sacar(valorSaque);

            JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!");

            Extrato Extrato = new Extrato("Saque\nTaxa sobre saque: R$ 5,00", "Valor do saque: ", valorSaque);

            Extratos.add(0,Extrato);

            JOptionPane.showMessageDialog(null,Extratos.get(0));
            comprovanteSaque++;
        }else {
            JOptionPane.showMessageDialog(null,"Saldo insuficiente");
        }
        operacoes();
    }else{
             JOptionPane.showMessageDialog(null,"Senha incorreta");
         }
    }
    public static void Pix(){

        String opcaoPix=JOptionPane.showInputDialog("""
                1- Ver chave pix
                2- Cadastrar chave pix
                3- Excluir chave pix
                4 -Transferir via Pix
                0 -Voltar""");

            while (opcaoPix.length()<1){
                JOptionPane.showMessageDialog(null,"Selecione um serviço!");
                opcaoPix=JOptionPane.showInputDialog("""
                        1- Ver chave pix
                        2- Cadastrar chave pix
                        3 -Transferir via pix
                        0 -Voltar""");
            }
            int opcaoPiix=Integer.parseInt(opcaoPix);

            switch (opcaoPiix) {
                case 0 -> operacoes();
                case 1 -> {
                    int numeroContaChaves = 1;
                    Conta contaChaves = encontrarConta(numeroContaChaves);
                    JOptionPane.showMessageDialog(null, "Chave cpf/cnpj: " + contaChaves.getPixCpfCnpj() +
                            "\nChave email: " + contaChaves.getPixEmail() +
                            "\nChave telefone: " + contaChaves.getPixTelefone() +
                            "\nChave aleatória: " + contaChaves.getPixAleatoria());
                    Pix();
                }
                case 2 -> {
                    String cadastroPix = JOptionPane.showInputDialog("""
                            1- Chave pix cpf/cnpj
                            2- Chave pix email
                            3- Chave pix telefone
                            4- Chave pix aleatória""");
                    while (cadastroPix.length() < 1) {
                        JOptionPane.showMessageDialog(null, "Selecione um serviço");
                        cadastroPix = JOptionPane.showInputDialog("""
                                1- Chave pix cpf/cnpj
                                2- Chave pix email
                                3- Chave pix telefone
                                4- Chave pix aleatória""");
                    }
                    int cadastroPiix = Integer.parseInt(cadastroPix);
                    switch (cadastroPiix) {
                        case 1 -> {
                            int numeroContaCp = 1;
                            Conta contaCp = encontrarConta(numeroContaCp);
                            String senhaCp = JOptionPane.showInputDialog("Senha: ");
                            if (senhaCp.equals(contaCp.getSenha())) {
                                String chaveCp = JOptionPane.showInputDialog("Digite a chave desejada:");
                                contaCp.cadastroPixCpfCnpj(chaveCp);
                                JOptionPane.showMessageDialog(null, "Chave pix cpf/cnpj cadastrada");
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");
                            }
                            Pix();
                        }
                        case 2 -> {
                            int numeroContaEm = 1;
                            Conta contaEm = encontrarConta(numeroContaEm);
                            String senhaEm = JOptionPane.showInputDialog("Senha: ");
                            if (senhaEm.equals(contaEm.getSenha())) {
                                String chaveEm = JOptionPane.showInputDialog("Digite a chave desejada:");
                                JOptionPane.showMessageDialog(null, "Chave pix email cadastrada");
                                contaEm.cadastroPixEmail(chaveEm);
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");
                            }
                            Pix();
                        }
                        case 3 -> {
                            int numeroContaTel = 1;
                            Conta contaTel = encontrarConta(numeroContaTel);
                            String senhaTel = JOptionPane.showInputDialog("Senha: ");
                            if (senhaTel.equals(contaTel.getSenha())) {
                                String chaveTel = JOptionPane.showInputDialog("Digite a chave desejada:");
                                contaTel.cadastroPixTelefone(chaveTel);
                                JOptionPane.showMessageDialog(null, "Chave pix telefone cadastrada");
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");
                            }
                            Pix();
                        }
                        case 4 -> {
                            int numeroContaAl = 1;
                            Conta contaAl = encontrarConta(numeroContaAl);
                            String senhaAl = JOptionPane.showInputDialog("Senha: ");
                            if (senhaAl.equals(contaAl.getSenha())) {
                                String chaveAl = JOptionPane.showInputDialog("Digite a chave desejada:");
                                contaAl.cadastroPixAleatoria(chaveAl);
                                JOptionPane.showMessageDialog(null, "Chave pix aleatória cadastrada");
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");
                            }
                            Pix();
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                            operacoes();
                        }
                    }
                }


                case 3->{
                    String excluirPix = JOptionPane.showInputDialog("""
                            1- Excluir chave pix cpf/cnpj
                            2- Excluir chave pix email
                            3- Excluir chave pix telefone
                            4- Excluir chave pix aleatória""");
                    while (excluirPix.length() < 1) {
                        JOptionPane.showMessageDialog(null, "Selecione um serviço");
                        excluirPix = JOptionPane.showInputDialog("""
                            1- Excluir chave pix cpf/cnpj
                            2- Excluir chave pix email
                            3- Excluir chave pix telefone
                            4- Excluir chave pix aleatória""");
                    }
                    int cadastroPiix = Integer.parseInt(excluirPix);
                    switch (cadastroPiix) {
                        case 1 -> {
                            int numeroContaCp = 1;
                            Conta contaCp = encontrarConta(numeroContaCp);
                            if(contaCp.getPixCpfCnpj()!="Não cadastrada") {
                                String senhaCp = JOptionPane.showInputDialog("Senha: ");
                                if (senhaCp.equals(contaCp.getSenha())) {
                                    String chaveCp ="Não cadastrada";
                                    contaCp.excluirPixCpfCnpj(chaveCp);
                                    JOptionPane.showMessageDialog(null, "Chave pix cpf/cnpj cancelada");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                                }
                            }else{JOptionPane.showMessageDialog(null,"Chave pix cpf/cnpj não cadastrada");}
                            Pix();
                        }
                        case 2 -> {
                            int numeroContaEm = 1;
                            Conta contaEm = encontrarConta(numeroContaEm);
                            if(contaEm.getPixEmail()!="Não cadastrada") {
                                String senhaEm = JOptionPane.showInputDialog("Senha: ");
                                if (senhaEm.equals(contaEm.getSenha())) {
                                    String chaveEm = "Não cadastrada";
                                    contaEm.excluirPixEmail(chaveEm);
                                    JOptionPane.showMessageDialog(null, "Chave pix email cancelada");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                                }
                            }else{JOptionPane.showMessageDialog(null,"Chave pix email não cadastrada");}
                            Pix();
                        }
                        case 3 -> {
                            int numeroContaTel = 1;
                            Conta contaTel = encontrarConta(numeroContaTel);
                            if(contaTel.getPixTelefone()!="Não cadastrada") {

                                String senhaTel = JOptionPane.showInputDialog("Senha: ");
                                if (senhaTel.equals(contaTel.getSenha())) {
                                    String chaveTel = "Não cadastrada";
                                    contaTel.excluirPixTelefone(chaveTel);
                                    JOptionPane.showMessageDialog(null, "Chave pix telefone cancelada");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                                }
                             }else{JOptionPane.showMessageDialog(null,"Chave pix telefone não cadastrada");}
                            Pix();
                        }
                        case 4 -> {

                            int numeroContaAl = 1;
                            Conta contaAl = encontrarConta(numeroContaAl);

                            if(contaAl.getPixAleatoria()!="Não cadastrada") {
                                String senhaAl = JOptionPane.showInputDialog("Senha: ");
                                if (senhaAl.equals(contaAl.getSenha())) {
                                    String chaveAl = "Não cadastrada";
                                    contaAl.excluirPixAleatoria(chaveAl);
                                    JOptionPane.showMessageDialog(null, "Chave pix aleatória cancelada");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                                }
                            }else{JOptionPane.showMessageDialog(null,"Chave pix aleatória não cadastrada");}
                            Pix();
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                            operacoes();
                        }
                    }




                }

                case 4 -> {
                    int numeroContaP = 1;
                    Conta contaP = encontrarConta(numeroContaP);
                    String destinatarioP = JOptionPane.showInputDialog("Chave Pix: ");
                    Double valorP = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));
                    String senhaP = JOptionPane.showInputDialog("Senha: ");
                    if (senhaP.equals(contaP.getSenha())) {
                        if (valorP > 0 && contaP.getSaldo() >= valorP) {

                            contaP.transferenciaPix(valorP);

                            Extrato ExtratoP = new Extrato("Transferência via pix\ndestinatario: ", destinatarioP + "\nvalor:", valorP);

                            Extratos.add(0, ExtratoP);

                            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");

                            JOptionPane.showMessageDialog(null, Extratos.get(0));
                            comprovanteTransferencia++;
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                    }
                    operacoes();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    operacoes();
                }
            }


    }
    public static void transferencias() {

        String tipoTransferencia=JOptionPane.showInputDialog("""
                1-Transferir via ted
                2-Transferir via doc
                3-Transferir via pix
                4-Agendamentos
                0- Voltar""");

            while (tipoTransferencia.length()<1){
                JOptionPane.showMessageDialog(null,"Selecione um serviço");
                tipoTransferencia=JOptionPane.showInputDialog("""
                        1-Transferir via ted
                        2-Transferir via doc
                        3-Transferir via pix
                        4-Agendamentos
                        0- Voltar""");
            }
            int tipoTransfereciaTipo=Integer.parseInt(tipoTransferencia);

            switch (tipoTransfereciaTipo) {
                case 0 -> operacoes();
                case 1 -> {
                    int numeroContaT = 1;
                    Conta contaT = encontrarConta(numeroContaT);
                    String destinatarioT = JOptionPane.showInputDialog("Numero do destinatario: ");
                    while (destinatarioT.length()<1){
                        JOptionPane.showMessageDialog(null,"Informe o destinatário");
                        destinatarioT = JOptionPane.showInputDialog("Número do destinatário: ");
                    }

                    Double valorT = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));
                    String senhaT = JOptionPane.showInputDialog("Senha: ");
                    if (senhaT.equals(contaT.getSenha())) {

                        if (valorT > 0 && contaT.getSaldo() >= valorT) {

                            contaT.transferenciaTed(valorT);

                            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");

                            Extrato Extrato = new Extrato("Transferência via ted\ndestinatario: ", destinatarioT + "\nTaxa: R$ 13,70" + "\nvalor:", valorT);

                            Extratos.add(0, Extrato);
                            JOptionPane.showMessageDialog(null, Extratos.get(0));
                            comprovanteTransferencia++;
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                    }
                }
                case 2 -> {
                    int numeroContaD = 1;
                    Conta contaD = encontrarConta(numeroContaD);
                    String destinatarioD = JOptionPane.showInputDialog("Numero do destinatario: ");
                    while (destinatarioD.length()<1){
                        JOptionPane.showMessageDialog(null,"Informe o destinatário");
                        destinatarioD = JOptionPane.showInputDialog("Número do destinatário: ");
                    }

                    Double valorD = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));
                    String senhaD = JOptionPane.showInputDialog("Senha: ");
                    if (senhaD.equals(contaD.getSenha())) {

                        if (valorD > 0 && contaD.getSaldo() >= valorD) {

                            contaD.transferenciaDoc(valorD);

                            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");

                            Extrato ExtratoD = new Extrato("Transferência via doc\ndestinatario: ", destinatarioD + "\nTaxa sobre doc: R$ 11,90" + "\nvalor:", valorD);

                            Extratos.add(0, ExtratoD);
                            JOptionPane.showMessageDialog(null, Extratos.get(0));
                            comprovanteTransferencia++;

                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                    }
                }
                case 3 -> {
                    int numeroContaP = 1;
                    Conta contaP = encontrarConta(numeroContaP);
                    String destinatarioP = JOptionPane.showInputDialog("Chave Pix: ");
                    while (destinatarioP.length()<1){
                        JOptionPane.showMessageDialog(null,"Informe a chave pix");
                        destinatarioP = JOptionPane.showInputDialog("Chave Pix: ");
                    }

                    Double valorP = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));
                    String senhaP = JOptionPane.showInputDialog("Senha: ");
                    if (senhaP.equals(contaP.getSenha())) {

                        if (valorP > 0 && contaP.getSaldo() >= valorP) {

                            contaP.transferenciaPix(valorP);

                            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");

                            Extrato ExtratoP = new Extrato("Transferência via pix\ndestinatario: ", destinatarioP + "\nvalor:", valorP);

                            Extratos.add(0, ExtratoP);
                            JOptionPane.showMessageDialog(null, Extratos.get(0));
                            comprovanteTransferencia++;

                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                    }
                }
                case 4 -> {

                    String tipoAgendamento=JOptionPane.showInputDialog("""
                            Selecione um serviço:
                            1-Agendar transferência
                            2-Cancelar transferência""");
                    while (tipoAgendamento.length() < 1) {
                        JOptionPane.showMessageDialog(null, "Selecione um serviço");
                        tipoAgendamento = JOptionPane.showInputDialog("""
                            Selecione um serviço:
                            1-Agendar transferência
                            2-Cancelar transferência""");
                    }
                    int tipoAgendamentoo=Integer.parseInt(tipoAgendamento);

                    switch (tipoAgendamentoo){

                        case 1 ->{
                            String opcaoAgendameto = JOptionPane.showInputDialog("""
                            1-Agendar transferência via ted
                            2-Agendar transferência via doc
                            3-Agendar transferência via pix""");
                            while (opcaoAgendameto.length() < 1) {
                                JOptionPane.showMessageDialog(null, "Selecione um serviço");
                                opcaoAgendameto = JOptionPane.showInputDialog("""
                                1-Agendar transferência via ted
                                2-Agendar transferência via doc
                                3-Agendar transferência via pix""");
                            }
                            int opcaoAgendametoTipo = Integer.parseInt(opcaoAgendameto);
                            switch (opcaoAgendametoTipo) {
                                case 1 -> {
                                    String destinatarioAgendamentoT = JOptionPane.showInputDialog("Número do destinatário: ");
                                    while (destinatarioAgendamentoT.length()<1){
                                        JOptionPane.showMessageDialog(null,"Informe o destinatário");
                                        destinatarioAgendamentoT = JOptionPane.showInputDialog("Número do destinatário: ");
                                    }

                                    int diaT= Integer.parseInt(JOptionPane.showInputDialog("Dia agendamento:"));
                                    while (diaT>31 || diaT<=0 ){
                                        JOptionPane.showMessageDialog(null,"Selecione um dia valido");
                                        diaT= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                    }

                                    int mesT= Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                    while (mesT>12 || mesT<5){
                                        JOptionPane.showMessageDialog(null,"Selecione um mes" +
                                                " valido");
                                        mesT= Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                    }

                                    Calendar ano= Calendar.getInstance();
                                    LocalDate dataAgendamento=LocalDate.of(ano.get(Calendar.YEAR),mesT,diaT);
                                    DateTimeFormatter formatar=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    String dataAgendamentoT= formatar.format(dataAgendamento);

                                    Double valorAgendamentoT = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));
                                    int numeroContaaT = 1;
                                    Conta contaaT = (encontrarConta(numeroContaaT));
                                    String senhaaT = JOptionPane.showInputDialog("Senha: ");

                                    if (senhaaT.equals(contaaT.getSenha())) {
                                        Extrato ExtratoT = new Extrato("Transferência via ted" +
                                                "\nData: " + dataAgendamentoT +
                                                "\nDestinatário: ", destinatarioAgendamentoT +
                                                "\nvalor: ", valorAgendamentoT);
                                        Extratos.add(0, ExtratoT);
                                        JOptionPane.showMessageDialog(null, "Transferência agendada com sucesso!");

                                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                                        comprovanteTransferencia++;

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                                    }
                                }
                                case 2 -> {
                                    String destinatarioAgendamentoD = JOptionPane.showInputDialog("Número do destinatário: ");
                                    while (destinatarioAgendamentoD.length()<1){
                                        JOptionPane.showMessageDialog(null,"Informe o destinatário");
                                        destinatarioAgendamentoD = JOptionPane.showInputDialog("Número do destinatário: ");
                                    }

                                    int diaD= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                    while (diaD>31 || diaD<=0){
                                        JOptionPane.showMessageDialog(null,"Selecione um dia valido");
                                        diaD= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                    }
                                    int mesD= Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                    while (mesD>12 || mesD<5){
                                        JOptionPane.showMessageDialog(null,"Selecione um mes" +
                                                " valido");
                                        mesD= Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                    }

                                    Calendar ano= Calendar.getInstance();
                                    LocalDate dataAgendamento=LocalDate.of(ano.get(Calendar.YEAR),mesD,diaD);
                                    DateTimeFormatter formatar=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    String dataAgendamentoD= formatar.format(dataAgendamento);

                                    Double valorAgendamentoD = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));
                                    int numeroContaaD = 1;
                                    Conta contaaD = (encontrarConta(numeroContaaD));
                                    String senhaaD = JOptionPane.showInputDialog("Senha: ");
                                    if (senhaaD.equals(contaaD.getSenha())) {

                                        Extrato ExtratoD = new Extrato("Transferência via doc" +
                                                "\nData: " + dataAgendamentoD +
                                                "\nDestinatário: ", destinatarioAgendamentoD +
                                                "\nvalor: ", valorAgendamentoD);
                                        Extratos.add(0, ExtratoD);
                                        JOptionPane.showMessageDialog(null, "Transferência agendada com sucesso!");

                                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                                        comprovanteTransferencia++;

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                                    }
                                }
                                case 3 -> {
                                    String chaveP = JOptionPane.showInputDialog("Chave pix: ");
                                    while (chaveP.length()<1){
                                        JOptionPane.showMessageDialog(null,"Informe a chave pix");
                                        chaveP = JOptionPane.showInputDialog("Chave pix: ");
                                    }

                                    int diaP= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                    while (diaP>31 || diaP<=0){
                                        JOptionPane.showMessageDialog(null,"Selecione um dia valido");
                                        diaP= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                    }
                                    int mesP= Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                    while (mesP>12 || mesP<5){
                                        JOptionPane.showMessageDialog(null,"Selecione um mes" +
                                                " valido");
                                        mesP= Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                    }

                                    Calendar ano= Calendar.getInstance();
                                    LocalDate dataAgendamento=LocalDate.of(ano.get(Calendar.YEAR),mesP,diaP);
                                    DateTimeFormatter formatar=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    String dataAgendamentoP= formatar.format(dataAgendamento);

                                    Double valorAgendamentoP = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));
                                    int numeroContaaP = 1;
                                    Conta contaaP = (encontrarConta(numeroContaaP));
                                    String senhaaP = JOptionPane.showInputDialog("Senha: ");
                                    if (senhaaP.equals(contaaP.getSenha())) {

                                        Extrato ExtratoP = new Extrato("Transferência via pix" +
                                                "\nData: " + dataAgendamentoP +
                                                "\nDestinatário: ", chaveP +
                                                "\nvalor: ", valorAgendamentoP);
                                        Extratos.add(0, ExtratoP);
                                        JOptionPane.showMessageDialog(null, "Transferência agendada com sucesso!");

                                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                                        comprovanteTransferencia++;

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                                    }
                                }
                                default -> {
                                    JOptionPane.showMessageDialog(null, "Opção inválida ");
                                    transferencias();
                                }
                            }
                        }


                        case 2-> {

                            String opcaoCancelaAgendameto = JOptionPane.showInputDialog("""
                                    1-Cancelar transferência via ted
                                    2-Cancelar transferência via doc
                                    3-Cancelar transferência via pix""");
                            while (opcaoCancelaAgendameto.length() < 1) {
                                JOptionPane.showMessageDialog(null, "Selecione um serviço");
                                opcaoCancelaAgendameto = JOptionPane.showInputDialog("""
                                        1-Cancelar transferência via ted
                                        2-Cancelar transferência via doc
                                        3-Cancelar transferência via pix""");
                            }
                            int opcaoCancelaAgendametoTipo = Integer.parseInt(opcaoCancelaAgendameto);

                            switch (opcaoCancelaAgendametoTipo) {

                                case 1 -> {

                                    if (Extratos.size() > 0 && comprovanteTransferencia > 0) {

                                        int diaT = Integer.parseInt(JOptionPane.showInputDialog("Dia agendamento:"));
                                        while (diaT > 31 || diaT <= 0) {
                                            JOptionPane.showMessageDialog(null, "Selecione um dia valido");
                                            diaT = Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                        }

                                        int mesT = Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                        while (mesT > 12 || mesT < 5) {
                                            JOptionPane.showMessageDialog(null, "Selecione um mes" +
                                                    " valido");
                                            mesT = Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                        }

                                        Calendar ano = Calendar.getInstance();
                                        LocalDate dataCancelaAgendamento = LocalDate.of(ano.get(Calendar.YEAR), mesT, diaT);
                                        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        String dCancelaT = formatar.format(dataCancelaAgendamento);
                                        String destinatarioAgendamentoT = "cancelado";
                                        Double valorAgendamentoT = 0.0;

                                        int numeroContaaT = 1;
                                        Conta contaaT = (encontrarConta(numeroContaaT));
                                        String senhaaT = JOptionPane.showInputDialog("Senha: ");
                                        if (senhaaT.equals(contaaT.getSenha())) {
                                        for (int i = 0; i < Extratos.size(); i++) {
                                            if (Extratos.get(i).TipoOperacao.contains("Transferência via ted" +
                                                    "\nData: " + dCancelaT)) {
                                                Extratos.remove(i);

                                                Extrato ExtratoT = new Extrato("Transferência via ted cancelada" +
                                                        "\nData: " + dCancelaT +
                                                        "\nDestinatário: ", destinatarioAgendamentoT +
                                                        "\nvalor: ", valorAgendamentoT);
                                                Extratos.add(0, ExtratoT);
                                                JOptionPane.showMessageDialog(null, "Transferência cancelada com sucesso!");

                                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                                                comprovanteTransferencia++;

                                            }
                                        }


                                    } else {
                                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                                        }
                                    }else{
                                             JOptionPane.showMessageDialog(null,"Não há operações");
                                    }
                                }

                                case 2 -> {

                                    if (Extratos.size() > 0 && comprovanteTransferencia > 0) {

                                        int diaD = Integer.parseInt(JOptionPane.showInputDialog("Dia agendamento:"));
                                        while (diaD > 31 || diaD <= 0) {
                                            JOptionPane.showMessageDialog(null, "Selecione um dia valido");
                                            diaD = Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                        }

                                        int mesD = Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                        while (mesD > 12 || mesD < 5) {
                                            JOptionPane.showMessageDialog(null, "Selecione um mes" +
                                                    " valido");
                                            mesD = Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                        }

                                        Calendar ano = Calendar.getInstance();
                                        LocalDate dataCancelaAgendamento = LocalDate.of(ano.get(Calendar.YEAR), mesD, diaD);
                                        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        String dCancelaD = formatar.format(dataCancelaAgendamento);
                                        String destinatarioAgendamentoD = "cancelado";
                                        Double valorAgendamentoD = 0.0;

                                        int numeroContaaT = 1;
                                        Conta contaaT = (encontrarConta(numeroContaaT));
                                        String senhaaT = JOptionPane.showInputDialog("Senha: ");
                                        if (senhaaT.equals(contaaT.getSenha())) {

                                        for (int i = 0; i < Extratos.size(); i++) {

                                            if (Extratos.get(i).TipoOperacao.contains("Transferência via doc" +
                                                    "\nData: " + dCancelaD)) {
                                                Extratos.remove(i);

                                                Extrato ExtratoD = new Extrato("Transferência via doc cancelada" +
                                                        "\nData: " + dCancelaD +
                                                        "\nDestinatário: ", destinatarioAgendamentoD +
                                                        "\nvalor: ", valorAgendamentoD);
                                                Extratos.add(0, ExtratoD);
                                                JOptionPane.showMessageDialog(null, "Transferência cancelada com sucesso!");

                                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                                                comprovanteTransferencia++;

                                            }
                                        }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Não há operações");
                                    }
                                }

                                case 3 -> {

                                    if (Extratos.size() > 0 && comprovanteTransferencia > 0) {

                                        int diaP = Integer.parseInt(JOptionPane.showInputDialog("Dia agendamento:"));
                                        while (diaP > 31 || diaP <= 0) {
                                            JOptionPane.showMessageDialog(null, "Selecione um dia valido");
                                            diaP = Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                        }

                                        int mesP = Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                        while (mesP > 12 || mesP < 5) {
                                            JOptionPane.showMessageDialog(null, "Selecione um mes" +
                                                    " valido");
                                            mesP = Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                        }

                                        Calendar ano = Calendar.getInstance();
                                        LocalDate dataCancelaAgendamento = LocalDate.of(ano.get(Calendar.YEAR), mesP, diaP);
                                        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        String dCancelaP = formatar.format(dataCancelaAgendamento);
                                        String destinatarioAgendamentoP = "cancelado";
                                        Double valorAgendamentoP = 0.0;

                                        int numeroContaaT = 1;
                                        Conta contaaT = (encontrarConta(numeroContaaT));
                                        String senhaaT = JOptionPane.showInputDialog("Senha: ");
                                        if (senhaaT.equals(contaaT.getSenha())) {

                                        for (int i = 0; i < Extratos.size(); i++) {

                                            if (Extratos.get(i).TipoOperacao.contains("Transferência via pix" +
                                                    "\nData: " + dCancelaP)) {
                                                Extratos.remove(i);

                                                Extrato ExtratoP = new Extrato("Transferência via pix cancelada" +
                                                        "\nData: " + dCancelaP +
                                                        "\nDestinatário: ", destinatarioAgendamentoP +
                                                        "\nvalor: ", valorAgendamentoP);
                                                Extratos.add(0, ExtratoP);
                                                JOptionPane.showMessageDialog(null, "Transferência cancelada com sucesso!");

                                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                                                comprovanteTransferencia++;


                                            }
                                        }

                                    } else {
                                            JOptionPane.showMessageDialog(null, "Senha incorreta");
                                        }

                                    }else{
                                        JOptionPane.showMessageDialog(null,"Não há operações");
                                    }

                                }

                            }
                        }

                        default -> {
                            JOptionPane.showMessageDialog(null,"Opção inválida");
                            operacoes();
                        }

                    }
                }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida");
            }
            transferencias();
    }


    public static void Pagamentos(){
       String opcaoPagamento=JOptionPane.showInputDialog("""
                1- Pagar boleto
                2- Pagar boleto via cartão virtual
                3- Agendar pagamento
                0- Voltar
               """);

        while (opcaoPagamento.length()<1){
            JOptionPane.showMessageDialog(null,"Selecione um serviço");
            opcaoPagamento=JOptionPane.showInputDialog("""
                     1- Pagar boleto
                     2- Pagar boleto via cartão virtual
                     3- Agendar pagamento
                     0- Voltar
                    """);
        }
        int opcaoPamentoTipo=Integer.parseInt(opcaoPagamento);

        switch (opcaoPamentoTipo) {
            case 0 -> operacoes();
            case 1 -> {
                int numeroContaB = 1;
                Conta contaB = encontrarConta(numeroContaB);
                String codBarras = JOptionPane.showInputDialog("Código de barras: ");
                if (codBarras.length() == 48) {

                    Double valorB = Double.parseDouble(JOptionPane.showInputDialog("Confirme valor do boleto"));

                    int numeroContaaB = 1;
                    Conta contaaB = (encontrarConta(numeroContaaB));
                    String senhaaB = JOptionPane.showInputDialog("Senha: ");
                    if (senhaaB.equals(contaaB.getSenha())) {

                        if (valorB > 0 && contaB.getSaldo() >= valorB) {

                            contaB.pagamentoBoleto(valorB);

                            JOptionPane.showMessageDialog(null, "Boleto pago com sucesso!");

                            Extrato Extrato = new Extrato("Pagamento via boleto\ncodigo de barras: ", codBarras + "\nvalor:", valorB);

                            Extratos.add(0, Extrato);
                            JOptionPane.showMessageDialog(null, Extratos.get(0));
                            comprovantePagamento++;
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Código de barras incorreto");
                    Pagamentos();
                }
            }
            case 2 -> {
                int numeroContaV = 1;
                Conta contaV = encontrarConta(numeroContaV);
                String codBarrasV = JOptionPane.showInputDialog("Código de barras: ");
                if (codBarrasV.length() == 48) {
                    Double valorV = Double.parseDouble(JOptionPane.showInputDialog("Confirme valor do boleto"));
                    int numeroContaaV = 1;
                    Conta contaaV = (encontrarConta(numeroContaaV));
                    String senhaaV = JOptionPane.showInputDialog("Senha: ");
                    if (senhaaV.equals(contaaV.getSenha())) {
                        if (valorV < contaV.getCartaoVirtual()) {
                            contaV.pagamentoCartaoVirtual(valorV);
                            JOptionPane.showMessageDialog(null, "Boleto pago com sucesso!");
                            Extrato Extrato = new Extrato("Pagamento via cartão virtual\ncodigo de barras: ", codBarrasV + "\nTaxa sobre cartão de virtual: " +
                                    "R$ 0,50" + "\nvalor:", valorV);
                            Extratos.add(0, Extrato);
                            JOptionPane.showMessageDialog(null, Extratos.get(0));
                            comprovantePagamento++;
                            operacoes();
                        } else {
                            JOptionPane.showMessageDialog(null, "Limite do cartão de " +
                                    "virtual insuficiente");}
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta");}
                } else {
                    JOptionPane.showMessageDialog(null, "Código de barras incompleto");}}
            case 3 -> {

                String opcaoAgendamento=JOptionPane.showInputDialog("""
                        selecione um serviço:
                        1-Agendar pagamento
                        2-Cancelar agendamento""");
                while (opcaoAgendamento.length() < 1) {
                    JOptionPane.showMessageDialog(null, "Selecione um serviço");
                    opcaoAgendamento = JOptionPane.showInputDialog("""
                        selecione um serviço:
                        1-Agendar pagamento
                        2-Cancelar agendamento""");
                }
                int opcaoAgendamentoo = Integer.parseInt(opcaoAgendamento);

                switch (opcaoAgendamentoo){

                    case 1->{

                        String opcaoAgendamentoBoletos = JOptionPane.showInputDialog("""
                        1-Saldo em conta
                        2- Cartão virtual""");
                        while (opcaoAgendamentoBoletos.length() < 1) {
                            JOptionPane.showMessageDialog(null, "Selecione um serviço");
                            opcaoAgendamentoBoletos = JOptionPane.showInputDialog("""
                            1-Saldo em conta
                            2- Cartão virtual""");
                        }
                        int opcaoAgendamentoBoletosTipo = Integer.parseInt(opcaoAgendamentoBoletos);
                        switch (opcaoAgendamentoBoletosTipo) {
                            case 1 -> {
                                int diaB= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                while (diaB>31 || diaB<=0){
                                    JOptionPane.showMessageDialog(null,"Selecione um dia valido");
                                    diaB= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));}
                                int mesB= Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                while (mesB>12 || mesB<5){
                                    JOptionPane.showMessageDialog(null,"Selecione um mes" +
                                            " valido");
                                    mesB= Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));}
                                Calendar ano= Calendar.getInstance();
                                LocalDate dataAgendamento=LocalDate.of(ano.get(Calendar.YEAR),mesB,diaB);
                                DateTimeFormatter formatar=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                String dataB= formatar.format(dataAgendamento);
                                String codBarrasBoleto = JOptionPane.showInputDialog("Código de barras:");
                                if (codBarrasBoleto.length() == 48) {
                                    Double valorBoleto = Double.parseDouble(JOptionPane.showInputDialog("Valor da conta:"));
                                    int numeroContaaV = 1;
                                    Conta contaaV = (encontrarConta(numeroContaaV));
                                    String senhaaV = JOptionPane.showInputDialog("Senha: ");
                                    if (senhaaV.equals(contaaV.getSenha())) {
                                        Extrato ExtratoB = new Extrato("Pagamento via saldo" +
                                                "\nData: " + dataB +
                                                "\nCodigo de barras: ", codBarrasBoleto +
                                                "\nvalor: ", valorBoleto);
                                        Extratos.add(0, ExtratoB);
                                        JOptionPane.showMessageDialog(null, "Pagamento agendado com sucesso!");
                                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                                        comprovantePagamento++;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Senha incorreta");}
                                } else {
                                    JOptionPane.showMessageDialog(null, "Código de barras incompleto");}
                                Pagamentos();}
                            case 2 -> {
                                int diaV= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                while (diaV>31 || diaV<=0){
                                    JOptionPane.showMessageDialog(null,"Selecione um dia valido");
                                    diaV= Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                }
                                int mesV= Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                while (mesV>12 || mesV<5){
                                    JOptionPane.showMessageDialog(null,"Selecione um mes" +
                                            " valido");
                                    mesV= Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                }

                                Calendar ano= Calendar.getInstance();
                                LocalDate dataAgendamento=LocalDate.of(ano.get(Calendar.YEAR),mesV,diaV);
                                DateTimeFormatter formatar=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                String dataV= formatar.format(dataAgendamento);

                                String codBarrasCartao = JOptionPane.showInputDialog("Código de barras:");
                                if (codBarrasCartao.length() == 48) {

                                    Double valorBoletoV = Double.parseDouble(JOptionPane.showInputDialog("Valor da conta:"));

                                    int numeroContaaV = 1;
                                    Conta contaaV = (encontrarConta(numeroContaaV));
                                    String senhaaV = JOptionPane.showInputDialog("Senha: ");
                                    if (senhaaV.equals(contaaV.getSenha())) {

                                        Extrato ExtratoV = new Extrato("Pagamento via cartão virtual" +
                                                "\nData: " + dataV +
                                                "\ncodigo de barras: ", codBarrasCartao +
                                                "\nvalor: ", valorBoletoV);
                                        Extratos.add(0, ExtratoV);
                                        JOptionPane.showMessageDialog(null, "Pagamento agendado com sucesso!");
                                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                                        comprovantePagamento++;

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Código de barras incompleto");
                                }
                            }
                            default -> JOptionPane.showMessageDialog(null, "Caso deseje o serviço refaça a operação novamente");
                        }
                        Pagamentos();

                    }

                    case 2-> {
                        String opcaoCancelaAgendameto = JOptionPane.showInputDialog("""
                                1-Cancelar pagamento via saldo
                                2-Cancelar pagamento via cartão virtual""");
                        while (opcaoCancelaAgendameto.length() < 1) {
                            JOptionPane.showMessageDialog(null, "Selecione um serviço");
                            opcaoCancelaAgendameto = JOptionPane.showInputDialog("""
                                    1-Cancelar pagamento via saldo
                                    2-Cancelar pagamento via cartão virtual""");
                        }
                        int opcaoCancelaAgendametoTipo = Integer.parseInt(opcaoCancelaAgendameto);


                        switch (opcaoCancelaAgendametoTipo) {
                            case 1 -> {

                                if (Extratos.size() > 0 && comprovantePagamento > 0) {

                                    int diaS = Integer.parseInt(JOptionPane.showInputDialog("Dia agendamento:"));
                                    while (diaS > 31 || diaS <= 0) {
                                        JOptionPane.showMessageDialog(null, "Selecione um dia valido");
                                        diaS = Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));
                                    }

                                    int mesS = Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                    while (mesS > 12 || mesS < 5) {
                                        JOptionPane.showMessageDialog(null, "Selecione um mes" +
                                                " valido");
                                        mesS = Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));
                                    }

                                    Calendar ano = Calendar.getInstance();
                                    LocalDate dataCancelaAgendamento = LocalDate.of(ano.get(Calendar.YEAR), mesS, diaS);
                                    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    String dCancelaS = formatar.format(dataCancelaAgendamento);
                                    String destinatarioAgendamentoS = "cancelado";
                                    Double valorAgendamentoS = 0.0;

                                    int numeroContaaT = 1;
                                    Conta contaaT = (encontrarConta(numeroContaaT));
                                    String senhaaT = JOptionPane.showInputDialog("Senha: ");
                                    if (senhaaT.equals(contaaT.getSenha())) {

                                        for (int i = 0; i < Extratos.size(); i++) {

                                            if (Extratos.get(i).TipoOperacao.contains("Pagamento via saldo" +
                                                    "\nData: " + dCancelaS)) {
                                                Extratos.remove(i);

                                                Extrato ExtratoS = new Extrato("Pagamento via saldo cancelada" +
                                                        "\nData: " + dCancelaS +
                                                        "\nDestinatário: ", destinatarioAgendamentoS +
                                                        "\nvalor: ", valorAgendamentoS);
                                                Extratos.add(0, ExtratoS);
                                                JOptionPane.showMessageDialog(null, "Transferência cancelada com sucesso!");

                                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                                                comprovanteTransferencia++;

                                            }
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null,"Não há operações");
                                }
                            }

                            case 2->{
                                if (Extratos.size() > 0 && comprovantePagamento > 0) {
                                    int diaV = Integer.parseInt(JOptionPane.showInputDialog("Dia agendamento:"));
                                    while (diaV > 31 || diaV <= 0) {
                                        JOptionPane.showMessageDialog(null, "Selecione um dia valido");
                                        diaV = Integer.parseInt(JOptionPane.showInputDialog("Dia do agendamento:"));}
                                    int mesV = Integer.parseInt(JOptionPane.showInputDialog("Mês agendamento:"));
                                    while (mesV > 12 || mesV < 5) {
                                        JOptionPane.showMessageDialog(null, "Selecione um mes" +
                                                " valido");
                                        mesV = Integer.parseInt(JOptionPane.showInputDialog("Mês do agendamento:"));}
                                    Calendar ano = Calendar.getInstance();
                                    LocalDate dataCancelaAgendamento = LocalDate.of(ano.get(Calendar.YEAR), mesV, diaV);
                                    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    String dCancelaV = formatar.format(dataCancelaAgendamento);
                                    String destinatarioAgendamentoV = "cancelado";
                                    Double valorAgendamentoV = 0.0;
                                    int numeroContaaT = 1;
                                    Conta contaaT = (encontrarConta(numeroContaaT));
                                    String senhaaT = JOptionPane.showInputDialog("Senha: ");
                                    if (senhaaT.equals(contaaT.getSenha())) {
                                        for (int i = 0; i < Extratos.size(); i++) {
                                            if (Extratos.get(i).TipoOperacao.contains("Pagamento via cartão virtual" +
                                                    "\nData: " + dCancelaV)) {
                                                Extratos.remove(i);
                                                Extrato ExtratoS = new Extrato("Pagamento via saldo cancelada" +
                                                        "\nData: " + dCancelaV +
                                                        "\nDestinatário: ", destinatarioAgendamentoV +
                                                        "\nvalor: ", valorAgendamentoV);
                                                Extratos.add(0, ExtratoS);
                                                JOptionPane.showMessageDialog(null, "Transferência " +
                                                        "cancelada com sucesso!");
                                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                                                comprovanteTransferencia++;}}
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Senha incorreta");}
                                }else{
                                    JOptionPane.showMessageDialog(null,"Não há operações");}}}}

                    default -> {
                        JOptionPane.showMessageDialog(null,"Opção inválida");
                        Pagamentos();
                    }
                }


            }
            default -> JOptionPane.showMessageDialog(null, "Opção invalida");
        }
            Pagamentos();
    }

    public static void Cartoes() {
        String cartao = JOptionPane.showInputDialog("""
                Escolha o serviço desejado
                1- Ver cartões
                2- Cartão de crédito
                3- Cartão virtual
                0- Voltar ao inicio""");

        while (cartao.length() < 1) {
            JOptionPane.showMessageDialog(null, "Selecione um serviço");
            cartao = JOptionPane.showInputDialog("""
                    Escolha o serviço desejado
                    1- Ver cartões
                    2- Cartão de crédito
                    3- Cartão virtual
                    0- Voltar ao inicio""");
        }
        int cartaoTipo = Integer.parseInt(cartao);

        switch (cartaoTipo) {

            case 0 -> {operacoes();}

            case 1 -> {
                int nConta = 1;
                Conta contaa = encontrarConta(nConta);
                contaa.LimiteCartoes();
                Cartoes();}

            case 2 -> {
                String opcaocartaoC = JOptionPane.showInputDialog("1-solicitar cartão de crédito" +
                                                                  "\n2-cancelar cartão de crédito");
                while (opcaocartaoC.length() < 1) {
                    JOptionPane.showMessageDialog(null, "Selecione um serviço");
                    opcaocartaoC = JOptionPane.showInputDialog("1-solicitar cartão de crédito" +
                                                               "\n2-cancelar cartão de crédito");}
                int opcaoCartaoCR = Integer.parseInt(opcaocartaoC);
                switch (opcaoCartaoCR) {
                    case 1 -> {
                        int opcaoCredito = JOptionPane.showConfirmDialog(null, "Confirmar " +
                                "solicitação ?");
                        if (opcaoCredito == JOptionPane.YES_OPTION) {
                            int numeroContaC = 1;
                            Conta contaC = encontrarConta(numeroContaC);
                            Double limiteCredito = Double.parseDouble((JOptionPane.showInputDialog("Qual limite do " +
                                    "cartão de credito?")));
                            String senhaaC = JOptionPane.showInputDialog("Senha: ");
                            if (senhaaC.equals(contaC.getSenha())) {
                                contaC.cartaoCredito(limiteCredito);
                                Extrato Extrato = new Extrato("Solicitação cartão de Crédito" +
                                                              "\nstatus: Aprovado",
                                        "Limite do cartão: ", limiteCredito);
                                Extratos.add(0, Extrato);
                                JOptionPane.showMessageDialog(null, "Cartão de crédito desbloqueado");
                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");}
                        } else if (opcaoCredito == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Caso deseje o solicitar " +
                                                                "o cartão de credito \n refaça a operação novamente");}
                        operacoes();}
                    case 2 -> {
                        int opcaoCancelaCredito = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");
                        if (opcaoCancelaCredito == JOptionPane.YES_OPTION) {
                            int numeroConta = 1;

                            Conta conta = encontrarConta(numeroConta);

                            Double limiteCredito = 0.0;

                            int numeroContaC = 1;
                            Conta contaaC = (encontrarConta(numeroContaC));
                            String senhaaC = JOptionPane.showInputDialog("Senha: ");
                            if (senhaaC.equals(contaaC.getSenha())) {

                                conta.excluirCartaoCredito(limiteCredito);

                                Extrato Extrato = new Extrato("Cancelamento cartão de crédito" +
                                                              "\nstatus: Cancelado", "Limite do cartão: ", limiteCredito);

                                Extratos.add(0, Extrato);

                                JOptionPane.showMessageDialog(null, "cartão de crédito cancelado");

                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");
                            }
                        } else if (opcaoCancelaCredito == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Caso deseje cancelar " +
                                                                "o cartão refaça o procedimento novamente");
                        }
                        operacoes();
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Opção invalida");
                        operacoes();
                    }
                }
            }

            case 3 -> {
                String opecaoCartaoVirtual = JOptionPane.showInputDialog("1-solicitar cartão virtual" +
                                                                         "\n2-cancelar cartão virtual");

                while (opecaoCartaoVirtual.length() < 1) {
                    JOptionPane.showMessageDialog(null, "Selecione um serviço");
                    opecaoCartaoVirtual = JOptionPane.showInputDialog("1-solicitar cartão virtual" +
                                                                      "\n2-cancelar cartão virtual");
                }
                int opecaoCartaoVirtualL = Integer.parseInt(opecaoCartaoVirtual);

                switch (opecaoCartaoVirtualL) {
                    case 1 -> {
                        int opcaoVirtual = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");
                        if (opcaoVirtual == JOptionPane.YES_OPTION) {

                            int numeroConta = 1;

                            Conta contaV = encontrarConta(numeroConta);

                            Double limiteVirtual = Double.parseDouble((JOptionPane.showInputDialog("Qual limite do cartão virtual?")));

                            String senhaaV = JOptionPane.showInputDialog("Senha: ");
                            if (senhaaV.equals(contaV.getSenha())) {

                                contaV.cartaoVirtual(limiteVirtual);

                                Extrato Extrato = new Extrato("Solicitação cartão Virtual" +
                                                              "\nstatus: Aprovado", "Limite do cartão: ", limiteVirtual);

                                Extratos.add(0, Extrato);

                                JOptionPane.showMessageDialog(null, "Cartão virtual desbloqueado");

                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");
                            }
                        } else if (opcaoVirtual == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Caso deseje o serviço refaça a operação novamente");
                            operacoes();
                        }
                        operacoes();
                    }
                    case 2 -> {
                        int opcaoCancelaVirtual = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");
                        if (opcaoCancelaVirtual == JOptionPane.YES_OPTION) {
                            int numeroConta = 1;
                            Conta conta = encontrarConta(numeroConta);
                            Double limiteVirtual = 0.0;
                            int numeroContaV = 1;
                            Conta contaaV = (encontrarConta(numeroContaV));
                            String senhaaC = JOptionPane.showInputDialog("Senha: ");
                            if (senhaaC.equals(contaaV.getSenha())) {

                                conta.excluirCartaoVirtual(limiteVirtual);

                                Extrato Extrato = new Extrato("Cancelamento cartão Virtual" +
                                                              "\nstatus: Cancelado", "Limite do cartão: ", limiteVirtual);

                                Extratos.add(0, Extrato);

                                JOptionPane.showMessageDialog(null, "cartão virtual cancelado");

                                JOptionPane.showMessageDialog(null, Extratos.get(0));
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha incorreta");
                            }
                        } else if (opcaoCancelaVirtual == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Caso deseje cancelar " +
                                                                "o cartão refaça o procedimento novamente");
                        }
                        operacoes();
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Opção invalida");
                        Cartoes();
                    }
                }

            }
        }
    }

    public static void Emprestimo() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");

        if (opcao == JOptionPane.YES_OPTION) {

            int numeroConta = 1;

            Conta conta = encontrarConta(numeroConta);

            Double valorEmprestimo = Double.parseDouble((JOptionPane.showInputDialog("Qual valor do empréstimo ?")));

            String senha = JOptionPane.showInputDialog("Senha: ");
            if (senha.equals(conta.getSenha())) {

                if (valorEmprestimo <= conta.getSalario() * 2) {

                    conta.emprestimo(valorEmprestimo);

                    Extrato Extrato = new Extrato("Empréstimo", "Valor disponibilizado: ", valorEmprestimo);
                    Extratos.add(0, Extrato);

                    JOptionPane.showMessageDialog(null, "Valor do empréstimo depositado com sucesso!");

                    JOptionPane.showMessageDialog(null, Extratos.get(0));
                } else {
                    JOptionPane.showMessageDialog(null, "Opção inválida, acima do limite disponibilizado");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreta");
            }
        }else if(opcao==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Caso deseje o serviço refaça a operação novamente");
        }
    operacoes();
    }

    public static void impostoDeRenda(){

        int opcao = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");

        int numeroConta = 1;
        Conta conta = (encontrarConta(numeroConta));

        if (opcao == JOptionPane.YES_OPTION) {
            String senha = JOptionPane.showInputDialog("Senha: ");
            if (senha.equals(conta.getSenha())) {
            JOptionPane.showMessageDialog(null, "Documento enviado para o email cadastrado na conta");
        }else{
            JOptionPane.showMessageDialog(null,"Senha incorreta");
        }
        }else if(opcao==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Caso deseje o serviço refaça a operação novamente");

        }
        operacoes();
    }

    public static void Portabilidade() {

        int opcao = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");

        int numeroConta = 1;

        Conta conta = encontrarConta(numeroConta);

        Double salarioBase = Double.parseDouble(JOptionPane.showInputDialog("Confirme salario base atual :"));


        if (salarioBase.equals(conta.getSalario())) {

            if (opcao == JOptionPane.YES_OPTION) {

                String senha = JOptionPane.showInputDialog("Senha: ");
                if (senha.equals(conta.getSenha())) {

                Extrato Extrato = new Extrato("Portabilidade de salario" +
                        "\nstatus: Em analise", "Salario base: ", salarioBase);

                Extratos.add(0, Extrato);

                JOptionPane.showMessageDialog(null, "Os dados foram enviados para análise");
                JOptionPane.showMessageDialog(null, Extratos.get(0));
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreta");
            }
            } else if (opcao == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Caso deseje o serviço refaça a operação novamente");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Dados incompatíveis!");
        }
        operacoes();
    }
    public static void RenegociacaoDividas() {

        int opcao = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");

        if (opcao == JOptionPane.YES_OPTION) {

            Double divida = Double.parseDouble(JOptionPane.showInputDialog("Qual valor da divida atual ?"));

            int numeroContaV = 1;
            Conta contaaV = (encontrarConta(numeroContaV));
            String senhaaC = JOptionPane.showInputDialog("Senha: ");
            if (senhaaC.equals(contaaV.getSenha())) {
                Extrato Extrato = new Extrato("Renegociação de divida\n" +
                        "Status: Em analise", "Valor da divida: ", divida);

                Extratos.add(0, Extrato);
                JOptionPane.showMessageDialog(null, "Os dados foram enviados para análise");

                JOptionPane.showMessageDialog(null, Extratos.get(0));
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreta");
            }
        }else if(opcao==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Caso deseje o serviço refaça a operação novamente");
        }
        operacoes();

    }
    public static void Suporte() {
        String duvida =JOptionPane.showInputDialog(
                """
                        Logo abaixo estão algumas perguntas frequentes em nosso sistema,
                        esperamos que seu problema seja resolvido o mais rapido possivel !
                        caso não encontre ou não fique claro resolução do problema ligue em nossa central de atendimentos
                        Whatsapp: 114334-5566
                        Email: ProjetoInter_SengBank@gmail.com
                        1 - Como faço para alterar meus dados ? \s
                        2 - Como faço para obter cartão de crédito ?   \s
                        3 - Qual meu limite de empréstimo ?        \s
                        4 - Como funcionam os agendamentos ?   \s
                        5 - Não estou conseguindo encerrar minha conta \s
                        0 - Voltar a tela inicial""");

        while (duvida.length()<1){
            JOptionPane.showMessageDialog(null,"Selecione um serviço");
            duvida=JOptionPane.showInputDialog(
                    """
                            Logo abaixo estão algumas perguntas frequentes em nosso sistema,
                            esperamos que seu problema seja resolvido o mais rapido possivel !
                            caso não encontre ou não fique claro resolução do problema ligue em nossa central de atendimentos
                            Whatsapp: 114334-5566
                            Email: ProjetoInter_SengBank@gmail.com \s
                            1 - Como faço para alterar meus dados ?   \s
                            2 - Como faço para obter cartão de crédito ?      \s
                            3 - Qual meu limite de empréstimo ?          \s
                            4 - Como funcionam os agendamentos ?     \s
                            5 - Não estou conseguindo encerrar minha conta   \s
                            0 - Voltar a tela inicial""");
        }
        int duvidaOpcao=Integer.parseInt(duvida);

        switch (duvidaOpcao) {
            case 0 -> operacoes();
            case 1 -> JOptionPane.showMessageDialog(null, "Basta ir até a área de perfil, solicitar alterar dados" +
                    "\n e escolher qual dado deve ser alterado");
            case 2 -> JOptionPane.showMessageDialog(null,
                    """
                            Bastar ir até a área cartões, selecionar cartão de crédito, após isso selecione solicitar\s
                            cartão de crédito e defina quanto quer de limite no cartão lembrando que o limite
                            máximo do cartão de crédito é de 1500 reais e o do cartão virtual é de 1000 reais""");
            case 3 -> JOptionPane.showMessageDialog(null,
                    """
                            O limite máximo de empréstimo não pode ultrapassar o dobro do
                             sálatio base do cliente, ou seja, se o sálario base do cliente for
                             1500 reais ele poderá solicitar até 3000 reais de empréstimo""");
            case 4 -> {
                JOptionPane.showMessageDialog(null, """
                      Os agendamentos são agendados para o próximo 
                      dia útil e apenas podem ocorrer no intervalo 
                      do mesmo ano de solicitação
                      """);
                ;
            }
            case 5 ->
                    JOptionPane.showMessageDialog(null, "Para o encerramento da conta no Seng Bank é preciso estar com saldo 0 em conta, " +
                            "realize um saque total\n ou faça alguma transferência " +
                            "para poder prosseguir com o encerramento da mesma ");
            default -> JOptionPane.showMessageDialog(null, """
                    Opção invalida! Fale com nossos canais de atendimento
                    Whatsapp: 114334-5566
                    Email: ProjetoInter_SengBank@gmail.com""");
        }
           Suporte();
    }

    public  static void comprovantes() {
        String comprovante=JOptionPane.showInputDialog("""
                Selecione o tipo de comprovante: 
                1-Depósito
                2-Saque
                3-Transferência
                4-Pagamento
                0-Voltar
                """);

        while (comprovante.length()<1){
            JOptionPane.showMessageDialog(null,"Selecione uma opção");
            comprovante=JOptionPane.showInputDialog("""
                Selecione o tipo de comprovante: 
                1-Depósitos
                2-Saques
                3-Transferências
                4-Pagamentos
                0-Voltar
                """);
        }
        int opcaoComprovante=Integer.parseInt(comprovante);

       switch (opcaoComprovante){

           case 0->{
             operacoes();
           }

           case 1->{
               if (Extratos.size() > 0 && comprovanteDeposito>0) {
                   for (Extrato extrato : Extratos) {
                       if (extrato.TipoOperacao.contains("Deposito") ) {
                           JOptionPane.showMessageDialog(null, extrato);
                       }
                   }
               }else{
                   JOptionPane.showMessageDialog(null, " Não há operações realizadas");
               }
           }

       case 2 ->{

           if (Extratos.size() > 0 && comprovanteSaque>0) {
               for (Extrato extrato : Extratos) {
                   if (extrato.TipoOperacao.contains("Saque") ) {
                       JOptionPane.showMessageDialog(null, extrato);
                   }
               }
           }else{
               JOptionPane.showMessageDialog(null, " Não há operações realizadas");
           }
       }



       case 3->{


           if (Extratos.size() > 0 && comprovanteTransferencia>0) {
               for (Extrato extrato : Extratos) {
                   if (extrato.TipoOperacao.contains("Transferência") ) {
                       JOptionPane.showMessageDialog(null, extrato);
                   }
               }
           }else{
               JOptionPane.showMessageDialog(null, " Não há operações realizadas");
           }
       }

       case 4->{


           if (Extratos.size() > 0 && comprovantePagamento>0) {
               for (Extrato extrato : Extratos) {
                   if (extrato.TipoOperacao.contains("Pagamento") ) {
                       JOptionPane.showMessageDialog(null, extrato);
                   }
               }
           }else{
               JOptionPane.showMessageDialog(null, " Não há operações realizadas");
           }
       }

           default -> {
               JOptionPane.showMessageDialog(null,"Opção inválida");
               comprovantes();
           }
       }
        operacoes();
    }

    public static  void Recargas(){
       String operadora=JOptionPane.showInputDialog("""
               Selecione a operadora
               1-Regarga Tim
               2-Regarga Vivo
               3-Regarga Oi
               4-Regarga Claro
               0- Voltar""");

        while (operadora.length()<1){
            JOptionPane.showMessageDialog(null,"Selecione um serviço");
            operadora=JOptionPane.showInputDialog("""
                    Selecione a operadora
                    1-Regarga Tim
                    2-Regarga Vivo
                    3-Regarga Oi
                    4-Regarga Claro
                    0- Voltar""");
        }
        int operadoraOpcao=Integer.parseInt(operadora);

        switch (operadoraOpcao) {
            case 0 -> operacoes();
            case 1 -> {
                int numeroContaT = 1;
                Conta contaT = encontrarConta(numeroContaT);
                String numeroT = JOptionPane.showInputDialog("Número de telefone: ");
                Double valorT = Double.parseDouble(JOptionPane.showInputDialog("Valor da recarga"));
                String senhaT = JOptionPane.showInputDialog("Senha: ");
                if (senhaT.equals(contaT.getSenha())) {
                    if (valorT > 0 && contaT.getSaldo() >= valorT) {

                        contaT.recargaChipTim(valorT);

                        JOptionPane.showMessageDialog(null, "Recarga realizada com sucesso!");

                        Extrato Extrato = new Extrato("Pagamento recarga tim\nNúmero: ", numeroT + "\nvalor da recarga:", valorT);

                        Extratos.add(0, Extrato);
                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                        comprovantePagamento++;

                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                }

            }
            case 2 -> {
                int numeroContaV = 1;
                Conta contaV = encontrarConta(numeroContaV);
                String numeroV = JOptionPane.showInputDialog("Número de telefone: ");
                Double valorV = Double.parseDouble(JOptionPane.showInputDialog("Valor da recarga"));
                String senhaV = JOptionPane.showInputDialog("Senha: ");
                if (senhaV.equals(contaV.getSenha())) {
                    if (valorV > 0 && contaV.getSaldo() >= valorV) {

                        contaV.recargaChipVivo(valorV);

                        JOptionPane.showMessageDialog(null, "Recarga realizada com sucesso!");

                        Extrato Extrato = new Extrato("Pagamento recarga vivo\nNúmero: ", numeroV + "\nvalor da recarga:", valorV);

                        Extratos.add(0, Extrato);
                        comprovantePagamento++;

                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                }

            }
            case 3 -> {
                int numeroContaO = 1;
                Conta contaO = encontrarConta(numeroContaO);
                String numeroO = JOptionPane.showInputDialog("Número de telefone: ");
                Double valorO = Double.parseDouble(JOptionPane.showInputDialog("Valor da recarga"));
                String senhaO = JOptionPane.showInputDialog("Senha: ");
                if (senhaO.equals(contaO.getSenha())) {
                    if (valorO > 0 && contaO.getSaldo() >= valorO) {

                        contaO.recargaChipOi(valorO);

                        JOptionPane.showMessageDialog(null, "Recarga realizada com sucesso!");

                        Extrato Extrato = new Extrato("Pagamento recarga oi\nNúmero: ", numeroO + "\nvalor da recarga:", valorO);

                        Extratos.add(0, Extrato);
                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                        comprovantePagamento++;

                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                }
              comprovantes();
            }
            case 4 -> {
                int numeroContaC = 1;
                Conta contaC = encontrarConta(numeroContaC);
                String numeroC = JOptionPane.showInputDialog("Número de telefone: ");
                Double valorC = Double.parseDouble(JOptionPane.showInputDialog("Valor da recarga"));
                String senhaC = JOptionPane.showInputDialog("Senha: ");
                if (senhaC.equals(contaC.getSenha())) {

                    if (valorC > 0 && contaC.getSaldo() >= valorC) {

                        contaC.recargaChipClaro(valorC);

                        JOptionPane.showMessageDialog(null, "Recarga realizada com sucesso!");

                        Extrato Extrato = new Extrato("Pagamento recarga vivo\nNúmero: ", numeroC + "\nvalor da recarga:", valorC);

                        Extratos.add(0, Extrato);
                        JOptionPane.showMessageDialog(null, Extratos.get(0));
                        comprovantePagamento++;

                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                }

            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção inválida");
               Recargas();
            }
        }
        operacoes();
    }
    public static void Extratos() {
        if (Extratos.size() > 0 ) {
            for (Extrato extrato : Extratos) {
                JOptionPane.showMessageDialog(null,extrato);
            }
        } else {
            JOptionPane.showMessageDialog(null, " Não há operações realizadas");
        }

        operacoes();
    }
    public static void encerrarConta(){

    int opcao = JOptionPane.showConfirmDialog(null, "Confirmar solicitação ?");

    if(opcao==JOptionPane.YES_OPTION) {
        int numeroConta = 1;
        Conta conta = encontrarConta(numeroConta);
        if (conta.getSaldo() == 0) {
            String senha = JOptionPane.showInputDialog("Senha: ");
            if (senha.equals(conta.getSenha())) {

             contasBancarias.clear();
             Extratos.clear();

             JOptionPane.showMessageDialog(null, "Conta encerrado com sucesso");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo em conta!");
            operacoes();
        }
    }else if(opcao==JOptionPane.NO_OPTION){
        JOptionPane.showMessageDialog(null,"Caso deseje encerrar a conta refaça a operação novamente");
    }
}


}
