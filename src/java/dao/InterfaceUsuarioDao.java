/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author EMPRESA
 */
public interface InterfaceUsuarioDao {
   
    public void salvar(Usuario usuario);
    public void excluir(Usuario usuario);
    public void alterar (Usuario usuario);
    public Usuario pesquisarCodigo(Integer codigo);
    public List<Usuario> getList();
     public Usuario  pesquisarCodigoTeste(Integer codigo);
     
       public Usuario pesquisarPorcodigo(Integer codigo);
       
       
       
       
       public Usuario login(Integer usuario);
}
