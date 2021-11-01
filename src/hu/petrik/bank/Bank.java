package hu.petrik.bank;

import hu.petrik.bank.felhasznalo.Tulajdonos;
import hu.petrik.bank.szolgaltatasok.HitelSzamla;
import hu.petrik.bank.szolgaltatasok.MegtakaritasiSzamla;
import hu.petrik.bank.szolgaltatasok.Szamla;

import java.util.ArrayList;
import java.util.List;

public final class Bank {
    private final List<Szamla> szamlaLista;

    public Bank(int max) {
        szamlaLista = new ArrayList<>(max);
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret) {
        Szamla szamla;
        if (hitelKeret == 0) {
            szamla = szamlaNyitas(tulajdonos);
        } else {
            szamla = new HitelSzamla(tulajdonos, hitelKeret);
        }
        szamlaLista.add(szamla);
        return szamla;
    }

    public MegtakaritasiSzamla szamlaNyitas(Tulajdonos tulajdonos) {
        return new MegtakaritasiSzamla(tulajdonos);
    }

    //Működéshez szükséges
    public Szamla getSzamla(int index) {
        return szamlaLista.get(index);
    }

    public int getOsszegyenleg(Tulajdonos tulajdonos) {
        int szum = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos) {
                szum += szamla.getAktualisEgyenleg();
            }
        }
        return szum;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) throws Exception {
        int i = 0;
        while (i < szamlaLista.size() && szamlaLista.get(i).getTulajdonos() != tulajdonos) {
            i++;
        }
        if (i==szamlaLista.size()){
            throw new Exception("Nem lehetséges");
        }
        Szamla szamlaMaistro = szamlaLista.get(i);
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos && szamla.getAktualisEgyenleg() > szamlaMaistro.getAktualisEgyenleg()) {
                szamlaMaistro = szamla;
            }
        }
        return szamlaMaistro;
    }

    public long getOsszhitelkeret() {
        int szum = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getClass() == HitelSzamla.class) {
                szum += ((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return szum;
    }
}
