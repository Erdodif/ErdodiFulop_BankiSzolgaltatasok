package hu.petrik.bank.szolgaltatasok;

import hu.petrik.bank.felhasznalo.Tulajdonos;

public final class Kartya extends BankiSzolgaltatas{
    private final Szamla szamla;
    private final String kartyaSzam;

    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaSzam) {
        super(tulajdonos);
        this.szamla = szamla;
        this.kartyaSzam = kartyaSzam;
    }

    public String getKartyaSzam() {
        return kartyaSzam;
    }

    public boolean vasarlas(int osszeg){
        return szamla.kivesz(osszeg);
    }
}
