package practice_4;

public class Matrix {
    
    private double[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0)
            throw new IllegalArgumentException("Недопустимый размер");
        data = new double[rows][cols];
    }

    public void set(int row, int col, double value) {
        if (row < 0 || row >= data.length || col < 0 || col >= data[0].length)
            throw new IllegalArgumentException("Недопустимый индекс");
        data[row][col] = value;
    }

    public int size() {
        return data.length * data[0].length;
    }

    public double sum() {
        double s = 0;
        for (double[] row : data)
            for (double v : row) s += v;
        return s;
    }

    public void multiply(double num) {
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                data[i][j] *= num;
    }

    public void add(double num) {
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                data[i][j] += num;
    }

    public void print() {
        for (double[] row : data) {
            for (double v : row)
                System.out.printf("%6.1f", v);
            System.out.println();
        }
    }

    public static void main() {
        Matrix m = new Matrix(2, 3);
        m.set(0, 0, 1); m.set(0, 1, 2); m.set(0, 2, 3);
        m.set(1, 0, 4); m.set(1, 1, 5); m.set(1, 2, 6);

        System.out.println("Матрица:\n");
        m.print();
        System.out.println("Размер: " + m.size());
        System.out.println("Сумма: " + m.sum());

        m.multiply(2);
        System.out.println("После умножения на 2:\n");
        m.print();

        m.add(1);
        System.out.println("После прибавления 1:\n");
        m.print();
    }
}