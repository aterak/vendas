/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
public interface InterfaceProdutoDao {
   
    public void salvar(Produto produto);
    public void excluir(Produto produto);
    public void alterar (Produto produto);
    public List<Produto> getList();
    public Produto peequisarPorDescricao(String nome);

    public Produto pesquisarPorcodigo(int codigo);
    
}
