package br.com.fecaf.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private String servidor, banco, user, password;
    public Connection conexao;

    public Conexao() {
        this.servidor = "localhost";
        this.banco = "db_java";
        this.user = "root";
        this.password = "gtr3253";
    }

    public Boolean connectDrive() {
        try {
            // URL de conexão no formato correto
            String url = "jdbc:mysql://localhost:3306/" + this.banco;
            // Estabelecendo a conexão
            this.conexao = DriverManager.getConnection(url, this.user, this.password);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return false;
        }
    }

    public Connection getConnection() {
        boolean validaConexao = connectDrive();
        System.out.println("Conexão válida: " + validaConexao);

        if (validaConexao) {
            return this.conexao;
        }
        return null;
    }
}
