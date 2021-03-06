package com.pixelutilities.arcade.system;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OSLogger {

private Logger log;
	
	public OSLogger(String name){
		log = Logger.getLogger(name);
		log.setParent(log);
	}
	
	public void log(String out, boolean warning){
		if(warning){
			log.log(Level.WARNING, out);
		}
	}
	
	public void log(String out){
		log.log(Level.FINE, out);
	}
}
