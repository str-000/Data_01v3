package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Date {
    public Date(int day, String monthString, int year,
                int day2, String monthString2, int year2) throws ParseException {

        int monthInt = 0, monthInt2 = 0;
        String monthNameString = null, monthNameString2 = null;

        String[] monthsNameArray = new String[12];
        monthsNameArray[0] = "Styczen";
        monthsNameArray[1] = "Luty";
        monthsNameArray[2] = "Marzec";
        monthsNameArray[3] = "Kwiecien";
        monthsNameArray[4] = "Maj";
        monthsNameArray[5] = "Czerwiec";
        monthsNameArray[6] = "Lipiec";
        monthsNameArray[7] = "Sierpien";
        monthsNameArray[8] = "Wrzesien";
        monthsNameArray[9] = "Pazdziernik";
        monthsNameArray[10] = "Listopad";
        monthsNameArray[11] = "Grudzien";

        boolean isNumeric = isNumeric(monthString);
        boolean isNumeric2 = isNumeric(monthString2);

        //-----------------------------------------------------------------
        //wyswietlenie, sprawdzenie i przypisanie wartosci do daty 1

        if (isNumeric){
            monthInt = Integer.parseInt(monthString);
            monthNameString = monthsNameArray[monthInt-1];

            if (day > 31 || monthInt > 12) {
                System.out.println("Niepoprawna data!");
            } else {
                System.out.println(day +
                        "." + monthNameString +
                        "." + year);
            }
        } else {
            String monthStringString = monthString;
            monthString = String.valueOf(Arrays.asList(monthsNameArray).indexOf(monthString)+1);

            System.out.println(day +
                    "." + monthStringString +
                    "." + year );
        }

        //-----------------------------------------------------------------
        //wyswietlenie, sprawdzenie i przypisanie wartosci do daty 1

        if (isNumeric2){
            monthInt2 = Integer.parseInt(monthString2);
            monthNameString2 = monthsNameArray[monthInt2-1];

            if (day > 31 || monthInt2 > 12) {
                System.out.println("Niepoprawna data!");
            } else {
                System.out.println(day2 +
                        "." + monthNameString2 +
                        "." + year2);
            }
        } else {
            String monthStringString2 = monthString2;
            monthString2 = String.valueOf(Arrays.asList(monthsNameArray).indexOf(monthString2)+1);

            System.out.println(day2 +
                    "." + monthStringString2 +
                    "." + year2 );
        }

        //-----------------------------------------------------------------
        //obliczenia na datach

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        java.util.Date firstDate = sdf.parse( monthString + "/" + String.valueOf(day) + "/" +String.valueOf(year));
        java.util.Date secondDate = sdf.parse(monthString2 + "/" + String.valueOf(day2) + "/" +String.valueOf(year2));

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("Różnica dni: "+diffrence);
    }

    //-----------------------------------------------------------------
    //funkcje

    //funkcja sprawdzajaca jaki typ danej dot. miesiaca podano
    public static boolean isNumeric(String monthString) {
        try {
            Integer.parseInt(monthString);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static int leapYear(int year){
        if (year % 4 == 0) {
            return 366;
        } return 365;
    }
}
