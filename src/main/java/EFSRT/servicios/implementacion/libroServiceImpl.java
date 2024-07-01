package EFSRT.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EFSRT.model.libro;
import EFSRT.repositorio.libroRepositorio;
import EFSRT.servicios.libroService;

@Service
public class libroServiceImpl implements libroService{

	@Autowired
	private libroRepositorio libroRepo;
	
	@Override
	public List<libro> ListarLibro() {
		// TODO Auto-generated method stub
		return libroRepo.findAll();
	}

	@Override
	public libro crearLibro(libro libro) {
		// TODO Auto-generated method stub
		return libroRepo.save(libro);
	}

	@Override
	public void eliminarLibro(Long id) {
		libroRepo.deleteById(id);
	}

	@Override
	public libro obtenerLibro(Long id) {
		// TODO Auto-generated method stub
		return libroRepo.findById(id).orElseThrow(() -> new RuntimeException("libro no encontrado con ID: " + id));
	}

	
	
}
