package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.ProduktBatchKompImpl;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;

public class produktBatchKompTest {
	
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		ProduktBatchKompImpl rb = new ProduktBatchKompImpl();

		System.out.println("Indsaettelse af ny ProduktBatchKomp med pb_id = 1");
		ProduktBatchKompDTO ProduktBatchKompDTO = new ProduktBatchKompDTO(1, 1, 0.5, 10.5, 2);
		try { rb.createProduktBatchKomp(ProduktBatchKompDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("ProduktBatchKomp nummer 1:");
		try { System.out.println(rb.getProduktBatchKomp(1, 1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
