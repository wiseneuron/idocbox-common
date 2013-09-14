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
package com.idocbox.common.math;

import java.util.Random;

import com.idocbox.common.log.IdocboxLog;
import com.idocbox.common.log.impl.IdocboxLogFactory;


/**
 * Code util, used to generate code.
 * @author Chunhui Li
 *
 */
public class CodeUtil {
	/**
	 * logger of the class
	 */
	private final static IdocboxLog logger = IdocboxLogFactory.getLog(CodeUtil.class);

	/**
	 * generate a random code whose length is given.
	 * @param len length of code.
	 * @return random code.
	 */
	public static String genericCode(final int len){
		String radStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer generateRandStr = new StringBuffer();
        Random rand = new Random();
        int length = len;
        for(int i=0;i<length;i++)
        {
            int randNum = rand.nextInt(36);
            generateRandStr.append(radStr.substring(randNum,randNum+1));
        }
        return generateRandStr.toString();
	}
}
