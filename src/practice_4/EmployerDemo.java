package practice_4;
import java.util.Objects;

class Employer {
    private String name;
    private double salary;
    private int hireYear;
    private String education;

    public Employer(String name, double salary, int hireYear, String education) {
        this.name = name;
        this.salary = salary;
        this.hireYear = hireYear;
        this.education = education;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public int getHireYear() { return hireYear; }

    public String getInfo() {
        return name + ", зарплата: " + salary + ", образование: " + education;
    }

    public int calculateExperience() {
        return 2026 - hireYear;
    }

    public double calculateBonus() {
        return salary * 0.1;
    }

    public String toString() {
        return "Employer{" + name + ", стаж=" + calculateExperience() + " лет}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer e = (Employer) o;
        return Double.compare(e.salary, salary) == 0 && hireYear == e.hireYear && Objects.equals(name, e.name);
    }

    public int hashCode() {
        return Objects.hash(name, salary, hireYear);
    }
}

class Developer extends Employer {
    private String language;

    public Developer(String name, double salary, int hireYear, String education, String language) {
        super(name, salary, hireYear, education);
        this.language = language;
    }

    public double calculateBonus() {
        return getSalary() * 0.15;
    }

    public String toString() {
        return "Developer{" + getName() + ", язык: " + language + ", бонус: " + calculateBonus() + "}";
    }
}

class Teacher extends Employer {
    private String subject;

    public Teacher(String name, double salary, int hireYear, String education, String subject) {
        super(name, salary, hireYear, education);
        this.subject = subject;
    }

    public double calculateBonus() {
        return getSalary() * 0.05;
    }

    public String toString() {
        return "Teacher{" + getName() + ", предмет: " + subject + ", бонус: " + calculateBonus() + "}";
    }
}

class Manager extends Employer {
    private int teamSize;

    public Manager(String name, double salary, int hireYear, String education, int teamSize) {
        super(name, salary, hireYear, education);
        this.teamSize = teamSize;
    }

    public double calculateBonus() {
        return getSalary() * 0.2 + teamSize * 1000;
    }

    public String toString() {
        return "Manager{" + getName() + ", команда: " + teamSize + ", бонус: " + calculateBonus() + "}";
    }
}

public class EmployerDemo {
    public static void main(String[] args) {
        Employer[] staff = {
            new Developer("Иванов", 100000, 2020, "Высшее", "Java"),
            new Developer("Петров", 120000, 2019, "Высшее", "Python"),
            new Teacher("Сидорова", 60000, 2015, "Высшее", "Математика"),
            new Teacher("Козлова", 65000, 2018, "Высшее", "Физика"),
            new Manager("Смирнов", 150000, 2017, "Высшее", 10),
            new Manager("Новиков", 180000, 2016, "Высшее", 15)
        };

        // Полиморфный вызов
        for (Employer e : staff) {
            System.out.println(e.getInfo());
            System.out.println("  Стаж: " + e.calculateExperience() + " лет");
            System.out.println("  Бонус: " + e.calculateBonus());
            System.out.println("  " + e);
            System.out.println();
        }
    }
}