package saif.casetas.demoOcr.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "REGISTRO_ENTRADAS_NO_RECONOCIDAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "REGISTRO_ENTRADAS_NO_RECONOCIDAS", schema="c##casetas")
public class NoReconocidaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mi_seq")
	@SequenceGenerator(name = "mi_seq", sequenceName = "MI_SECUENCIA", allocationSize = 1)*/
    @Column(name = "CVE_ENTRADA_NO_RECONOCIDA")
    private int cve_entrada;

    @Column(name="FECHA_HORA")
    private Date fecha_hora;

    @Lob
    @Column(name="IMAGEN64", nullable= false)
    private byte[] imagen64;
}

