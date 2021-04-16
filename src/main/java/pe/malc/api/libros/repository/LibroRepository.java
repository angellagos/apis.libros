package pe.malc.api.libros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.malc.api.libros.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

	@Query("Select p from Libro p where p.estado='1'")
	List<Libro> findAllCustom();
	
	@Query("Select p from Libro p where upper(p.genero) like upper(:genero)")
	List<Libro> findByLikeGenero(@Param("genero") String genero);
}
