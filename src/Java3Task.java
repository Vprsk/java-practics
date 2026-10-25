
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.Scanner;

public class Java3Task {

    public static void task1(int[] arr){

        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] % 2 == 0) {
                count++;
                System.out.println(arr[i]);
            }
        }
        System.out.println("Количество четных: " + count);
    }

    public static int task2(int[] arr){

        Set<Integer> unique = new HashSet<>();

        for (int x : arr) {
            unique.add(x);
        }

        return unique.size();

    }

    public static double[] task3(int[] a) {
        double[] b = new double[a.length];
        double sum = 0;
        for (int k = 0; k < a.length; k++) {
            sum += a[k];
            b[k] = sum / (k + 1);
        }
        return b;
    }

    public static void task4(int[][] m) {
        int n = m.length;
        int[] res = new int[n * n];
        int idx = 0, t = 0, b = n - 1, l = 0, r = n - 1;
        while (t <= b && l <= r) {
            for (int i = t; i <= b; i++) res[idx++] = m[i][l]; l++;
            for (int j = l; j <= r; j++) res[idx++] = m[b][j]; b--;
            for (int i = b; i >= t; i--) res[idx++] = m[i][r]; r--;
            for (int j = r; j >= l; j--) res[idx++] = m[t][j]; t++;
        }
        for(int i: res) System.out.println(i);
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void calculate() {
        while (true) {
            showMenu();

            int choice = readMenuChoice();

            if (choice == 1) {
                double[] parameters = readParameters();
                double bmi = calculateBmi(parameters);
                printResult(bmi);
            } else if (choice == 2) {
                printProgramInfo();
            } else if (choice == 3) {
                printDeveloperInfo();
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

    private static int readMenuChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= 4) {
                    return choice;
                }

                System.out.print("Ошибка: введите число от 1 до 4: ");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Ошибка: введите число от 1 до 4: ");
            }
        }
    }

    private static double[] readParameters() {
        double[] parameters = new double[2];

        parameters[0] = readPositiveDouble("Введите вес в кг: ");
        parameters[1] = readPositiveDouble("Введите рост в метрах: ");

        return parameters;
    }

    private static double readPositiveDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                double value = scanner.nextDouble();

                if (checkValue(value)) {
                    return value;
                }

                System.out.println("Ошибка: значение должно быть больше нуля.");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Ошибка: введите число.");
            }
        }
    }

    private static boolean checkValue(double value) {
        return value > 0;
    }

    private static double calculateBmi(double[] parameters) {
        double weight = parameters[0];
        double height = parameters[1];

        return weight / (height * height);
    }

    private static void printResult(double bmi) {
        System.out.printf("Ваш ИМТ: %.2f%n", bmi);
        System.out.println("Категория: " + getBmiCategory(bmi));
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

    private static void printProgramInfo() {
        System.out.println("\nПрограмма вычисляет ИМТ по формуле: вес (кг) / рост^2 (м^2).");
    }

    private static void printDeveloperInfo() {
        System.out.println("\nРазработчик: Елькин Олег");
    }


    public static void main(){
        int[][] arr = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        task4(arr);
    }
}
