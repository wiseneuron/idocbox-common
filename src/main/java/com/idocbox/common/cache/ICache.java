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
package com.idocbox.common.cache;

import java.util.Date;

import com.idocbox.common.cache.exceptions.NeedsRefreshCacheException;



/**
 * Cache is used to cache object.
 * @author C.H Li
 * email:wiseneuron@gmail.com
 * 
 */
public interface ICache<T> {
	/**
	 * put object into cache.
	 * @param key key of object.
	 * @param o   object to cache.
	 */
	public void put(String key, T o);
	/**
	 * remove given key's object.
	 * @param key
	 */
	public void remove(String key);
	/**
	 * remove all object from cache.
	 */
	public void removeAll();
	/**
	 * Flush the entire cache at the given date. 
	 * @param date
	 */
	public void removeAll(Date date);
	/**
	 * get object from cache by key.
	 * @param key
	 * @return
	 * @throws NeedsRefreshCacheException
	 */
	public T get(String key) throws NeedsRefreshCacheException;
	/**
	 * cancel update given key.
	 * @see com.opensymphony.oscache.general.GeneralCacheAdministrator#cancelUpdate(java.lang.String)
	 * @param key
	 */
	public void cancelUpdate(String key);
}
