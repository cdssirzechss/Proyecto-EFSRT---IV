package EFSRT.servicios;

import java.util.List;

import EFSRT.model.editorial;

public interface editorialService {
	
	public List<editorial> ListarEditorial();
	
	public editorial crearEditorial(editorial editorial);
	
	public void eliminarEditorial(Long id);

	public editorial obtenerEditorial(Long id);

}
