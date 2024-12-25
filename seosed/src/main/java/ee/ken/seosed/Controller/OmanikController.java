package ee.ken.seosed.Controller;


import ee.ken.seosed.Repository.OmanikRepository;
import ee.ken.seosed.entity.Omanik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class OmanikController {
    @Autowired
    OmanikRepository omanikRepository;

    @GetMapping("omanikud")
    public List<Omanik> getOmanikud() {
        return omanikRepository.findAll();
    }
    @PostMapping("omanikud")
    public List<Omanik> lisaOmanikud(@RequestBody Omanik omanik) {
        omanikRepository.save(omanik);
        return omanikRepository.findAll();
    }
    @DeleteMapping("omanikud/{id}")
    public List<Omanik> kustutaOmanik(@PathVariable Long id) {
        omanikRepository.deleteById(id);
        return omanikRepository.findAll();
    }
}
