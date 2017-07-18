package edu.byui.cit360.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONUtilities;

import edu.byui.cit360.model.Expense;
import edu.byui.cit360.model.DBConnection;

/**
 * Servlet implementation class ExpenseServlet
 */
public final class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ExpenseServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBConnection connection = new DBConnection();
		Connection conn = connection.getDBConnection();
		try {
			int i = 0;
			List<Expense> expenses = new ArrayList<Expense>();
			List<String> JSONStrings = new ArrayList<String>();
			Expense expense = new Expense();
			ExpenseTrans expenseTrans = new ExpenseTrans();
			expenses = expenseTrans.readExpenses();
			
			for (int j = 0; j < expenses.size(); j++) {
				expense = expenses.get(j);
				String JSONString = JSONUtilities.stringify(expenses.get(i));
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
