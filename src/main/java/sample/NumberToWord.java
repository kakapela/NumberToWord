package sample;

import java.util.InputMismatchException;
        import java.util.Scanner;

public class NumberToWord {
    public static String translacja(long liczba) {
        String[] jednoœci = { "", "jeden ", "dwa ", "trzy ", "cztery ",
                "piêæ ", "szeœæ ", "siedem ", "osiem ", "dziewiêæ ", };

        String[] nastki = { "", "jedenaœcie ", "dwanaœcie ", "trzynaœcie ",
                "czternaœcie ", "piêtnaœcie ", "szesnaœcie ", "siedemnaœcie ",
                "osiemnaœcie ", "dziewiêtnaœcie ", };

        String[] dziesi¹tki = { "", "dziesiêæ ", "dwadzieœcia ",
                "trzydzieœci ", "czterdzieœci ", "piêædziesi¹t ",
                "szeœædziesi¹t ", "siedemdziesi¹t ", "osiemdziesi¹t ",
                "dziewiêædziesi¹t ", };

        String[] setki = { "", "sto ", "dwieœcie ", "trzysta ", "czterysta ",
                "piêæset ", "szeœæset ", "siedemset ", "osiemset ",
                "dziewiêæset ", };

        String[][] grupy = { { "", "", "" },
                { "tysi¹c ", "tysi¹ce ", "tysiêcy " },
                { "milion ", "miliony ", "milionów " },
                { "miliard ", "miliardy ", "miliardów " },
                { "bilion ", "biliony ", "bilionów " },
                { "biliard ", "biliardy ", "biliardów " },
                { "trylion ", "tryliony ", "trylionów " }, };

// INICJACJA ZMIENNYCH
        long j = 0/* jednoœci */, n = 0/* nastki */, d = 0/* dziesi¹tki */, s = 0/* setki */, g = 0/* grupy */, k = 0/* koñcówwki */;
        String s³ownie = "";
        String znak = "";

// OPERACJA DOTYCZ¹CA ZNAKU

        if (liczba < 0) {
            znak = "minus ";
            liczba = -liczba; // bezwglêdna wartoœæ poniewa¿, jeœli bêdziemy
// operowaæ na liczbie z minusem tablica bêdzie
// przyjmowa³a wartoœci ujemne i zwróci nam b³¹d
        }
        if (liczba == 0) {
            znak = "zero";
        }

// PÊTLA G£ÓWNA
        while (liczba != 0) {
            s = liczba % 1000 / 100;
            d = liczba % 100 / 10;
            j = liczba % 10;

            if (d == 1 & j > 0) // if zajmuj¹cy siê nastkami
            {
                n = j;
                d = 0;
                j = 0;
            } else {
                n = 0;
            }

// <---- KOÑCÓWKI

            if (j == 1 & s + d + n == 0) {
                k = 0;

                if (s + d == 0 && g > 0) // jeœli nie bêdzie dziesi¹tek ani setek, wtedy otrzymamy sam¹ grupê
                { // przyk³adowo 1000 - wyœwietli nam siê "tysi¹c", jeœli
// zakomentujemy tego if'a to otrzymamy "jeden tysi¹c"
                    j = 0;
                    s³ownie = grupy[(int) g][(int) k] + s³ownie;
                }
            } else if (j == 2) {
                k = 1;
            } else if (j == 3) {
                k = 1;
            } else if (j == 4) {
                k = 1;
            } else {
                k = 2;
            }

// KONIEC KOÑCÓWEK -->

            if (s+d+n+j > 0) {
                s³ownie = setki[(int) s] + dziesi¹tki[(int) d] + nastki[(int) n]
                        + jednoœci[(int) j] + grupy[(int) g][(int) k] + s³ownie;
            }

// POZBYWAMY SIÊ TYCH LICZBY KTÓRE JU¯ PRZEROBILIŒMY czyli
// przyk³adowo z 132132 zostaje nam 132 do obróbki
            liczba = liczba / 1000;
// ORAZ ZWIÊKSZAMY G KTÓRE ODPOWIEDZIALNE JEST ZA NUMER POLA W
// TABLICY WIELOWYMIAROWEJ
            g = g + 1;
        }
// KONIEC PÊTLI G£ÓWNEJ

// DODANIE ZNAKU I ZWRÓCENIE METODY
        s³ownie = znak + s³ownie;
        return s³ownie;

    }


}