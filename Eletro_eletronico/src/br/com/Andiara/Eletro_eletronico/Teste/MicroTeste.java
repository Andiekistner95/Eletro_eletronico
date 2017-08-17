package br.com.Andiara.Eletro_eletronico.Teste;

import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Eletro_eletronico.Service.Micro_systemService;
import br.com.Andiara.Eletro_eletronico.model.Micro_system;

public class MicroTeste {

	public static void main(String[] args) throws SQLException {

		Micro_systemService micro_systemService = new Micro_systemService();

		List<Micro_system> lMicro_system = new Micro_systemService().listaMicro_system();
		for (Micro_system micro : lMicro_system) {
			System.out.println("Codigo: "+micro.getCodigo());
			micro_systemService.aumentarVolume(micro.getCodigo());
			micro_systemService.diminuirVolume(micro.getCodigo());
		}
	}
}
