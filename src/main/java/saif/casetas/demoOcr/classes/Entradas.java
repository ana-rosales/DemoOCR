package saif.casetas.demoOcr.classes;


public class Entradas {
	private int cve_entrada, estatus, tipo_de_deteccion;
	private String placa_detectada, numero_economico_detectado, marca_economica_detectada, fecha_hora;
	private TipoVehiculo tipo_vehiculo;
	private byte[] imagen64;
	private Autobus autobus;
	
	public int getCve_entrada() {
		return cve_entrada;
	}
	public void setCve_entrada(int cve_entrada) {
		this.cve_entrada = cve_entrada;
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
	public TipoVehiculo getTipo_vehiculo() {
		return tipo_vehiculo;
	}
	public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}
	public byte[] getImagen64() {
		return imagen64;
	}
	public void setImagen64(byte[] imagen64) {
		this.imagen64 = imagen64;
	}
	public Autobus getAutobus() {
		return autobus;
	}
	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
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
	public String getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	
	
}
