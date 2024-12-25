package ee.ken.salat.Controller;
import ee.ken.salat.entity.Lemmikloom;
import ee.ken.salat.repository.LemmikloomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class LemmikloomController {

    @Autowired
    LemmikloomRepository lemmikloomRepository;

    @GetMapping("Lemmikloomad")
    public List<Lemmikloom> saaLemmikloomad(){
        return lemmikloomRepository.findAll();
    }

    @PostMapping("Lemmikloomad")
    public List<Lemmikloom> lisaLemmikloom(@RequestBody Lemmikloom lemmikloom){
        lemmikloomRepository.save(lemmikloom);
        return lemmikloomRepository.findAll();
    }

    @DeleteMapping("Lemmikloomad/{id}")
    public List<Lemmikloom> kustutaLemmikloom(@PathVariable Long id){
        lemmikloomRepository.deleteById(id);
        return lemmikloomRepository.findAll();
    }

    @PutMapping("Lemmikloomad")
    public List<Lemmikloom> muudaLemmikloom(@RequestBody Lemmikloom lemmikloom){
        lemmikloomRepository.save(lemmikloom);
        return lemmikloomRepository.findAll();
    }
}
