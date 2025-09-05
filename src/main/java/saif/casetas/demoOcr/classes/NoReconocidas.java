package saif.casetas.demoOcr.classes;

import java.time.LocalDateTime;

public class NoReconocidas {
	int cve_entradas_no_reconocidas, verificado, estatus, tipo_de_deteccion;
	LocalDateTime fecha_hora;
	byte[] imagen64;
	String placa_detectada, numero_economico_detectado, marca_economica_detectada;
	public int getCve_entradas_no_reconocidas() {
		return cve_entradas_no_reconocidas;
	}
	public void setCve_entradas_no_reconocidas(int cve_entradas_no_reconocidas) {
		this.cve_entradas_no_reconocidas = cve_entradas_no_reconocidas;
	}
	public int getVerificado() {
		return verificado;
	}
	public void setVerificado(int verificado) {
		this.verificado = verificado;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public int getTipo_de_deteccion() {
		return tipo_de_deteccion;
	}
	public void setTipo_de_deteccion(int tipo_de_deteccion) {
		this.tipo_de_deteccion = tipo_de_deteccion;
	}
	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public byte[] getImagen64() {
		return imagen64;
	}
	public void setImagen64(byte[] imagen64) {
		this.imagen64 = imagen64;
	}
	public String getPlaca_detectada() {
		return placa_detectada;
	}
	public void setPlaca_detectada(String placa_detectada) {
		this.placa_detectada = placa_detectada;
	}
	public String getNumero_economico_detectado() {
		return numero_economico_detectado;
	}
	public void setNumero_economico_detectado(String numero_economico_detectado) {
		this.numero_economico_detectado = numero_economico_detectado;
	}
	public String getMarca_economica_detectada() {
		return marca_economica_detectada;
	}
	public void setMarca_economica_detectada(String marca_economica_detectada) {
		this.marca_economica_detectada = marca_economica_detectada;
	}
	
	
}
