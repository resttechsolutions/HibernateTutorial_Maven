/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.main;

import com.resttechsoutions.hibernatetutorial.domain.Ordenes;
import com.resttechsoutions.hibernatetutorial.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Rafael Estrella
 */
public class SelectOrderBy {
    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();

        Session s = hu.getSession();

        s.beginTransaction();
        
        List<Ordenes> resultOrdenes = s.createQuery("from Ordenes o order by o.fechaorden").list(); // Select * and order by
        
        s.getTransaction().commit();
        s.close();
        
        System.out.println("***************************Select order by***************************");
        
        resultOrdenes.stream()
                .forEach(
                        o -> System.out.println(o.getOrdenid() + " - " + o.getFechaorden())
                );
    }
}
