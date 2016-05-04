package test01917;

import daoimpl01917.OperatoerImpl;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;

import java.sql.SQLException;

import connector01917.Connector;

public class operatoerTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		System.out.println("Operatoer nummer 1:");
		OperatoerImpl opr = new OperatoerImpl();
		try { System.out.println(opr.getOperatoer(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Indsaettelse af ny operatoer med opr_id =  2");
		OperatoerDTO oprDTO = new OperatoerDTO(2,"Don Juan","DJ","000000-0000","iloveyou", 0, "operatør");
		try { opr.createOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	

		System.out.println("Operatoer nummer 2:");
		try { System.out.println(opr.getOperatoer(2)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Opdatering af initialer for operatoer nummer 2");
		oprDTO.setIni("DoJu");
		try { opr.updateOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 2:");
		try { System.out.println(opr.getOperatoer(2)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Alle operatoerer:");
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Indsaettelse af ny operatoer med opr_id =  3");
		OperatoerDTO oprDTO1 = new OperatoerDTO(3,"Martin","MR","130193-0000","Hejasverige", 2, "farmaceut");
		try { opr.createOperatoer(oprDTO1); }
		catch (DALException e) { System.out.println(e.getMessage()); }	

		System.out.println("Operatoer nummer 3:");
		try { System.out.println(opr.getOperatoer(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		

		System.out.println("Update cpr for Operator 3");
		oprDTO1.setCpr("920349-2345");
		try { opr.updateOperatoer(oprDTO1); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Update password for Operator 3: ");
		oprDTO1.setPassword("hejmeddig");
		try { opr.updateOperatoer(oprDTO1); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 3:");
		try { System.out.println(opr.getOperatoer(3)); }
		catch (DALException e) { System.out.println(e.getMessage());
		}
	}
}
