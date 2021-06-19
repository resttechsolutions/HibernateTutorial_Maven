/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.main;

import com.resttechsoutions.hibernatetutorial.domain.Empleados;
import com.resttechsoutions.hibernatetutorial.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Rafael Estrella
 */
public class Delete {

    public static void main(String[] args) {
        
        System.out.println("***************************Delete***************************");

        HibernateUtil hu = new HibernateUtil();

        Session s = hu.getSession();
        s.getTransaction().begin();
        
        s.delete(s.get(Empleados.class, 1));
        List<Empleados> deleted = s.createQuery("from Empleados").list();
        s.getTransaction().commit();
        s.close();
        
        deleted.stream()
                .forEach(
                        d -> System.out.println(d.getEmpleadoid() + " " + d.getNombre() + " " + d.getApellido())
                );
    }
}
