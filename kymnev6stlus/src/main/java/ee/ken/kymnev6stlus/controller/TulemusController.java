package ee.ken.kymnev6stlus.controller;

import ee.ken.kymnev6stlus.entity.Tulemus;
import ee.ken.kymnev6stlus.repository.TulemusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class TulemusController {

    @Autowired
    TulemusRepository tulemusRepository;

    @GetMapping("Tulemused")
    public Page<Tulemus> saaTulemus(Pageable pageable) {
        return tulemusRepository.findAll(pageable);
    }

    @PostMapping("Tulemused")
    public Page<Tulemus> lisaTulemus(@RequestBody Tulemus tulemus, Pageable pageable){
        int punktid = (int) (tulemus.getSooritus() * 100); // Punktide osas peaks olema sügavam arvutustehe
        tulemus.setPunktid(punktid);
        tulemusRepository.save(tulemus);
        return tulemusRepository.findAll(pageable);
    }

    @DeleteMapping("Tulemused/{id}")
    public Page<Tulemus> kustutaTulemus(@PathVariable Long id, Pageable pageable){
        tulemusRepository.deleteById(id);
        return tulemusRepository.findAll(pageable);
    }
    @GetMapping("LiidaPunktid")
    public int liidaPunktid(@RequestParam Long id) {
        int summa = 0;
        List<Tulemus> tulemused = tulemusRepository.findBySportlane_Id(id);
        for(Tulemus t: tulemused) {
            summa += t.getPunktid();
        }
        return summa;
    }

}
