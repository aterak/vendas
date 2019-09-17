/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.InterfacePrevVendaDao;
import dao.PrevisaoVendaDao;
import dao.ProdutoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import modelo.PrevisaoVenda;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
@ManagedBean
@SessionScoped
public class RegistraOK implements Serializable {

    /**
     * Creates a new instance of RegistraOK
     */
    public RegistraOK() {
    }
  private Produto produtos;
  private List<Produto> listaProdutosBean  = new ArrayList<Produto>();
  private PrevisaoVenda vendas;
  private List<PrevisaoVenda> listavenda ;//=  new ArrayList<PrevisaoVenda>();
  
    public Produto getProdutos() {
     if(produtos  == null){
     
     produtos = new Produto();
     }
        
        
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getListaProdutosBean() {
       
        listaProdutosBean = new ProdutoDao().getList();
        
        return listaProdutosBean;
    }

    public PrevisaoVenda getVendas() {
      
        if(vendas == null){
        vendas =  new PrevisaoVenda();
        }
        
        return vendas;
    }

    public void setVendas(PrevisaoVenda vendas) {
        this.vendas = vendas;
    }

  

    public void setListavenda(List<PrevisaoVenda> listavenda) {
        this.listavenda = listavenda;
    }

  public List<PrevisaoVenda> getListavenda() {
        
        listavenda = new PrevisaoVendaDao().getLista();
        
        return listavenda;
    }
    
   
    
    
    public String salvaraarinho(PrevisaoVenda vendas){
  this.vendas = vendas;
    
    InterfacePrevVendaDao dao = new PrevisaoVendaDao();
       dao.registra(this.vendas);
    
    
    List<Produto> lp= new ArrayList<Produto>(produtos.getIdproduto());
    
        
     //   for (Produto produto : lp) {
       //     lp.add(p);
       //     InterfacePrevVendaDao dao = new PrevisaoVendaDao();
      //  dao.registra((PrevisaoVenda) lp);
     //   }
      
      
    
        /// erro
      // List<PrevisaoVenda> v = new ArrayList<>();
      //  v.add((PrevisaoVenda) listaProdutosBean);
     //  InterfacePrevVendaDao dao = new PrevisaoVendaDao();
     //   dao.registra( (PrevisaoVenda) v);
    
        return "love";
        
    }
 
    
    
        public String verificaPrevVendaID(int codigo){
       
            InterfacePrevVendaDao daoprev = new PrevisaoVendaDao();
            daoprev.pesquisarPrevPorcodigo(codigo);
           
            
            
            
            
            return "love";
              
       
            
    }
    
     public void carregarCarrinoPrevVendaID(PrevisaoVenda u) {
        
         
    
         
         this.vendas =u;
      
        
       // List<PrevisaoVenda> v = new ArrayList<>();
        

        // for (PrevisaoVenda previsaoVenda : v) {
             
             listavenda.add(this.vendas);
             
        // }
//  v.add((PrevisaoVenda) listavenda);
        
        
    }
}
