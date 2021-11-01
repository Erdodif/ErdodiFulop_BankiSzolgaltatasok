package hu.petrik.bank;

import hu.petrik.bank.felhasznalo.Tulajdonos;
import hu.petrik.bank.szolgaltatasok.Szamla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static List<Tulajdonos> tulajdonosok = new ArrayList<>();

    private static void bankUgyintezes(Bank bank, int meret) {
        Random random = new Random();
        for (int i = 0; i < meret; i++) {
            int randomindex = random.nextInt(tulajdonosok.size());
            int keret = random.nextBoolean() ? random.nextInt(100000) : 0;
            bank.szamlaNyitas(tulajdonosok.get(randomindex), keret);
            bank.getSzamla(i).befizet(random.nextInt(10000));
        }
    }

    private static String Kiirato(Bank bank) {
        String ki = "Bank összes kiadott hitelkerete: ";
        ki += bank.getOsszhitelkeret();
        Tulajdonos keresett = tulajdonosok.get(1);
        try {
            ki += "\nLegbőbb számlád ennél a banknál: ";
            ki += bank.getLegnagyobbEgyenleguSzamla(keresett).getAktualisEgyenleg();
            ki += "\nÖsszegyenleged ennél a banknál: ";
            ki += bank.getOsszegyenleg(keresett);
        } catch (Exception e) {
            ki += "Nincs ennél a banknál számlád";
        }
        return ki;
    }

    public static void main(String[] args) {
        Bank raifaisen = new Bank(110);
        Bank otp = new Bank(210);
        tulajdonosok.add(new Tulajdonos("Én"));
        tulajdonosok.add(new Tulajdonos("Te"));
        tulajdonosok.add(new Tulajdonos("Ő"));
        tulajdonosok.add(new Tulajdonos("Mi"));
        tulajdonosok.add(new Tulajdonos("Ti"));
        tulajdonosok.add(new Tulajdonos("Ők"));
        bankUgyintezes(raifaisen, 10);
        bankUgyintezes(otp, 20);
        System.out.println("\nOtp: \n" + Kiirato(otp));
        System.out.println("\nRaifaisen: \n" + Kiirato(raifaisen));
    }
}
