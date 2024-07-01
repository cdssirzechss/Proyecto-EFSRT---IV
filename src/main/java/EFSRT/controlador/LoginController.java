package EFSRT.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import EFSRT.model.rol;
import EFSRT.model.usuario;
import EFSRT.servicios.implementacion.rolServiceImplement;
import EFSRT.servicios.implementacion.usuarioServiciosImple;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
		
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Authentication auth,  Model modelo) {
		
		for (GrantedAuthority authority : auth.getAuthorities()) {
            if (authority.getAuthority().equals("admin")) {
                return "redirect:/admin";
            } else if (authority.getAuthority().equals("usuario")) {
                return "redirect:/usuario";
            } 
        }
		
		modelo.addAttribute("rol", auth.getAuthorities().toString());
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin_vista(Authentication auth, Model modelo) {
		
		modelo.addAttribute("rol", auth.getAuthorities().toString());
		
		return "admin";
	}
	
	@GetMapping("/usuario")
	public String usuario_vista(Authentication auth, Model modelo) {
		
		modelo.addAttribute("rol", auth.getAuthorities().toString());
		
		return "index";
	}
	
}
