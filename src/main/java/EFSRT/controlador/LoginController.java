package EFSRT.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String Jefe_Prestamista(Authentication auth, Model modelo) {
		
		modelo.addAttribute("rol", auth.getAuthorities().toString());
		
		return "admin";
	}
	
}
