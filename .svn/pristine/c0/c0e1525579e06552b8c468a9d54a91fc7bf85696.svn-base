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
package com.idocbox.common.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.zip.ZipException;

import com.idocbox.common.log.IdocboxLog;
import com.idocbox.common.log.impl.IdocboxLogFactory;


/**
 * File util can read file from classpath include file in jar.
 * @author C.H Li email:wiseneuron@gmail.com
 * @since0.0.1.1
 */
public class CellFileUtil {
	/**
	 * logger of the class
	 */
	private final static IdocboxLog logger = IdocboxLogFactory.getLog(CellFileUtil.class);
	
    /** URL protocol for an entry from a jar file: "jar" */
    private static final String URL_PROTOCOL_JAR = "jar";

    /** URL protocol for an entry from a zip file: "zip" */
    private static final String URL_PROTOCOL_ZIP = "zip";
    /**
     * prefix of file.
     */
    private static final String FILE_PREFIX = "file:";
	 /**
     * Return the thread context class loader if available.
     * Otherwise return null.
     *
     * The thread context class loader is available for JDK 1.2
     * or later, if certain security conditions are met.
     * @throws MarsConfigurationException 
     *
     * @exception LogConfigurationException if a suitable class loader
     * cannot be identified.
     */
    private static ClassLoader getClassLoader() throws Exception
    {
        ClassLoader classLoader = null;

        if (classLoader == null) {
            try {
                // Are we running on a JDK 1.2 or later system?
                Method method = Thread.class.getMethod("getClassLoader", null);

                // Get the thread context class loader (if there is one)
                try {
                    classLoader = (ClassLoader)method.invoke(Thread.currentThread(), null);
                } catch (IllegalAccessException e) {
                    ;  // ignore
                } catch (InvocationTargetException e) {
                    /**
                     * InvocationTargetException is thrown by 'invoke' when
                     * the method being invoked (getContextClassLoader) throws
                     * an exception.
                     *
                     * getContextClassLoader() throws SecurityException when
                     * the context class loader isn't an ancestor of the
                     * calling class's class loader, or if security
                     * permissions are restricted.
                     *
                     * In the first case (not related), we want to ignore and
                     * keep going.  We cannot help but also ignore the second
                     * with the logic below, but other calls elsewhere (to
                     * obtain a class loader) will trigger this exception where
                     * we can make a distinction.
                     */
                    if (e.getTargetException() instanceof SecurityException) {
                         // ignore
                    } else {
                        // Capture 'e.getTargetException()' exception for details
                        // alternate: log 'e.getTargetException()', and pass back 'e'.
                        throw new Exception
                            ("Unexpected InvocationTargetException", e.getTargetException());
                    }
                }
            } catch (NoSuchMethodException e) {
                // Assume we are running on JDK 1.1
                // ignore
            }
        }

        if (classLoader == null) {
            classLoader = CellFileUtil.class.getClassLoader();
        }

        // Return the selected class loader
        return classLoader;
    }
    /**
     * get resource as stream.
     * @param name file name under class path.
     * @return 
     */
    public static InputStream getResourceAsStream(final String name)
    {
        return (InputStream)AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    ClassLoader threadCL = null;
					try {
						threadCL = getClassLoader();
					} catch (Exception e) {
						logger.error(e);
						return null;
					}

                    if (threadCL != null) {
                        return threadCL.getResourceAsStream(name);
                    } else {
                        return ClassLoader.getSystemResourceAsStream(name);
                    }
                }
            });
    }
    /**
     * get file under class path.
     * if the file is in jar or zip file, extract it to classpath, then open it.
     * @param nameUnderClassPath
     * @return
     */
    public static File getFile(final String nameUnderClassPath){
    	File f = null;
    	 String classPath = getClassPathFolder(CellFileUtil.class.getClassLoader().getResource(""));
    	 URL url = CellFileUtil.class.getClassLoader().getResource(nameUnderClassPath);
    	 
    	 if(null != url){
    		 if(URL_PROTOCOL_JAR.equals(url.getProtocol()) || URL_PROTOCOL_ZIP.equals(url.getProtocol())){
    			 //extract the file to class path.
    			 try {
					ZipExtracter.extract(getZipJarFile(url), nameUnderClassPath, classPath);
				} catch (ZipException e) {
					logger.error(e);
				} catch (IOException e) {
                    logger.error(e);
				}
    		 } else {
    			 //nothing to do.
    		 }
    		 //read file.
             String fileExtracted = classPath + "/" + nameUnderClassPath;
             f = new File(fileExtracted);
    	 }
    	 
    	return f;
    }
    
    private static String getZipJarFile(URL url){
    	String fileName = null;
    	String s = url.getFile();
    	int sIdx = FILE_PREFIX.length();
    	int eIdx = s.lastIndexOf('!');
    	fileName = s.substring(sIdx, eIdx);
    	return fileName;
    }
    
    private static String getClassPathFolder(URL url){
    	String f = null;
    	String s = url.getFile();
    	if(s.startsWith(FILE_PREFIX)){
    		int sIdx = FILE_PREFIX.length();
    		f = s.substring(sIdx);
    	} else {
    		f = s;
    	}
    	
    	
    	return f;
    }
    
}
