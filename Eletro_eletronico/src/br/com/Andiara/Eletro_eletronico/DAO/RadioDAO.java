package br.com.Andiara.Eletro_eletronico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.model.Radio;

public class RadioDAO {

private final Connection con;
	
	public RadioDAO(Connection con) {
		this.con = con;
	}
	
	
	public boolean aumentarVolume(int codigo) throws SQLException{
		
		/*
		 * Consulta que será enviada ao banco. O símbolo "?" representa o parâmetro
		 * que será recebido no método 
		 */
		String sql = "UPDATE ELETRO_ELETRONICO SET VOLUME_ELETRO = (VOLUME_ELETRO + 1) WHERE CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		
		/*
		 * Preparação dos parâmetros com o metodo statement.setInt(1, codigo);
		 * sendo que o 1 representa o primeiro parametro "?" recebido, 
		 * ele receberá o valor da variável recebida na chamada do metodo aumentarVolume;		 * 
		 */
		statement.setInt(1, codigo);
		boolean resultado = statement.executeUpdate() > 0;
		System.out.println("Volume aumentado");
		retornaVolume(codigo);
		return resultado;
	}
	
	public boolean diminuirVolume(int codigo) throws SQLException{
		
		/*
		 * Consulta que será enviada ao banco. O símbolo "?" representa o parâmetro
		 * que será recebido no método 
		 */
		String sql = "UPDATE ELETRO_ELETRONICO SET VOLUME_ELETRO = (VOLUME_ELETRO -1) WHERE CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		
		/*
		 * Preparação dos parâmetros com o metodo statement.setInt(1, codigo);
		 * sendo que o 1 representa o primeiro parametro "?" recebido, 
		 * ele receberá o valor da variável recebida na chamada do metodo diminuirVolume;		 * 
		 */
		statement.setInt(1, codigo);
		boolean resultado = statement.executeUpdate() > 0;
		System.out.println("Volume diminuido");
		retornaVolume(codigo);
		return resultado;
	}
	
	
	public List<Radio> lista() throws SQLException {
		List<Radio> lRadios = new ArrayList<>();

		// traz os registros do banco de dados da tabela "radio"
		String sql = "select * from Eletro_eletronico where tipo_eletro = 'RADIO'";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			// se tiver resultado (encontra dados na tabela ) ele executa o
			// codigo abaixo
			try (ResultSet rs = stmt.getResultSet()) {
				// faz um loop usando while para pegar os dados e criar os
				// objetos do tipo radio
				while (rs.next()) {

					int codigo = rs.getInt("codigo");
					String tipo_eletro = rs.getString("tipo_eletro");
					int volume_eletro = rs.getInt("volume_eletro");
					Radio radio = new Radio(codigo, tipo_eletro, volume_eletro);
					lRadios.add(radio);
				}
			}
		}

		return lRadios;

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
					System.out.println("\n"+volume);
					
				}
			}
		}
	}
}
