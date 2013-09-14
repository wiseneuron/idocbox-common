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

import java.math.BigDecimal;

/**
 * Bigdecimal related methods.
 * @author C.H Li email:wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class BigDecimalUtil {
    /**
     * add two bigdecimal number.
     * @param a
     * @param b
     * @return
     */
	public static BigDecimal add(BigDecimal a, BigDecimal b){
		BigDecimal c = new BigDecimal(0);
		
		if(null != a){
			c = c.add(a);
		}
		if(null != b){
			c = c.add(b);
		}
		
		return c;
	}
	/**
	 * add bigdecimal with double.
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal add(BigDecimal a, Double b){
		BigDecimal bb = null;
		if(null != b){
			bb = new BigDecimal(b);
		}
		return add(a, bb);
	}
	/**
	 * compute a -b
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal minus(BigDecimal a, BigDecimal b){
		BigDecimal bb = null;
		if(null != b){
			BigDecimal NAV_ONE = new BigDecimal(-1);
			bb = NAV_ONE.multiply(b);
		}
		return add(a, bb);
	}
	/**
	 * compute a - b.
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal minus(BigDecimal a, Double b){
		Double bb = null;
		if(null != b){
			bb = b * (-1);
		}
		return add(a, bb);
	}
	/**
	 * convert to bigdecimal.
	 * @param d
	 * @return
	 */
	public static BigDecimal toBigDecimal(Double d){
		BigDecimal bd = null;
		
		if(null != d){
			bd = new BigDecimal(d);
		}
		
		return bd;
	}
}
