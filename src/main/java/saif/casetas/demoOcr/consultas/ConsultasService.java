package saif.casetas.demoOcr.consultas;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import saif.casetas.demoOcr.classes.Autobus;
import saif.casetas.demoOcr.classes.NoReconocidas;
import saif.casetas.demoOcr.classes.Entradas;
import saif.casetas.demoOcr.classes.EntradasImg;
import saif.casetas.demoOcr.classes.dto.BusEntradaTipoME_DTO;
import saif.casetas.demoOcr.classes.dto.CambioNoReconocidas_DTO;
import saif.casetas.demoOcr.classes.dto.NoReconocidas_DTO;

@Service
public class ConsultasService {
	
	@Value("${com.saif.esquema.db}")
    private String esquema_casetas;
	
	private final JdbcTemplate jdbcTemplate;

	public ConsultasService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Autobus> consultaPruebaAutobuses(){
		String sql = "SELECT * FROM " + esquema_casetas + ".AUTOBUS;";
		List<Autobus> resultados = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                	Autobus bus = new Autobus();
                	bus.setCve_autobus(rs.getInt("CVE_AUTOBUS"));
                    bus.setMatricula(rs.getString("MATRICULA"));
                    return bus;
                });
		if (resultados.isEmpty()) {
			Autobus bus = new Autobus();
			resultados.add(bus);
		}
		return resultados;
	}
	public /*List<EntradasImg>*/ EntradasImg consultaPruebaImagen(int x){
		String sql = "SELECT IMAGEN64 FROM " + esquema_casetas + ".registro_entradas where CVE_ENTRADA= ? ";
		List<EntradasImg> resultados = jdbcTemplate.query(sql,
				(rs, rowNum) -> {
					EntradasImg bus = new EntradasImg();
					bus.setImagen64(rs.getBytes("imagen64"));
					return bus;
				},x);
		return resultados.get(0);
	}
	public /*List<EntradasImg>*/ EntradasImg consultaPruebaNoRecImagen(int x){
		String sql = "SELECT IMAGEN64 FROM " + esquema_casetas + ".registro_entradas_no_reconocidas where CVE_ENTRADA_NO_RECONOCIDA= ? ";
		List<EntradasImg> resultados = jdbcTemplate.query(sql,
				(rs, rowNum) -> {
					EntradasImg bus = new EntradasImg();
					bus.setImagen64(rs.getBytes("imagen64"));
					return bus;
				},x);
		return resultados.get(0);
	}
	
	public List<BusEntradaTipoME_DTO> consultaBusesCapturasExitosas_BD(){
		String sql = "SELECT "
				+ "E.CVE_ENTRADA, "
				+ "E.TIPO_DE_DETECCION, "
				+ "TO_CHAR(E.FECHA_HORA, 'YYYY-MM-DD HH24:MI:SS') AS HORA_ENTRADA, "
				+ "E.NUMERO_ECONOMICO_DETECTADO, "
				+ "E.PLACA_DETECTADA, "
				+ "E.MARCA_ECONOMICA_DETECTADA, "
				+ "NVL(A.CVE_AUTOBUS,0) AS CVE_AUTOBUS, "
				+ "NVL(A.NUMERO_ECONOMICO,'N/A') AS NUMERO_ECONOMICO, "
				+ "NVL(A.MATRICULA,'N/A') AS MATRICULA, "
				+ "NVL(M.ME_NAME,'N/A') AS MARCA_ECONOMICA, "
				+ "T.DESCRIPCION AS TIPO_VEHICULO "
				
				+ "FROM " + esquema_casetas + ".REGISTRO_ENTRADAS E "
				+ "LEFT JOIN " + esquema_casetas + ".AUTOBUS A ON A.CVE_AUTOBUS = E.CVE_AUTOBUS "
				+ "LEFT JOIN " + esquema_casetas + ".MARCA_ECONOMICA M ON A.CVE_ME = M.CVE_ME "
				+ "INNER JOIN " + esquema_casetas + ".TIPO_VEHICULO T ON T.CVE_VEHICULO = T.CVE_VEHICULO "
				
				+ "ORDER BY E.FECHA_HORA DESC";
		List<BusEntradaTipoME_DTO> resultados = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                	BusEntradaTipoME_DTO bus = new BusEntradaTipoME_DTO();
                	bus.setCveEntrada(rs.getInt("CVE_ENTRADA"));
                	bus.setTipoDeteccion(rs.getInt("TIPO_DE_DETECCION"));
                	bus.setHora_entrada(rs.getString("HORA_ENTRADA"));
                	bus.setNumero_economico_detectado(rs.getString("NUMERO_ECONOMICO_DETECTADO"));
                	bus.setPlaca_detectada(rs.getString("PLACA_DETECTADA"));
                	bus.setMarca_economica_detectada(rs.getString("MARCA_ECONOMICA_DETECTADA"));
                	bus.setCveAutobus(rs.getInt("CVE_AUTOBUS"));
                	bus.setNumero_economico(rs.getString("NUMERO_ECONOMICO"));
                	bus.setMatricula(rs.getString("MATRICULA"));
                	bus.setMarca_economica(rs.getString("MARCA_ECONOMICA"));
                	bus.setTipo_vehiculo(rs.getString("TIPO_VEHICULO"));
                    return bus;
                });
		if (resultados.isEmpty()) {
			BusEntradaTipoME_DTO bus = new BusEntradaTipoME_DTO();
			resultados.add(bus);
		}
		return resultados;
	}
	
	public List<NoReconocidas_DTO> consultaCapturasNoReconocidas_BD(){
		String sql = "SELECT CVE_ENTRADA_NO_RECONOCIDA, "
				+ "TO_CHAR(FECHA_HORA, 'YYYY-MM-DD HH24:MI:SS') AS HORA_ENTRADA, "
				+ "VERIFICADO, "
				+ "PLACA_DETECTADA, "
				+ "NUMERO_ECONOMICO_DETECTADO, "
				+ "MARCA_ECONOMICA_DETECTADA, "
				+ "TIPO_DE_DETECCION "
				+ "FROM " + esquema_casetas + ".REGISTRO_ENTRADAS_NO_RECONOCIDAS ";
		List<NoReconocidas_DTO> resultados = jdbcTemplate.query(sql,
				(rs, rowNum) -> {
					NoReconocidas_DTO captura = new NoReconocidas_DTO();
					captura.setCve_entradas_no_reconocidas(rs.getInt("CVE_ENTRADA_NO_RECONOCIDA"));
					captura.setHora_fecha(rs.getString("HORA_ENTRADA"));
					captura.setVerificado(rs.getInt("VERIFICADO"));
					captura.setPlaca_detectada(rs.getString("PLACA_DETECTADA"));
					captura.setNumero_economico_detectado(rs.getString("NUMERO_ECONOMICO_DETECTADO"));
					captura.setMarca_economica_detectada(rs.getString("MARCA_ECONOMICA_DETECTADA"));
					captura.setTipo_de_deteccion(rs.getInt("TIPO_DE_DETECCION"));
					return captura;
				});
		if (resultados.isEmpty()) {
			NoReconocidas_DTO bus = new NoReconocidas_DTO();
			resultados.add(bus);
		}
		return resultados;
	}
	
	/**
	 * Insertar no reconocida a reconocida.
	 * Tipo deteccion siempre es 3
	 * @param cve_
	 * @return
	 */
	/*public Boolean cambiarDeTabla_BD (
			int cve_no_reconocida, int cve_vehiculo, 
			String placa, String numero_economico, String marca_economica) {
		
		String con = ""
		
		// consulta
		String consulta = "SELECT TO_CHAR(E.FECHA_HORA, 'YYYY-MM-DD HH24:MI:SS') AS HORA_ENTRADA "
				+ "FROM " + esquema_casetas + ".REGISTRO_ENTRADAS_NO_RECONOCIDAS "
				+ "WHERE CVE_ENTRADA_NO_RECONOCIDA = ? "
				+ "AND PLACA_DETECTADA = ? "
				+ "AND NUMERO_ECONOMICO_DETECTADO = ? "
				+ "AND MARCA_ECONOMICA_DETECTADA = ? ";
		
		List<CambioNoReconocidas_DTO> resultados = jdbcTemplate.query(consulta,
				(rs, rowNum) -> {
					CambioNoReconocidas_DTO captura = new CambioNoReconocidas_DTO();
					captura.setFecha_hora(rs.getString("HORA_ENTRADA"));
					return captura;
				},cve_no_reconocida);
		
		CambioNoReconocidas_DTO noReconocida = resultados.get(0);
		noReconocida.setImagen64(consultaPruebaNoRecImagen(cve_no_reconocida).getImagen64());
		
		
		String sql = "INSERT INTO C##CASETAS.REGISTRO_ENTRADAS (FECHA_HORA, IMAGEN64) " +
                "VALUES (SYSDATE, ?, ?)";
		int filasAfectadas = jdbcTemplate.update(sql, noReconocida.getFecha_hora(),);
		
	}*/
	
	public Boolean insertarRegistroEntrada_BD(
			int cve_entrada, int cve_vehiculo,
			String placa, String numero_economico, String marca) {
	    String sql = "INSERT INTO " + esquema_casetas + ".REGISTRO_ENTRADAS " +
	            "(FECHA_HORA, IMAGEN64, CVE_VEHICULO, CVE_AUTOBUS, PLACA_DETECTADA, NUMERO_ECONOMICO_DETECTADO, MARCA_ECONOMICA_DETECTADA, TIPO_DE_DETECCION) " +
	            "SELECT n.FECHA_HORA, n.IMAGEN64, ?, ?, ?, ?, ?, ? " +
	            "FROM " + esquema_casetas + ".REGISTRO_ENTRADAS_NO_RECONOCIDAS n " +
	            "WHERE n.CVE_ENTRADA_NO_RECONOCIDA = ? ";

	    System.out.println("cve_vehiculo: " + cve_vehiculo);
	    System.out.println("cve_entrada: " + cve_entrada);
	    System.out.println("placa: " + placa);
	    System.out.println("numero_economico: " + numero_economico);
	    System.out.println("marca: " + marca);
	    
	    int filasAfectadas = jdbcTemplate.update(sql,
	    		cve_vehiculo,
	    		0,
	            placa,
	            numero_economico,
	            marca,
	            3,
	            cve_entrada
	    );
	    
	    return filasAfectadas > 0;
	}
	
	
}









