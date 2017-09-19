/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldub.gerville;

import com.ldub.gerville.manager.PaysManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author lionel
 */
public class GerevilleJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //tests
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GerevilleJPAPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Pays> query =  em.createNamedQuery("Pays.findAll", Pays.class);
        List<Pays> results = query.getResultList();
        for (Pays p : results) {
            
            System.out.println("p:" + p.getNom());
            //System.out.println("capitale nom:" + p.getCapitaleId().getNom());
            
            System.out.println("villes:");
            for (Ville ville : p.getVilleList()) {
                System.out.println("ville:" + ville.getNom());
            }
            
        }
        
        //tests avzec un "manager"
        
        
        PaysManager pm = new PaysManager();
        List<Pays> ps = pm.findAll();
        for (Pays pays : ps) {

           System.out.println("p:" + pays.getNom());
        }
        
        Pays pays = new Pays("kikou des prés");
        pm.save(pays);
        System.out.println("nouveau pays:" + pays.getId());
    }
    
}
