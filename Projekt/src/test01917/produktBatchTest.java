package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.ProduktBatchImpl;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;

public class produktBatchTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		ProduktBatchImpl pb = new ProduktBatchImpl();

		System.out.println("Indsaettelse af ny ProduktBatch med pb_id =  1");
		ProduktBatchDTO produktBatchDTO = new ProduktBatchDTO(1, 3, 1);
		try { pb.createProduktBatch(produktBatchDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("ProduktBatch nummer 1:");
		try { System.out.println(pb.getProduktBatch(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
