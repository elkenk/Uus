package ee.ken.kymnev6stlus.controller;

import ee.ken.kymnev6stlus.entity.Kaart;
import ee.ken.kymnev6stlus.entity.SkoorElud;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")

public class KaardiMang {

    public List<Kaart> kaardid = new ArrayList<>(Arrays.asList(
            new Kaart("Ruutu", "kaks", 2), new Kaart("Ruutu", "kolm", 3), new Kaart("Ruutu", "neli", 4),
            new Kaart("Ruutu", "viis", 5), new Kaart("Ruutu", "kuus", 6), new Kaart("Ruutu", "seitse", 7),
            new Kaart("Ruutu", "kaheksa", 8), new Kaart("Ruutu", "yheksa", 9), new Kaart("Ruutu", "kymme", 10),
            new Kaart("Ruutu", "poiss", 10), new Kaart("Ruutu", "emand", 10), new Kaart("Ruutu", "kuningas", 10),
            new Kaart("Ruutu", "2ss", 10),
            new Kaart("Risti", "kaks", 2), new Kaart("Risti", "kolm", 3), new Kaart("Risti", "neli", 4),
            new Kaart("Risti", "viis", 5), new Kaart("Risti", "kuus", 6), new Kaart("Risti", "seitse", 7),
            new Kaart("Risti", "kaheksa", 8), new Kaart("Risti", "yheksa", 9), new Kaart("Risti", "kymme", 10),
            new Kaart("Risti", "poiss", 10), new Kaart("Risti", "emand", 10), new Kaart("Risti", "kuningas", 10),
            new Kaart("Risti", "2ss", 10),
            new Kaart("2rtu", "kaks", 2), new Kaart("2rtu", "kolm", 3), new Kaart("2rtu", "neli", 4),
            new Kaart("2rtu", "viis", 5), new Kaart("2rtu", "kuus", 6), new Kaart("2rtu", "seitse", 7),
            new Kaart("2rtu", "kaheksa", 8), new Kaart("2rtu", "yheksa", 9), new Kaart("2rtu", "kymme", 10),
            new Kaart("2rtu", "poiss", 10), new Kaart("2rtu", "emand", 10), new Kaart("2rtu", "kuningas", 10),
            new Kaart("2rtu", "2ss", 10),
            new Kaart("Poti", "kaks", 2), new Kaart("Poti", "kolm", 3), new Kaart("Poti", "neli", 4),
            new Kaart("Poti", "viis", 5), new Kaart("Poti", "kuus", 6), new Kaart("Poti", "seitse", 7),
            new Kaart("Poti", "kaheksa", 8), new Kaart("Poti", "yheksa", 9), new Kaart("Poti", "kymme", 10),
            new Kaart("Poti", "poiss", 10), new Kaart("Poti", "emand", 10), new Kaart("Poti", "kuningas", 10),
            new Kaart("Poti", "2ss", 10)//Otsin siia kuidas saab lihtsama ja ilusama rivi teha, ja lühemalt!

    ));
    Kaart kaart;
    int elud = 3;
    int skoor = 0;

    @GetMapping("alusta")
    public Kaart Alusta() {
        int juhuslikNumber = (int) (Math.random() * kaardid.size());
        kaart = kaardid.get(juhuslikNumber);
        elud = 3;
        skoor = 0;
        return kaart;
    }

    @GetMapping("vordle-kaarte/{guess}")
    public String vordleKaarte(@PathVariable String guess) {
        if (elud == 0) {
            return "Elud on otsas!";
        }
        int juhuslikNumber = (int) (Math.random() * kaardid.size());
        Kaart uusKaart = kaardid.get(juhuslikNumber);

        if (uusKaart.getVaartus() < kaart.getVaartus() && guess.equals("less")) {
            kaart = uusKaart;
            skoor++;
            return "Õige";
        }
        if (uusKaart.getVaartus() == kaart.getVaartus() && guess.equals("same")) {
            kaart = uusKaart;
            skoor++;
            return "Õige";
        }
        if (uusKaart.getVaartus() > kaart.getVaartus() && guess.equals("more")) {
            kaart = uusKaart;
            skoor++;
            return "Õige";
        }
        kaart = uusKaart;
        elud --;
        return "Vale";
    }

    @GetMapping("mangi-uuesti")
    public Kaart mangiUuesti() {
        return kaart;
    }
    @GetMapping("skoor-ja-elud")
    public SkoorElud saaSkoorJaElud() {
        return new SkoorElud(skoor, elud);
    }

}


