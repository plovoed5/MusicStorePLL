import java.util.ArrayList;
import java.util.Scanner;

public class MusicStorePLL {
    static ArrayList<String> titles = new ArrayList<>();
    static ArrayList<String> author = new ArrayList<>();
    static ArrayList<String> genreMusic = new ArrayList<>();
    static ArrayList<Integer> topOfMonth = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;

        while (!stop) {
            System.out.println("\nМеню Магазина Музыки:");
            System.out.println("1 - Добавить музыку");
            System.out.println("2 - Все музыка");
            System.out.println("3 - Топ месяца");
            System.out.println("4 - Найти музыку");
            System.out.println("5 - Выйти");
            System.out.print("Ответ: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMusic(scanner);
                    break;
                case 2:
                    displayMusics();
                    break;
                case 3:
                    displayTopOfMonth();
                    break;
                case 4:
                    searchMusic(scanner);
                    break;
                case 5:
                    stop = true;
                    System.out.println("Остановка");
                    break;
            }
        }
        scanner.close();
    }

    public static void addMusic(Scanner scanner) {
        System.out.print("Название музыки: ");
        String title = scanner.nextLine();
        titles.add(title);

        System.out.print("Исполнитель музыки: ");
        String artist = scanner.nextLine();
        author.add(artist);

        System.out.print("Жанр музыки: ");
        String genre = scanner.nextLine();
        genreMusic.add(genre);

        System.out.print("Введите номер в топе месяца (например, 1 для первого места): ");
        int rank = scanner.nextInt();
        scanner.nextLine();
        topOfMonth.add(rank);

        System.out.println("Успешно добавлено!");
    }

    public static void displayMusics() {
        System.out.println("Все музыка:");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println("Название: " + titles.get(i) + ", Исполнитель: " + author.get(i) +
                    ", Жанр: " + genreMusic.get(i) + ", Топ месяца: " + topOfMonth.get(i));
        }
    }

    public static void displayTopOfMonth() {
        System.out.println("Топ месяца:");
        boolean found = false;

        ArrayList<Integer> sortedIndexes = new ArrayList<>();
        for (int i = 0; i < topOfMonth.size(); i++) {
            sortedIndexes.add(i);
        }

        sortedIndexes.sort((i1, i2) -> topOfMonth.get(i1) - topOfMonth.get(i2));

        for (int i : sortedIndexes) {
            System.out.println("Ранг: " + topOfMonth.get(i) + ", Название: " + titles.get(i) +
                    ", Исполнитель: " + author.get(i) + ", Жанр: " + genreMusic.get(i));
            found = true;
        }

        if (!found) {
            System.out.println("Нет музыки в топе месяца.");
        }
    }

    public static void searchMusic(Scanner scanner) {
        System.out.println("Поиск по:");
        System.out.println("1. Название");
        System.out.println("2. Исполнитель");
        System.out.println("3. Жанр");
        System.out.print("Введите номер поиска: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        switch (choice) {
            case 1:
                System.out.print("Введите название музыки: ");
                String title = scanner.nextLine();
                for (int i = 0; i < titles.size(); i++) {
                    if (titles.get(i).equalsIgnoreCase(title)) {
                        displayMusicDetails(i);
                        found = true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.print("Введите исполнителя музыки: ");
                String artist = scanner.nextLine();
                for (int i = 0; i < author.size(); i++) {
                    if (author.get(i).equalsIgnoreCase(artist)) {
                        displayMusicDetails(i);
                        found = true;
                        break;
                    }
                }
                break;
            case 3:
                System.out.print("Введите жанр музыки: ");
                String genre = scanner.nextLine();
                for (int i = 0; i < genreMusic.size(); i++) {
                    if (genreMusic.get(i).equalsIgnoreCase(genre)) {
                        displayMusicDetails(i);
                        found = true;
                        break;
                    }
                }
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }

        if (!found) {
            System.out.println("Музыка не найдена.");
        }
    }

    public static void displayMusicDetails(int i) {
        System.out.println("Название: " + titles.get(i) + ", Исполнитель: " + author.get(i) +
                ", Жанр: " + genreMusic.get(i) + ", Топ месяца: " + topOfMonth.get(i));
    }
}
