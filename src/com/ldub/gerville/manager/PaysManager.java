/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldub.gerville.manager;

import com.ldub.gerville.Pays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author lionel
 */
public class PaysManager {
    
    
    
    public List<Pays> findAll(){
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Pays p");
        return query.getResultList();
        
    }
    
    
    public void save(Pays p){
        
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        em.close();

        PersistenceManager.INSTANCE.close();
    }
     
    
}
