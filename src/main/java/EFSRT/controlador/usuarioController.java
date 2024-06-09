package EFSRT.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import EFSRT.model.dto.UsuarioDTO;
import EFSRT.repositorio.UsuarioRepositorio;
import EFSRT.servicios.implementacion.usuarioServiciosImple;

@Controller
@RequestMapping("/usuario")
public class usuarioController {
	
	@Autowired
	public usuarioServiciosImple usuServi;
	
	@ModelAttribute("usuarioDTO")
	public UsuarioDTO modelo() {
		return new UsuarioDTO();
	}
	
	@GetMapping("/lista")
	public String ListaUsuario(Authentication auth,  Model model) {
		
		model.addAttribute("listausu", usuServi.listaporrol("usuario"));
		
		return "ListaUsuario";
	}
	
}
