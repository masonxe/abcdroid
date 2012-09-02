package net.abcdroid.ejmandroidyoutube.config;

import net.abcdroid.ejmandroidyoutube.dao.VideoDao;
import net.abcdroid.ejmandroidyoutube.dao.impl.VideoDaoImpl;
import net.abcdroid.ejmandroidyoutube.service.VideoService;
import net.abcdroid.ejmandroidyoutube.service.impl.VideoServiceImpl;
import roboguice.config.AbstractAndroidModule;

public class Modulo extends AbstractAndroidModule{

	@Override
	protected void configure() {
		
		//Iniciando Daos
		bind(VideoDao.class).to(VideoDaoImpl.class);
		
		//Iniciando Servicios
		bind(VideoService.class).to(VideoServiceImpl.class);
	}
}
