package saif.casetas.demoOcr.classes;

import java.time.LocalDateTime;

public class TipoVehiculo {
	int cve_vehiculo, estatus;
	String descripcion;
	LocalDateTime fecha_registro;
	
	public int getCve_Vehiculo() {
		return this.cve_vehiculo;
	}
	
	public int getEstatus() {
		return this.estatus;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public LocalDateTime getFecha_Registro() {
		return this.fecha_registro;
	}
	
	public void setCve_Vehiculo(int cve_vehiculo) {
		this.cve_vehiculo = cve_vehiculo;
	}
	
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setFecha_Registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
}
