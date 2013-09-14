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
package com.idocbox.common.log.impl;

import org.apache.commons.logging.impl.LogFactoryImpl;

import com.idocbox.common.log.IdocboxLog;


/**
 * idocbox Log factory, used to produce IdocboxLog object.
 * @author C.H Li email:wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class IdocboxLogFactory extends LogFactoryImpl {
    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param clazz Class from which a log name will be derived
     */
    @SuppressWarnings("unchecked")
	public static IdocboxLog getLog(Class clazz){
        IdocboxLog log = null;
        if(null != clazz){
        	log = new IdocboxLogger(clazz.getName());
        } else {
        	log = new IdocboxLogger();
        }
        
        return log;
    }
    
}
