package EFSRT.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import EFSRT.model.autor;
import EFSRT.servicios.autorservice;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private autorservice autoServi;
	
	@ModelAttribute("autor")
	public autor modeloautor() {
		return new autor();
	}
	
	@GetMapping("/lista")
	public String ListaUsuario(Model model) {
		
		model.addAttribute("listaautor", autoServi.ListarAutores());
		return "ListaAutores";
	}
	
	@GetMapping("/registro")
	public String MuestraRegistroAutor() {
		
		return "registroautor";
	}
	
	@PostMapping("/registro")
	public String MuestraRegistroAutor(@ModelAttribute("autor") autor autor) {
		autoServi.crearAutor(autor);
		return "redirect:/autor/lista?exito";
		
	}
	
	@GetMapping("/{id}/editar")
	public String MuestraEdicion(@PathVariable Long id, Model model) {
		autor autor = autoServi.obtenerautor(id);
		model.addAttribute("editar", (boolean) true);
		model.addAttribute("autor", autor);
		return "registroautor";
		
	}
	
	@PostMapping("{id}/eliminar")
	public String Eliminar(@PathVariable Long id) {
		autoServi.eliminarAutor(id);
		return "redirect:/autor/lista?eliminar";
		
	}
	
}
