package EFSRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
@Entity
@Table(name = "usuario")
public class usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email" , unique = true)
    private String email;
    
    @Column(name = "password")
    private String password;

    @Column(name = "dni")
    private String dni;
    
    @Column(name = "celular")
    private String celular;
    
    @ManyToOne
    @JoinColumn(name = "rol_id" , referencedColumnName = "id")
    private rol rol;
	
}
