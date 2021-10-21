package hu.petrik.bank;

import hu.petrik.bank.felhasznalo.Tulajdonos;
import hu.petrik.bank.szolgaltatasok.HitelSzamla;
import hu.petrik.bank.szolgaltatasok.MegtakaritasiSzamla;
import hu.petrik.bank.szolgaltatasok.Szamla;

import java.util.ArrayList;
import java.util.List;

public final class Bank {
    private final List<Szamla> szamlaLista;

    public Bank(int max){
        szamlaLista = new ArrayList<>(max);
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        Szamla szamla;
        if (hitelKeret == 0){
            szamla = szamlaNyitas(tulajdonos);
        }
        else{
            szamla = szamlaNyitas(tulajdonos);
        }
        return szamla;
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos){
        return new MegtakaritasiSzamla(tulajdonos);
    }

    public int getOsszegyenleg(){
        int szum = 0;
        for(Szamla szamla: szamlaLista){
            szum += szamla.getAktualisEgyenleg();
        }
        return szum;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(){
        Szamla szamlaMaistro = szamlaLista.get(0);
        for(Szamla szamla: szamlaLista){
            if (szamla.getAktualisEgyenleg()>szamlaMaistro.getAktualisEgyenleg()){
                szamlaMaistro = szamla;
            }
        }
        return szamlaMaistro;
    }

    public long getOsszhitelkeret(){
        int szum = 0;
        for(Szamla szamla: szamlaLista){
            if(szamla.getClass()== HitelSzamla.class){
                szum += ((HitelSzamla)szamla).getHitelKeret();
            }
        }
        return szum;
    }
}
