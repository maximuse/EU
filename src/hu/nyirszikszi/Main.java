package hu.nyirszikszi;

public class Main {
    public static void main(String[] args) {
        Actions.fileToList("EUcsatlakozas.txt");
        System.out.println(Actions.task3());
        System.out.println(Actions.task4(2007));
        System.out.println(Actions.task5("Magyarország"));
        System.out.println(Actions.task6("május"));
        System.out.println(Actions.task7());
    }
}