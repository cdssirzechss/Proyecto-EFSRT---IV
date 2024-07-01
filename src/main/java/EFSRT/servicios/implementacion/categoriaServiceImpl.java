package EFSRT.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import EFSRT.model.categoria;
import EFSRT.repositorio.categoriaRepositorio;
import EFSRT.servicios.categoriaService;

@Service
public class categoriaServiceImpl implements categoriaService{

	@Autowired
	private categoriaRepositorio cateRepo;

	@Override
	public List<categoria> ListarCategoria() {
		// TODO Auto-generated method stub
		return cateRepo.findAll();
	}

	@Override
	public categoria crearCategoria(categoria categoria) {
		// TODO Auto-generated method stub
		return cateRepo.save(categoria);
	}

	@Override
	public void eliminarCategoria(Long id) {
		cateRepo.deleteById(id);
	}

	@Override
	public categoria obtenerCategoria(Long id) {
		// TODO Auto-generated method stub
		return cateRepo.findById(id).orElseThrow(() -> new RuntimeException("categoria no encontrado con ID: " + id));
	}
	

	
}
