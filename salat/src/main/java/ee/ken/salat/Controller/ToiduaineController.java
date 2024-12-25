package ee.ken.salat.Controller;

import ee.ken.salat.entity.Toiduaine;
import ee.ken.salat.repository.ToiduaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ToiduaineController {

    //Hiljem võtame andmebaasist
//    List<Toiduaine> toiduained = new ArrayList<>(Arrays.asList(
//            new Toiduaine("Kartul", 1, 15, 2),
//            new Toiduaine("Hapukoor", 10, 5, 15),
//            new Toiduaine("Vorst", 5, 15, 12)
//    ));
    @Autowired
    ToiduaineRepository toiduaineRepository;
//    private final ToiduaineRepository toiduaineRepository;   <-- Teeb sama asja kui üleval Autowired, aga pikemalt
//
//    public ToiduaineController(ToiduaineRepository toiduaineRepository) {
//        this.toiduaineRepository = toiduaineRepository;
//    }

    @GetMapping("toiduained")
    public List<Toiduaine> saaToiduained(){
        return toiduaineRepository.findAll();
    }

    @PostMapping ("toiduained")
    public List<Toiduaine> lisaToiduained(@RequestBody Toiduaine toiduaine){
//        toiduained.add(toiduaine);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{name}")
    public List<Toiduaine> kustutaToiduained(@PathVariable String name){
//        toiduained.remove(index);
        toiduaineRepository.deleteById(name);
        return toiduaineRepository.findAll();
    }

    @PutMapping("toiduained") //Muudab millist- Body sees peaks olema õige ID
    public List<Toiduaine> muudaToiduained(@RequestBody Toiduaine toiduaine){
       toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @PatchMapping("toiduained/{name}") // Ühe väärtuse(objekti) muutmiseks
    public List<Toiduaine> muudaToiduained(@PathVariable String name) {
        Toiduaine toiduaine = toiduaineRepository.findById(name).get();
        toiduaine.setValk(10);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
        }
    }
