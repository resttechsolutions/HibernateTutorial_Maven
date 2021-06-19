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
public class Update {

    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();

        Session s = hu.getSession();

        s.getTransaction().begin();

        Empleados empleado = s.get(Empleados.class, 1); //retorna el objeto del tipo que se le pase en el primer parametro y del ID del segundo parametro
        empleado.setApellido("PEREZ"); // se altera el objeto

        s.merge(empleado); // se le hace el update al objeto en la BD
        s.getTransaction().commit();
        s.close();

        s = hu.getSession();
        s.getTransaction().begin();
        List<Empleados> empleados = s.createQuery("from Empleados e").list();
        s.getTransaction().commit();
        s.close();

        System.out.println("***************************Updated***************************");

        empleados.stream()
                .forEach(
                        e -> System.out.println(e.getNombre() + " " + e.getApellido())
                );
    }
}
