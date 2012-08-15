package net.abcdroid.ejmroboguice.config;

import java.util.List;

import roboguice.application.RoboApplication;

import com.google.inject.Module;

public class EjmRoboGuiceAplicacion extends RoboApplication {

	private Module modulo = new EjmRoboGuiceModulo();
	
	@Override
	protected void addApplicationModules(List<Module> modules) {
		modules.add(modulo);
	}

	public void setModule(Module module) {
		this.modulo = module;
	}
}