package ee.ken.kymnev6stlus.controller;

import ee.ken.kymnev6stlus.entity.Mangija;
import ee.ken.kymnev6stlus.repository.MangijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class MangijaController {
    @Autowired
    MangijaRepository mangijaRepository;

    @GetMapping("mangijad")
    public List<Mangija> getMangijad() {
        return mangijaRepository.findAll();
    }
    @PostMapping("mangijad")
    public List<Mangija> lisaMangija(@RequestBody Mangija mangija) {
        mangijaRepository.save(mangija);
        return mangijaRepository.findAll();
    }
    @DeleteMapping("mangijad/{id}")
    public List<Mangija> kustutaMangija(@PathVariable Long id) {
        mangijaRepository.deleteById(id);
        return mangijaRepository.findAll();
    }
}
