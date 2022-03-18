package fp.nacimiento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public class Nacimiento implements Comparable<Nacimiento>{
//Propiedades básicas
	private String nombreHospital;
	private TipoCentro tipoCentro;
	private String municipio;
	private String provincia;
	private LocalDate fechaNacimiento;
	private Integer nHombres;
	private Integer nMujeres;
	private Double promedioPesoH;
	private Double promedioPesoM;
	private Double promedioAltH;
	private Double promedioAltM;
	private Boolean helipuerto;
	
//Propiedades derivadas
	public Integer edad() {
		Integer e = this.fechaNacimiento.until(LocalDate.now()).getYears();
		return e;
	}

	public Integer sumaNacimientos() {
		Integer s = this.nHombres + this.nMujeres;
		return s;
	}

//Constructor 1
	public Nacimiento(String nombreHospital, TipoCentro tipoCentro,String municipio, String provincia,
			LocalDate fechaNacimiento, Integer nHombres, Integer nMujeres, Double promedioPesoH, Double promedioPesoM,
			Double promedioAltH, Double promedioAltM, Boolean helipuerto) {

		this.nombreHospital = nombreHospital;
		this.tipoCentro = tipoCentro;
		this.provincia = provincia;
		this.municipio = municipio;
		this.fechaNacimiento = fechaNacimiento;
		edad();
		this.nHombres = nHombres;
		this.nMujeres = nMujeres;
		this.promedioPesoH = promedioPesoH;
		this.promedioPesoM = promedioPesoM;
		this.promedioAltH = promedioAltH;
		this.promedioAltM = promedioAltM;
		this.helipuerto = helipuerto;
		compruebanH();
		compruebanM();
		compruebaPesoH();
		compruebaPesoM();
		compruebaAlturaH();
		compruebaAlturaM();
		compruebaHelipuerto();
	
	}
	
//Constructor 2
	public Nacimiento(String nombreHospital, String municipio, String provincia, LocalDate fechaNacimiento) {
		this.nombreHospital = nombreHospital;
		this.provincia = provincia;
		this.municipio = municipio;
		this.fechaNacimiento = fechaNacimiento;
		edad(); 
		this.nHombres = 0;
		this.nMujeres = 0;
		this.promedioPesoH = 0.0;
		this.promedioPesoM = 0.0;
		this.promedioAltH = 0.0;
		this.promedioAltM = 0.0;
		this.helipuerto = false;
		compruebanH();
		compruebanM();
		compruebaPesoH();
		compruebaPesoM();
		compruebaAlturaH();
		compruebaAlturaM();
		compruebaHelipuerto();
	}
	
//Consultores/Modificadores
	public String getNombreHospital() {
		return this.nombreHospital;
	}
	
	public void setNombreHospital(String nombreHospital) {
		this.nombreHospital= nombreHospital;
	}
	
	public TipoCentro getTipoCentro() {
		return this.tipoCentro;
	}
	
	public void setTipoCentro(TipoCentro tipoCentro) {
		this.tipoCentro= tipoCentro;
	}
	
	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getnHombres() {
		return nHombres;
	}

	public void setnHombres(Integer nHombres) {
		this.nHombres = nHombres;
		compruebanH();
	}

	public Integer getnMujeres() {
		return nMujeres;
	}

	public void setnMujeres(Integer nMujeres) {
		this.nMujeres = nMujeres;
		compruebanM();
	}

	public Double getPromedioPesoH() {
		return promedioPesoH;
	}

	public void setPromedioPesoH(Double promedioPesoH) {
		this.promedioPesoH = promedioPesoH;
		compruebaPesoH();
	}

	public Double getPromedioPesoM() {
		return promedioPesoM;
	}

	public void setPromedioPesoM(Double promedioPesoM) {
		this.promedioPesoM = promedioPesoM;
		compruebaPesoM();
	}

	public Double getPromedioAltH() {
		return promedioAltH;
	}

	public void setPromedioAltH(Double promedioAltH) {
		this.promedioAltH = promedioAltH;
		compruebaAlturaH();
	}

	public Double getPromedioAltM() {
		return promedioAltM;
	}

	public void setPromedioAltM(Double promedioAltM) {
		this.promedioAltM = promedioAltM;
		compruebaAlturaM();
	}

	public Boolean getHelipuerto() {
		return helipuerto;
	}

	public void setHelipuerto(Boolean helipuerto) {
		this.helipuerto = helipuerto;
		compruebaHelipuerto();
	}
	
//Restricciones
	private void compruebanH() {
		Checkers.check("El número de nacimientos de hombres ha de ser mayor o igual que cero", this.getnHombres()>=0);
	}
	
	private void compruebanM() {
		Checkers.check("El número de nacimientos de mujeres ha de ser mayor o igual que cero", this.getnMujeres()>=0);
	}
	
	private void compruebaPesoH() {
		Checkers.check("El peso de los hombres ha de ser mayor o igual que cero", this.getPromedioPesoH()>=0.0);
	}

	private void compruebaPesoM() {
		Checkers.check("El peso de las mujeres ha de ser mayor o igual que cero", this.getPromedioPesoM()>=0.0);
	}
	
	private void compruebaAlturaH() {
		Checkers.check("La altura de los hombres ha de ser mayor o igual que cero", this.getPromedioAltH()>=0.0);
	}
	
	private void compruebaAlturaM() {
		Checkers.check("La altura de las mujeres ha de ser mayor o igual que cero", this.getPromedioAltM()>=0.0);
	}
	
	private void compruebaHelipuerto() {
		Checkers.check("La propiedad del helipuerto no puede tener el valor 'null'", this.getHelipuerto()!=null);
	}

//Método formatoCorto
		public String formatoCorto() {
			return this.nombreHospital + " (" + this.municipio + ", " + this.provincia + "); "
					+ this.fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "; "
					+ sumaNacimientos() + " nacimientos";
		}
	
//Método toString
	public String toString() {
		return this.nombreHospital + ";" + this.tipoCentro + ";" + this.municipio + ";" + this.provincia + ";" 
				+ this.fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
				+ this.nHombres + ";" + this.nMujeres + ";" + this.promedioPesoH + ";" + this.promedioPesoM + ";"
				+ this.promedioAltH + ";" + this.promedioAltM + ";" + this.helipuerto;
	}

//Criterio de igualdad (hashcode & equals)
@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, nHombres, nMujeres, nombreHospital);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nacimiento other = (Nacimiento) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nHombres, other.nHombres)
				&& Objects.equals(nMujeres, other.nMujeres) && Objects.equals(nombreHospital, other.nombreHospital);
	}
	
//Principio de ordenación
	public int compareTo(Nacimiento n) {
		Integer res=this.getNombreHospital().compareTo(n.getNombreHospital());
		if (res==0) {
			res=this.getFechaNacimiento().compareTo(n.getFechaNacimiento());
			if(res==0) {
				res=this.getnHombres().compareTo(n.getnHombres());
				if(res==0) {
					res=this.getnMujeres().compareTo(n.getnMujeres());
				}
			}
		}
		return res;
	}
}	
/* TAREA:
• Tener al menos una propiedad derivada. (cada alumno/a piense en una propiedad derivada que se
pueda obtener a partir de los datos básicos del dataset). Resaltarla/s en README XXXXX ---> (revisar propiedad derivada)

 */
