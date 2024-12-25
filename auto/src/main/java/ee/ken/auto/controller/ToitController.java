package ee.ken.auto.controller;

import ee.ken.auto.entity.Toiduaine;
import ee.ken.auto.entity.Toit;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ToitController {
    List<Toit> toidud = new ArrayList<>(Arrays.asList(
            new Toit("Kartulisalt", 500, new ArrayList<>(Arrays.asList("kartul", "Vorst", "Hapukoor", "Muna"))),
            new Toit("Vorstivõileib", 100, new ArrayList<>(Arrays.asList("Vorst", "Või", "Leib"))),
            new Toit("Praemuna", 250, new ArrayList<>(Arrays.asList("Muna", "Vorst", "Juust")))
    ));

    @GetMapping("Toit")
    public List<Toit> saaToidud(){
        return toidud;
    }

    @PostMapping("lisa-Toit")
    public List<Toit> lisaToidud(@RequestBody Toit toit) {
        toidud.add(toit);
        return toidud;
    }

    @DeleteMapping("kustuta-Toit/{index}")
    public List<Toit> kustutaToidud(@PathVariable int index) {
        toidud.remove(index);
        return toidud;
    }

    @PutMapping("Toit/{index}")
    public List<Toit> muudaToidud(@PathVariable int index, @RequestBody Toit toit) {
        toidud.set(index, toit);
        return toidud;
    }
    //TEISTELE KA ---> Kalkulaatori sisse /Autod/Töötajad
    @GetMapping("Toit/{index}")
    public Toit saaToit(@PathVariable int index) {
        Toit toit = toidud.get(index);
        return toit;
    }
}
