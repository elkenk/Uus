package ee.ken.kymnev6stlus.controller;

import ee.ken.kymnev6stlus.entity.Sportlane;
import ee.ken.kymnev6stlus.repository.SportlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")

public class SportlaneController {

    @Autowired
    SportlaneRepository sportlaneRepository;

    @GetMapping("Sportlased")
    public List<Sportlane> saaSportlased(){
        return sportlaneRepository.findAll();
    }

    @PostMapping("Sportlased")
    public List<Sportlane> lisaSportlane(@RequestBody Sportlane sportlane){
        sportlaneRepository.save(sportlane);
        return sportlaneRepository.findAll();
    }

    @DeleteMapping("Sportlased/{id}")
    public List<Sportlane> kustutaSportlane(@PathVariable Long id){
        sportlaneRepository.deleteById(id);
        return sportlaneRepository.findAll();
    }
}
