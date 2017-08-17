package br.com.Andiara.Eletro_eletronico.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.DAO.TVDAO;
import br.com.Andiara.Eletro_eletronico.jdbc.oracle.ConnectionPoolOracle;
import br.com.Andiara.Eletro_eletronico.model.TV;


public class TVService {

	public List<TV> listarTvs() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new TVDAO(con).lista();
		}
	}
	
	public boolean aumentarVolume(int codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()){
			return new  TVDAO(con).aumentarVolume(codigo);
		}
	}
	
	public boolean diminuirVolume(int codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()){
			return new  TVDAO(con).diminuirVolume(codigo);
		}
	}
}
