package com.vsi.boot.util;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.lang.StringUtils;

public class FileUtil
{
	/**
	 * This method checks the existence of the given file.
	 * If the file does not exist, it creates one and returns true.
	 * Returns true if file already exist. Returns false if any Exception occurs.
	 *  
	 * @param fileData	Byte array to be used to create a file if it does not exist
	 * @param destPath	File path to be used check the existence of file/create new file
	 * @return			True or False 
	 */
	public static boolean createFileIfDoesnotExist( byte[] fileData, String destPath )
	{
		boolean success = false;

		if ( (fileData == null || fileData.length < 0) || (StringUtils.isBlank(destPath)) ) 
			return success;

		try 
		{
			File out = new File(destPath);

			//If file does not exists create file                      
			if( !out.exists() )
			{
				FileOutputStream fos = new FileOutputStream(out);
				for (int i = 0; i < fileData.length; i++)
				{
					fos.write(fileData[i]);
				}
				fos.close();

				success = true;
			}
			else
			{
				success = true;
			}    
		} 
		catch (Exception e)
		{
			success = false;
		}    

		return success;
	}

	/**
	 * Created a files if it does not already exist.
	 * Returns true if file already exist. Returns false if any Exception occurs.
	 *  
	 * @param destPath	File path to be used check the existence of file/create new file
	 * @return			True or False 
	 */
	public static boolean createFileIfDoesnotExist(String destPath)
	{
		boolean success = false;

		if (StringUtils.isBlank(destPath)) 
			return success;

		try 
		{
			File out = new File(destPath);

			//If file does not exists create file                      
			if( !out.exists() )
			{
				FileOutputStream fos = new FileOutputStream(out);
				fos.close();

				success = true;
			}
			else
				success = true;
		} 
		catch (Exception e)
		{
			success = false;
		}    

		return success;
	}

	/**
	 * Checks the existence of a give file in the list of Directories provided.
	 * If given file exist in any of given directories, the Directory path will be returned,
	 * otherwise null will be returned.
	 * 
	 * @param astrTryDirs	Array of Directories to be used to check file existence
	 * @param strFileTest	Name of file to be used to check for existence
	 * @return				Directory path if file exist in that directory
	 * @throws Exception
	 */
	public static String resolveServiceDirectory( String[] astrTryDirs, String strFileTest ) throws Exception
	{
		for (int idx = 0; idx < astrTryDirs.length; ++idx)
		{
			String strDir = astrTryDirs[idx];

			if ((strDir != null) && ((strDir = canonicalDir(strDir)) != null))
			{
				File fileProps = mergePathnames(strDir, strFileTest);
				if (fileProps.exists())
					return strDir;
			}
		}
		return null;
	}

	/**
	 * Merges Directory path and File name and creates File for that path
	 * 
	 * @param strDir	Directory path
	 * @param strFile	File Name
	 * @return			File
	 */
	public static File mergePathnames( String strDir, String strFile )
	{
		File fileRet = new File(strFile);
		if (fileRet.isAbsolute())
			return fileRet;
		else
			return new File(strDir, strFile);
	}

	/**
	 * Gives canonical pathname string for given Dir
	 * 
	 * @param strDir	Directory path to be checked for canonical pathname 
	 * @return			Canonical pathname string
	 */
	public static String canonicalDir( String strDir )
	{
		String strRet = null;
		try
		{
			File fileDir = new File(strDir);
			if (fileDir.isDirectory())
				strRet = fileDir.getCanonicalPath();			
		}
		catch (Exception exc)
		{
			;
		}
		return strRet;
	}
}