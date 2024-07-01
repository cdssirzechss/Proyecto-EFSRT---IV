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
import EFSRT.model.editorial;
import EFSRT.servicios.autorservice;
import EFSRT.servicios.implementacion.editorialServiceImpl;

@Controller
@RequestMapping("/editorial")
public class EditorialController {


	@Autowired
	private editorialServiceImpl ediServi;
	
	@ModelAttribute("editorial")
	public editorial modeloeditorial() {
		return new editorial();
	}
	
	@GetMapping("/lista")
	public String ListaUsuario(Model model) {
		
		model.addAttribute("listaeditorial", ediServi.ListarEditorial());
		return "ListaEditorial";
	}
	
	@GetMapping("/registro")
	public String MuestraRegistroAutor() {
		
		return "registroEditorial";
	}
	
	@PostMapping("/registro")
	public String MuestraRegistroAutor(@ModelAttribute("editorial") editorial editorial) {
		ediServi.crearEditorial(editorial);
		return "redirect:/editorial/lista?exito";
		
	}
	
	@GetMapping("/{id}/editar")
	public String MuestraEdicion(@PathVariable Long id, Model model) {
		editorial editorial = ediServi.obtenerEditorial(id);
		model.addAttribute("editar", (boolean) true);
		model.addAttribute("editorial", editorial);
		return "registroEditorial";
		
	}
	
	@PostMapping("{id}/eliminar")
	public String Eliminar(@PathVariable Long id) {
		ediServi.eliminarEditorial(id);
		return "redirect:/editorial/lista?eliminar";
		
	}
	
}
