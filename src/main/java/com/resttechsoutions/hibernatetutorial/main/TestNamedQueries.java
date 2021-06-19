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
import org.hibernate.query.Query;

/**
 *
 * @author Rafael Estrella
 */
public class TestNamedQueries {
    private static HibernateUtil hu;
    
    public static void main(String[] args) {
        hu = new HibernateUtil();
        
        Session s = hu.getSession();
        
        s.getTransaction().begin();
        
        List<Categorias> categorias = s.createNamedQuery("Categorias.findAll", Categorias.class).getResultList(); //se llama el namedquery delcarado en el entity
        
        categorias.stream()
                .forEach(c -> System.out.println(c.getCategoriaid() + " " + c.getCategoriaid()));
        
        
        System.out.println("***************************USING PARAMS THROUH NAMEDQUERY");
        
        Query query = s.createNamedQuery("Categorias.findByCategoriaid", Categorias.class); //se llama el namedquery delcarado en el entity
        query.setParameter("categoriaid", 100); // se le pasa el parametro que espera el namedquery
        
        Categorias cat = (Categorias) query.getSingleResult(); // se puede obtener un listado, pero en este caso indicamos que nos devuelva un solo registro, ya que fitramos por id
        
        System.out.println(cat.getCategoriaid() + " " + cat.getNombrecat());
        s.close();
    }
}
