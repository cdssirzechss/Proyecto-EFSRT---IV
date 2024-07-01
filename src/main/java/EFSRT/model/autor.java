package EFSRT.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "autor")
public class autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechanacimiento;
	
	private String nacionalidad;
	
	@Column(nullable = true)
	private String biografia;
	
	public autor(String nombre, String apellido, LocalDate fechanacimiento, String nacionalidad, String biografia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nacionalidad = nacionalidad;
		this.biografia = biografia;
	}	

}
