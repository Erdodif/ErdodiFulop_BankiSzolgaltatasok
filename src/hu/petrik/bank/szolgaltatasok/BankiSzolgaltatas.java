package hu.petrik.bank.szolgaltatasok;

import hu.petrik.bank.felhasznalo.Tulajdonos;

public abstract class BankiSzolgaltatas {
    private Tulajdonos tulajdonos;

    protected BankiSzolgaltatas(Tulajdonos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Tulajdonos getTulajdonos() {
        return tulajdonos;
    }
}
