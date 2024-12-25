package ee.ken.auto.controller;

import ee.ken.auto.entity.Toiduaine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ToiduaineController {
    List<Toiduaine> toiduained = new ArrayList<>(Arrays.asList(
            new Toiduaine("Kartul", 1, 15, 2),
            new Toiduaine("Hapukoor", 10, 5, 15),
            new Toiduaine("Vorst", 5, 15, 12)
    ));

    @GetMapping("toiduained")
    public List<Toiduaine> saaToiduained(){
        return toiduained;
    }

    @PostMapping ("lisa-toiduained")
    public List<Toiduaine> lisaToiduained(@RequestBody Toiduaine toiduaine){
        toiduained.add(toiduaine);
        return toiduained;
    }

    @DeleteMapping("kustuta-toiduained/{index}")
    public List<Toiduaine> kustutaToiduained(@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }

    @PutMapping("toiduained/{index}")
    public List<Toiduaine> muudaToiduained(@PathVariable int index, @RequestBody Toiduaine toiduaine){
        toiduained.set(index, toiduaine);
        return toiduained;
    }

    @PatchMapping("toiduained/{index}") // Ühe väärtuse(objekti) muutmiseks
    public List<Toiduaine> muudaToiduained(@PathVariable int index) {
        toiduained.get(index).setValk(10);
        return toiduained;
    }
}
