package EFSRT.servicios;

import java.util.List;

import EFSRT.model.editorial;
import EFSRT.model.libro;

public interface libroService {

	public List<libro> ListarLibro();

	public libro crearLibro(libro libro);

	public void eliminarLibro(Long id);

	public libro obtenerLibro(Long id);

}
