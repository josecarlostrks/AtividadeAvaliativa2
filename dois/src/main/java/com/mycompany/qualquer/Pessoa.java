/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qualquer;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class Pessoa implements Serializable{
    private int id;
    private String nome;
    private String cpf;
    private String idDependente;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String idDependente) {
        this.nome = nome;
        this.cpf = cpf;
        this.idDependente = idDependente;
    }

    public Pessoa(int id, String nome, String cpf, String idDependente) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idDependente = idDependente;
    }

    public int getId() {
        return id;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(String idDependente) {
        this.idDependente = idDependente;
    }


    
    
}
