
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
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
public class UsuarioDao implements InterfaceUsuarioDao {

    private List<Usuario> listaUsuarioDao;
    
    
    @Override
    public void salvar(Usuario usuario) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(usuario);
        t.commit();

    }

    @Override
    public void excluir(Usuario usuario) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.delete(usuario);
        t.commit();

    }

    @Override
    public void alterar(Usuario usuario) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.update(usuario);
        t.commit();

    }

    @Override
    public List<Usuario> getList() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        Criteria cri = ss.createCriteria(Usuario.class);
        this.listaUsuarioDao = cri.list();
        return this.listaUsuarioDao;
        
    }

    @Override
    public Usuario pesquisarCodigo(Integer codigo) {

     Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        Criteria cri =  ss.createCriteria(Usuario.class);
        this.listaUsuarioDao = cri.list();
        return (Usuario) this.listaUsuarioDao;
    
    }

 
 @Override
    public Usuario  pesquisarCodigoTeste(Integer codigo) {

    Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        String hql = "From Usuario where idusuario='"+codigo+"'"; 
       Query query = ss.createQuery(hql);
       
        
        listaUsuarioDao = (List<Usuario>) query.list().get(0);
        return  (Usuario) this.listaUsuarioDao;    }

    @Override
    public Usuario pesquisarPorcodigo(Integer codigo) {
      
           
     Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
         String hql = "From Usuario where Idproduto= '"+codigo+"'";
       Query query = ss.createQuery(hql); 
            return (Usuario) query.uniqueResult();
    
        
    }
    
    
    
    
       @Override
    public Usuario login(Integer usuario) {

        Usuario us = null;

        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        String hql = "from Cliente where codigoCliente = '" + usuario+ "'";

        Query query = ss.createQuery(hql);

        if (!query.list().isEmpty()) {
            us = (Usuario) query.list().get(0);
            t.commit();
        }return us;
    }
}
