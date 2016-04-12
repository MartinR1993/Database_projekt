package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchKompDTO;

public class ProduktBatchKompImpl implements ProduktBatchKompDAO {

	@Override
	public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pbId = " + pbId + " AND rbId = " + rbId);
		try {
			if (!rs.first()) throw new DALException("Produktbatchkomponenten med ID " + pbId + ", findes ikke");
			return new ProduktBatchKompDTO (rs.getInt("pbId"), rs.getInt("rbId"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("oprId"));
		}
		catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pbId = " + pbId);
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(rs.getInt("pbId"), rs.getInt("rbId"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("oprId")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(rs.getInt("pbId"), rs.getInt("rbId"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("oprId")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate(
				"INSERT INTO produktbatchkomponent(pbId, rbId, tara, netto, orpId) VALUES " +
						"(" + produktbatchkomponent.getPbId() + ", '" + produktbatchkomponent.getRbId() + "', '" + 
						produktbatchkomponent.getTara() + "', '" + produktbatchkomponent.getNetto() + "', '" + 
						produktbatchkomponent.getOprId() + "')"
				);
	}

	@Override
	public void updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate(
				"UPDATE produktbatchkomponent SET rbId = '" + produktbatchkomponent.getRbId() + "', tara =  '" + 
						produktbatchkomponent.getTara() + "', netto = '" + produktbatchkomponent.getNetto() + 
						"', oprId = '" + produktbatchkomponent.getOprId() + "' WHERE pbId = " +
						produktbatchkomponent.getPbId()
				);
	}

}
