package saif.casetas.demoOcr.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoReconocidaRepository{
	private JdbcTemplate jdbcTemplate;

    public void MyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	public NoReconocidaRepository(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<String> getNames() {
        String sql = "SELECT * FROM c##cacetas.autobus";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("name"));
    }
}
