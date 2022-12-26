package DailyJournal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    private static Calendar calendar;

    public static void main(String[] args) {
        calendar = new Calendar();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            getDayTasks(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите название задачи:");
        String title = scanner.nextLine();
        System.out.println("Введито описание задачи:");
        String description = scanner.nextLine();
        boolean isPrivate;
        System.out.println("Это персональная задача?");
        switch (scanner.nextLine()) {
            case "Y":
            case "y":
                isPrivate = true;
            default:
                isPrivate = false;
        }

        LocalDateTime date = null;
        System.out.println("ВВедите дату и время задачи.");
        boolean pressEnter = true;
        while (pressEnter) {
            try {
                date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
                pressEnter = false;
            } catch (DateTimeException e) {
                System.out.println("Неверный формат.");
            }
        }
        Task task;

        System.out.println("Установите повторяемсть задания:");

        System.out.println(" 0 - не повторять.");
        System.out.println(" 1 - повторять каждый день.");
        System.out.println(" 3 - повторять каждую неделю.");
        System.out.println(" 4 - повторять каждый месяц.");
        System.out.println(" 5 - повторять каждый год.");

        switch (scanner.next()) {
            case "1":
                task = new DailyTask(title, description, date, isPrivate);
                break;
            case "2":
                task = new WeeklyTask(title, description, date, isPrivate);
                break;
            case "3":
                task = new MonthlyTask(title, description, date, isPrivate);
                break;
            case "4":
                task = new YearlyTask(title, description, date, isPrivate);
                break;
            default:
                task = new OneTimeTask(title, description, date, isPrivate);
        }
        calendar.addTask(task);

    }

    private static void removeTask(Scanner scanner){
        System.out.println("Введите id задачи:");
        calendar.removeTask(scanner.nextInt());
    }
    private static void getDayTasks(Scanner scanner) {
        System.out.println("Введите дату:");
        LocalDate date = null;
        boolean pressEnter = true;
        while (pressEnter) {
            try {
                date = LocalDate.parse(scanner.nextLine(), Task.DATE_FORMATTER);
                pressEnter = false;
            } catch (DateTimeException e) {
                System.out.println("Неверный формат.");
            }
        }
        System.out.println(calendar.getOneDayTasks(date));
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу" + "\n" +
                        "2. Удалить задачу" + "\n" +
                        "3. Получить задачу на указанный день" + "\n" +
                        "0. Выход"
        );
    }
}