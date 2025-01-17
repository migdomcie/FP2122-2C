package fp.nacimiento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import fp.nacimiento.*;
import fp.utiles.Checkers;

public class FactoríaNacimiento {
	
	//metodo lectura fichero
	public static List<Nacimiento> leeNacimientos(String fichero){
		List<Nacimiento> listaNacimientos= new ArrayList<>();
		
		try {
			List<String> registros= Files.readAllLines(Paths.get(fichero));
			for (String registro: registros.subList(1, registros.size())) {
				listaNacimientos.add(parseaNacimiento(registro));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return listaNacimientos;
	}
	
	//metodo parsea tipo 
	public static Nacimiento parseaNacimiento (String s) {
		String[] trozos= s.split(";");
		Checkers.check("La cadena está mal troceada", trozos.length==12);
		String nombre= trozos[0].trim();
		TipoCentro tipoCentro= TipoCentro.valueOf(trozos[1].trim());
		String municipio= trozos[2].trim();
		String provincia= trozos[3].trim();
		LocalDate fecha= LocalDate.parse(trozos[4].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer nHombres= Integer.valueOf(trozos[5].trim());
		Integer nMujeres= Integer.valueOf(trozos[6].trim());
		Double pesoH= Double.valueOf(trozos[7].trim());
		Double pesoM= Double.valueOf(trozos[8].trim());
		Double alturaH= Double.valueOf(trozos[9].trim());
		Double alturaM= Double.valueOf(trozos[10].trim());
		Boolean helipuerto= Boolean.valueOf(trozos[11].trim());
	
		Nacimiento n= new Nacimiento(nombre, tipoCentro, municipio, provincia, fecha, nHombres, nMujeres, pesoH, pesoM, alturaH, alturaM, helipuerto);
		
		return n;
	}
	
	//metodo lee tipo con constructor stream
	public static Informes leeInformeStream(String fichero) {
		List<Nacimiento> listaNacimientos= new ArrayList<Nacimiento>();
		Stream<Nacimiento> streamNac= listaNacimientos.stream();
		try {
			List<String> lineas= Files.readAllLines(Paths.get(fichero));
			for(String linea: lineas.subList(1, lineas.size())) {
				listaNacimientos.add(parseaNacimiento(linea));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return new Informes(Informes.fechaPredetInforme(), Informes.instituciónPredet(), Informes.numPredetInforme(), streamNac) ;
	}
}
