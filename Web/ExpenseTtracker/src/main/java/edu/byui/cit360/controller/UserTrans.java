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

import edu.byui.cit360.model.User;

/**
 *
 * @author Jesus Arredondo
 */
public class UserTrans {

    //This methods creates a new client in the database
    public User addUser(String userName, String password) {

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(user);
            session.getTransaction().commit();
        }

        return user;
    }

    //This methods reads the list of clients from the data base
    @SuppressWarnings("unchecked")
	public List<User> readUsers() {
        List<User> users = new ArrayList<User>();
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from user");
            users = query.list();
            for (User user : users) {
                System.out.println("Done " + user.getUserName());
            }
            session.getTransaction().commit();
        }

        return users;

    }

    public User updateUser(String userName, String password) {
        User user;
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            user = session.get(User.class, 2);
            user.setUserName(userName);
            user.setPassword(password);
            session.getTransaction().commit();
        }
        return user;
    }

    public void deleteUser() {
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            User user = session.load(User.class, 2);
            session.delete(user);
            System.out.println("Deleted Successfully");
            session.getTransaction().commit();
        }
    }
}
