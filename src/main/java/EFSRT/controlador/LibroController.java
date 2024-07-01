package EFSRT.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import EFSRT.model.editorial;
import EFSRT.model.libro;
import EFSRT.servicios.autorservice;
import EFSRT.servicios.categoriaService;
import EFSRT.servicios.editorialService;
import EFSRT.servicios.libroService;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private libroService libroServi;
	
	@Autowired
	private categoriaService cateServi;
	
	@Autowired
	private autorservice autorServi;
	
	@Autowired
	private editorialService editorialServi;
	
	@ModelAttribute("libro")
	public libro modelolibro() {
		return new libro();
	}
	
	@GetMapping("/lista")
	public String Lista(Model model) {
		
		model.addAttribute("listalibro", libroServi.ListarLibro());
		return "listaLibro";
	}
	
	@GetMapping("/registro")
	public String MuestraRegistra(Model model) {
		
		model.addAttribute("listaautor", autorServi.ListarAutores());
		model.addAttribute("listacategoria", cateServi.ListarCategoria());
		model.addAttribute("listaeditorial", editorialServi.ListarEditorial());
		
		return "registroLibro";
	}
	
	@PostMapping("/registro")
	public String MuestraRegistroAutor(@ModelAttribute("libro") libro libro) {
		libroServi.crearLibro(libro);
		return "redirect:/libro/lista?exito";
		
	}
	
	@GetMapping("/{id}/editar")
	public String MuestraEdicion(@PathVariable Long id, Model model) {
		libro libro = libroServi.obtenerLibro(id);
		
		model.addAttribute("listaautor", autorServi.ListarAutores());
		model.addAttribute("listacategoria", cateServi.ListarCategoria());
		model.addAttribute("listaeditorial", editorialServi.ListarEditorial());
		
		model.addAttribute("editar", (boolean) true);
		model.addAttribute("libro", libro);
		return "registroLibro";
		
	}
	
	@PostMapping("{id}/eliminar")
	public String Eliminar(@PathVariable Long id) {
		libroServi.eliminarLibro(id);
		return "redirect:/libro/lista?eliminar";
		
	}

}
