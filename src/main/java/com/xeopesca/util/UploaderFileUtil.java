package com.xeopesca.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.web.multipart.MultipartFile;

import com.xeopesca.webapp.model.vos.Especie;


public class UploaderFileUtil {
	
	
	private UploaderFileUtil(){
		
	}
	
	public static boolean uploadFile(MultipartFile file,Especie especie, String path)
	{
		String  nomeFicheiro;
		
		try {
			if (!file.isEmpty()) {

				byte[] data = file.getBytes();
				
				OutputStream out = null;
				nomeFicheiro = String.valueOf(especie.getId())+".jpg";
				
				//Validamos
				File dir = new File (path+nomeFicheiro);
			    if (dir.exists()) {
			    	if (dir.length() == file.getSize())
			    	{
			    		return true;
			    	}else {
			    		//dir.renameTo(new File (path+nomeFicheiro+"borrar"));
			    		if (!dir.delete())
			    			{
			    				//return false;
			    			}
			    		//return true;
			    	}
			    }
			    	
			    	
			    	
				
				dir.deleteOnExit();

				FileOutputStream fo = new FileOutputStream(dir) ;
				fo.flush();
				out = fo;
				out.flush();
				out.write(data);

		
				return true;
			} else {
				return false;

			}
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
		
}
