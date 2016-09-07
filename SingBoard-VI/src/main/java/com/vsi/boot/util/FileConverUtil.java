package com.vsi.boot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class FileConverUtil {

	/*File creation from bytearray - it will create and download with file stream user can choose where he/she can download when downloading file*/
	public static <T> byte[] getByteArrayForFile(Map<String, String> headers,List<T> object, String filename) {

		byte[] byteData = new byte[2048];
		StringBuffer buffer = new StringBuffer();
		List<String> keys = new ArrayList<String>();
		try {

			Iterator<Map.Entry<String, String>> entries = headers.entrySet().iterator();

			while (entries.hasNext()) {
				Map.Entry<String, String> entry = entries.next();
				String value = entry.getValue();
				keys.add(entry.getKey());
				buffer.append(value);
				buffer.append(",");
			}
			buffer.append('\n');

			if(object != null)
			{
			for (Object obj : object) {
				Class<?> clazz = obj.getClass();
				for (String string : keys) {

					Field field = org.springframework.util.ReflectionUtils.findField(clazz, string);
					if(field != null)
					{
						org.springframework.util.ReflectionUtils.makeAccessible(field);
	
						if (string.equalsIgnoreCase(field.getName())) {
							Object lable = field.get(obj);
							if(lable != null)
							{
							  buffer.append(lable.toString().replace(",", " "));
							}else
							{
								buffer.append("");
							}
							buffer.append(",");
						}
					}else
					{
						buffer.append("");
						buffer.append(",");
					}
				}
				buffer.append('\n');
				File file = new File(filename);
				FileUtils.writeStringToFile(file, buffer.toString());
				byteData = readFileToByte(file);
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteData;
	}

	private static byte[] readFileToByte(File file) {
		int i = 2048;
		byte[] buffer = null;
		try {
			if (file.length() > i) {

			}

			buffer = new byte[(int) file.length()];
			InputStream ios = null;

			ios = new FileInputStream(file);
			if (ios.read(buffer) == -1) {
				extracted();
			}
			ios.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer;
	}

	private static void extracted() throws Exception {
		throw new Exception("EOF reached while trying to read the whole file");
	}

	/*File creation from FileWriter - it will create and download file without stream, can not choose where he/she can  download when time of downloading then file*/
	public static <T> FileWriter getCSVfileAsFileWriter(Map<String, String> headers, List<T> object, String filename) {

		FileWriter writer = null;

		try {
			writer = new FileWriter(filename, true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		List<String> keys = new ArrayList<String>();
		try {

			Iterator<Map.Entry<String, String>> entries = headers.entrySet().iterator();

			while (entries.hasNext()) {
				Map.Entry<String, String> entry = entries.next();
				String value = entry.getValue();
				keys.add(entry.getKey());
				writer.append(value);
				writer.append(",");
			}
			writer.append('\n');

			for (Object obj : object) {
				Class<?> clazz = obj.getClass();
				for (String string : keys) {

					Field field = org.springframework.util.ReflectionUtils.findField(clazz, string);
					org.springframework.util.ReflectionUtils.makeAccessible(field);

					if (string.equalsIgnoreCase(field.getName())) {
						Object lable = field.get(obj);
						writer.append(lable.toString());
						writer.append(",");
					}
				}
				writer.append('\n');
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer;
	}

}
