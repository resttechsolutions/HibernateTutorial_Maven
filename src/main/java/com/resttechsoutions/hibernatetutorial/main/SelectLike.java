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
public class SelectLike {

    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();

        Session s = hu.getSession();

        s.beginTransaction();

        List<Categorias> result = s.createQuery("from Categorias c where c.nombrecat like '%L%'").list(); //Select all LIKE

        s.getTransaction().commit();
        s.close();

        System.out.println("***************************Select like***************************");

        result.stream()
                .forEach(
                        c -> System.out.println(c.getCategoriaid() + " - " + c.getNombrecat())
                );

    }
}
