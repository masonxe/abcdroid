package net.abcdroid.roboguicesqlite.util;

import android.util.Log;

public class LoggerUtil {
	
	public static void debug(String tag,String mensaje){
		Log.d(tag,mensaje);	
	}
	
	public static void debug(Class<?> clase,String mensaje){
		Log.d(clase.getSimpleName(),mensaje);
	}
	
	public static void error(String tag,String mensaje){
		Log.e(tag,mensaje);	
	}
	
	public static void error(Class<?> clase,String mensaje){
		Log.e(clase.getSimpleName(),mensaje);
	}
	
	public static void verbose(String tag,String mensaje){
		Log.v(tag,mensaje);	
	}
	
	public static void verbose(Class<?> clase,String mensaje){
		Log.v(clase.getSimpleName(),mensaje);
	}
}