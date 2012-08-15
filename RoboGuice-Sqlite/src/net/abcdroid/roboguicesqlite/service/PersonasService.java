package net.abcdroid.roboguicesqlite.service;

import java.util.List;

import net.abcdroid.roboguicesqlite.dbo.PersonaDbo;

public interface PersonasService {

	public long registrarPersona(PersonaDbo p);
	public List<PersonaDbo> listarPersonas();
}
