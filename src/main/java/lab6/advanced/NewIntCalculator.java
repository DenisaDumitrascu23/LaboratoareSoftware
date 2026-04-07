package lab6.advanced;

public class NewIntCalculator extends ACalculator<Integer> {

    @Override
    NewIntCalculator init() {
        state = 0;
        return this;
    }

    public  NewIntCalculator add(Integer a) {
        state = (Integer)state + a;
        return this;
    }

    public  NewIntCalculator subtract(Integer a) {
        state = (Integer)state - a;
        return this;
    }
    public  NewIntCalculator multiply(Integer a) {
        state = (Integer)state * a;
        return this;
    }
    public NewIntCalculator divide(Integer a) {
        if (a == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }
        if (a == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        state = (Integer)state / a;
        return this;
    }
}
