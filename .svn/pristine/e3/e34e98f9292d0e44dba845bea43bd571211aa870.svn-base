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
package com.idocbox.common.lang;

import java.io.Serializable;
import java.util.Map;

/**
 * Map Util.
 * @author C.H Li email: wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class MapUtils {	
	/**
	 * put not empty value into map.
	 * @param map
	 * @param key
	 * @param value
	 */
	public static void putNotEmpty(Map<String, Serializable> map, String key,
			Serializable value) {
		if (null != value) {
			if(value instanceof String){
				if(!"".equals(value)){
					map.put(key, value);
				}
			} else {
				map.put(key, value);	
			}
		}
	}
}
