package fp.nacimientos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import fp.nacimiento.*;
import fp.nacimientos.*;

public class NacimientosTest02 {

	public static void main(String[] args) {
		//Inicialización varios objetos tipo contenedor + print de algunas propiedades (metodo leeNacimientos)
		Informes InformeNacimientos= new Informes(LocalDate.parse("23/04/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Junta de Andalucía", 38738984, FactoríaNacimiento.leeNacimientos("./data/Nacimientos.csv"));
		Informes InformeNacimientos1= new Informes(LocalDate.parse("24/04/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Junta de Andalucía", 38738984);
		System.out.println("Informe 1: " + InformeNacimientos.toString());
		System.out.println("Informe 2: " + InformeNacimientos1.toString());
		System.out.println("¿¿¿Son los dos informes iguales??? ---> " + InformeNacimientos.equals(InformeNacimientos1));
		System.out.println("Principio ordenación de InformeNacimientos sobre InformeNacimientos1: " + InformeNacimientos.compareTo(InformeNacimientos1) + "\n");
		
		//Inicialización varios objetos tipo base para realizar operaciones (metodo parseaNacimiento)
		Nacimiento n= new Nacimiento("Hospital Alto Guadalquivir", TipoCentro.COMARCAL, "Andújar", "Jaén", LocalDate.parse("07/12/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 4, 2, 3.4, 2.19, 51.4, 47.9, false);
		Nacimiento n1= FactoríaNacimiento.parseaNacimiento("Hospital Quirónsalud Sagrado Corazón;PRIVADO;Sevilla;Sevilla;02/01/2003;1;0;2.85;0;58;0;false");
		Nacimiento n2= FactoríaNacimiento.parseaNacimiento("Hospital Fátima;PRIVADO;Sevilla;Sevilla;28/02/2022;0;3;0;3.24;0;49.6;false");
		String año= "2018";
		String provincia= "Málaga";
		Boolean valor= false;
		
		//Lectura fichero csv
		System.out.println("Hay " + InformeNacimientos.getTamañoListaNacimientos() + " nacimientos");
		System.out.println("Los tres primeros: " + InformeNacimientos.getListaNacimientos().subList(0, 3));
		System.out.println("Los tres últimos: " + InformeNacimientos.getListaNacimientos().subList(InformeNacimientos.getTamañoListaNacimientos()-3, InformeNacimientos.getTamañoListaNacimientos()) +"\n");
		
		//Tests operaciones adicionales
		System.out.println("El tamaño de la lista del dataset es: "+ InformeNacimientos.getTamañoListaNacimientos());//utilizar metodos de op adicionales
		InformeNacimientos.añadeNacimiento(n1);//utilizar metodos de op adicionales
		InformeNacimientos.añadeNacimiento(n2);
		System.out.println("Último nacimiento añadido: ''"+ InformeNacimientos.getListaNacimientos().get(InformeNacimientos.getTamañoListaNacimientos()-1)+ "''");
		InformeNacimientos.añadeColeccionNacimientos(InformeNacimientos1.getListaNacimientos());//utilizar metodos de op adicionales
		System.out.println("Últimos nacimientos añadidos: ''" + InformeNacimientos.getListaNacimientos().subList(InformeNacimientos.getListaNacimientos().indexOf(n1), InformeNacimientos.getListaNacimientos().indexOf(n2)+1) + "''");
		InformeNacimientos.eliminaNacimiento(n2);//utilizar metodos de op adicionales
		System.out.println("Último nacimiento de la colección: ''"+ InformeNacimientos.getListaNacimientos().get(InformeNacimientos.getTamañoListaNacimientos()-1)+ "''\n");
		
		//Tests tratamientos secuenciales
		System.out.println("Método 1: ¿¿¿Existe el nacimiento ''" + n +"'' en la lista??? ---> "+ InformeNacimientos.existeNacimiento(n));
		System.out.println("Método 2: El número de nacimientos producidos en el año " + año + " son "+ InformeNacimientos.calculaNumeroNacimientosAño(año) + " nacimientos");
		System.out.println("Método 3: Los hospitales para la provincia de " + provincia + " que tienen helipuerto==" + valor + " son los siguientes: ");
		for (String hospital: InformeNacimientos.filtraHospitalesProvinciaHelipuerto(provincia, valor)){
			System.out.println(hospital);
		}
		System.out.println("Método 4: Los nacimientos producidos por provincia son los siguientes: " + InformeNacimientos.dicNacimientosProvincia());
		System.out.println("Método 5: El número de nacimientos producidos por cada año son los siguientes: ");
		for(Map.Entry<Integer,Integer> e :InformeNacimientos.dicCuentaNacimientosAño().entrySet()){
			System.out.println(e);
		}
	}
}