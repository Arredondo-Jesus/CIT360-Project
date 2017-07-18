/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.controller;

import edu.byui.cit360.model.User;

/**
 *
 * @author Jesus Arredondo
 */
public class Test {

    public static void main(String[] args) {
        UserTrans userTrans = new UserTrans();
        User user = new User();
        
        String userName = "user";
        String password = "password";


        userTrans.addUser(userName, password);
        user.setUserName(userName);
        user.setPassword(password);

    }
}
