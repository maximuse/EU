package hu.nyirszikszi;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

class Actions {
    private static ArrayList<Eu> list = new ArrayList<>();

    private static ArrayList<Eu> getList() {
        return list;
    }

    private static void setList(ArrayList<Eu> list) {
        Actions.list = list;
    }

    static void fileToList(String fileName) {
        ArrayList<Eu> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            String[] slice;

            while (row != null) {
                slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");
                list.add(new Eu(slice[0], slice[1]));
                row = raf.readLine();
            }

            raf.close();

            setList(list);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static String task3() {
        return "3. feladat: EU tagállamainak száma: " + Actions.getList().size() + " db";
    }

    private static String[] getSplittedDate(String date) {
        return date.split("\\.");
    }

    static String task4(int year) {
        int counter = 0;
        String[] date;
        int y;

        for (int i = 0; i < Actions.getList().size(); i++) {
            date = getSplittedDate(Actions.getList().get(i).getDatum());
            y = Integer.parseInt(date[0]);

            if (y == year) {
                counter++;
            }
        }

        return "4. feladat: " + year + "-ban/ben " + counter + " ország csatlakozott.";
    }

    static String task5(String country) {
        String c = new String(country.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String date = "";

        for (int i = 0; i < Actions.getList().size(); i++) {
            if (Actions.getList().get(i).getOrszag().equals(c)) {
                date = Actions.getList().get(i).getDatum();
                break;
            }
        }

        return "5. feladat: " + country + " csatlakozásának dátuma: " + date;
    }

    static String task6(String month) {
        String mth = null;
        String[] date;
        String m;
        boolean r = false;

        switch (month) {
            case "január":
            case "1":
            case "01":
                mth = "01";
                break;
            case "február":
            case "2":
            case "02":
                mth = "02";
                break;
            case "március":
            case "3":
            case "03":
                mth = "03";
                break;
            case "április":
            case "4":
            case "04":
                mth = "04";
                break;
            case "május":
            case "5":
            case "05":
                mth = "05";
                break;
            case "június":
            case "6":
            case "06":
                mth = "06";
                break;
            case "július":
            case "7":
            case "07":
                mth = "07";
                break;
            case "augusztus":
            case "8":
            case "08":
                mth = "08";
                break;
            case "szeptember":
            case "9":
            case "09":
                mth = "09";
                break;
            case "október":
            case "10":
                mth = "10";
                break;
            case "november":
            case "11":
                mth = "11";
                break;
            case "december":
            case "12":
                mth = "12";
                break;
        }

        if (mth != null) {
            for (int i = 0; i < Actions.getList().size(); i++) {
                date = getSplittedDate(Actions.getList().get(i).getDatum());
                m = date[1];

                if (mth.equals(m)) {
                    r = true;
                    break;
                }
            }
        }

        return "6. feladat: " + month.substring(0, 1).toUpperCase() + month.substring(1) + "-ban/ben " + ((r) ? "volt" : "nem volt") + " csatlakozás!";
    }

    static String task7() {
        Actions.getList().sort(Comparator.comparing(Eu::getDatum));

        return "7. feladat: Legutoljára csatlakozott ország: " + Actions.getList().get(Actions.getList().size() - 1).getOrszag();
    }

    static String task8() {
        return null;
    }
}