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
package com.idocbox.common.config;

import com.idocbox.common.log.IdocboxLog;
import com.idocbox.common.log.impl.IdocboxLogFactory;


/**
 * The exception will be thrown while the url protocol is not supported.
 * @author C.H Li mail: wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class UnsupportedURLProtocolException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6851625739167848158L;
	private static IdocboxLog logger = IdocboxLogFactory
            .getLog(UnsupportedURLProtocolException.class);

    public UnsupportedURLProtocolException() {
        super();
    }

    /**
     * @param message
     */
    public UnsupportedURLProtocolException(String message) {
        super(message);
        logger.error(message);
    }

    /**
     * @param message
     * @param cause
     */
    public UnsupportedURLProtocolException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message,cause);
    }

    /**
     * @param cause
     */
    public UnsupportedURLProtocolException(Throwable cause) {
        this("��֧�ֵ�URL���ͣ�",cause);
    }
}