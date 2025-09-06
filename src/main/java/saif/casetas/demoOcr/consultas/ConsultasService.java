package saif.casetas.demoOcr.consultas;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import saif.casetas.demoOcr.classes.Autobus;
import saif.casetas.demoOcr.classes.dto.BusEntradaTipoME_DTO;

@Service
public class ConsultasService {
	
	private final JdbcTemplate jdbcTemplate;

	public ConsultasService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Autobus> consultaPruebaAutobuses(){
		String sql = "SELECT * FROM C##CASETAS.AUTOBUS;";
		List<Autobus> resultados = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                	Autobus bus = new Autobus();
                	bus.setCve_autobus(rs.getInt("CVE_AUTOBUS"));
                    bus.setMatricula(rs.getString("MATRICULA"));
                    return bus;
                });
		return resultados;
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
				
				+ "FROM C##CASETAS.REGISTRO_ENTRADAS E "
				+ "LEFT JOIN C##CASETAS.AUTOBUS A ON A.CVE_AUTOBUS = E.CVE_AUTOBUS "
				+ "LEFT JOIN C##CASETAS.MARCA_ECONOMICA M ON A.CVE_ME = M.CVE_ME "
				+ "INNER JOIN C##CASETAS.TIPO_VEHICULO T ON T.CVE_VEHICULO = T.CVE_VEHICULO "
				
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
		return resultados;
	}
	
	
	
	
	
}
