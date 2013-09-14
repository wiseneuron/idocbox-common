/*
 * Copyright [2011] [C.H Li http://code.google.com/p/idocbox-common/]
 * Licensed to the Chunhui Li(C.H Li) under one or more contributor license agreements.  
 * See the NOTICE file distributed with this work for additional information 
 * regarding copyright ownership.
 *
 * C.H Li licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.idocbox.common.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.idocbox.common.file.CellFileUtil;
import com.idocbox.common.log.IdocboxLog;
import com.idocbox.common.log.impl.IdocboxLogFactory;


/**
 * PropertyUtil can be used to read property file.
 * @author C.H Li
 * @since 0.0.1.1
 *
 */
public class PropertyUtil {
	/**
	 * logger of the class
	 */
	private final static IdocboxLog logger = IdocboxLogFactory.getLog(PropertyUtil.class);
	/**
	 * properties file map.
	 * <properties file name, propertiesObject>
	 */
    private static HashMap<String,Properties> propertiesFileMap = null;
    /**
     * configuration file map.
     * <module name, configuration>
     */
    private static Map<String, Configuration> confMap = null;
    
    private static final String MSG_ILLEGAL_ARGUMENT = 
        "you must be crazy. no module or no key, then nothing.";
    private static final String MSG_CONFIGURATION_NOT_FOUND = 
        "could not find the configuration named ";
    //linux:file:
    private static  String FILE_PREFIX = "file:/";
    
    static {
    	Properties props=System.getProperties(); 
    	String os = props.getProperty( "os.name").toLowerCase();
    	if(os.indexOf("linux") > -1){//linux
    		FILE_PREFIX = "file:";
    	} else {//windows
    		FILE_PREFIX = "file:/";
    	}
    	
    }
    /**
     * check and fix config file name.
     * @param configFile
     * @return
     */
    private static String fixConfigFileName(String configFile){
    	//check file name.
    	String propFileName = configFile;    	
    	if(null != propFileName){
    		propFileName = propFileName.trim();
    		if(!propFileName.endsWith(".xml")){
    			if(propFileName.endsWith(".")){
    				propFileName += "xml";
    			} else {
    				propFileName += ".xml";
    			}
    		}
    	}
    	return propFileName;
    }
    /**
     * check and fix properties file name.
     * @param configFile
     * @return
     */
    private static String fixPropertitiesFileName(String propertityFile){
    	//check file name.
    	String propFileName = propertityFile;    	
    	if(null != propFileName){
    		propFileName = propFileName.trim();
    		if(!propFileName.endsWith(".properties")){
    			if(propFileName.endsWith(".")){
    				propFileName += "properties";
    			} else {
    				propFileName += ".properties";
    			}
    		}
    	}
    	return propFileName;
    }
    /**
     * get configuration file.
     * @param moduleName
     * @return
     * @throws ConfigurationException
     */
    public static Configuration getConfiguration(String moduleName) throws ConfigurationException {
    	if(null == confMap){
    		confMap = new HashMap<String, Configuration>();
    	}
        Configuration configuration = confMap.get(moduleName);
        
        if (configuration == null) {
        	synchronized(PropertyUtil.class) {
	        	if (configuration == null){
                    try {
    		            ConfigurationFactory factory = new ConfigurationFactory();
    		            URL url = URLPatternResolver.getStandardURL(
    		                    PropertyUtil.class.getClassLoader().getResource(fixConfigFileName(moduleName)).toString()
    		                );
    		            factory.setConfigurationURL(url);
		            
		                configuration = factory.getConfiguration();
		                if (configuration != null) {
		                    confMap.put(moduleName, configuration);
		                } else {
		                	throw new ConfigurationException();
		                }
		            } catch (Exception e) {
		                logger.error(MSG_CONFIGURATION_NOT_FOUND + moduleName, e);
		                throw new ConfigurationException(MSG_CONFIGURATION_NOT_FOUND + moduleName);
		            }
        		}
        	}
        }
        return configuration;
    }
    /**
     * get string from value from module file.
     * @param module
     * @param key
     * @return
     */
    public static String getString(String module, String key) {
    	String value = null;
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);
        try {
			Configuration configuration = getConfiguration(module);
			if(null != configuration){
				value = configuration.getString(key);
			}
		} catch (ConfigurationException e) {
			logger.error("Error:", e);
		}
        
        return value;
    }

	/**
	 * get configuration from properties file.
	 * @param moduleName properties file without extention.
	 * @return
	 * @throws ConfigurationException 
	 */
	public static Configuration getPropertiesConfig(String moduleName) throws ConfigurationException {
    	if(null == confMap){
    		confMap = new HashMap<String, Configuration>();
    	}
        Configuration configuration = confMap.get(moduleName);
        if (configuration == null) {
        	synchronized(PropertyUtil.class) {
	        	if (configuration == null){
                    try {
		                configuration = new PropertiesConfiguration(fixPropertitiesFileName(moduleName));
		                if (null != configuration) {
		                    confMap.put(moduleName, configuration);
		                } else {
		                	throw new ConfigurationException();
		                }
		            } catch (Exception e) {
		                logger.error(MSG_CONFIGURATION_NOT_FOUND + moduleName, e);
		                throw new ConfigurationException(MSG_CONFIGURATION_NOT_FOUND + moduleName);
		            }
        		}
        	}
        }
        return configuration;
    }
	 /**
     * get properties object of given properties file name.
     * @param propertiesFileName
     * @return
     */
    public static Properties getProperties(String propertiesFileName){
    	Properties p = null;
    	if(null == propertiesFileMap){
    		propertiesFileMap = new HashMap<String,Properties>();
    	}
    	String propFileName = fixPropertitiesFileName(propertiesFileName);
    	String propKey = getPropertiesFileKey(propFileName);
    	//get properties object by key.
    	p = propertiesFileMap.get(propKey);
    	if(null == p){
    		p = new Properties();
    		InputStream input;
			try {
				
				//create input stream.
				input = CellFileUtil.getResourceAsStream(propFileName);
				//load properties file.
				p.load(input);
				//put properties file into map.
				propertiesFileMap.put(propKey, p);
			} catch (FileNotFoundException e) {
				//remove the key mapped properties file.
				propertiesFileMap.remove(propKey);
				e.printStackTrace();
			} catch (IOException e) {
				//remove the key mapped properties file.
				propertiesFileMap.remove(propKey);
				e.printStackTrace();
			}
    	}
    	return p;
    }
    /**
     * get properties file key.
     * key is a string without extention file name.
     * @param fixedPropertiesFileName
     * @return
     */
    private static String getPropertiesFileKey(String fixedPropertiesFileName){
    	String propKey = "";
    	propKey = fixedPropertiesFileName.substring(0, fixedPropertiesFileName.length() - ".properties".length());
    	return propKey;
    }
}
