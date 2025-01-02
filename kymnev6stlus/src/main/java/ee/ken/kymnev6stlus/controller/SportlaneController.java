package ee.ken.kymnev6stlus.controller;

import ee.ken.kymnev6stlus.entity.Sportlane;
import ee.ken.kymnev6stlus.repository.SportlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")

public class SportlaneController {

    @Autowired
    SportlaneRepository sportlaneRepository;

    @GetMapping("Sportlased")
    public Page<Sportlane> saaSportlased(Pageable pageable){
        return sportlaneRepository.findAll(pageable);
    }

    @PostMapping("Sportlased")
    public Page<Sportlane> lisaSportlane(@RequestBody Sportlane sportlane, Pageable pageable){
        sportlaneRepository.save(sportlane);
        return sportlaneRepository.findAll(pageable);
    }

    @DeleteMapping("Sportlased/{id}")
    public Page<Sportlane> kustutaSportlane(@PathVariable Long id, Pageable pageable){
        sportlaneRepository.deleteById(id);
        return sportlaneRepository.findAll(pageable);
    }
}
