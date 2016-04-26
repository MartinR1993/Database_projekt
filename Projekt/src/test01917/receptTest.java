package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.ReceptImpl;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;

public class receptTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		ReceptImpl recept = new ReceptImpl();

		System.out.println("Indsaettelse af ny recept med recept_id =  1");
		ReceptDTO receptDTO = new ReceptDTO(1, "Hej");
		try { recept.createRecept(receptDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Repect nummer 1:");
		try { System.out.println(recept.getRecept(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
