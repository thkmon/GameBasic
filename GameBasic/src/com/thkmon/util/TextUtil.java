package com.thkmon.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import data.StringList;

public class TextUtil {

//	public static void write_file( File file , ArrayList<String> str_list){
//		  try{
//		   
//		   BufferedWriter writer = new BufferedWriter
//		       (new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
//		       //(new OutputStreamWriter(new FileOutputStream(file),"MS949"));
//		   
//		   for(String str : str_list) {
//		    
//		                writer.write(str, 0, str.length());
//		                writer.newLine();
//		                
//		            }
//		   
//		   //°´Ã¼ ´ÝÀ½
//		   writer.close();
//
//		  }
//		  catch(Exception ex){
//		   StringManager.out("write_file ¿¡·¯: " + ex.getMessage());
//		   System.out.println(ex.getMessage());
//		   ex.printStackTrace();
//		  }
//		 }
//		 

	
	public static StringList readTextFile(String filePath) {
		
		if (filePath == null || filePath.length() == 0) {
			return null;
		}
		
		File file = new File(filePath);
		return readTextFile(file);
	}
	
	
	public static StringList readTextFile(File file) {

		StringList resultList = null;
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			if (!file.exists()) {
				LogUtil.debug("TextUtil readTextFile : file not exists");
				return null;
			}

			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			
			String oneLine = null;
			
			while((oneLine = br.readLine()) != null) {
			   if (resultList == null) {
				   resultList = new StringList();
			   }
			   
			   resultList.add(oneLine);
			}

		} catch (Exception e) {
			LogUtil.debug(e);
		   
		} finally {
			close(br);
			close(isr);
			close(fis);
		}
		
		return resultList;
	}
	
	
	private static void close(BufferedReader br) {
		try {
			if (br != null) {
				br.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			br = null;
			
		} finally {
			br = null;
		}
	}
	
	
	private static void close(InputStreamReader isr) {
		try {
			if (isr != null) {
				isr.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			isr = null;
			
		} finally {
			isr = null;
		}
	}
	
	
	private static void close(FileInputStream fis) {
		try {
			if (fis != null) {
				fis.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			fis = null;
			
		} finally {
			fis = null;
		}
	}
}
