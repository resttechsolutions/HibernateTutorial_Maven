/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.main;

import com.resttechsoutions.hibernatetutorial.domain.Categorias;
import com.resttechsoutions.hibernatetutorial.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Rafael Estrella
 */
public class DynamicParameters {
    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();

        Session s = hu.getSession();
        s.getTransaction().begin();
        
        System.out.println("***************************DYNAMIC PARAMETERS***************************");
        
        Categorias cat = s.get(Categorias.class, 300); // se obtiene registro desde la BD a traves de su ID
        
        System.out.println("Before update: " + cat.getNombrecat());
        
        cat.setNombrecat("LIMPIEZA ..."); // se altera el objeto
        
        Query query = s.createQuery("UPDATE from Categorias c set c.nombrecat = :nombrecat"); // se crea el query del update con los parametros dinamicos
        query.setParameter("nombrecat", cat); // se le pasa el objeto a alterar al parametro
        s.getTransaction().commit();
        s.close();
        
        s = hu.getSession();
        s.getTransaction().begin();
        
        cat = s.get(Categorias.class, 300);
        
        s.getTransaction().commit();
        s.close();
        
        System.out.println("After update: " + cat.getNombrecat());
    }
}
