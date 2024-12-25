package ee.ken.film_rental.repository;

import ee.ken.film_rental.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}