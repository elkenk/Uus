package ee.ken.film_rental.repository;

import ee.ken.film_rental.entity.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByIdOrderByNameAsc(Long id, Pageable pageable);

    List<Film> findByAvailableOrderByRental_IdAsc(boolean available, Pageable pageable);
}