package net.abcdroid.roboguicesqlite.config;

import java.util.List;

import roboguice.application.RoboApplication;

import com.google.inject.Module;

public class RoboGuiceSqliteAplicacion extends RoboApplication{

	private Module modulo = new RoboGuiceSqliteModulo();
	
	@Override
	protected void addApplicationModules(List<Module> modules) {
		modules.add(modulo);
	}

	public void setModule(Module module) {
		this.modulo = module;
	}
}
