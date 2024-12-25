package ee.ken.kymnev6stlus.controller;

import ee.ken.kymnev6stlus.entity.Skoor;
import ee.ken.kymnev6stlus.repository.SkoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class SkoorController {
    @Autowired
    SkoorRepository skoorRepository;

    @GetMapping("skoorid")
    public List<Skoor> getSkoor() {
        return skoorRepository.findAll();
    }
    @PostMapping("Skoorid")
    public List<Skoor> lisaSkoor(@RequestBody Skoor skoor) {
        skoorRepository.save(skoor);
        return skoorRepository.findAll();
    }
    @DeleteMapping("skoorid/{id}")
    public List<Skoor> kustutaSkoor(@PathVariable Long id) {
        skoorRepository.deleteById(id);
        return skoorRepository.findAll();
    }

}

