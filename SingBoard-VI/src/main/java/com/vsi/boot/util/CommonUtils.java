package com.vsi.boot.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.vsi.boot.domain.Client;

public class CommonUtils {
	
public static <T> void ConverObjectToCSVFilWitheHeaderAndObjectMapping(HttpServletResponse response,List<T> object){
		
		Field[] declaredFields = Client.class.getDeclaredFields();
        Map<String,String> hasMap = new HashMap<String,String>();
        for(Field f:declaredFields){
            System.out.println(toCamelCase(f.getName()));
            hasMap.put(f.getName(), toCamelCase(f.getName()));
         }
        
        byte[] buffer = FileConverUtil.getByteArrayForFile(hasMap, object, "Shop_"+System.currentTimeMillis()+".csv");
        try {
			getResponseOutPutStreamForFile(response, buffer, "Shop_"+System.currentTimeMillis()+".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//internal method for change words to camel case
	public static String toCamelCase(final String str) {
		if (str == null)
		{
			return null;
		}
		final StringBuilder ret = new StringBuilder(str.length());
		for (final String word : str.split(" ")) 
		{
			if (!word.isEmpty()) {
				ret.append(word.substring(0, 1).toUpperCase());
				String[] camelCaseWords = word.substring(1).split("(?=[A-Z])");
				for (int i = 0; i < camelCaseWords.length; i++) {
					String string = camelCaseWords[i];
					if (i > 0) {
						ret.append(" ");
					}
					ret.append(string);
				}
			}
			if (!(ret.length() == str.length()))
			{
				ret.append(" ");
			}
		}
		return ret.toString();
	}

	public static void getResponseOutPutStreamForFile(HttpServletResponse response, byte[] buffer,String fileName) throws IOException
	{
		
		String extension = "";
        if(fileName != null)
        {
			int i = fileName.lastIndexOf('.');
			if (i > 0) {
			    extension = fileName.substring(i+1);
			}
       
	try {
			response.getOutputStream();
			OutputStream outStream = response.getOutputStream();
	        
			response.setContentType("application/"+extension+"");					
			response.setHeader("Content-Disposition", "attachment; filename="+fileName);		
			response.setHeader("Pragma", "public");
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Cache-Control", "public");
			response.setHeader("Content-Description", "File Transfer");				
	
			outStream.write(buffer);
		    outStream.flush();
		    outStream.close();
		    response.flushBuffer();
	      
        } catch (IOException e) {
        	e.printStackTrace();
		}
        }
	}
}
