package ee.ken.film_rental.controller;

import ee.ken.film_rental.entity.Film;
import ee.ken.film_rental.entity.Rental;
import ee.ken.film_rental.repository.FilmRepository;
import ee.ken.film_rental.repository.RentalRepository;
import ee.ken.film_rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RentalController {

     //Kodus tegemiseks.

    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    FilmRepository filmRepository; // Saab @Autowired teha kui klassil : extends JpaRepository
    @Autowired
    RentalService rentalService; //Saab @Autowired teha kuin on klassil @Service

    // Controlleris võiksid olla ainult @Mapping funktsioonid!!!

    @PostMapping("start-rental") // Tuleb panna list filmidest, ID ja INITIALRENRDAYS igale ühele
    public List<Rental> startRental(@RequestBody List<Film> films) {
        for (Film film : films) {
            Film dbFilm = filmRepository.findById(film.getId()).orElseThrow();
            if (!dbFilm.isAvailable()){
                return rentalRepository.findAll();
            }
        }
        Rental rental = new Rental();
        rental.setStartDate(new Date()); // Lisamise aegne kuupäev ja kellaaeg
        rental.setLastChangeDate(null);
        rental.setLateFee(0);
        //rental.setSum(calculateSum(films));
        int sum = 0;
        Rental rentalWithId = rentalRepository.save(rental); //Peale andmebaasi salvestust tekib sellele klassile ID

        for(Film film: films) {
            Film dbFilm = filmRepository.findById(film.getId()).orElseThrow();
            film.setName(dbFilm.getName()); // Võib front endist saata nime, aga sellel pole mõtel, kirjutab üle.
            film.setType(dbFilm.getType()); //                   --//--
            film.setInitialRentDays(film.getInitialRentDays()); // Selle võtan front-endist. sealt tuleb see + ID
            film.setFinalRentDays(0);       // see tuleb ka panna, muidu äkki front-endis sisestakse muu arv(aga andmebaasisi juba on 0)
            film.setAvailable(false);       // Muudan
            film.setRental(rentalWithId);    // Muudan
            sum = sum + rentalService.calculateSum(film);
            rentalService.addBonusPoints(film.getType());
            filmRepository.save(film);      // Tehakse .save() aga tegelikult teeb update-i
        }
            sum = rentalService.bonusPayment(films, sum);
            rental.setSum(sum);
             rentalRepository.save(rental);

        return rentalRepository.findAll();
    }

    @PostMapping("end-rental") // Localhost:8080/end-rental?filmId=4&rentDays=10
    public List<Rental> endRental(@RequestParam Long filmId, int rentDays) {
        Film film = filmRepository.findById(filmId).get();
        // film.setFinalRentDays(rentDays);

        Rental rental = rentalRepository.findById(film.getRental().getId()).get();
        rental.setLastChangeDate(new Date());
        if (rentDays > film.getInitialRentDays()) {
            //siis tuleb arvutada late-fee
            rental.setLateFee(rental.getLateFee() + rentalService.calculateLateFee(film, rentDays));
        }
        film.setInitialRentDays(0);
        film.setAvailable(true);
        film.setRental(null);
        filmRepository.save(film);
        rentalRepository.save(rental);

        return rentalRepository.findAll();
    }
}