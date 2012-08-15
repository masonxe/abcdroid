package net.abcdroid.roboguicesqlite.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import net.abcdroid.roboguicesqlite.util.Constantes;
import net.abcdroid.roboguicesqlite.util.LoggerUtil;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DatabaseHelper{

	@Inject 
    private static Provider<Context> contextProvider;
	
	private Context contexto;
	private SQLiteDatabase sqlDb; 
	
	private String modoCrearBd;
    private static String DB_PATH = "";
	private static String DB_NAME = "";
	
	ResourceBundle propiedades;

    public DatabaseHelper() {
    	contexto = contextProvider.get();
    	propiedades = ResourceBundle.getBundle("bd");
    	DB_PATH = propiedades.getString("ruta_bd");
    	DB_NAME = propiedades.getString("nombre_bd");
    	modoCrearBd = propiedades.getString("crear_bd_una_vez");
    	crearBaseDeDatos();
	}

	public SQLiteDatabase getConexion(){
	    //Open the database
	    String ruta = DB_PATH + DB_NAME;
	    try{
		    sqlDb = SQLiteDatabase.openDatabase(ruta, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
	    }catch(SQLException e){
	    	LoggerUtil.error(DatabaseHelper.class,e.getMessage());
	    	sqlDb = null;
	    }
	    return sqlDb;
	}
	 
	public synchronized void cerrar() {
 	    if(sqlDb != null)
 		    sqlDb.close();
	}
	
	public void crearBaseDeDatos() { 
		
		if(modoCrearBd.equals(Constantes.CREAR_BD_UNA_VEZ)){
			boolean dbExist = verificarBaseDeDatos();
	    	if(!dbExist){
	        	copiarBaseDeDatos();
	        	cerrar();
	    	}
	    	LoggerUtil.debug(DatabaseHelper.class,"Modo carga una vez");
		}else{
			copiarBaseDeDatos();
	    	cerrar();
	    	LoggerUtil.debug(DatabaseHelper.class,"Modo carga cada vez que inicia");
		}
		
    }

	private boolean verificarBaseDeDatos(){
 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String  ruta = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(ruta, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
 
    	}catch(SQLiteException e){
    		LoggerUtil.error(DatabaseHelper.class,e.getMessage());
    	}
 
    	if(checkDB != null){
    		checkDB.close();
    	}
 
    	return checkDB != null ? true : false;
    }
	
	private void copiarBaseDeDatos() {
		 
    	//Open your local db as the input stream
		File carpeta = null;
    	InputStream entrada = null;
    	OutputStream salida = null;
    	String rutaArchivo = "";
    	byte[] buffer = null;
    	
    	try {
			entrada = contexto.getAssets().open(DB_NAME);
			
			//Creamos la carpeta
			carpeta = new File(DB_PATH);
			if (!carpeta.exists()) {
				carpeta.mkdir();
			}
			
			// Path to the just created empty db
	    	rutaArchivo = DB_PATH + DB_NAME;
	 
	    	//Open the empty db as the output stream
	    	salida = new FileOutputStream(rutaArchivo);
	 
	    	//transfer bytes from the inputfile to the outputfile
	    	buffer = new byte[Constantes.MB];
	    	int length;
	    	while ((length = entrada.read(buffer))>0){
	    		salida.write(buffer, 0, length);
	    	}
	 
	    	//Close the streams
	    	salida.flush();
	    	salida.close();
	    	entrada.close();
		} catch (IOException e) {
	    	LoggerUtil.error(DatabaseHelper.class,e.getMessage());
		}
    }

	public String getModoCrearBd() {
		return modoCrearBd;
	}

	public void setModoCrearBd(String modoCrearBd) {
		this.modoCrearBd = modoCrearBd;
	}
	
}