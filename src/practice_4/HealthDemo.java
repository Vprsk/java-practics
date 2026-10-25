package practice_4;
import java.util.Objects;

class HealthMetric {
    private String name;
    private double value;

    public HealthMetric(String name, double value) {
        if (value <= 0) throw new IllegalArgumentException("Значение должно быть положительным");
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }
    public double getValue() { return value; }

    public String getInfo() {
        return name + ": " + value;
    }

    public String toString() {
        return "HealthMetric{" + name + "=" + value + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthMetric h = (HealthMetric) o;
        return Double.compare(h.value, value) == 0 && Objects.equals(name, h.name);
    }

    public int hashCode() {
        return Objects.hash(name, value);
    }
}

class BMI extends HealthMetric {
    private double height;
    private double weight;

    public BMI(double height, double weight) {
        super("ИМТ", weight / (height * height));
        this.height = height;
        this.weight = weight;
    }

    public String getCategory() {
        double v = getValue();
        return v < 18.5 ? "Недостаточный вес" : v < 25 ? "Норма" : v < 30 ? "Избыточный вес" : "Ожирение";
    }

    public String getInfo() {
        return super.getInfo() + " (" + getCategory() + ")";
    }

    public String toString() {
        return "BMI{рост=" + height + ", вес=" + weight + ", ИМТ=" + String.format("%.2f", getValue()) + "}";
    }
}


class HeartRate extends HealthMetric {
    private int age;

    public HeartRate(int bpm, int age) {
        super("Пульс", bpm);
        this.age = age;
    }

    public String getZone() {
        int max = 220 - age;
        double v = getValue();
        return v < max * 0.5 ? "Покой" : v < max * 0.7 ? "Жиросжигание" : v < max * 0.85 ? "Кардио" : "Максимум";
    }

    public String getInfo() {
        return super.getInfo() + " — зона: " + getZone();
    }

    public String toString() {
        return "HeartRate{пульс=" + (int) getValue() + ", возраст=" + age + ", зона=" + getZone() + "}";
    }
}

public class HealthDemo {
    public static void main(String[] args) {
        HealthMetric[] metrics = {
            new BMI(1.75, 70),
            new BMI(1.60, 50),
            new HeartRate(75, 30),
            new HeartRate(120, 25)
        };


        for (HealthMetric m : metrics) {
            System.out.println(m.getInfo());
            System.out.println("  " + m);
        }


        HealthMetric a = new BMI(1.75, 70);
        HealthMetric b = new BMI(1.75, 70);
        System.out.println("\na.equals(b): " + a.equals(b));
        System.out.println("hashCode a: " + a.hashCode() + ", b: " + b.hashCode());
    }
}