package pe.malc.api.libros.service;

import java.util.List;


import pe.malc.api.libros.model.Libro;

public interface LibroService {

	List<Libro> findAll();
	
	Libro findById(Long id);
	
	
	List<Libro> findByLikeGenero(String genero);
	
	Libro save(Libro libro);
	
	void delete(Libro libro);
	
	void deleteLogic(Libro libro);
}
