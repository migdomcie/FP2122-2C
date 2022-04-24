package fp.nacimiento;

import java.time.*;
import java.util.*;

import fp.utiles.Checkers;


public class Informes implements Comparable<Informes>{
	private LocalDate fechaEmisión;
	private String instituciónEmisora;
	private Integer númeroInforme;
	private List<Nacimiento> listaNacimientos;
	
	
	//getters y setters 
	public LocalDate getFechaEmisión() {
		return this.fechaEmisión;
	}
	
	public String getInstituciónEmisora() {
		return this.instituciónEmisora;
	}
	
	public Integer getNúmeroInforme() {
		return this.númeroInforme;
	}
	
	public List<Nacimiento> getListaNacimientos() {
		return new ArrayList<Nacimiento>(this.listaNacimientos);
	}
	
	public void setFechaEmisión(LocalDate fecha) {
		fechaEmisión= fecha;
	}
	
	public void setInstituciónEmisora(String inst) {
		instituciónEmisora= inst;
	}
	
	public void setNúmeroInforme(Integer número) {
		númeroInforme= número;
		compruebaNúmeroInforme();
	}
	
	//constructor 1
	
	public Informes(LocalDate fecha, String institución, Integer número) {
		fechaEmisión= fecha;
		instituciónEmisora= institución;
		númeroInforme= número;
		this.listaNacimientos= new ArrayList<Nacimiento>();
		compruebaNúmeroInforme();
		Checkers.checkNoNull(fecha, institución, número);
	}
	
	//constructor 2
	public Informes(LocalDate fecha, String institución, Integer número, List<Nacimiento> listaNacimientos) {
		fechaEmisión= fecha;
		instituciónEmisora= institución;
		númeroInforme= número;
		this.listaNacimientos= new ArrayList<Nacimiento>(listaNacimientos);
		compruebaNúmeroInforme();
		Checkers.checkNoNull(fecha, institución, número);
	}
	
	
//Restricciones

	private void compruebaNúmeroInforme() {
		Checkers.check("El número de informe no puede ser negativo", this.getNúmeroInforme()>=0);
		Checkers.check("El número de informe ha de tener 8 cifras", this.getNúmeroInforme().toString().length()==8);
	}

//toString 
	@Override
	public String toString() {
		return "Informe emitido por " + this.instituciónEmisora+ " con fecha " + this.fechaEmisión + "(Nº " + this.númeroInforme + ") ---> "+  this.listaNacimientos;
	}
	
//Criterio igualdad
		
	@Override
	public int hashCode() {
		return Objects.hash(fechaEmisión, instituciónEmisora, númeroInforme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Informes other = (Informes) obj;
		return Objects.equals(fechaEmisión, other.fechaEmisión)
				&& Objects.equals(instituciónEmisora, other.instituciónEmisora)
				&& Objects.equals(númeroInforme, other.númeroInforme);
	}
	
//Principio ordenación
	
	public int compareTo(Informes i) {
		Integer res= this.getFechaEmisión().compareTo(i.getFechaEmisión());
		if(res==0){
			res= this.getInstituciónEmisora().compareTo(i.getInstituciónEmisora());
			if (res==0) {
				res= this.getNúmeroInforme().compareTo(i.getNúmeroInforme());
			}
		}
		return res;
	}
	

//otras operaciones
		
	public Integer getTamañoListaNacimientos() {
		return this.listaNacimientos.size();
	}
	
	public void añadeNacimiento(Nacimiento n) {
		this.listaNacimientos.add(n);
	}
		
	public void añadeColeccionNacimientos(Collection<Nacimiento> c) {
		for(Nacimiento n: c) {
			if(!this.listaNacimientos.contains(n)) {
				this.listaNacimientos.add(n);
			}
		}
	}
		
	public void eliminaNacimiento(Nacimiento n) {
		this.listaNacimientos.remove(n);
	}
		
//tratamientos secuenciales
		
	//metodo 1
		
	public Boolean existeNacimiento(Nacimiento n) {
		Boolean res= false;
		for (Nacimiento nac: this.listaNacimientos) {
			if(nac.equals(n)) {
				res=true;
			}
		}
		return res;
	}
		
	//metodo 2
		
	public Integer calculaNumeroNacimientosAño(String año) {
		Integer res=0;
		for(Nacimiento n: this.listaNacimientos) {
			if(n.getFechaNacimiento().getYear() == Integer.valueOf(año)) {
				res++;
			}
		}
		return res;
	}
		
	//metodo 3
		
	public List<String> filtraHospitalesProvinciaHelipuerto(String provincia, Boolean helipuerto){
		SortedSet<String> conjuntoFiltrado= new TreeSet<String>();
			
		for(Nacimiento n: this.listaNacimientos) {
			if(n.getProvincia().equals(provincia) && n.getHelipuerto().equals(helipuerto)) {
				conjuntoFiltrado.add(n.getNombreHospital());
			} else {
				;
			}
		}
		return new ArrayList<String>(conjuntoFiltrado);
	}
		
	//metodo 4
		
	public Map<String,List<Nacimiento>> dicFiltraNacimientosProvincia(){
		Map<String, List<Nacimiento>> m= new HashMap<String, List<Nacimiento>>();
		for(Nacimiento n: this.listaNacimientos) {
			if(!m.containsKey(n.getProvincia())) {
				List<Nacimiento>l= new ArrayList<Nacimiento>();
				l.add(n);
				m.put(n.getProvincia(), l);
			}else {
				m.get(n.getProvincia()).add(n);
			}
		}
		return m;
		}
		
	//metodo 5
		
	public Map<Integer, Integer> dicCuentaNacimientosAño(){
		Map<Integer, Integer> m= new HashMap<Integer,Integer>();
		for(Nacimiento n: this.listaNacimientos) {
			if(m.containsKey(n.getFechaNacimiento().getYear())== false) {
				Integer numero=1;
				m.put(n.getFechaNacimiento().getYear(), numero);
			} else {
				Integer numero= m.get(n.getFechaNacimiento().getYear());
				numero++;
				m.put(n.getFechaNacimiento().getYear(), numero);
			}
		}
		return m;
	}
}
