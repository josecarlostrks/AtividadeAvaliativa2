/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qualquer;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlos
 */
@Local
public interface Dependentes {
    
    public void salvarDependente(Dependente dependente);
    public List<Dependente> listaDependente();
    public Dependente buscaPorUuid(String uuid);
    public void editarDependente(Dependente dependente);
    
}
