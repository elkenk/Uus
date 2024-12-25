package ee.ken.salat.Controller;

import ee.ken.salat.entity.Toiduaine;
import ee.ken.salat.entity.Toit;
import ee.ken.salat.repository.ToitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ToitController {

//    List<Toit> toidud = new ArrayList<>(Arrays.asList(
//            new Toit("Kartulisalt", 500, new ArrayList<>(Arrays.asList("kartul", "Vorst", "Hapukoor", "Muna"))),
//            new Toit("Vorstivõileib", 100, new ArrayList<>(Arrays.asList("Vorst", "Või", "Leib"))),
//            new Toit("Praemuna", 250, new ArrayList<>(Arrays.asList("Muna", "Vorst", "Juust")))
//    ));
    @Autowired
    ToitRepository toitRepository;

    @GetMapping("Toit")
    public List<Toit> saaToidud(){
        return toitRepository.findAll();
    }

    @PostMapping("Toit")
    public List<Toit> lisaToidud(@RequestBody Toit toit) {
        toitRepository.save(toit);
        return toitRepository.findAll();
    }

    @DeleteMapping("Toit/{name}")
    public List<Toit> kustutaToidud(@PathVariable String name) {
        toitRepository.deleteById(name);
        return toitRepository.findAll();
    }

    @PutMapping("Toit")
    public List<Toit> muudaToidud(@RequestBody Toit toit) {
        toitRepository.save(toit);
        return toitRepository.findAll();
    }
//TEISTELE KA ---> Kalkulaatori sisse /Autod/Töötajad
    @GetMapping("Toit/{name}")
    public Toit saaToit(@PathVariable String name) {
        return toitRepository.findById(name).get();
    }

}
