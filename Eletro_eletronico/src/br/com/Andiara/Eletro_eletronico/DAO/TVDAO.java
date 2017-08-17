package br.com.Andiara.Eletro_eletronico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.model.TV;

public class TVDAO {
private final Connection con;
	
	public TVDAO(Connection con) {
		this.con = con;
	}
	
	
	public boolean aumentarVolume(int codigo) throws SQLException{
		
		String sql = "UPDATE ELETRO_ELETRONICO SET VOLUME_ELETRO = (VOLUME_ELETRO + 2) WHERE CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
	
		statement.setInt(1, codigo);
		boolean resultado = statement.executeUpdate() > 0;
		System.out.println("Volume aumentado");
		retornaVolume(codigo);
		return resultado;
	}
	
	public boolean diminuirVolume(int codigo) throws SQLException{
		// pq o metodo statement.executeUpdate() retorna um valor true ou false 
		String sql = "UPDATE ELETRO_ELETRONICO SET VOLUME_ELETRO = (VOLUME_ELETRO - 2) WHERE CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setInt(1, codigo);
		boolean resultado = statement.executeUpdate() > 0;
		System.out.println("Volume diminuido");
		retornaVolume(codigo);
		return resultado;
	}
	
	public List<TV> lista() throws SQLException {
		List<TV> lTV = new ArrayList<>();

		String sql = "SELECT * FROM ELETRO_ELETRONICO WHERE TIPO_ELETRO = 'TELEVISAO'";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				
				while (rs.next()) {

					int codigo = rs.getInt("codigo");
					String tipo_eletro = rs.getString("tipo_eletro");
					int volume_eletro = rs.getInt("volume_eletro");
					TV tv = new TV(codigo, tipo_eletro, volume_eletro);
					lTV.add(tv);
				}
			}
		}

		return lTV;

	}
	
	public void retornaVolume(int codigoEletro) throws SQLException {
		
		String volume ="";
		
		String sql = "select * from eletro_eletronico where codigo = ?";
				
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, codigoEletro);
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				
				while (rs.next()) {

					int codigo = rs.getInt("codigo");
					String tipo_eletro = rs.getString("tipo_eletro");
					int volume_eletro = rs.getInt("volume_eletro");
					volume = "\nTipo: " + tipo_eletro + "\nvolume: " + volume_eletro;
					System.out.println(volume);
					
				}
			}
		}
	}
}
