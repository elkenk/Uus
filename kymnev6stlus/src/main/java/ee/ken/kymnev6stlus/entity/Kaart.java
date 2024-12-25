package ee.ken.kymnev6stlus.entity;

import lombok.Getter;

@Getter
public class Kaart {
    String mast;
    String nimi;
    int vaartus;

    public Kaart(String mast, String nimi, int vaartus) {
        this.mast = mast;
        this.nimi = nimi;
        this.vaartus = vaartus;
    }
}
