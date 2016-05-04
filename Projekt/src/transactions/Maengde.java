package transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connector01917.Connector;

public class Maengde {
Connection conn;
	
	public void updateMaengde() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{

		conn = Connector.connectToDatabase("jdbc:mysql://"+"localhost"+":"+3306+"/"+"Projekt_1",
				"root", "");
		PreparedStatement insertRecept = null;
		PreparedStatement insertReceptKomp = null;

//		String receptString = 
//				"INSERT INTO recept(recept_id, recept_navn) VALUES (?, ?);"; 
//
//		String receptKompString =
//				"INSERT INTO receptkomponent(recept_id, raavare_id, nom_Netto, tolerance) VALUES (?, ?, ?, ?);";
//
//		try {
//			conn.setAutoCommit(false);
//			insertRecept = conn.prepareStatement(receptString);
//			insertReceptKomp = conn.prepareStatement(receptKompString);
//			
//			insertRecept.setInt(1, recept_id);
//			insertRecept.setString(2, recept_navn);
//			insertRecept.executeUpdate();
//			insertReceptKomp.setInt(1, recept_id);
//			insertReceptKomp.setInt(2, raavare_id);
//			insertReceptKomp.setDouble(3, nom_netto);
//			insertReceptKomp.setDouble(4, tolerance);
//			insertReceptKomp.executeUpdate();
//			conn.commit();
//	    
//	}catch (SQLException e){
//		System.out.println(e);
//		conn.rollback();
//	}finally{
//		conn.setAutoCommit(true);
	}
}
