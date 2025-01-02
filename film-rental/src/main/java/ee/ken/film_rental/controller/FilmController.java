package ee.ken.film_rental.controller;

import ee.ken.film_rental.entity.Film;
import ee.ken.film_rental.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class FilmController  {

    @Autowired
    FilmRepository filmRepository;
//TODO: Kui tüüp kirjutatakse valesti, on error, väiksed ja suured tähed ka looevad!!!
    @PostMapping("films")   //Front end peab saatma siia NAME ja TYPE--> ülejäänud kirjutatakse üle
    public Page<Film> addFilm (@RequestBody Film film, Pageable pageable) {  // Postmani või Front-endi body-sse
        film.setRental(null);
        film.setAvailable(true);
        film.setInitialRentDays(0);
        film.setFinalRentDays(0);
        filmRepository.save(film);
        return filmRepository.findAll(pageable);
    }

    @DeleteMapping("films/{id}")
    public Page<Film> deleteFilm(@PathVariable Long id, Pageable pageable ) { //Kui on PathVariable siis peab id üleval kirjas olema
        filmRepository.deleteById(id);
        return filmRepository.findAll(pageable);
    }
    // Ühe kindla mudeli välja muutmine. Siin on selleks type
    @PatchMapping("films")
    public Page<Film> patchFilm(@RequestParam Long id, String newType, Pageable pageable ) {  //-> ?id=1&newType= Uus tüüp
        Film film = filmRepository.findById(id).orElseThrow();
        film.setType(newType);
        filmRepository.save(film);
        return filmRepository.findAll(pageable);
    }

    @GetMapping("films")
    public Page<Film> allFilms(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    @GetMapping("available-films")
    public List<Film> allAvailableFilms() {
        List<Film> availableFilms = new ArrayList<>();
        for (Film film: filmRepository.findAll()) {
            if(film.isAvailable()){
                availableFilms.add(film);
            }
        }
        return availableFilms;
    }
}
