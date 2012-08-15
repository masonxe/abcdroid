package net.abcdroid.ejmroboguice.config;

import net.abcdroid.ejmroboguice.dao.EjmDao;
import net.abcdroid.ejmroboguice.dao.impl.EjmDaoImpl;
import net.abcdroid.ejmroboguice.service.EjmService;
import net.abcdroid.ejmroboguice.service.impl.EjmServiceImpl;
import roboguice.config.AbstractAndroidModule;

import com.google.inject.Singleton;

public class EjmRoboGuiceModulo extends AbstractAndroidModule {

	@Override
	protected void configure() {
		
		//Dao
		bind(EjmDao.class).to(EjmDaoImpl.class).in(Singleton.class);
		
		//Service
		bind(EjmService.class).to(EjmServiceImpl.class).in(Singleton.class);
	}
}