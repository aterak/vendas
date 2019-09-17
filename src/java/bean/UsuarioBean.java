/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceUsuarioDao;
import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Usuario;

/**
 *
 * @author EMPRESA
 */

@ManagedBean
@javax.faces.bean.SessionScoped
public class UsuarioBean implements Serializable {

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    private Usuario usuarioBean;
    private List<Usuario> listaUsuarioBean;

    public Usuario getUsuarioBean() {

        if (this.usuarioBean == null) {

            this.usuarioBean = new Usuario();
        }

        return usuarioBean;
    }

    public void setUsuarioBean(Usuario usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    
    
    public List<Usuario> getListaUsuariobean() {

        listaUsuarioBean = new UsuarioDao().getList();

        return listaUsuarioBean;
    }

    public void salvarUsuario(ActionEvent actionEvent) {

        InterfaceUsuarioDao dao = new UsuarioDao();
        dao.salvar(usuarioBean);

    }

    public void apagarUsuario(Usuario u) {
        this.usuarioBean = u;
        InterfaceUsuarioDao dao = new UsuarioDao();
        dao.excluir(usuarioBean);

    }

    public void prepararMudarUsuario(Usuario u) {
        usuarioBean = u;
        InterfaceUsuarioDao dao = new UsuarioDao();
        dao.excluir(usuarioBean);
    }

    public void mudarUsuario(ActionEvent actionEvent) {

        InterfaceUsuarioDao dao = new UsuarioDao();
        dao.alterar(usuarioBean);

    }

    
      public String verificaLogin(Integer codigo ) {
        Usuario us;
       InterfaceUsuarioDao dao = new UsuarioDao();
       us =  dao.login(codigo);
       if (us != null) {        
               
 return "index";
    } else {
      us = null;
      return "love";
      }
       
      }     
    
    
    
    
     public String verificaCodigo(Integer codigo) {
     
                InterfaceUsuarioDao dao = new UsuarioDao();
                    dao.pesquisarPorcodigo(codigo);
             
                  return "usuario";       
    
      }   
}
