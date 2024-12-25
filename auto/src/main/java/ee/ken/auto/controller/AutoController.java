package ee.ken.auto.controller;

import ee.ken.auto.entity.Auto;
import org.springframework.web.bind.annotation.*;
import java.time.Year;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class AutoController {
    List<Auto> autod = new ArrayList<>(Arrays.asList(
            new Auto("Skoda", "Superb", 2016, 18500),
            new Auto("Kia", "Stnger", 2020, 45000),
            new Auto("Toyota", "Supra", 1994, 74000),
            new Auto("Nissan", "Gtr", 2011, 40000),
            new Auto("Vw", "Passat", 1991, 600),
            new Auto("Ford", "Sierra", 1988, 1500)
    ));

    @GetMapping("Auto")
    public List<Auto> saaAutod() {
        return autod;
    }

    @PostMapping("lisa-Auto")
    public List<Auto> lisaAuto(@RequestBody Auto auto){
        autod.add(auto);
        return autod;
    }

    @DeleteMapping("kustuta-auto/{index}")
    public List<Auto> kustutaAuto(@PathVariable int index){
        autod.remove(index);
        return autod;
    }

    @GetMapping("/keskmine-Auto-Vanus")
    public double keskmineAutoVanus() {
        int currentYear = Year.now().getValue();
        double summa = 0;
        for(Auto t: autod) {
            int vanus = currentYear - t.getYear();
            summa += vanus;
        }
        return summa/ autod.size();
    }

    @GetMapping("/autod-vanus-kasvavalt")
    public List<Auto> autodVanusKasvavalt() {
        autod.sort(Comparator.comparing(Auto::getYear));
        return autod;
    }

    @GetMapping("keskmine-hind")
    public double keskmineHind() {
        double summa = 0;
        for(Auto t: autod) {
            summa = summa + t.getPrice();
        }
        return summa/autod.size();
    }

    @GetMapping("/autod-hind-kasvavalt")
    public List<Auto> autodHindKasvavalt() {
        autod.sort(Comparator.comparing(Auto::getPrice));
        return autod;
    }

    @GetMapping("hind-alla-40k")
    public List<Auto> hindAlla40k() {
        return autod.stream()
                .filter(auto -> auto.getPrice() <= 40000)
                .collect(Collectors.toList());
    }

    @GetMapping("make-az")
    public List<Auto> makeAZ() {
        autod.sort(Comparator.comparing(Auto::getMake));
        return autod;
    }

    @GetMapping("model-az")
    public List<Auto> modelAZ() {
        autod.sort(Comparator.comparing(Auto::getModel));
        return autod;
    }

}
