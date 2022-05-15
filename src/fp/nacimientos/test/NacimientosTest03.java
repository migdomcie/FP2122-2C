package fp.nacimientos.test;

import java.time.*;
import java.time.format.*;
import java.util.*;

import fp.nacimiento.*;

public class NacimientosTest03 {

	public static void main(String[] args) {
		//Inicialización objeto tipo contenedor (metodo leeInformeStream)
		Informes InformeNacimientos= FactoríaNacimiento.leeInformeStream("./data/Nacimientos.csv");
		System.out.println("Hay " + InformeNacimientos.getTamañoListaNacimientos() + " nacimientos");
		System.out.println("Los tres primeros: " + InformeNacimientos.getListaNacimientos().subList(0, 3));
		System.out.println("Los tres últimos: " + InformeNacimientos.getListaNacimientos().subList(InformeNacimientos.getTamañoListaNacimientos()-3, InformeNacimientos.getTamañoListaNacimientos()) +"\n");

		//Inicialización objeto tipo base para realizar
		Nacimiento n= new Nacimiento("Hospital Alto Guadalquivir", TipoCentro.COMARCAL, "Andújar", "Jaén", LocalDate.parse("07/12/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 4, 2, 3.4, 2.19, 51.4, 47.9, false);
		Nacimiento n1= FactoríaNacimiento.parseaNacimiento("Hospital Quirónsalud Sagrado Corazón;PRIVADO;Sevilla;Sevilla;02/01/2003;1;0;2.85;0;58;0;false");
		InformeNacimientos.añadeNacimiento(n1);
		String año= "2018";
		String provincia= "Málaga";
		Boolean valor= false;
		String tipo= "REGIONAL";
		String género= "Hombre";
		
		//Tests tratamientos secuenciales
		System.out.println("Método 6: ¿¿¿Existe el nacimiento \"" + n +"\" en la lista??? ---> "+ InformeNacimientos.existeNacimientoStream(n));
		System.out.println("Método 7: El número de nacimientos producidos en el año \"" + año + "\" son "+ InformeNacimientos.calculaNumeroNacimientosAñoStream(año) + " nacimientos");
		System.out.println("Método 8: Los hospitales para la provincia de \"" + provincia + "\" que tienen helipuerto==" + valor + " son los siguientes: " + InformeNacimientos.filtraHospitalesProvinciaHelipuertoStream(provincia, valor));
		for (String hospital: InformeNacimientos.filtraHospitalesProvinciaHelipuertoStream(provincia, valor)){
			System.out.println(hospital);
		}
		System.out.println("Método 9: El peso máximo para la provincia de \"" + provincia + "\" es de " + InformeNacimientos.calculaPesoMaximoProvinciaStream(provincia) + "kg");
		System.out.println("Método 10: " + "Los nacimientos producidos para el tipo de centro \"" + tipo + "\" son los siguientes: " + InformeNacimientos.filtraNacimientosTipoHospitalFecha(tipo));
		System.out.println("Método 11 (metodo 4 stream): " + "Los nacimientos producidos por provincia son los siguientes: " + InformeNacimientos.dicNacimientosProvinciaStream());
		System.out.println("Método 11 (metodo 5 stream): " + "El número total de nacimientos producidos por cada año son los siguientes:");
		for(Map.Entry<Integer,Long> e: InformeNacimientos.dicCuentaNacimientosAñoStream().entrySet()){
			System.out.println(e);
		}
		System.out.println("Método 12: " + "Los municipios distintos correspondientes a los nacimientos son los siguientes: " + InformeNacimientos.calculaMunicipiosDistintosStream());
		System.out.println("Método 13: " + "La menor edad de las personas nacidas por hospital son las siguientes: " + InformeNacimientos.dicCalculaEdadEnMesesMinimaHospitalStream());
		System.out.println("Método 14: " + "Las mayores alturas de las personas nacidas por provincia son las siguientes: " + InformeNacimientos.dicMayoresAlturasProvinciaGénero(género));
		System.out.println("Método 15: " + "El mayor número de nacimientos producidos cuyo hospital tiene helipuerto es el siguiente: " + InformeNacimientos.maxDicCuentaHospitalesconHelipuertoProvincia());
	}
}