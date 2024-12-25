package ee.ken.salat.Controller;

import ee.ken.salat.entity.Omanik;
import ee.ken.salat.repository.OmanikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class OmanikController {

    @Autowired
    OmanikRepository omanikRepository;

    @GetMapping("Omanikud")
    public List<Omanik> saaOmanikud(){
        return omanikRepository.findAll();
    }

    @PostMapping("Omanikud")
    public List<Omanik> lisaOmanik(@RequestBody Omanik omanik){
        omanikRepository.save(omanik);
        return omanikRepository.findAll();
    }

    @DeleteMapping("Omanikud/{id}")
    public List<Omanik> kustutaOmanik(@PathVariable Long id){
        omanikRepository.deleteById(id);
        return omanikRepository.findAll();
    }

    @PutMapping("Omanikud")
    public List<Omanik> muudaOmanik(@RequestBody Omanik omanik){
        omanikRepository.save(omanik);
        return omanikRepository.findAll();
    }

}

