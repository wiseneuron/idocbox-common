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
package com.idocbox.common.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.idocbox.common.log.IdocboxLog;
import com.idocbox.common.log.impl.IdocboxLogFactory;

/**
 * Encrypter:Used to ecnry text.
 * @author C.H Li email:wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class Encrypter {
	/**
	 * logger of the class
	 */
	private final static IdocboxLog logger = IdocboxLogFactory.getLog(Encrypter.class);

	/**
	 * encrypt a given text with md5 algorithm.
	 * 
	 * @param txt
	 * @return encrypted text.
	 */
	public static String md5Encrypt(final String txt) {
		String enTxt = txt;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error:", e);
		}
		if (null != md) {
			byte[] md5hash = new byte[32];
			try {
				md.update(txt.getBytes("UTF-8"), 0, txt.length());
			} catch (UnsupportedEncodingException e) {
				logger.error("Error:", e);
			}
			md5hash = md.digest();
			StringBuffer md5StrBuff = new StringBuffer();
			for (int i = 0; i < md5hash.length; i++) {
				if (Integer.toHexString(0xFF & md5hash[i]).length() == 1) {
					md5StrBuff.append("0").append(
							Integer.toHexString(0xFF & md5hash[i]));
				} else {
					md5StrBuff.append(Integer.toHexString(0xFF & md5hash[i]));
				}
			}
			enTxt = md5StrBuff.toString();
		}
		return enTxt;
	  }
	/**
	 * encrypt text by sha algorithm.
	 * @param txt
	 * @return string generated by sha.
	 */
	public static String shaEncrypt(final String txt){
		String enTxt = txt;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error:", e);
		}
		if (null != md) {
			byte[] shahash = new byte[32];
			try {
				md.update(txt.getBytes("UTF-8"), 0, txt.length());
			} catch (UnsupportedEncodingException e) {
				logger.error("Error:", e);
			}
			shahash = md.digest();
			StringBuffer md5StrBuff = new StringBuffer();
			for (int i = 0; i < shahash.length; i++) {
				if (Integer.toHexString(0xFF & shahash[i]).length() == 1) {
					md5StrBuff.append("0").append(
							Integer.toHexString(0xFF & shahash[i]));
				} else {
					md5StrBuff.append(Integer.toHexString(0xFF & shahash[i]));
				}
			}
			enTxt = md5StrBuff.toString();
		}
		return enTxt;
	  
	}
}

