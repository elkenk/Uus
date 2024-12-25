package ee.ken.seosed.Controller;

import ee.ken.seosed.Repository.LemmikloomRepository;
import ee.ken.seosed.entity.Lemmikloom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LemmikloomController {
    @Autowired
    LemmikloomRepository lemmikloomRepository;

    @GetMapping("lemmikloomad")
    public List<Lemmikloom> getLemmikloomad() {
        return lemmikloomRepository.findAll();
    }
    @PostMapping("lemmikloomad")
    public List<Lemmikloom> lisaLemmikloom(@RequestBody Lemmikloom lemmikloom) {
        lemmikloomRepository.save(lemmikloom);
        return lemmikloomRepository.findAll();
    }
    @DeleteMapping("lemmikloomad/{id}")
    public List<Lemmikloom> kustutaLemmikloom(@PathVariable Long id) {
        lemmikloomRepository.deleteById(id);
        return lemmikloomRepository.findAll();
    }
}
