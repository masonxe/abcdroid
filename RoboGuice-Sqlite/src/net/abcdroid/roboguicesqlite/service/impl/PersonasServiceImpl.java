package net.abcdroid.roboguicesqlite.service.impl;

import java.util.List;

import net.abcdroid.roboguicesqlite.dao.PersonasDao;
import net.abcdroid.roboguicesqlite.dbo.PersonaDbo;
import net.abcdroid.roboguicesqlite.service.PersonasService;

import com.google.inject.Inject;

public class PersonasServiceImpl implements PersonasService {

	@Inject
	PersonasDao personasDao;
	
	@Override
	public long registrarPersona(PersonaDbo p) {
		return personasDao.registrarPersona(p);
	}

	
	@Override
	public List<PersonaDbo> listarPersonas() {
		return personasDao.listarPersonas();
	}
}