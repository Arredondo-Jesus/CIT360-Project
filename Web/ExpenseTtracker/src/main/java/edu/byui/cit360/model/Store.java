/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jesus Arredondo
 */
@Entity
@Table(name = "store")
public class Store implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8349983175716936682L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idStore")
    private int id;
    @Column(name = "storeName")
    private String name;
    @Column(name = "storeLocation")
    private String location;

    @OneToMany(mappedBy = "store", cascade = CascadeType.PERSIST)
    private List<Expense> expenses = new ArrayList<Expense>();

    public Store() {
    }

    public Store(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Store(String name, String location, List<Expense> expenses) {
        this.name = name;
        this.location = location;
        this.expenses = expenses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    

}
