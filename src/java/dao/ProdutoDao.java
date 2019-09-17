/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Produto;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class ProdutoDao implements InterfaceProdutoDao {

    private List<Produto> listaProdutoDao;
    
    
    @Override
    public void salvar(Produto produto) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.save(produto);
        t.commit();

    }

    @Override
    public void excluir(Produto produto) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.delete(produto);
        t.commit();

    }

    @Override
    public void alterar(Produto produto) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.update(produto);
        t.commit();

    }

    @Override
    public List<Produto> getList() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        Criteria cri = ss.createCriteria(Produto.class);
        this.listaProdutoDao = cri.list();
      
        return this.listaProdutoDao;
       
    }

     @Override
    public Produto peequisarPorDescricao(String nome){
      Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        String hql = "From Produto Where nome like '"+nome+"'  ";
         Query query = ss.createQuery(hql);
         query.setString("nome", nome);
         return (Produto) query.uniqueResult();
    
    
    }


     @Override
     public Produto pesquisarPorcodigo(int codigo) {
        
          Session ss = HibernateUtil.getSessionFactory().openSession();
         Transaction t = ss.beginTransaction();
          return    (Produto) ss.load(Produto.class, codigo);
     
}
}
