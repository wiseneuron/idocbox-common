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

import org.apache.log4j.Level;

/**
 * This class introduces a new level level called LETHAL. 
 * LETHAL has high level
 * than FATAL.
 */
/**
 * This class introduces a new level level called LETHAL. 
 * LETHAL has high level
 * than FATAL.
 * @author C.H Li mail: wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class IdocboxLevel extends Level {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2577394923028251085L;

	static public final int LETHAL_INT = Level.FATAL_INT + 10000;

	private static String LETHAL_STR = "LETHAL";

	static public final int EVER_INT = LETHAL_INT + 10000;

	private static String EVER_STR = "EVER";
	
	public static final IdocboxLevel EVER = new IdocboxLevel(EVER_INT, EVER_STR, 0);
	
	public static final IdocboxLevel LETHAL = new IdocboxLevel(LETHAL_INT, LETHAL_STR, 0);
	

	protected IdocboxLevel(int level, String strLevel, int syslogEquiv) {
		super(level, strLevel, syslogEquiv);
	}

	/**
	 * Convert the string passed as argument to a level. If the conversion
	 * fails, then this method returns {@link #TRACE}.
	 */
	public static Level toLevel(String sArg) {
		return toLevel(sArg, IdocboxLevel.TRACE);
	}

	public static Level toLevel(String sArg, Level defaultValue) {

		if (sArg == null) {
			return defaultValue;
		}
		String stringVal = sArg.toUpperCase();

       if(stringVal.equals(LETHAL_STR)) {
			return IdocboxLevel.LETHAL;
		} else if(stringVal.equals(EVER_STR)){
			return IdocboxLevel.EVER;
		}

		return Level.toLevel(sArg, (Level) defaultValue);
	}

	public static Level toLevel(int i) throws IllegalArgumentException {
		switch (i) {
		  case LETHAL_INT:
			return IdocboxLevel.LETHAL;
		  case EVER_INT:
				return IdocboxLevel.EVER;
		}
		return Level.toLevel(i);
	}

}
