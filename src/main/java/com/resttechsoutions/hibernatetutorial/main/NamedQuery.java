/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.main;

import com.resttechsoutions.hibernatetutorial.domain.Productos;
import com.resttechsoutions.hibernatetutorial.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Rafael Estrella
 */
public class NamedQuery {
    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();

        Session s = hu.getSession();
        s.getTransaction().begin();
        
        System.out.println("***************************NATIVE QUERY***************************");

        s = hu.getSession();
        s.getTransaction().begin();

        Query nativeQuery = s.createNativeQuery("Select * from productos", Productos.class);

        List<Productos> productos = nativeQuery.getResultList();

        productos.stream()
                .forEach(
                        p -> System.out.println(p.getDescripcion() + " " + p.getPreciounit() + " " + p.getExistencia())
                );
        s.getTransaction().commit();
        s.close();
    }
}
