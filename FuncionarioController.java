package br.com.fecaf.controller;

import br.com.fecaf.database.Conexao;
import br.com.fecaf.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FuncionarioController {

    public void consultarFuncionario(){
        try{
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement statement = objConnection.createStatement();
            String queryConsulta = "Select * from funcionario";
            ResultSet resultSet = statement.executeQuery(queryConsulta);

            while (resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
                funcionario.setNome(resultSet.getNString("nome"));
                funcionario.setMatricula(resultSet.getInt("matricula"));
                funcionario.setDepartamento(resultSet.getInt("departamento_FK"));
                funcionario.exibirInformacoes();
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Boolean cadastrarFuncionario(Funcionario funcionario){
        try{
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement statement = objConnection.createStatement();
            String queryCreate = "Insert into funcionario(idFuncionario, nome, matricula, departamento_FK)values ('"
                    + funcionario.getIdFuncionario() + "','" + funcionario.getNome() + "','" + funcionario.getMatricula()
                    + "','" + funcionario.getDepartamento() + "')";

            statement.executeUpdate(queryCreate);
            return true;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public Boolean deletarFuncionario(int id){
        try{
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement statement = objConnection.createStatement();
            String queryDelete = "Delete from funcionario where idFuncionario = " + id;
            statement.executeUpdate(queryDelete);
            return true;

        }catch(Exception e){
            System.out.println(e);;
            return false;
        }

    }
}
