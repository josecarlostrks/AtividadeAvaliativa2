/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qualquer;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author carlos
 */
public class Dependente implements Serializable{
    
    private String id;
    private String nome;
    private Date idade;

    public Dependente() {
    }

    public Dependente(String uuid,String nome) {
        this(
            uuid,nome,Date.from(Instant.now())
        );
    }    
    public Dependente(String nome, Date idade) {
        this.nome = nome;
        this.idade = idade;
    }

    Dependente(String id, String nome, Date idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }
    
    public static Dependente fake() {
        return new Dependente("-1","-1");
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

    public String getId() {
        return id;
    }


    public boolean naoValido() {
        return nomeVazio() || nascimentoAnterior();
    }

    public boolean nomeVazio() {
        return this.nome == null || this.nome.trim().equals("");
    }

    public boolean nascimentoAnterior() {
        return this.idade == null
            || this.idade.equals(Date.from(Instant.now()))
            || this.idade.after(Date.from(Instant.now()));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.idade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dependente other = (Dependente) obj;
        if (!Objects.equals(this.id,other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome,other.nome)) {
            return false;
        }
        if (!Objects.equals(this.idade,other.idade)) {
            return false;
        }
        return true;
    }
    
}
