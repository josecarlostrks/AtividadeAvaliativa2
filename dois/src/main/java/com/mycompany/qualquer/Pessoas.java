package com.mycompany.qualquer;


import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlos
 */
@Local
public interface Pessoas {
    
    public void salvar(Pessoa pessoa);
    public List<Pessoa> listaPessoas();
    public Pessoa buscarPorCPF(String cpf);
    public void editarPessoa(Pessoa pessoa);
    public void excluirPessoa(Pessoa pessoa);

    

    
}
