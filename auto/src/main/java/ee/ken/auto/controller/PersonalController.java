package ee.ken.auto.controller;

import ee.ken.auto.entity.Personal;
import org.springframework.web.bind.annotation.*;
import java.time.Year;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class PersonalController {
    List<Personal> person = new ArrayList<>(Arrays.asList(
            new Personal("Maizi", "Pulgad", 45, "Puiga"),
            new Personal("Tee", "Peet", 37, "Haapsalu"),
            new Personal("Sviit", "Hõum", 22, "Pärnu"),
            new Personal("Jüri", "ÖÖ", 96, "Olustvere"),
            new Personal("Haimar", "Link", 78, "Lasnamägi"),
            new Personal("Rootsi", "Kunn", 72, "Stockholm"),
            new Personal("Kolju", "Murru", 33, "Rummu"),
            new Personal("Dmitri", "Kida", 43, "Narva"),
            new Personal("Kasepats", "Pidur", 18, "Pärnu"),
            new Personal("Alev", "Ström", 48, "Stockholm"),
            new Personal("Maamees", "Jaanes", 56, "Haapsalu"),
            new Personal("Taevoo", "Tiko", 27, "Pärnu"),
            new Personal("Poeezia", "Komissaarova", 51, "Narva")
    ));

    @GetMapping("Personal")
    public List<Personal> saaPersonal(){
        return person;
    }

    @PostMapping("lisa-Personal")
    public List<Personal> lisaPersonal(@RequestBody Personal personal){
        person.add(personal);
        return person;
    }

    @DeleteMapping("kustuta-Personal/{index}")
    public List<Personal> kustutaPersonal(@PathVariable int index){
        person.remove(index);
        return person;
    }

    @GetMapping("keskmine-vanus")
    public double keskmineVanus() {
        double summa = 0;
        for(Personal t: person) {
            summa = summa + t.getVanus();
        }
        return summa/person.size();
    }

    @GetMapping("vanus-kasvavalt")
    public List<Personal> vanusKasvavalt() {
        person.sort(Comparator.comparing(Personal::getVanus));
        return person;
    }

    @GetMapping("sellest-linnast") //Ei tööta, koduste käigus üle vaadata!
    public List<Personal> sellestLinnast(@PathVariable String elukoht) {
    return person.stream()
            .filter(p -> p.getElukoht().equalsIgnoreCase(elukoht))
            .collect(Collectors.toList());
    }

    @GetMapping("eesnimi-az")
    public List<Personal> eesnimiAZ() {
        person.sort(Comparator.comparing(Personal::getEesnimi));
        return person;
    }

    @GetMapping("perenimi-az")
    public List<Personal> perenimiAZ() {
        person.sort(Comparator.comparing(Personal::getPerenimi));
        return person;
    }

}
