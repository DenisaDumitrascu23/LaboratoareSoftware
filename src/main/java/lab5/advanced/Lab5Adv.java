package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {

        NewIntCalculator intCalc = new NewIntCalculator(10);
        int result1 = (Integer) intCalc.add(5)
                .subtract(3)
                .multiply(2)
                .result();

        System.out.println("Integer result: " + result1);

        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        double result2 = (Double) doubleCalc.add(5.0)
                .subtract(3.3)
                .multiply(2.2)
                .result();

        System.out.println("Double result: " + result2);
    }
}