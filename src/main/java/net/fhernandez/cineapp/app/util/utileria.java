package net.fhernandez.cineapp.app.util;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import sun.util.calendar.Gregorian;


public class utileria {
	/*
	 * Metodo que regresa una lista de Strings con las fechas siguientes, segun el
	 * parametro count
	 */
	public static List<String> getNexDays(int count){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, count);
		Date dateEnd = calendar.getTime();
		
		GregorianCalendar gregorian = new GregorianCalendar();
		gregorian.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gregorian.getTime().after(dateEnd)) {
			Date date = gregorian.getTime();
			gregorian.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(date));
			
		}
		return nextDays;	
	} 
	
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		// Obtenemos el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		
		nombreOriginal = nombreOriginal.replace(" ", "_");
		String nombreFinal = randomAlphaNumeric(8).concat(nombreOriginal);
		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images/
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(rutaFinal + nombreFinal);
			System.out.println(imageFile.getAbsolutePath());
			// Aqui se guarda fisicamente el archivo en el disco duro
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	
	public static String randomAlphaNumeric (int count) {
		String caracteres = "ABCDEFGHIJKLMNOPQRLSTUVWXYZ123456789";
		StringBuilder build = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random() * caracteres.length());
			build.append(caracteres.charAt(character));
		}
		
		return build.toString();
	}
}
