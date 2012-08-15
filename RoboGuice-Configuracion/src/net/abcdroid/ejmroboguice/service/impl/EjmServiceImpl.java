package net.abcdroid.ejmroboguice.service.impl;

import net.abcdroid.ejmroboguice.dao.EjmDao;
import net.abcdroid.ejmroboguice.service.EjmService;

import com.google.inject.Inject;

public class EjmServiceImpl implements EjmService {

	@Inject
	EjmDao ejmDao;
	
	@Override
	public void guardarInformacion(String info) {
		ejmDao.guardarInformacion(info);
	}
	
	public String obtenerInformacion(){
		return ejmDao.obtenerInformacion();
	}

}
