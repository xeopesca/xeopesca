/* --------------------------------------------------------------------
 This file is part of xeoPesca

Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/
package com.xeopesca.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.web.multipart.MultipartFile;

import com.xeopesca.webapp.model.vos.Especie;

/**
 * Clase de utiler'ia para subir ficheiros ao servidor
 * 
 * @author belay
 * 
 */
public class UploaderFileUtil {

	private UploaderFileUtil() {

	}

	/**
	 * Sube un ficheiro ao servidor
	 * 
	 * @param file
	 * @param directorio 
	 * @param especie
	 * @param path
	 * @return boolean
	 */
	public static boolean uploadFile(MultipartFile file, String directorio, Especie especie) {

		String nomeFicheiro = String.valueOf(especie.getId()) + ".jpg";
		String pathFicheiro = directorio + nomeFicheiro;

		try {
			//if (!file.isEmpty()) {

				byte[] data = file.getBytes();
				File ficheiro = new File(pathFicheiro);
				// Borramos se o ficheiro existe
				ficheiro.deleteOnExit();

				FileOutputStream fos = new FileOutputStream(ficheiro);
				DataOutputStream dos = new DataOutputStream(fos);
				dos.write(data);
				dos.flush();
				dos.close();

				return true;
			//}
		} catch (IOException e) {
			e.printStackTrace();
			// return false;
		}
		return false;
	}

}
