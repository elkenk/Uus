package ee.ken.kalkulaator;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")

public class Sonad {
    public List<String> sonad = new ArrayList<>(Arrays.asList("kuu", "heinakuhi", "ahi", "puukuur", "aed", "joogipudel"));



    @GetMapping("/sonad")
    public List<String> saadaSonad() {
        return sonad;
    }

    @GetMapping ("/lisaSona/{uusSona}")
    public List<String> lisaSona(@PathVariable String uusSona) {
        sonad.add(uusSona);
        return sonad;
    }

    @GetMapping ("/kustutaSona/{index}")
    public List<String> kustutaSona(@PathVariable int index) {
        sonad.remove(index);
        return sonad;
    }

    @GetMapping("tahed")
    public int tahed() {
        return sonad.stream().mapToInt(String::length).sum();
    }

    @GetMapping("tahedKeskmine")
    public double tahedKeskmine() {
        int sonaArv =sonad.size();
        int kokku = tahed();
        return sonaArv == 0 ? 0 : (double) kokku / sonaArv;
    }

    @GetMapping("arvuta-tahed/{index}")
    public int arvutaTahed(@PathVariable int index) {
        return sonad.get(index).length();
    }

    @GetMapping("esimene-taht/{index}")
    public String esimeneTaht(@PathVariable int index) {
        return sonad.get(index).substring(0,1);
    }

    @GetMapping("viimane-taht/{index}")
    public String viimaneTaht(@PathVariable int index) {
        String sona = sonad.get(index);
        int eelviimaneIndex = sona.length()-1;
        int viimaneIndex = sona.length();
        return sona.substring(eelviimaneIndex, viimaneIndex);
    }
}
