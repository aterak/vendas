/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Produto;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class teste {

    
    
    public static void main(String[] args) {
     
       teste();
    
    
      System.out.print("certo");
    }
    
    
    
    
    
    static Produto  teste(){
    // Produto p = new Produto();
        
        int codigo= 3;
        Session ss = HibernateUtil.getSessionFactory().openSession();
         Transaction t = ss.beginTransaction();
          return    (Produto) ss.load(Produto.class, codigo);
      //      
}
}