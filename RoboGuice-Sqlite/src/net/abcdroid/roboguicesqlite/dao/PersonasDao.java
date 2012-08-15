package net.abcdroid.roboguicesqlite.dao;

import java.util.List;

import net.abcdroid.roboguicesqlite.dbo.PersonaDbo;

public interface PersonasDao {

	public long registrarPersona(PersonaDbo p);
	public List<PersonaDbo> listarPersonas();
}