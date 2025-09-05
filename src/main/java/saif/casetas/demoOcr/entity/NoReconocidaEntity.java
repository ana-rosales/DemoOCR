package saif.casetas.demoOcr.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "REGISTRO_ENTRADAS_NO_RECONOCIDAS")
@Table(name = "REGISTRO_ENTRADAS_NO_RECONOCIDAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoReconocidaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CVE_ENTRADA_NO_RECONOCIDA")
    private int cve_entrada;

    @Column(name="FECHA_HORA")
    private Date fecha_hora;

    @Column(name="IMAGEN64")
    private String imagen64;
}

