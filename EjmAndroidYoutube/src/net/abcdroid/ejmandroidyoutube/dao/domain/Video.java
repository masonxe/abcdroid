package net.abcdroid.ejmandroidyoutube.dao.domain;

import java.util.List;

public class Video {

	String titulo;
	String ruta;
	List<Miniatura> miniaturas;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public List<Miniatura> getMiniaturas() {
		return miniaturas;
	}
	public void setMiniaturas(List<Miniatura> miniaturas) {
		this.miniaturas = miniaturas;
	}
}