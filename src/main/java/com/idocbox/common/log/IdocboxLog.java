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
package com.idocbox.common.log;

import org.apache.commons.logging.Log;

/**
 * idocbox Log
 * @author C.H Li email:wiseneuron@gmail.com
 * @since  0.0.1.1
 * 
 */
public interface IdocboxLog extends Log {
	  /**
     * <p> Is lethal logging currently enabled? </p>
     *
     * <p> Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than LETHAL. </p>
     *
     * @return true if lethal is enabled in the underlying logger.
     */
    public boolean isLethalEnabled();
    /**
     * <p> Log a message with LETHAL log level. </p>
     *
     * @param message log this message
     */
    public void lethal(Object message);


    /**
     * <p> Log an error with LETHAL log level. </p>
     *
     * @param message log this message
     * @param t log this cause
     */
    public void lethal(Object message, Throwable t);
    
	  /**
     * <p> Is ever logging currently enabled? </p>
     *
     * <p> Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than LETHAL. </p>
     *
     * @return true if trace is enabled in the underlying logger.
     */
    public boolean isEverEnabled();
    /**
     * <p> Log a message with ever log level. </p>
     *
     * @param message log this message
     */
    public void ever(Object message);


    /**
     * <p> Log an error with ever log level. </p>
     *
     * @param message log this message
     * @param t log this cause
     */
    public void ever(Object message, Throwable t);
}
