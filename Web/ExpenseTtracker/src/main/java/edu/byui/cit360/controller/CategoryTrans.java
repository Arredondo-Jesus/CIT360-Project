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

import edu.byui.cit360.model.Category;
import edu.byui.cit360.model.User;

/**
 *
 * @author Jesus Arredondo
 */
public class CategoryTrans {

    //This methods creates a new client in the database
    public Category addCategory(String name, String description) {

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(category);
            session.getTransaction().commit();
        }

        return category;
    }

    //This methods reads the list of clients from the data base
    @SuppressWarnings("unchecked")
	public List<Category> readCategories() {
        List<Category> categories = new ArrayList<Category>();
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from member");
            categories = query.list();
            for (Category category : categories) {
                System.out.println("Done " + category.getName());
            }
            session.getTransaction().commit();
        }

        return categories;

    }

    public Category updateUser(String name, String description) {
        Category category;
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            category = session.get(Category.class, 2);
            category.setName(name);
            category.setDescription(description);
            session.getTransaction().commit();
        }
        return category;
    }

    public void deleteCategory() {
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Category category = session.load(Category.class, 2);
            session.delete(category);
            System.out.println("Deleted Successfully");
            session.getTransaction().commit();
        }
    }
}
