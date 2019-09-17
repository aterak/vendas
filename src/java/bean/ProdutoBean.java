/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceProdutoDao;
import dao.InterfaceUsuarioDao;
import dao.ProdutoDao;
import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

import modelo.Produto;
import modelo.Usuario;

/**
 *
 * @author EMPRESA
 */
@ManagedBean

@javax.faces.bean.SessionScoped
public class ProdutoBean implements Serializable {

    /**
     * Creates a new instance of UsuarioBean
     */
    public ProdutoBean() {
    }
    
      InterfaceProdutoDao dao = new ProdutoDao();
      private Produto produtoBean;
      private List<Produto> listaProdutoBean;

    public Produto getProdutoBean() {

        if (this.produtoBean == null) {

            this.produtoBean = new Produto();
        }

        return produtoBean;
    }

    public void setProdutoBean(Produto produtoBean) {
        this.produtoBean = produtoBean;
    }

    
    
    public List<Produto> getListaProdutobean() {

        listaProdutoBean = new ProdutoDao().getList();

        return listaProdutoBean;
    }

    public void salvarProduto(ActionEvent actionEvent) {

       
        dao.salvar(produtoBean);

    }

    public void apagarProduto(Produto u) {
        this.produtoBean = u;
        
        dao.excluir(produtoBean);

    }

    public void prepararMudarProduto(Produto u) {
        produtoBean = u;
        // return "alterar";
    }

    public void mudarProduto(ActionEvent actionEvent) {

       
        dao.alterar(produtoBean);

    }

    
    public void descricaoProduto(String n){
    
    
        dao.peequisarPorDescricao(n);
    
    }
    
    
   
    
    public String verificaProdutoID(int codigo){
       
       dao.pesquisarPorcodigo(codigo);
            return "love";
            
    }
    
}
