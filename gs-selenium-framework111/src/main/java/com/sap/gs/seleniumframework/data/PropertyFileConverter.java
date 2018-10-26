package com.sap.gs.seleniumframework.data;

import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * <p>
 * PropertyFileConverter is used to parse properties file
 * </p>
 * <p>
 * Copyright (c) 2016 www.sap.com
 * </p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 */
public class PropertyFileConverter {
	private static final String ENCODING = "utf-8";
	private String fileName;
	
	public PropertyFileConverter init(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public LinkedHashMap<String, String> generate() {	
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	
		PropertiesConfiguration config = new PropertiesConfiguration();
		config.setEncoding(ENCODING);
		try {
			config.load(fileName);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		
		Iterator<String> it = config.getKeys();	
		while (it.hasNext()) {
			String key = it.next();
			String value = config.getString(key);
			map.put(key, value);
		}
		
		return map;
	}
}