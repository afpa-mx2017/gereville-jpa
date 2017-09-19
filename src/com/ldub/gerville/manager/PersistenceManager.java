/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldub.gerville.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
  INSTANCE;
 
  private EntityManagerFactory emFactory;
 
  private PersistenceManager() {
    // "jpa-example" was the value of the name attribute of the
    // persistence-unit element.
    emFactory = Persistence.createEntityManagerFactory("GerevilleJPAPU");
  }
 
  public EntityManager getEntityManager() {
    return emFactory.createEntityManager();
  }
 
  public void close() {
    emFactory.close();
  }
}