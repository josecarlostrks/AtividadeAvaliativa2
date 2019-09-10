/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qualquer.controle;

import com.mycompany.qualquer.Dependente;
import com.mycompany.qualquer.Dependentes;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author carlos
 */

@Named
@SessionScoped
public class dependenteBean implements Serializable{
    
    private Dependente dependente = new Dependente();
    private String nome;
    private Date idade;
    
    @EJB
    private Dependentes service;
    
    public String cadastrarDependente(){
        this.dependente.setNome(this.nome);
        this.dependente.setIdade(this.idade);
        service.salvarDependente(this.dependente);
        this.dependente = new Dependente();
        return null;
    }    

    public List<Dependente> listarDependentes(){
        return service.listaDependente();
    } 
    
    public Dependente buscarDependente(String idDependente) {
        return service.buscaPorUuid(nome);
    }    

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getIdade() {
        return idade;
    }

    public void setIdade(Date idade) {
        this.idade = idade;
    }
    
    
    
}
