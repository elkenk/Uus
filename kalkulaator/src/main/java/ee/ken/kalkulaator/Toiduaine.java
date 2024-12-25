package ee.ken.kalkulaator;

public class Toiduaine {
    String nimi;
    int rasv;
    int sysivesik;
    int valk;

    public String getNimi() {
        return nimi;
    }

    public int getRasv() {
        return rasv;
    }

    public int getSysivesik() {
        return sysivesik;
    }

    public int getValk() {
        return valk;
    }

    public Toiduaine(String nimi, int rasv, int sysivesik, int valk) {
        this.nimi = nimi;
        this.rasv = rasv;
        this.sysivesik = sysivesik;
        this.valk = valk;
    }
}
