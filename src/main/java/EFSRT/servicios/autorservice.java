package EFSRT.servicios;

import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import EFSRT.model.autor;

public interface autorservice {

	public List<autor> ListarAutores();
	
	public autor crearAutor(autor autor);
	
	public void eliminarAutor(Long id);

	public autor obtenerautor(Long id);
	
}
