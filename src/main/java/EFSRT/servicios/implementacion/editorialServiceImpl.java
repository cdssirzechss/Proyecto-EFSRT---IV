package EFSRT.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EFSRT.model.editorial;
import EFSRT.repositorio.editorialRepositorio;
import EFSRT.servicios.editorialService;

@Service
public class editorialServiceImpl implements editorialService{

	@Autowired
	private editorialRepositorio ediRepo;
	
	@Override
	public List<editorial> ListarEditorial() {
		return ediRepo.findAll();
	}

	@Override
	public editorial crearEditorial(editorial editorial) {
		return ediRepo.save(editorial);
	}

	@Override
	public void eliminarEditorial(Long id) {
		ediRepo.deleteById(id);
	}

	@Override
	public editorial obtenerEditorial(Long id) {
		return ediRepo.findById(id).orElseThrow(() -> new RuntimeException("editorial no encontrado con ID: " + id));
	}

}
