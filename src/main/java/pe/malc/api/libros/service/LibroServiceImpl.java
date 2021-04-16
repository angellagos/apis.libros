package pe.malc.api.libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.malc.api.libros.model.Libro;
import pe.malc.api.libros.repository.LibroRepository;

@Transactional
@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAllCustom();
	}

	@Override
	public Libro save(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}

	@Override
	public Libro findById(Long id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id).orElse(null);
	}

	@Override
	public List<Libro> findByLikeGenero(String genero) {
		// TODO Auto-generated method stub
		genero = "%" + ((genero==null)?"":genero) + "%";
		return libroRepository.findByLikeGenero(genero);
	}

	@Override
	public void delete(Libro libro) {
		// TODO Auto-generated method stub
		libroRepository.delete(libro);
	}

	@Override
	public void deleteLogic(Libro libro) {
		// TODO Auto-generated method stub
		Libro oLibro = libroRepository.findById(libro.getId()).orElse(null);
		if (oLibro != null) {
			oLibro.setEstado("0");
			libroRepository.save(oLibro);
		}
	}

}
