package saif.casetas.demoOcr.classes;

import java.time.LocalDateTime;

public class Autobus {
	private int cve_autobus, status, anio;
	private String matricula, numero_economico, color, marca, modelo, fecha_registro;
	private MarcaEconomica marca_economica;

	
	public MarcaEconomica getMarca_economica() {
		return marca_economica;
	}
	public void setMarca_economica(MarcaEconomica marca_economica) {
		this.marca_economica = marca_economica;
	}
	public int getCve_autobus() {
		return cve_autobus;
	}
	public void setCve_autobus(int cve_autobus) {
		this.cve_autobus = cve_autobus;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNumero_economico() {
		return numero_economico;
	}
	public void setNumero_economico(String numero_economico) {
		this.numero_economico = numero_economico;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	
	
}
