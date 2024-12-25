package ee.ken.kymnev6stlus.controller;

import ee.ken.kymnev6stlus.entity.Tulemus;
import ee.ken.kymnev6stlus.repository.TulemusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class TulemusController {

    @Autowired
    TulemusRepository tulemusRepository;

    @GetMapping("Tulemused")
    public List<Tulemus> saaTulemus() {
        return tulemusRepository.findAll();
    }

    @PostMapping("Tulemused")
    public List<Tulemus> lisaTulemus(@RequestBody Tulemus tulemus){
        int punktid = (int) (tulemus.getSooritus() * 100); // Punktide osas peaks olema sügavam arvutustehe
        tulemus.setPunktid(punktid);
        tulemusRepository.save(tulemus);
        return tulemusRepository.findAll();
    }

    @DeleteMapping("Tulemused/{id}")
    public List<Tulemus> kustutaTulemus(@PathVariable Long id){
        tulemusRepository.deleteById(id);
        return tulemusRepository.findAll();
    }
    @GetMapping("LiidaPunktid") // On ununenud lisada!!!
    public int liidaPunktid(@RequestParam Long id) {
        int summa = 0;
        List<Tulemus> tulemused = tulemusRepository.findBySportlane_Id(id);
        for(Tulemus t: tulemused) {
            summa += t.getPunktid();
        }
        return summa;
    }

}
