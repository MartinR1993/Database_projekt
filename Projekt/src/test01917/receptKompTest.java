package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.ReceptKompImpl;
import daointerfaces01917.DALException;
import dto01917.ReceptKompDTO;

public class receptKompTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		ReceptKompImpl rk = new ReceptKompImpl();

		System.out.println("Indsaettelse af nyt receptkomp med recept_id =  1");
		ReceptKompDTO receptKompDTO = new ReceptKompDTO(1, 1, 100.0, 0.5);
		try { rk.createReceptKomp(receptKompDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Repect liste:");
		try { System.out.println(rk.getReceptKompList(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
