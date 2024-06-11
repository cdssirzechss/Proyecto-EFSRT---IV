package EFSRT.servicios;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import EFSRT.model.usuario;

public interface usuarioServicios extends UserDetailsService{
	
	public List<usuario>  listaporrol (String nombre); 
	
	public usuario obtenerusuarioporid(Long id);
	
	public void eliminar(Long id);

}
