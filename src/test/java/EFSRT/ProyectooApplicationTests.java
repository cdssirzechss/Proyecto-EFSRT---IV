package EFSRT;

import EFSRT.model.rol;
import EFSRT.model.ubigeo;
import EFSRT.model.usuario;
import EFSRT.repositorio.*;
import EFSRT.security.SecurityConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ProyectooApplicationTests {

	SecurityConfiguration secu = new SecurityConfiguration();
	
	@Autowired
	private rolRepositorio rolRepositorio;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Test
	void IngresarValores() {
		
		rol rol1 = rolRepositorio.save(new rol("admin"));
		rol rol2 = rolRepositorio.save(new rol("usuario"));
		
		usuario usuario = new usuario();
		usuario.setNombre("Jhordan");
		usuario.setApellido("Via Pese");
		usuario.setEmail("admin@gmail.com");
		usuario.setPassword(secu.passwordEncoder().encode("admin"));
		usuario.setDni("13245645");
		usuario.setCelular("132456798");
		usuario.setRol(rol1);
		
		ubigeo ubi = new ubigeo();
		ubi.setDistrito("Lima");
		ubi.setUbicacion("En mi casa");
		usuario.setUbigeo(ubi);
		
		usuarioRepositorio.save(usuario);
		
		usuario usuario1 = new usuario();
		usuario1.setNombre("Jhordan");
		usuario1.setApellido("Via Pese");
		usuario1.setEmail("usuario@gmail.com");
		usuario1.setPassword(secu.passwordEncoder().encode("usuario"));
		usuario1.setDni("13245645");
		usuario1.setCelular("132456798");
		usuario1.setRol(rol2);
		
		ubigeo ubi2 = new ubigeo();
		ubi2.setDistrito("Lima");
		ubi2.setUbicacion("En mi casa");
		usuario1.setUbigeo(ubi2);
		
		usuarioRepositorio.save(usuario1);
		
	}

}
