package ee.ken.kalkulaator;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class NumbriteKontroller {
    List<Integer> numbrid=new ArrayList<>(Arrays.asList(1,2,3,4,5));

//    @GetMapping("/numbrid")    // seda ei saa muuta
//    public  int[] saadaNumbrid() {
//        int[] numbrid={1,2,3,4};
//        return numbrid;
//    }

    @GetMapping("/numbrid")    // Listiga on muudetav
    public List<Integer> saadaNumbrid() {
        return numbrid;
    }

    @GetMapping("/lisa-number/{uus}")
    public List<Integer> lisaNumber(@PathVariable int uus) {
        numbrid.add(uus);
        return numbrid;
    }

    @GetMapping("/kustuta-number/{index}")
    public List<Integer> kustutaNumber(@PathVariable int index) {
        numbrid.remove(index);     //splice(index,1) oli front endis sama asi
        return numbrid;
    }

    @GetMapping("/koguarv")    // Listiga on muudetav
    public int koguarv() {
        return numbrid.size();
    }

    @GetMapping("/kogusumma")
    public int kogusumma() {
        int summa=0;
//        summa = summa + 1;
//        summa = summa + 2;
        for(int number : numbrid) {
            summa = summa + number;
        }
        return summa;
    }

    @GetMapping("/keskmine")
    public double keskmine () {
        int summa = 0;
        int koguarv = numbrid.size();
        for (int number : numbrid) {
            summa += number;
        }
        return koguarv == 0 ? 0 : (double) summa / koguarv;
    }

    @GetMapping("/liida/{nr1}/{nr2}")
    public int liida(@PathVariable int nr1, @PathVariable int nr2) {
        return  nr1 + nr2;
    }

    @GetMapping("/lahuta/{nr1}/{nr2}")
    public int lahuta(@PathVariable int nr1, @PathVariable int nr2) {
        return  nr1 - nr2;
    }

    @GetMapping("/jaga/{nr1}/{nr2}")
    public int jaga(@PathVariable int nr1, @PathVariable int nr2) {
        return  nr1 / nr2;
    }

    @GetMapping("/korruta/{nr1}/{nr2}")
    public int korruta(@PathVariable int nr1, @PathVariable int nr2) {
        return  nr1 * nr2;
    }
//http://localhost:8080/korrutaJaga?nr1=5&nr2=7&nr3=2
    @GetMapping("/korrutaJaga")
    public int korrutaJaga(@RequestParam int nr1, @RequestParam int nr2, @RequestParam int nr3) {
        return nr1*nr2/nr3;
    }

    @GetMapping("/lisa-juhuslik-number")
    public List<Integer> lisaJuhuslikNumber() {
        int juhuslik = (int) (Math.random() * 9);
        numbrid.add(juhuslik);
        return numbrid;
    }

    @GetMapping("/kustuta-juhuslik-number")
    public List<Integer> kustutaJuhuslikNumber() {
        int juhuslik = (int) (Math.random() * (numbrid.size() - 1));  // -1 võibolla ei ole vajalik
        numbrid.remove(juhuslik);
        return numbrid;
    }
}
