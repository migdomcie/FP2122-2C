package fp.nacimientos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.nacimiento.*;

public class NacimientosTest01 {
//Hospital Universitario San Cecilio;ESPECIALIDADES;Granada;Granada;09/11/2019;4;3;3.29;3.23;52.8;48.6;false
	public static void main(String[] args) {
		
		//Inicialización objetos 'n', 'n1', 'n2', 'n3' 
		Nacimiento n= new Nacimiento("Hospital Universitario Virgen del Rocío", TipoCentro.REGIONAL,"Sevilla","Sevilla",
				LocalDate.parse("04/09/2018",DateTimeFormatter.ofPattern("dd/MM/yyyy")),2,6,3.43,2.72,52.4,49.9,true);
		Nacimiento n1= new Nacimiento("Hospital Universitario Virgen del Rocío", TipoCentro.REGIONAL,"Sevilla","Sevilla",
				LocalDate.parse("04/09/2018",DateTimeFormatter.ofPattern("dd/MM/yyyy")),2,6,3.43,2.72,52.4,49.9,true);
		Nacimiento n2= new Nacimiento("Hospital Universitario Virgen del Rocío", TipoCentro.REGIONAL,"Sevilla","Sevilla",
				LocalDate.parse("04/09/2018",DateTimeFormatter.ofPattern("dd/MM/yyyy")),2,6,3.43,2.72,52.4,49.9,true);
		Nacimiento n3= new Nacimiento("Hospital Universitario Virgen de Valme","Sevilla","Sevilla",
				LocalDate.parse("24/05/2019",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				
		//Print de objeto 'n', 'n3' en formato general y formato corto		
			System.out.println("Formato general---> "+n);
			System.out.println("Formato corto---> "+n.formatoCorto()+"\n");
			
			System.out.println("Formato general---> "+n3);
			System.out.println("Formato corto---> "+n3.formatoCorto()+"\n");
			
		//Set de la altura de 'n' a 3.5 y print de la propiedad
		
			n.setPromedioAltH(3.5);
			System.out.println("PromedioAltH---> "+ n.getPromedioAltH()+"\n");
		
	
		//Comprobación de todas las restricciones (peso, altura y helipuerto), modificando el objeto 'n' e inicializando otro objeto 'n3'
		
			//Set número de nacimientos y print 
//				n.setnHombres(-5);		
//				n.setnMujeres(-5);
//		
//			//Set pesos y print
//				n.setPromedioPesoH(-2.5);		
//				n.setPromedioPesoM(-2.5);
//		
//			//Set alturas y print
//				n.setPromedioAltH(-55.0);				
//				n.setPromedioAltM(-55.0);				
//		
//			//Set helipuerto
//				n.setHelipuerto(null);			
//	
//			//Inicialización de n3 'CON helipuerto=null' 
//				Nacimiento n3= new Nacimiento("Hospital Concertado Santa María Del Puerto",TipoCentro.CONCERTADO, "Puerto de Santa María. El","Cádiz",
//						LocalDate.parse("08/06/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy")),3,6,2.71,3.57,47.9,49.2,null);
				
		//Cambio de propiedades en 'n1' y 'n2' para comprobar el criterio de igualdad y de ordenación
			//Print métodos equals(), hashCode() y compareTo() SIN CAMBIAR PROPIEDADES 
				System.out.println("¿Son los objetos idénticos?---> " +n1.equals(n2));
				System.out.println("HashCode del primer objeto---> " +n1.hashCode());
				System.out.println("HashCode del segundo objeto---> " +n2.hashCode());
				System.out.println("¿Qué objeto va antes?---> " +n1.compareTo(n2));
			
			//Set de 'n1', pero 'n2' sigue teniendo las mismas propiedades 
				n1.setnHombres(16);
			
			//Print métodos equals(), hashCode() y compareTo() CAMBIANDO PROPIEDADES
				System.out.println("------------------------------------");
				System.out.println("¿Son los objetos idénticos?---> " +n1.equals(n2));
				System.out.println("HashCode del primer objeto---> " +n1.hashCode());
				System.out.println("HashCode del segundo objeto---> " +n2.hashCode());
				System.out.println("¿Qué objeto va antes?---> " +n1.compareTo(n2));
			
	}
	
}
