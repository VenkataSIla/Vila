package com.vsi.boot.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.vsi.boot.domain.Client;

public class Test {

	public static void main(String[] args) {
		
	}
	

 public <T> void FileHeaderAndObjectMapping(HttpServletResponse response, T object){
		
		// TODO Auto-generated method stub
		Field[] declaredFields = Client.class.getDeclaredFields();
        Map<String,String> hasMap = new HashMap<String,String>();
        for(Field f:declaredFields){
            System.out.println(toCamelCase(f.getName()));
            hasMap.put(f.getName(), toCamelCase(f.getName()));
            
         }
        
        byte[] buffer = FileConverUtil.getByteArrayForFile(hasMap, new ArrayList<Client>(), "test.csv");
        try {
			CommonUtils.getResponseOutPutStreamForFile(response, buffer, "test.csv");
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
}