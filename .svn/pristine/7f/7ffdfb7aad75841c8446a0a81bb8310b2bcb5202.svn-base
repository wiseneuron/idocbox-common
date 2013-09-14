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

import java.net.URL;

import com.idocbox.common.log.IdocboxLog;
import com.idocbox.common.log.impl.IdocboxLogFactory;


/**
 *  Used to process the different format of url protocol on the different 
 *  web server.wsjar is not supported by some open source projects.So the format
 *  will be converted. 
 * @author C.H Li mail: wiseneuron@gmail.com
 * @since 0.0.1.1
 * 
 */
public class URLPatternResolver {

    /** URL protocol for an entry from a jar file: "jar" */
    private static final String URL_PROTOCOL_JAR = "jar";

    /** URL protocol for an entry from a zip file: "zip" */
    private static final String URL_PROTOCOL_ZIP = "zip";

    /** URL protocol for an entry from a WebSphere jar file: "wsjar" */
    private static final String URL_PROTOCOL_WSJAR = "wsjar";

    /** Separator between JAR URL and file path within the JAR */
    private static final String JAR_URL_SEPARATOR = "!/";
    
    private static IdocboxLog logger = IdocboxLogFactory.getLog(URLPatternResolver.class);

    public URLPatternResolver() {
        super();
    }

    /**
     * @param url
     *            输入的url
     * @return
     */
    public static URL getStandardURL(String url) {
        if (url == null) {
            return null;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("解析URL：" + url);
        }
        URL urlObj = null;
        if (url.startsWith(URL_PROTOCOL_WSJAR)) {
            if (logger.isDebugEnabled()) {
                logger.debug("当前使用的是WAS的classloader");
            }
            try {
                url = url.substring(2);
                urlObj = new URL(url);
            } catch (Exception e) {
                logger.error("URL转换出错！");
                return null;
            }
        } else if (url.startsWith(URL_PROTOCOL_JAR)) {
            if (logger.isDebugEnabled()) {
                logger.debug("当前使用的是普通的classloader");
            }
            try {
                urlObj = new URL(url);
            } catch (Exception e) {
                logger.error("URL转换出错！");
                return null;
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("当前使用的是普通的classloader");
            }
            try {
                urlObj = new URL(url);
            } catch (Exception e) {
                logger.error("URL转换出错！");
                return null;
            }
        }
        return urlObj;
    }

}