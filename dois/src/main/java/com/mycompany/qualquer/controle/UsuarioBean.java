/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qualquer.controle;


import javax.enterprise.context.Dependent;
import com.mycompany.qualquer.Dependente;
import javax.inject.Named;
import com.mycompany.qualquer.Pessoa;
import com.mycompany.qualquer.Pessoas;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author carlos
 */

@Dependent
@Named
public class UsuarioBean implements Serializable{
    
    private Pessoa pessoa = new Pessoa();
    private Dependente dependente;
    
    @Inject
    private dependenteBean depService;
    
    @EJB
    private Pessoas service;
    
    public String salvar(){
        this.pessoa.setIdDependente(dependente.getId());
        service.salvar(this.pessoa);
        this.pessoa = new Pessoa();
        return null;
    }
    
    public List<Pessoa> listarPessoas(){
        return service.listaPessoas();
    }
    
    public List<Dependente> listaDependentes(){
        return depService.listarDependentes();
    }
    
    public String buscar(){
        this.pessoa = service.buscarPorCPF(this.pessoa.getCpf());
        this.dependente = depService.buscarDependente(pessoa.getIdDependente());
        return null;
    }
    public String buscaDependente(Pessoa pessoa){
        this.pessoa = pessoa;
        buscar();
        return this.dependente.getNome();
    }
    
    public String editar(){
        buscar();
        service.editarPessoa(this.pessoa);
        this.pessoa = new Pessoa();
        this.dependente = new Dependente();
        return null;
    }
    
    public String excluir(Pessoa pessoa){
        this.service.excluirPessoa(pessoa);
        return null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }
    
    
}
