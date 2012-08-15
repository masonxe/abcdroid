package net.abcdroid.ejmroboguice.dao.impl;

import net.abcdroid.ejmroboguice.dao.EjmDao;

public class EjmDaoImpl implements EjmDao{

	private String textoPrueba;
	
	public EjmDaoImpl(){
		textoPrueba = "123";
	}
	
	public void guardarInformacion(String info){
		textoPrueba = info;
	}
	
	public String obtenerInformacion(){
		return textoPrueba;
	}
}