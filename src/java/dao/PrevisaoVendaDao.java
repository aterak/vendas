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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class PrevisaoVendaDao implements InterfacePrevVendaDao{

    private List<PrevisaoVenda> listaPrevisaoVendaDao;
    
    
    @Override
    public void registra(PrevisaoVenda previsaovenda) {
  Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(previsaovenda);
        t.commit();

    
    }

    @Override
    public void excluir(PrevisaoVenda previsaovenda) {
  Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.delete(previsaovenda);
        t.commit();

    
    }

    @Override
    public void alterar(PrevisaoVenda previsaovenda) {

      Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.update(previsaovenda);
        t.commit();

    }

    @Override
    public List<PrevisaoVenda> getLista() {
  Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        Criteria cri = ss.createCriteria(PrevisaoVenda.class);
        this.listaPrevisaoVendaDao = cri.list();
        return this.listaPrevisaoVendaDao;

    
    }

    @Override
    public void registraProdutoUsuario(Produto p, Usuario u) {
 Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(p.getNome(),u.getNome());
        t.commit();

    
    
    
    }

    @Override
    public PrevisaoVenda pesquisarPrevPorcodigo(int codigo) {

    Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
    return (PrevisaoVenda) ss.load(PrevisaoVenda.class, codigo);
    
    
    }
    
}
