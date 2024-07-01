package EFSRT.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EFSRT.model.autor;
import EFSRT.repositorio.autorRepositorio;
import EFSRT.servicios.autorservice;

@Service
public class autorserviceimpl implements autorservice{

	@Autowired
	private autorRepositorio autorRepo;
	
	@Override
	public List<autor> ListarAutores() {
		return autorRepo.findAll();
	}

	@Override
	public autor crearAutor(autor autor) {
		return autorRepo.save(autor);
	}

	@Override
	public void eliminarAutor(Long id) {
		autorRepo.deleteById(id);
	}

	@Override
	public autor obtenerautor(Long id) {
		return autorRepo.findById(id).orElseThrow(() -> new RuntimeException("usuario no encontrado con ID: " + id));
	}

}
