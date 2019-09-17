/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.PrevisaoVenda;
import modelo.Produto;
import modelo.Usuario;

/**
 *
 * @author EMPRESA
 */
public interface InterfacePrevVendaDao {
     public void registra(PrevisaoVenda previsaovenda);
    public void excluir(PrevisaoVenda previsaovenda);
    public void alterar (PrevisaoVenda previsaovenda);
    public List<PrevisaoVenda> getLista();

    public void registraProdutoUsuario(Produto p, Usuario u);
    
    public PrevisaoVenda  pesquisarPrevPorcodigo(int codigo);
}
