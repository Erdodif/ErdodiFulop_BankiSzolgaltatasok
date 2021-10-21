package hu.petrik.bank;

import hu.petrik.bank.felhasznalo.Tulajdonos;
import hu.petrik.bank.szolgaltatasok.Szamla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static List<Tulajdonos> tulajdonosok = new ArrayList<>();

    private static void bankUgyintezes(Bank bank, int meret) {
        for (int i = 0; i < meret; i++) {
            int randomindex = random.nextInt(tulajdonosok.size());
            bank.szamlaNyitas(tulajdonosok.get(randomindex),
                    random.nextBoolean() ? random.nextInt(100000) : 0);
            bank.getSzamla(i).befizet(random.nextInt(10000));
        }
    }

    private static String Kiirato(Bank bank) {
        String ki = "Összegyenleg: ";
        ki += bank.getOsszegyenleg();
        ki += "\nÖsszhitelkeret: ";
        ki += bank.getOsszhitelkeret();
        ki += "\nLegbőbb számla: ";
        ki += bank.getLegnagyobbEgyenleguSzamla().getAktualisEgyenleg();
        ki += "\nTulajdonosa: ";
        ki += bank.getLegnagyobbEgyenleguSzamla().getTulajdonos().getNev();
        return ki;
    }

    public static void main(String[] args) {
        Bank raifaisen = new Bank(10);
        Bank otp = new Bank(20);
        tulajdonosok.add(new Tulajdonos("Én"));
        tulajdonosok.add(new Tulajdonos("Te"));
        tulajdonosok.add(new Tulajdonos("Ő"));
        tulajdonosok.add(new Tulajdonos("Mi"));
        tulajdonosok.add(new Tulajdonos("Ti"));
        tulajdonosok.add(new Tulajdonos("Ők"));
        bankUgyintezes(raifaisen, 10);
        bankUgyintezes(otp, 20);
        System.out.println("\nOtp: \n"+Kiirato(otp));
        System.out.println("\nRaifaisen: \n"+Kiirato(raifaisen));
    }
}
