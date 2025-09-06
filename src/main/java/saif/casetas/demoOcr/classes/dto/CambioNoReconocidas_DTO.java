package saif.casetas.demoOcr.classes.dto;

import java.time.LocalDateTime;

public class CambioNoReconocidas_DTO {
	private byte[] imagen64;
	private String fecha_hora;
	public CambioNoReconocidas_DTO() {
		// TODO Auto-generated constructor stub
	}
	public byte[] getImagen64() {
		return imagen64;
	}
	public void setImagen64(byte[] imagen64) {
		this.imagen64 = imagen64;
	}
	public String getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	
}
