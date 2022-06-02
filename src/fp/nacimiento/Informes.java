package fp.nacimiento;

import java.time.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;


public class Informes implements Comparable<Informes>{
	private LocalDate fechaEmisión;
	private String instituciónEmisora;
	private Integer númeroInforme;
	private List<Nacimiento> listaNacimientos;
	
	//metodos estaticos propiedades predefinidas (derivadas)
	
	public static LocalDate fechaPredetInforme() {
		return LocalDate.now();
	}
	
	public static Integer numPredetInforme() {
		Integer valor= new Random().nextInt(10000000, 99999999);
		return Integer.valueOf(valor);
	}
	
	public static String instituciónPredet() {
		return "Junta de Andalucía";
	}
	
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
	
	//contructor 3
	public Informes(LocalDate fecha, String institución, Integer número, Stream<Nacimiento> streamNacimientos) {
		fechaEmisión= fecha;
		instituciónEmisora= institución;
		númeroInforme= número;
		this.listaNacimientos= new ArrayList<Nacimiento>(streamNacimientos.toList());
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
				break;
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
			}
		}
		return new ArrayList<String>(conjuntoFiltrado);
	}
		
	//metodo 4
		
	public Map<String,List<Nacimiento>> dicNacimientosProvincia(){
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
	
	//metodo 6
	
	public Boolean existeNacimientoStream(Nacimiento n) {
		return this.listaNacimientos.stream().anyMatch(nacimiento -> nacimiento.equals(n));
	}
	
	//metodo 7
	
	public Integer calculaNumeroNacimientosAñoStream(String año) {
		return (int) this.listaNacimientos.stream().filter(nacimiento -> nacimiento.getFechaNacimiento().getYear()== Integer.valueOf(año))
				.count();
	}
	
	//metodo 8
	
	public List<String> filtraHospitalesProvinciaHelipuertoStream(String provincia, Boolean helipuerto){
		Set<String>s= this.listaNacimientos.stream().filter(nacimiento -> nacimiento.getProvincia().equals(provincia) && nacimiento.getHelipuerto().equals(helipuerto))
				.collect(Collectors.mapping(nacimiento -> nacimiento.getNombreHospital(), Collectors.toSet()));
		
		return new ArrayList<String>(s);
	}
	
	//metodo 9
	
	public Double calculaPesoMaximoProvinciaStream(String provincia) {
		Double maximoPesoH = this.listaNacimientos.stream().filter(nacimiento -> nacimiento.getProvincia().equals(provincia))
				.max(Comparator.comparingDouble(nacimiento -> nacimiento.getPromedioPesoH())).get().getPromedioPesoH();
		
		Double maximoPesoM = this.listaNacimientos.stream().filter(nacimiento -> nacimiento.getProvincia().equals(provincia))
				.max(Comparator.comparingDouble(nacimiento -> nacimiento.getPromedioPesoM())).get().getPromedioPesoH();
		
		if(maximoPesoH>maximoPesoM) {
			return maximoPesoH;
		}else {
			return maximoPesoM;
		}
	}
	
	//metodo 10
	
	public List<Nacimiento> filtraNacimientosTipoHospitalFecha(String tipo){
		return this.listaNacimientos.stream().filter(nacimiento -> nacimiento.getTipoCentro()== TipoCentro.valueOf(tipo))
				.sorted(Comparator.comparing(nacimiento -> nacimiento.getFechaNacimiento())).collect(Collectors.toList());
	}

	//metodos 11 (metodo 4 y 5 stream)
	
	public Map<String,List<Nacimiento>> dicNacimientosProvinciaStream(){
		return this.listaNacimientos.stream().collect(Collectors.groupingBy(nacimiento -> nacimiento.getProvincia()));
	}
	
	public Map<Integer, Long> dicCuentaNacimientosAñoStream(){
		return this.listaNacimientos.stream().collect(Collectors.groupingBy(nacimiento -> Integer.valueOf(nacimiento.getFechaNacimiento().getYear()), Collectors.counting()));
	}
	
	//metodo 12
	
	public Set<String> calculaMunicipiosDistintosStream(){
		return this.listaNacimientos.stream().collect(Collectors.mapping(nacimiento -> nacimiento.getMunicipio(), Collectors.toCollection(() -> new TreeSet<>())));
	}
	
	//metodo 13
	
	public Map<String, Integer> dicCalculaEdadEnMesesMinimaHospitalStream(){
		
		Map<String,Integer> d= this.listaNacimientos.stream()
				.collect(Collectors.groupingBy(Nacimiento::getNombreHospital, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Nacimiento::getFechaNacimiento))
						, n -> Period.between(n.get().getFechaNacimiento(), LocalDate.now()).getMonths())));
		return d;
	}
	
	//metodo 14
	
	public SortedMap<String, List<Double>> dicMayoresAlturasProvinciaGénero(String género){
		
		Map<String, List<Double>> dicAlturasProvincia= new HashMap<>();
		
		if(género=="Hombre") {
			dicAlturasProvincia.putAll(this.listaNacimientos.stream().collect(Collectors.groupingBy(Nacimiento::getProvincia, Collectors.mapping(Nacimiento::getPromedioAltM, Collectors.toList()))));
			dicAlturasProvincia.entrySet().stream().forEach(e -> Collections.sort(e.getValue()));
			dicAlturasProvincia.entrySet().stream().forEach(e -> Collections.reverse(e.getValue()));
		}
		else if (género=="Mujer"){
			dicAlturasProvincia.putAll(this.listaNacimientos.stream().collect(Collectors.groupingBy(Nacimiento::getProvincia, Collectors.mapping(Nacimiento::getPromedioAltM, Collectors.toList()))));
			dicAlturasProvincia.entrySet().stream().forEach(e -> Collections.sort(e.getValue()));
			dicAlturasProvincia.entrySet().stream().forEach(e -> Collections.reverse(e.getValue()));
		}
		return new TreeMap<String, List<Double>>(dicAlturasProvincia);
		
	}
	
	//metodo 15
	
	public Map.Entry<String, Long> maxDicCuentaHospitalesconHelipuertoProvincia(){
		Map<String, Long> dic= this.listaNacimientos.stream().collect(Collectors.groupingBy(Nacimiento::getProvincia, Collectors.collectingAndThen(Collectors.toList(), l -> l.stream().filter(n -> n.getHelipuerto()==true).count())));
		
		return dic.entrySet().stream().max(Comparator.comparing(e -> e.getValue())).get();
	}
	
	public Map<TipoCentro, Double> ObtenerPromedioNacimientosPorTipoHospital(){
		return this.listaNacimientos.stream()
				.collect(Collectors.groupingBy(Nacimiento::getTipoCentro, Collectors.collectingAndThen(Collectors.toList(), l -> calculaPromedioNacimientos(l))));
		
	}
	
	private Double calculaPromedioNacimientos(List<Nacimiento> l) {
		Integer numeroTotalNacimientos=  l.size();
		Integer numeroNacimientosHombresyMujeres= l.stream().mapToInt(Nacimiento::getnHombres).sum() + l.stream().mapToInt(Nacimiento::getnMujeres).sum() ;
		return 1.0*numeroNacimientosHombresyMujeres / numeroTotalNacimientos;
	}
}

