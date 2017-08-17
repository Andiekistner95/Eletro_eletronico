package br.com.Andiara.Eletro_eletronico.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.DAO.micro_systemDAO;
import br.com.Andiara.Eletro_eletronico.jdbc.oracle.ConnectionPoolOracle;
import br.com.Andiara.Eletro_eletronico.model.Micro_system;


public class Micro_systemService {

		public List<Micro_system> listaMicro_system() throws SQLException{
			try (Connection con = new ConnectionPoolOracle().getConnection()) {
	            return new micro_systemDAO(con).lista();
			}
		}
		
		public boolean aumentarVolume(int codigo) throws SQLException{
			try (Connection con = new ConnectionPoolOracle().getConnection()){
				return new  micro_systemDAO(con).aumentarVolume(codigo);
			}
		}
		
		public boolean diminuirVolume(int codigo) throws SQLException{
			try (Connection con = new ConnectionPoolOracle().getConnection()){
				return new  micro_systemDAO(con).diminuirVolume(codigo);
			}
		}	
	}

