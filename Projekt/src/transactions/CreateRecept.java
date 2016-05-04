package transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connector01917.Connector;
import connector01917.Constant;

public class CreateRecept {
	Connection conn;
	
	public void createRecept(int recept_id, String recept_navn, int raavare_id, double nom_netto, double tolerance) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{

		conn = Connector.connectToDatabase("jdbc:mysql://"+Constant.server+":"+Constant.port+"/"+Constant.database,
				Constant.username, Constant.password);
		PreparedStatement insertRecept = null;
		PreparedStatement insertReceptKomp = null;

		String receptString = 
				"INSERT INTO recept(recept_id, recept_navn) VALUES (?, ?);"; 

		String receptKompString =
				"INSERT INTO receptkomponent(recept_id, raavare_id, nom_Netto, tolerance) VALUES (?, ?, ?, ?);";

		try {
			conn.setAutoCommit(false);
			insertRecept = conn.prepareStatement(receptString);
			insertReceptKomp = conn.prepareStatement(receptKompString);
			
			insertRecept.setInt(1, recept_id);
			insertRecept.setString(2, recept_navn);
			insertRecept.executeUpdate();
			insertReceptKomp.setInt(1, recept_id);
			insertReceptKomp.setInt(2, raavare_id);
			insertReceptKomp.setDouble(3, nom_netto);
			insertReceptKomp.setDouble(4, tolerance);
			insertReceptKomp.executeUpdate();
			conn.commit();
	    
	}catch (SQLException e){
		System.out.println(e);
		conn.rollback();
	}finally{
		conn.setAutoCommit(true);
	}
		
//		mysql syntax
//		START TRANSACTION;
//		INSERT INTO recept(recept_id, recept_navn) VALUES (1, 'Magharita');
//		INSERT INTO receptkomponent(recept_id, raavare_id, nom_Netto, tolerance) VALUES (1, 1, 100, 0.5);
//		COMMIT;

	}
}
