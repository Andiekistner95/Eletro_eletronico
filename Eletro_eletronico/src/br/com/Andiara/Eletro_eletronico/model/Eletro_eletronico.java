package br.com.Andiara.Eletro_eletronico.model;

public abstract class Eletro_eletronico {

	private int codigo;
	private String tipo_eletro;
	private int volume_eletro;

	public Eletro_eletronico(int codigo,String tipo_eletro,int volume_eletro) {
		setCodigo(codigo);
		setTipo_eletro(tipo_eletro);
		setVolume_eletro(volume_eletro);
	}
	
	public Eletro_eletronico() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo_eletro() {
		return tipo_eletro;
	}

	public void setTipo_eletro(String tipo_eletro) {
		this.tipo_eletro = tipo_eletro;
	}

	public int getVolume_eletro() {
		return volume_eletro;
	}

	public void setVolume_eletro(int volume_eletro) {
		this.volume_eletro = volume_eletro;
	}

}