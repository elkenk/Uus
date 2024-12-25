package ee.ken.film_rental.service;

import ee.ken.film_rental.entity.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Et saaks teha @Autowired

public class RentalService { // Abiline klass kuhu saab Controllerist funkstioone välja tõsta.

    int bonusPoints = 0;

    public int calculateSum(Film film) {
        int basic_price = 3;
        int premium_price = 4;
        int sum = 0; //See on algselt o kuid järjest suurendame
//        for (Film film : films) {
        switch (film.getType()) {
            // 6 päeva 3 + 3*1 = 6
            case "Old" -> {
                if (film.getInitialRentDays() <= 5) {
                    sum = sum + basic_price;
                } else {    // esimesed 5           ülejäänud päevad
                    sum = sum + basic_price + basic_price * (film.getInitialRentDays() - 5);
                }
            }
            // 6 päeva 3 + 3 * 3 = 12
            case "Regular" -> {
                if (film.getInitialRentDays() <= 3) {
                    sum = sum + basic_price;
                } else {
                    sum = sum + basic_price + basic_price * (film.getInitialRentDays() - 3);
                }
            }
            //6 päeva 6 * 4 = 24
            case "New" -> sum = sum + film.getInitialRentDays() * premium_price;
        }
        // }
        return sum;
    }

    public void addBonusPoints(String filmType) {
        switch (filmType) {
            case "New" -> bonusPoints += 2;
            case "Regular", "Old" -> bonusPoints +=1;
        }
    }

    public int calculateBonus(List<Film> films) {
        if (!films.isEmpty()) {
            String type = films.get(0).getType();
            return switch (type) {
                case "New" -> 4;
                case "Old", "Regular" -> 3;
                default -> 3;
            };
        }
        return 3;
    }

    public int calculateLateFee(Film film, int rentDays) {
        if (film.getType().equals("New")) {
            return (rentDays - film.getInitialRentDays()) * 4;
        } else if (film.getType().equals("Old") || film.getType().equals("Regular")) {
            return  (rentDays - film.getInitialRentDays()) * 3;
        } else {
            return 0;
        }
    }
    public int bonusPayment(List<Film> films, int sum) {
        if (bonusPoints >= 25) {
            int bonus_price = calculateBonus(films);
            sum -= bonus_price;
            bonusPoints -= 25;
        }
        return sum;
    }
}


