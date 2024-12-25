package ee.ken.kalkulaator;
//Tagasta lause +++
//Lisa lausesse üks sõna lõppu +++
//Mitu tähemärki lauses +++
//Mitu sõna lauses on +++
//Mitu a tähte lauses +++
//veel nuppe teiste tähtede jaoks +++

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")

public class LauseKontroller {

   public List<String> lause = new ArrayList<> (Arrays.asList("Elas metsas mutionu, keset kuuski noori vanu, kadakapõõsa juures all"));
// public String lause = "Elas metsas mutionu, keset kuuski noori vanu, kadakapõõsa juures all"

   @GetMapping("/lause")
    public List<String> saaLause() {
       return lause;
   }
    //@getmapping ("lause")
    //public String saaLause() {
    //    return lause
    //    }

    @GetMapping ("/lisaLoppuSona/{uusSonaLopus}")
    public List<String> lisaLoppuSona(@PathVariable String uusSonaLopus) {
        lause.add(uusSonaLopus);
        return lause;
    }
//    @GetMapping ("/lisaLoppuSona/{uusSonaLopus}")
//    public String lisaLoppuSona(@PathVariable String uusSonaLopus) {
//    lause = lause + " " +uusSonaLopus;
//    return lause;
//    }

    @GetMapping("mituTahte")
    public int tahed() {
        return lause.stream().mapToInt(String::length).sum();
    }
//    @GetMapping("mituTahte")
//    public int tahed() {
//    return lause.length();
//}
    
    @GetMapping("/sonadeArv")
    public int sonadeArv() {
       return  lause.stream()
               .mapToInt(l -> l.split("\\s+").length).sum();
    }
//    @GetMapping("/sonadeArv")
//    public int sonadeArv() {
//    return lause.split(" ").length
//}

    @GetMapping("mituAtahte")
        public int aTahte() {
        return lause.stream()
               .mapToInt(l->(int) l.chars()
                       .filter(c -> c == 'A' || c == 'a').count()).sum();
    }

//    @GetMapping("mituAtahte")
//    public int aTahte() {
//        return lause.stream()
//                .mapToInt(l->(int) l.chars()
//                        .filter(c -> c == 'A' || c == 'a').count()).sum();
//        return Arrays.stream
//    }


    @GetMapping("mituKtahte")
    public int kTahte() {
        return lause.stream()
                .mapToInt(l->(int) l.chars()
                        .filter(c -> c == 'K' || c == 'k').count()).sum();
    }

    @GetMapping("mituMtahte")
    public int mTahte() {
        return lause.stream()
                .mapToInt(l->(int) l.chars()
                        .filter(c -> c == 'M' || c == 'm').count()).sum();
    }

    @GetMapping("mituStahte")
    public int sTahte() {
        return lause.stream()
                .mapToInt(l->(int) l.chars()
                        .filter(c -> c == 'S' || c == 's').count()).sum();
    }
}
