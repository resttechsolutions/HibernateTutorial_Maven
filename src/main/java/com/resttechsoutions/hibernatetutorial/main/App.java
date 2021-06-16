/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.main;

import com.resttechsoutions.hibernatetutorial.domain.Categorias;
import com.resttechsoutions.hibernatetutorial.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Rafael Estrella
 */
public class App {
    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        
        List<Categorias> result = s.createQuery("from Categorias").list();
        s.getTransaction().commit();
        
        result.stream()
                .forEach(
                
                        c -> System.out.println(c.getCategoriaId() + " - " + c.getCategoriaId())
                );
        
    }
}
