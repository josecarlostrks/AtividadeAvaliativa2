package com.mycompany.qualquer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author carlos
 */

@Stateless
public class Jdbc implements Pessoas, Dependentes{
    

    private DataSource dataSource;
    private Connection connection;
    
    public Jdbc() {}    


    @Resource(name = "jdbc/myDatasource")
    public void setDataSource(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.connection = dataSource.getConnection();
    }
    

    @Override
    public void salvar(Pessoa pessoa) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO pessoas VALUES(?,?)"
            );
            statement.setString(1,pessoa.getNome());
            statement.setString(2, pessoa.getCpf());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE,null,ex);
        }         
    }

    @Override
    public List<Pessoa> listaPessoas(){
        String query = "SELECT * FROM pessoa";
        List<Pessoa> pessoas= new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                Pessoa pessoa = new Pessoa(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("cpf"),
                    resultado.getString("id_dependente")
                );
                pessoas.add(pessoa);
            }
            return pessoas;
        }catch(SQLException ex) {
            return null;
        } 
        
    }

    @Override
    public Pessoa buscarPorCPF(String cpf) {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, cpf);
            ResultSet resultado = statment.executeQuery();
            
            if(resultado.next()){
                Pessoa pessoa = new Pessoa(
                        resultado.getInt("id"),
                        resultado.getString("nome"), 
                        resultado.getString("cpf"),
                        resultado.getString("id_dependente")
                );
                return pessoa;
            }
                return null;
        }catch (SQLException ex) {
                return null;
        }
       
    }   
    

    @Override
    public void editarPessoa(Pessoa pessoa) {
         String sql = "UPDATE pessoa SET nome = ?, cpf = ?, id_dependente = ? WHERE id = ? ";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);		
            statment.setString(1, pessoa.getNome());
            statment.setString(1, pessoa.getCpf());
            statment.setString(1, pessoa.getIdDependente());
	    statment.executeUpdate();            
        }catch(SQLException e){
             e.printStackTrace();
        }         
    }    
    

    @Override
    public void excluirPessoa(Pessoa pessoa) {
         String sql = "DELETE FROM WHERE id = ? ";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);		
            statment.setInt(1, pessoa.getId());
	    statment.executeUpdate();            
        }catch(SQLException e){
             e.printStackTrace();
        }          
    }    
    
    @Override
    public void editarDependente(Dependente dependente) {
         String sql = "UPDATE dependente SET nome = ?, nascimento = ? WHERE id = ? ";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);		
            statment.setString(1, dependente.getNome());
            statment.setDate(2, (Date) dependente.getIdade());
            statment.setString(3, dependente.getId());
	    statment.executeUpdate();            
        }catch(SQLException e){
             e.printStackTrace();
        }         
    }    
    

    @Override
    public void salvarDependente(Dependente dependente) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO dependente(nome, nascimento) VALUES(?,?)"
            );
            statement.setString(1, dependente.getNome());
            statement.setDate(2, (Date) dependente.getIdade());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE,null,ex);
        }         
    }

    @Override
    public List<Dependente> listaDependente() {
        String query = "SELECT * FROM depedente";
        List<Dependente> dependentes= new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                Dependente dependente = new Dependente(
                    resultado.getString("id"),                        
                    resultado.getString("nome"),
                    resultado.getDate("idade")
                );
                dependentes.add(dependente);
            }
            return dependentes;
        }catch(SQLException ex) {
            return null;
        } 
    }

    @Override
    public Dependente buscaPorUuid(String uuid) {
        String sql = "SELECT * FROM dependente WHERE id = ?";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, uuid);
            ResultSet resultado = statment.executeQuery();
            
            if(resultado.next()){
                Dependente dep = new Dependente(
                        resultado.getString("id"),
                        resultado.getString("nome"), 
                        resultado.getDate("idade")
                );
                return dep;
            }
            return null;
        }catch (SQLException ex) {
                return null;
        }
    }



    
}
