package net.abcdroid.ejmandroidyoutube.config;

import java.util.List;

import roboguice.application.RoboApplication;

import com.google.inject.Module;

public class Aplicacion extends RoboApplication{

	private Module module = new Modulo();
	
	@Override
	protected void addApplicationModules(List<Module> modules) {
		modules.add(module);
	}

	public void setModule(Module module) {
		this.module = module;
	}
}