package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import transactions.CreateRecept;

public class testtest {
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		CreateRecept re = new CreateRecept();
		
		re.createRecept(3, "Test1", 1, 105.0, 0.6);
		
	}
}
