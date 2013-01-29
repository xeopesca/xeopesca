package com.xeopesca.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.filefilter.FileFileFilter;
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
				//src\main\webapp\images
				nomeFicheiro = String.valueOf(especie.getId())+".jpg";
				
				//File dir = new File ("./src/main/webapp/images/especie/"+nomeFicheiro);
				File dir = new File (path+nomeFicheiro);
			    dir.delete();
			    dir.setWritable(true);
				
				dir.deleteOnExit();

				FileOutputStream fo = new FileOutputStream(dir) ;
				fo.flush();
				out = fo;
				out.flush();
				out.write(data);

				

				// store the bytes somewhere
			//	return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
			//			+ "/admin/listaEspecies";
				return true;
			} else {
				//return "redirect:uploadFailure";
				return false;

			}
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
		
}
