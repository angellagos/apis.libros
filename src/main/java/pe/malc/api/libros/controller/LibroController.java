package pe.malc.api.libros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.malc.api.libros.model.Libro;
import pe.malc.api.libros.service.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public List<Libro> findAll(){
		return libroService.findAll();
	}
	
	@GetMapping("/{id}")
	public Libro findById(@PathVariable Long id) {
		return libroService.findById(id);
	}
	
	@GetMapping("/list")
	public List<Libro> findByGenero(@RequestParam String genero) {
		return libroService.findByLikeGenero(genero);
	}
	
	@PostMapping
	public Libro post(@RequestBody Libro libro) {
		return libroService.save(libro);
	}
	
	@PutMapping("/{id}")
	public Libro put(@PathVariable Long id, @RequestBody Libro libro) {
		libro.setId(id);
		return libroService.save(libro);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		libroService.delete(Libro.builder().id(id).build());
	}
	
	@DeleteMapping("/logic/{id}")
	public void deleteLogic(@PathVariable Long id) {
		libroService.deleteLogic(Libro.builder().id(id).build());
	}
}
