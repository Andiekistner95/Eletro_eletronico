package br.com.Andiara.Eletro_eletronico.Teste;

import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.Service.RadioService;
import br.com.Andiara.Eletro_eletronico.model.Radio;

public class RadioTeste {

	public static void main(String[] args) throws SQLException {

		RadioService radioService = new RadioService();

		List<Radio> lRadios = new RadioService().listaRadio();
		for (Radio radio : lRadios) {
			System.out.println("Codigo: "+radio.getCodigo());
			radioService.aumentarVolume(radio.getCodigo());
			radioService.diminuirVolume(radio.getCodigo());
		}
	}

}
