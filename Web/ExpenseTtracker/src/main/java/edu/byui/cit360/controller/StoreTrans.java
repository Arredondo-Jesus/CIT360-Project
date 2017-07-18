/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.byui.cit360.model.Store;
import edu.byui.cit360.model.User;

/**
 *
 * @author Jesus Arredondo
 */
public class StoreTrans {

    //This methods creates a new client in the database
    public Store addStore(String name, String location) {

        Store store = new Store();
        store.setName(name);
        store.setLocation(location);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(store);
            session.getTransaction().commit();
        }

        return store;
    }

    //This methods reads the list of clients from the data base
    @SuppressWarnings("unchecked")
	public List<Store> readStores() {
        List<Store> stores = new ArrayList<Store>();
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from store");
            stores = query.list();
            for (Store store : stores) {
                System.out.println("Done " + store.getName());
            }
            session.getTransaction().commit();
        }

        return stores;

    }

    public Store updateStore(String name, String location) {
        Store store;
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            store = session.get(Store.class, 2);
            store.setName(name);
            store.setLocation(location);
            session.getTransaction().commit();
        }
        return store;
    }

    public void deleteStore() {
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Store store = session.load(Store.class, 2);
            session.delete(store);
            System.out.println("Deleted Successfully");
            session.getTransaction().commit();
        }
    }
}
