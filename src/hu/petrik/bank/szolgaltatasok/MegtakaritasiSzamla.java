package hu.petrik.bank.szolgaltatasok;

import hu.petrik.bank.felhasznalo.Tulajdonos;

public final class MegtakaritasiSzamla extends Szamla{
    private double kamat;
    public static double alapKamat;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        kamat = 0;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(int kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        boolean siker = false;
        if(getAktualisEgyenleg() - osszeg > 0){
            siker = true;
            aktualisEgyenleg-=osszeg;
        }
        return siker;
    }

    public void kamatJovairas(){
        aktualisEgyenleg += kamat;
        kamat = 0;
    }
}
