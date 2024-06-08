package EFSRT.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "libro")
public class libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	private String titulo;
	
	@ManyToOne
    @JoinColumn(name = "editorial_id" , referencedColumnName = "id")
    private editorial editorial;
	
	@ManyToOne
    @JoinColumn(name = "categoria_id" , referencedColumnName = "id")
    private categoria categoria;
	
	@ManyToOne
    @JoinColumn(name = "autor_id" , referencedColumnName = "id")
    private autor autor;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "infoadicional_id" , referencedColumnName = "id")
    private InfoAdicional infoadicional;
	
}
