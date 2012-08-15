package net.abcdroid.roboguicesqlite.config;

import net.abcdroid.roboguicesqlite.dao.PersonasDao;
import net.abcdroid.roboguicesqlite.dao.impl.PersonasDaoImpl;
import net.abcdroid.roboguicesqlite.service.PersonasService;
import net.abcdroid.roboguicesqlite.service.impl.PersonasServiceImpl;
import roboguice.config.AbstractAndroidModule;

import com.google.inject.Singleton;

public class RoboGuiceSqliteModulo extends AbstractAndroidModule  {

	@Override
	protected void configure() {
		
		//Seteando el contexto a nuestro helper de base de datos
		requestStaticInjection(DatabaseHelper.class);
		
		//Daos
		bind(PersonasDao.class).to(PersonasDaoImpl.class).in(Singleton.class);
		
		//Service
		bind(PersonasService.class).to(PersonasServiceImpl.class).in(Singleton.class);
		
	}
}