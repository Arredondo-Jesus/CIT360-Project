/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.byui.cit360.model.Category;
import edu.byui.cit360.model.Expense;
import edu.byui.cit360.model.Store;
import edu.byui.cit360.model.User;

/**
 *
 * @author Jesus Arredondo
 */
public class ExpenseTrans {

    //This methods creates a new client in the database
    public Expense addExpense(Date date, float amount, String description) {

        Expense expense = new Expense();
        expense.setDate(date);
        expense.setAmount(amount);
        expense.setDescription(description);
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(expense);
            session.getTransaction().commit();
        }

        return expense;
    }

    //This methods reads the list of clients from the data base
    @SuppressWarnings("unchecked")
	public List<Expense> readExpenses() {
        List<Expense> expenses = new ArrayList<Expense>();
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from expense");
            expenses = query.list();
            for (Expense expense : expenses) {
                System.out.println("Done " + expense.getDescription());
            }
            session.getTransaction().commit();
        }

        return expenses;

    }

    public Expense updateExpense(Date date, float amount, String description) {
        Expense expense;
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            expense = session.get(Expense.class, 2);
            expense.setDate(date);
            expense.setAmount(amount);
            expense.setDescription(description);
            session.getTransaction().commit();
        }
        return expense;
    }

    public void deleteUser() {
        //getting session object from session factory
        try ( //Create session factory object
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Expense expense = session.load(Expense.class, 2);
            session.delete(expense);
            System.out.println("Deleted Successfully");
            session.getTransaction().commit();
        }
    }
}
