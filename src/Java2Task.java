
import java.util.Scanner;


public class Java2Task {

    static Scanner scanner= new Scanner(System.in);

    public static double task1(int n) {
        double sum = 0;
        for (int i = n; i <= 2 * n; i++) {
            sum += (double) i * i;
        }
        return sum;
    }

    public static double task2(double x, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            double term = Math.pow(x, 2 * i + 1) / (2 * i + 1);
            if (i % 2 == 0) {
                sum += term;
            } else {
                sum -= term;
            }
        }
        return sum;
    }

    public static void task3(int n) {
        int count = 0;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
            count++;
        }
        System.out.println("Количество цифр: " + count);
        System.out.println("Сумма цифр: " + sum);
    }

    public static double task4(double number) {
        System.out.println("Число: " + number);
        long intPart = (long) number;
        double fracPart = Math.abs(number - intPart);
        System.out.println("Целая часть: " + intPart);
        System.out.println("Дробная часть: " + fracPart);
        return fracPart;
    }

    public static void task5() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {
                calculateBmi();
            } else if (choice == 2) {
                showProgramInfo();
            } else if (choice == 3) {
                showDeveloperInfo();
            } else if (choice == 4) {
                System.out.println("Выход из программы.");
                break;
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nКалькулятор ИМТ");
        System.out.println("1. Выполнить расчёт");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.print("Выберите пункт: ");
    }

    private static void calculateBmi() {
        System.out.print("Введите вес в кг: ");
        double weight = scanner.nextDouble();

        System.out.print("Введите рост в метрах: ");
        double height = scanner.nextDouble();

        double bmi = calculateBmiValue(weight, height);

        System.out.printf("Ваш ИМТ: %.2f%n", bmi);
        System.out.println("Категория: " + getBmiCategory(bmi));
    }

    private static double calculateBmiValue(double weight, double height) {
        return weight / (height * height);
    }

    private static String getBmiCategory(double bmi) {
        if (bmi < 18.5) {
            return "Недостаточный вес";
        } else if (bmi < 25) {
            return "Нормальный вес";
        } else if (bmi < 30) {
            return "Избыточный вес";
        } else {
            return "Ожирение";
        }
    }

    private static void showProgramInfo() {
        System.out.println("\nПрограмма вычисляет ИМТ по формуле: вес (кг) / рост^2 (м^2).");
    }

    private static void showDeveloperInfo() {
        System.out.println("\nРазработчик: Елькин Олег");
    }
}


