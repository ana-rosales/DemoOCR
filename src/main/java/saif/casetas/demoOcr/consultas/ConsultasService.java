package saif.casetas.demoOcr.consultas;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import saif.casetas.demoOcr.classes.Autobus;

@Service
public class ConsultasService {
	
	private final JdbcTemplate jdbcTemplate;

	public ConsultasService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Autobus> consultaPruebaAutobuses(){
		String sql = "SELECT * FROM C##CASETAS.AUTOBUSES";
		List<Autobus> resultados = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                	Autobus bus = new Autobus();
                	bus.setCve_autobus(rs.getInt("CVE_AUTOBUS"));
                    bus.setMatricula(rs.getString("MATRICULA"));
                    return bus;
                });
		return resultados;
	}
	
}
