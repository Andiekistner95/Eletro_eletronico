package br.com.Andiara.Eletro_eletronico.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.DAO.RadioDAO;
import br.com.Andiara.Eletro_eletronico.jdbc.oracle.ConnectionPoolOracle;
import br.com.Andiara.Eletro_eletronico.model.Radio;

public class RadioService {

	public List<Radio> listaRadio() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new RadioDAO(con).lista();
		}
	}
	
	public boolean aumentarVolume(int codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()){
			return new  RadioDAO(con).aumentarVolume(codigo);
		}
	}
	
	public boolean diminuirVolume(int codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()){
			return new  RadioDAO(con).diminuirVolume(codigo);
		}
	}	
}
