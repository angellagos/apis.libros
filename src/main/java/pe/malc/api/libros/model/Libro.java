package pe.malc.api.libros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "LIBRO")
@Entity(name = "Libro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
	@Id
	@Column(name = "ID_LIBRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLibro")
	@SequenceGenerator(name = "seqLibro", allocationSize = 1, sequenceName = "SEQ_LIBRO")
	private Long id;
	
	@Column(name = "NOMBRE", length=60, nullable = false)
	private String nombre;
	
	@Column(name = "SINOPSIS", length=200, nullable = false)
	private String sinopsis;
	
	@Column(name = "GENERO", length=30, nullable = false)
	private String genero;
	
	@Column(name = "ESTADO", length=10, nullable = false)
	private String estado;
}
