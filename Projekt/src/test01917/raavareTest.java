package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.RaavareImpl;
import daointerfaces01917.DALException;
import dto01917.RaavareDTO;

public class raavareTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		RaavareImpl raavare = new RaavareImpl();

		System.out.println("Indsaettelse af ny raavare med raavare_Id =  1");
		RaavareDTO raavareDTO = new RaavareDTO(1, "Mel", "Mel A/S");
		try { raavare.createRaavare(raavareDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Raavare nummer 1:");
		try { System.out.println(raavare.getRaavare(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
