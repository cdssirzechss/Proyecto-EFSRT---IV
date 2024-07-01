package EFSRT.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EFSRT.model.usuario;

public interface UsuarioRepositorio extends JpaRepository<usuario, Long> {

	public usuario findByEmail(String email);

	public List<usuario> findByRolNombre(String nombre);

}
