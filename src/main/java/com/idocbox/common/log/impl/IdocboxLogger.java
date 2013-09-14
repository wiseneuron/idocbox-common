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

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;

import com.idocbox.common.log.IdocboxLevel;
import com.idocbox.common.log.IdocboxLog;


/**
 * idocbox Logger
 * @author C.H Li email:wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class IdocboxLogger extends Log4JLogger implements IdocboxLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3549545622795513615L;
	  /** The fully qualified name of the CelloryLogger class. */
    private static final String CLCN = IdocboxLogger.class.getName();
    
    public IdocboxLogger() {
    	
    }


    /**
     * Base constructor.
     */
    public IdocboxLogger(String name) {
       super(name);
    }

    /** 
     * For use with a Cellory factory.
     */
    public IdocboxLogger(Logger logger ) {
         super(logger);
    }
	/* (non-Javadoc)
	 * @see com.idocbox.core.log.CelloryLog#isLethalEnabled()
	 */
	public boolean isLethalEnabled() {
		return getLogger().isEnabledFor(IdocboxLevel.LETHAL);
	}

	/* (non-Javadoc)
	 * @see com.idocbox.core.log.CelloryLog#lethal(java.lang.Object)
	 */
	public void lethal(Object message) {
		getLogger().log(CLCN, IdocboxLevel.LETHAL, message, null );		
	}

	/* (non-Javadoc)
	 * @see com.idocbox.core.log.CelloryLog#lethal(java.lang.Object, java.lang.Throwable)
	 */
	public void lethal(Object message, Throwable t) {
		getLogger().log(CLCN, IdocboxLevel.LETHAL, message, t);
	}
	/* (non-Javadoc)
	 * @see com.idocbox.core.log.CelloryLog#isEverEnabled()
	 */
	public boolean isEverEnabled() {
		return getLogger().isEnabledFor(IdocboxLevel.EVER);
	}
	/* (non-Javadoc)
	 * @see com.idocbox.core.log.CelloryLog#ever(java.lang.Object)
	 */
	public void ever(Object message) {
		getLogger().log(CLCN, IdocboxLevel.EVER, message, null );
	}


	/* (non-Javadoc)
	 * @see com.idocbox.core.log.CelloryLog#ever(java.lang.Object, java.lang.Throwable)
	 */
	public void ever(Object message, Throwable t) {
		getLogger().log(CLCN, IdocboxLevel.EVER, message, t);		
	}
}
