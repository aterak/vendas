/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfacePrevVendaDao;
import dao.InterfaceProdutoDao;
import dao.InterfaceUsuarioDao;
import dao.PrevisaoVendaDao;
import dao.ProdutoDao;
import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.PrevisaoVenda;
import modelo.Produto;
import modelo.Usuario;

/**
 *
 * @author EMPRESA
 */
@ManagedBean
@javax.faces.bean.SessionScoped
public class RegistraVendaBean1 implements Serializable {

    /**
     * Creates a new instance of UsuarioBean
     */
    public RegistraVendaBean1() {
    }
    
    private PrevisaoVenda previsaovenda;
    private List<PrevisaoVenda> listaVenda = new ArrayList<PrevisaoVenda>();
    private Usuario usuarioSelecionado;
    private Produto produtoSelecionado = new Produto();
    private List<Produto> listaDeTodosProdutosNoMercado = new ArrayList<Produto>();
   

    
     public List<Produto> buscarProduto() {
        Produto produtoPesquisado = new Produto();
        InterfaceProdutoDao produtoDao = new ProdutoDao();

        if (this.produtoSelecionado.getNome() != null && !this.produtoSelecionado.getNome().equals("")) {

            produtoPesquisado = (Produto) produtoDao.getList();

            if (produtoPesquisado != null) {

                this.listaDeTodosProdutosNoMercado.add(produtoPesquisado);
               
            }
        }
        return   this.listaDeTodosProdutosNoMercado;
    }

    

    public String finalizaVenda() {

        if (!this.listaDeTodosProdutosNoMercado.isEmpty()) {
            ArrayList<PrevisaoVenda> vendas = new ArrayList<PrevisaoVenda>();

            for (Produto p : this.listaDeTodosProdutosNoMercado) {
                if (this.usuarioSelecionado !=null) {
                       

                 //   vendas.add(new PrevisaoVenda(p, this.usuarioSelecionado));

                
            //}
            for (PrevisaoVenda venda : vendas) {
                InterfacePrevVendaDao vendarn = new PrevisaoVendaDao();
         //       vendarn.registraVenda(Venda);/// aqui eu nao entendi 9:40 video 29
            }

        }
        }
       

    } return null;
}

    
    public void colocarProdutosNoCarrinho(ActionEvent actionEvent){
    
    //  ArrayList<PrevisaoVenda> carrinho = new ArrayList<PrevisaoVenda>();

           InterfacePrevVendaDao vendaDao = new PrevisaoVendaDao();
           vendaDao.registra(previsaovenda);
      
   //   for (Produto p : this.listaDeTodosProdutosNoMercado) {
    
      //            carrinho.set();
    
 //   }
    }
    
    public Produto getProdutoSelecionado() {
      
        if(produtoSelecionado == null){
        
        produtoSelecionado = new Produto();
        }
        
        
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Produto> getListaDeTodosProdutosNoMercado() {
      
        
        listaDeTodosProdutosNoMercado =  new ProdutoDao().getList();
        
        return listaDeTodosProdutosNoMercado;
    }

    public void setListaDeTodosProdutosNoMercado(List<Produto> listaDeTodosProdutosNoMercado) {
        this.listaDeTodosProdutosNoMercado = listaDeTodosProdutosNoMercado;
    }

    public PrevisaoVenda getPrevisaovenda() {
        
        if(previsaovenda == null){
        
        previsaovenda = new PrevisaoVenda();
        }
        
        return previsaovenda;
    }

    public void setPrevisaovenda(PrevisaoVenda previsaovenda) {
        this.previsaovenda = previsaovenda;
    }

    public Usuario getUsuarioSelecionado() {
       
        if(usuarioSelecionado == null){
        usuarioSelecionado =  new Usuario();
        }
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
    

    
    
public String prepararAlterarVenda(PrevisaoVenda p){

        previsaovenda = p;
    return "altearcarrinho";
    
}

    
    
    
    
}
