package ee.ken.kalkulaator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000/")

public class JuhuslikuSonaKontroller {

    public List<Auto> autod = new ArrayList<>(Arrays.asList(new Auto("BMW", 45000), new Auto( "Nobe", 30000),
                                                            new Auto("Tesla", 85000), new Auto("Opel", 25000),
                                                            new Auto("Volvo", 30000), new Auto("Ford", 30000),
                                                            new Auto("Audi", 45000),new Auto("Mercedes", 45000),
                                                            new Auto("Saab", 27000)
                                                            ));
    Auto auto;
    int elud = 3;
    int skoor = 0;

    //Kõigepealt läheb see käima, mängu alustamise käsk

    @GetMapping("alusta-mangu")
    public Auto alustaMangu(){
        int juhuslikNumber =(int) (Math.random() * 7);
        auto = autod.get(juhuslikNumber);
        elud = 3;
        skoor = 0;
        return auto;
    }

    @GetMapping("tahtede-arv/{guess}")
    public String tahtedeArv(@PathVariable String guess) {
        if (elud == 0) {
            return "Elud on otsas, rohkem vastata ei saa!";
        }
        int juhuslikNumber = (int) (Math.random() * 7);
        Auto uusAuto = autod.get(juhuslikNumber);

        if (uusAuto.nimi.length()< auto.nimi.length() && guess.equals("less")) {
            auto = uusAuto;
            skoor++;
            return "Õige vastus";
        }
            if (uusAuto.nimi.length() == auto.nimi.length() && guess.equals("same")) {
                auto = uusAuto;
                skoor++;
                return "Õige vastus";
                }
                if (uusAuto.nimi.length() > auto.nimi.length() && guess.equals("more")) {
                    auto = uusAuto;
                    skoor++;
                    return "Õige vastus";
                }
                auto = uusAuto;
                elud --;
                return "Vale vastus";
            }


    @GetMapping("hinna-vordlus/{guess}")
    public String hinnaVordlus(@PathVariable String guess) {
        if (elud == 0) {
            return "Elud on otsas, rohkem vastata ei saa!";
        }
        int juhuslikNumber = (int) (Math.random() * 7);
        Auto uusAuto = autod.get(juhuslikNumber);

        if (uusAuto.hind < auto.hind && guess.equals("less")) {
            auto = uusAuto;
            skoor++;
            return "Õige vastus";
        }
        if (uusAuto.hind== auto.hind && guess.equals("same")) {
            auto = uusAuto;
            skoor++;
            return "Õige vastus";
        }
        if (uusAuto.hind > auto.hind && guess.equals("more")) {
            auto = uusAuto;
            skoor++;
            return "Õige vastus";
        }
        auto = uusAuto;
        elud --;
        return "Vale vastus";
    }

    @GetMapping("arva-uuesti")
    public Auto arvaUuesti() {
        return auto; //See näitab millega võrdles
    }

    @GetMapping("skoor-ja-elud")
    public SkoorElud saaSkoorJaElud() {
        return new SkoorElud(skoor, elud);
    }

        }


