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
import EFSRT.model.categoria;
import EFSRT.servicios.categoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private categoriaService cateServi;
	
	@ModelAttribute("categoria")
	public categoria modeloautor() {
		return new categoria();
	}
	
	@GetMapping("/lista")
	public String ListaUsuario(Model model) {
		
		model.addAttribute("listacate", cateServi.ListarCategoria());
		return "ListaCategoria";
	}
	
	@GetMapping("/registro")
	public String MuestraRegistroAutor() {
		
		return "registroCategoria";
	}
	
	@PostMapping("/registro")
	public String MuestraRegistroAutor(@ModelAttribute("categoria") categoria categoria) {
		cateServi.crearCategoria(categoria);
		return "redirect:/categoria/lista?exito";
		
	}
	
	@GetMapping("/{id}/editar")
	public String MuestraEdicion(@PathVariable Long id, Model model) {
		categoria categoria = cateServi.obtenerCategoria(id);
		model.addAttribute("editar", (boolean) true);
		model.addAttribute("categoria", categoria);
		return "registroCategoria";
		
	}
	
	@PostMapping("{id}/eliminar")
	public String Eliminar(@PathVariable Long id) {
		cateServi.eliminarCategoria(id);
		return "redirect:/categoria/lista?eliminar";
		
	}
	
}
