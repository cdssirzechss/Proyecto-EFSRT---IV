package EFSRT.servicios;

import java.util.List;

import EFSRT.model.categoria;

public interface categoriaService {
	
	public List<categoria> ListarCategoria();
	
	public categoria crearCategoria(categoria categoria);
	
	public void eliminarCategoria(Long id);

	public categoria obtenerCategoria(Long id);


}
