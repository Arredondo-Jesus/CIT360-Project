package edu.byui.cit360.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quickconnect.json.*;

import edu.byui.cit360.model.DBConnection;
import edu.byui.cit360.model.Store;

/**
 * Servlet implementation class StoreServlet
 */
public final class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StoreServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			int i = 0;
			List<Store> stores = new ArrayList<Store>();
			List<String> JSONStrings = new ArrayList<String>();
			
			Store store = new Store();
			StoreTrans storeTrans = new StoreTrans();
			stores = storeTrans.readStores();
			
			for (int j = 0; j < stores.size(); j++) {
				store = stores.get(j);
				String JSONString = JSONUtilities.stringify(stores.get(i));
				JSONStrings.add(JSONString);
				i=i++;
			}
			request.setAttribute("JSONStrings", JSONStrings);
			Write write = new Write();
			write.writeFile(JSONStrings);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
