package net.abcdroid.roboguicesqlite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import net.abcdroid.roboguicesqlite.config.DatabaseHelper;
import net.abcdroid.roboguicesqlite.dao.PersonasDao;
import net.abcdroid.roboguicesqlite.dbo.PersonaDbo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PersonasDaoImpl implements PersonasDao {

	DatabaseHelper helper;	
	SQLiteDatabase conn;

	public PersonasDaoImpl(){
		helper = new DatabaseHelper();
		conn = helper.getConexion();
	}
	
	public long registrarPersona(PersonaDbo p){
		ContentValues valores = new ContentValues();
		valores.put("dni",p.getDni());
		valores.put("apPaterno",p.getApPaterno());
		valores.put("apMaterno",p.getApMaterno());
		valores.put("nombres",p.getNombres());
		long rs = conn.insert("personas",null, valores);
		
		if(rs == -1){
			Log.e("PersonasDaoImpl","Error al registrar");
		}
		
		return rs;
	}
	
	@Override
	public List<PersonaDbo> listarPersonas() {

		List<PersonaDbo> lstPersonas = new ArrayList<PersonaDbo>();
		String sql = "select * from personas order by apPaterno asc";
		Cursor c = conn.rawQuery(sql,null);
		
		int indexDni = c.getColumnIndex("dni");
    	int indexApPaterno = c.getColumnIndex("apPaterno");
    	int indexApMaterno = c.getColumnIndex("apMaterno");
    	int indexNombres = c.getColumnIndex("nombres");
    	
    	if(c.moveToFirst()){
    		do{	
    			PersonaDbo p = new PersonaDbo();
    			String dni = c.getString(indexDni);
    			String apPaterno = c.getString(indexApPaterno);
    			String apMaterno = c.getString(indexApMaterno);
    			String nombres = c.getString(indexNombres);
    			
    			p.setApPaterno(apPaterno);
    			p.setApMaterno(apMaterno);
    			p.setNombres(nombres);
    			p.setDni(dni);
    			
    			lstPersonas.add(p);
    		}while(c.moveToNext());
        	
    	}
		
		return lstPersonas;
	}
	
	@Override
	protected void finalize() throws Throwable {
		if(conn!=null){
			helper.cerrar();
			conn.close();
		}
		
		super.finalize();
	}

}