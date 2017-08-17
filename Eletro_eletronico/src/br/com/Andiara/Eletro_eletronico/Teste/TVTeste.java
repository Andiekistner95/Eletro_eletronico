package br.com.Andiara.Eletro_eletronico.Teste;

import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.Service.TVService;
import br.com.Andiara.Eletro_eletronico.model.TV;

public class TVTeste {
	
	public static void main(String[] args) throws SQLException {
		
		TVService tvService = new TVService();
		
	List<TV> lTvs = new TVService().listarTvs();
		for (TV tv : lTvs) {
			System.out.println("Codigo: "+tv.getCodigo() ) ;
			tvService.aumentarVolume(tv.getCodigo());
			tvService.diminuirVolume(tv.getCodigo());
       }
	}
}