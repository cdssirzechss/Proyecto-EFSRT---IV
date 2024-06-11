package EFSRT.servicios.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EFSRT.model.rol;
import EFSRT.repositorio.rolRepositorio;
import EFSRT.servicios.rolService;

@Service
public class rolServiceImplement implements rolService{

	@Autowired
	private rolRepositorio rolrepo;
	
	@Override
	public rol buscarrolporid(Long id) {
		return rolrepo.findById(id).orElseThrow(() -> new RuntimeException("rol no encontrado con ID: " + id));
	}

}
