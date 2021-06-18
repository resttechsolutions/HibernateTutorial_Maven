/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.main;

import com.resttechsoutions.hibernatetutorial.domain.Categorias;
import com.resttechsoutions.hibernatetutorial.domain.Empleados;
import com.resttechsoutions.hibernatetutorial.domain.Ordenes;
import com.resttechsoutions.hibernatetutorial.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Rafael Estrella
 */
public class App {

    public static void main(String[] args) {
        
        HibernateUtil hu = new HibernateUtil();
        
        Session s = hu.getSession();

        s.beginTransaction();

        List<Categorias> result = s.createQuery("from Categorias c where c.nombrecat like '%L%'").list();
        List<Ordenes> resultOrdenes = s.createQuery("from Ordenes o order by o.fechaorden").list();
        
        s.getTransaction().commit();
        s.close();

        System.out.println("***************************Select like***************************");
        
        result.stream()
                .forEach(
                        c -> System.out.println(c.getCategoriaid() + " - " + c.getNombrecat())
                );
        
        System.out.println("***************************Select order by***************************");
        
        resultOrdenes.stream()
                .forEach(
                        o -> System.out.println(o.getOrdenid() + " - " + o.getFechaorden())
                );
        
        System.out.println("***************************Update***************************");
        
        s = hu.getSession();
        s.getTransaction().begin();      
        
        Empleados empleado = s.get(Empleados.class, 1);
        empleado.setApellido("PEREZ");
        
        s.merge(empleado);
        s.getTransaction().commit();
        s.close();
        
        s = hu.getSession();
        s.getTransaction().begin();
        List<Empleados> empleados = s.createQuery("from Empleados e").list();
        s.getTransaction().commit();
        s.close();
        
        empleados.stream()
                .forEach(
                        e -> System.out.println(e.getNombre() +  " " + e.getApellido())
        );
        
        System.out.println("***************************Delete***************************");
        
        s = hu.getSession();
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
