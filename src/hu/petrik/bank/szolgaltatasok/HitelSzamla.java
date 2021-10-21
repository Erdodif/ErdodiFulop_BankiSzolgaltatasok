package hu.petrik.bank.szolgaltatasok;

import hu.petrik.bank.felhasznalo.Tulajdonos;

public final class HitelSzamla extends Szamla {
    private final int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelKeret) {
        super(tulajdonos);
        this.hitelKeret = hitelKeret;
    }

    public int getHitelKeret() {
        return hitelKeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        boolean siker = false;
        if(getAktualisEgyenleg() - osszeg > -hitelKeret){
            siker = true;
            aktualisEgyenleg-=osszeg;
        }
        return siker;
    }
}
