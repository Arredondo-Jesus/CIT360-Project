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
@Table(name = "category")
public class Category implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4927508548691111031L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategory")
    private int id;
    @Column(name = "categoryName")
    private String name;
    @Column(name = "categoryDescription")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Expense> expenses = new ArrayList<Expense>();

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description, List<Expense> expenses) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
