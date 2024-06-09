package EFSRT.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UsuarioDTO {
	
	private Long id;
	private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String dni;
    private String celular;
    private Long rol;
    private String distrito;
	private String ubicacion;
	
	public UsuarioDTO(String nombre, String apellido, String email, String password, String dni, String celular,
			Long rol, String distrito, String ubicacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.dni = dni;
		this.celular = celular;
		this.rol = rol;
		this.distrito = distrito;
		this.ubicacion = ubicacion;
	}

}
