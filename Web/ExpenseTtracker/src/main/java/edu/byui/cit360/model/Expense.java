/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jesus Arredondo
 */
@Entity
@Table(name = "expense")
public class Expense implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6596803355846836364L;
	private int id;
    private Date date;
    private float amount;
    private String description;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Store store;
    
    @ManyToOne
    private Category category;

    public Expense() {
    }

    public Expense(Date date, float amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idExpense")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "expenseDate")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "ammount")
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Column(name = "expenseDescription")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
