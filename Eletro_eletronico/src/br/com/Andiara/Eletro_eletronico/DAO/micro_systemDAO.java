package br.com.Andiara.Eletro_eletronico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.model.Micro_system;

public class micro_systemDAO {
	private final Connection con;

	public micro_systemDAO(Connection con) {
		this.con = con;
	}

	public boolean aumentarVolume(int codigo) throws SQLException {

		String sql = "UPDATE ELETRO_ELETRONICO SET VOLUME_ELETRO = (VOLUME_ELETRO + 3) WHERE CODIGO = ?";

		PreparedStatement statement = con.prepareStatement(sql);

		statement.setInt(1, codigo);
		boolean resultado = statement.executeUpdate() > 0;
		System.out.println("Volume aumentado");
		retornaVolume(codigo);
		return resultado;
	}

	public boolean diminuirVolume(int codigo) throws SQLException {

		String sql = "UPDATE ELETRO_ELETRONICO SET VOLUME_ELETRO = (VOLUME_ELETRO  -3) WHERE CODIGO = ?";

		PreparedStatement statement = con.prepareStatement(sql);

		statement.setInt(1, codigo);
		boolean resultado = statement.executeUpdate() > 0;
		System.out.println("Volume diminuido");
		retornaVolume(codigo);
		return resultado;
	}
	
	public List<Micro_system> lista() throws SQLException {
		List<Micro_system> lMicro_system = new ArrayList<>();

		String sql = "select * from Eletro_eletronico where tipo_eletro = 'MICRO_SYSTEM'";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
			
				while (rs.next()) {

					int codigo = rs.getInt("codigo");
					String tipo_eletro = rs.getString("tipo_eletro");
					int volume_eletro = rs.getInt("volume_eletro");
					Micro_system ms = new Micro_system(codigo, tipo_eletro, volume_eletro);
					lMicro_system.add(ms);
				}
			}
		}

		return lMicro_system;

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
					volume = "Tipo: " + tipo_eletro + "volume: " + volume_eletro;
					System.out.println(volume);
					
				}
			}
		}
	}
}
