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
package com.idocbox.common.cache.impl;

import java.util.Date;
import java.util.Properties;

import com.idocbox.common.cache.ICache;
import com.idocbox.common.cache.exceptions.NeedsRefreshCacheException;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

/**
 * Base Cache based on OSCache.
 * @author C.H Li
 * email: wiseneuron@gmail.com
 */
public class OSCacheBase<T> extends GeneralCacheAdministrator implements ICache<T> {
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4554035955197357682L;
	//refresh period of cache, unit is seconds.
	protected int refreshPeriod;
	//max size of cache.
	protected int maxCacheSize;
	//prefix of key.
	protected String keyPrefix; 
	
	/**
	 * @param p
	 */
	public OSCacheBase(Properties p) {
		super(p);
	}
    /**
     * constructor
     * @param keyPrefix
     * @param refreshPeriod
     */
	 public OSCacheBase(String keyPrefix, int refreshPeriod){
		 super();
		 this.keyPrefix = keyPrefix;
		 this.refreshPeriod = refreshPeriod;
		 this.maxCacheSize = 1000;
		 super.setCacheCapacity(this.maxCacheSize);
	 }
	 /**
	  * constructor
	  * @param keyPrefix
	  * @param refreshPeriod
	  * @param maxCacheSize
	  */
	 public OSCacheBase(String keyPrefix, int refreshPeriod, int maxCacheSize){
		 super();
		 this.keyPrefix = keyPrefix;
		 this.refreshPeriod = refreshPeriod;
		 this.maxCacheSize = maxCacheSize;
		 super.setCacheCapacity(this.maxCacheSize);
	 }
	 /**
	  * put object into cache.
	  * @param key
	  * @param o
	  */
	 public synchronized void put(String key, T o){
		 super.putInCache(this.keyPrefix + "_" + key, o);
	 }
	 /**
	  * remove object from cache.
	  * @param key
	  */
	 public synchronized void remove(String key){
		 super.flushEntry(this.keyPrefix + "_" + key);
	 }
	 /**
	  * remove all object from cache.
	  * @param date
	  */
	 public synchronized void removeAll(Date date){
		 super.flushAll(date);
	 }
	 /**
	  * remove all from cache.
	  */
	 public synchronized void removeAll(){
		 super.flushAll();
	 }
	 /**
	  * 
	  * @param key
	  * @return
	  * @throws Exception
	  */
	 public T get(String key) throws NeedsRefreshCacheException{
			try {
				return (T)super.getFromCache(this.keyPrefix + "_" + key, this.refreshPeriod);
			} catch (NeedsRefreshException e) {
				throw new NeedsRefreshCacheException(e);
			}
	 }
	 /**
	  * cancel update given key.
	  */
	 public void cancelUpdate(String key){
		 super.cancelUpdate(this.keyPrefix + "_" + key);
	 }
}

