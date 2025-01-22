package br.com.fecaf.model;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Funcionario {

    private int idFuncionario;
    private String nome;
    private int departamento;
    private int matricula;

    Scanner scanner = new Scanner(System.in);

    public void cadastrarFuncionario(){
        System.out.println("/--------------------- Cadastro --------------------------------/");
        System.out.println("Informe o nome: ");
        this.nome = scanner.nextLine();
        System.out.println("Informe o id: ");
        this.idFuncionario = scanner.nextInt();
        System.out.println("Informe a matricula: ");
        this.matricula = scanner.nextInt();
        System.out.println("Informe o departamento [ 1 - DEV  2 - QA  3 - ENG]");
        this.departamento = scanner.nextInt();
        scanner.nextLine();
        System.out.println("/-----------------------------------------------------------------/");


    }

    public void exibirInformacoes(){
        System.out.println("/------------------ Informacoes Funcionario ----------------------/");
        System.out.println(this.idFuncionario);
        System.out.println(this.nome);
        System.out.println(this.matricula);
        System.out.println(this.departamento);
        System.out.println("/-----------------------------------------------------------------/");;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
