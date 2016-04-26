package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.RaavareBatchImpl;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;

public class raavareBatchTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		RaavareBatchImpl rb = new RaavareBatchImpl();

		System.out.println("Indsaettelse af ny RaavareBatch med rb_id =  1");
		RaavareBatchDTO raavareBatchDTO = new RaavareBatchDTO(1, 1, 1000);
		try { rb.createRaavareBatch(raavareBatchDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Raavare nummer 1:");
		try { System.out.println(rb.getRaavareBatch(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}

}
