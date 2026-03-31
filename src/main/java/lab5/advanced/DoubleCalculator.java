package lab5.advanced;

public class DoubleCalculator extends ACalculator {

    public DoubleCalculator(Double state) {
        super(state);
    }

    @Override
    public void init(Object value) {
        this.state = (Double) value;
    }

    public DoubleCalculator add(Double value) {
        this.state = (Double) state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value) {
        this.state = (Double) state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value) {
        this.state = (Double) state * value;
        return this;
    }
}