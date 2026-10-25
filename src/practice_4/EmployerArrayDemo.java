package practice_4;


public class EmployerArrayDemo {
    public static void main(String[] args) {
        Employer[] staff = {
            new Developer("Иванов", 100000, 2020, "Высшее", "Java"),
            new Developer("Петров", 120000, 2019, "Высшее", "Python"),
            new Teacher("Сидорова", 60000, 2015, "Высшее", "Математика"),
            new Teacher("Козлова", 65000, 2018, "Высшее", "Физика"),
            new Manager("Смирнов", 150000, 2017, "Высшее", 10),
            new Manager("Новиков", 180000, 2016, "Высшее", 15)
        };

        double totalBonus = 0;

        for (Employer e : staff) {
            System.out.println(e);
            totalBonus += e.calculateBonus();
        }

        System.out.println("\nОбщий фонд бонусов: " + totalBonus);
    }
}