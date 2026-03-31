package lab5.advanced;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(Integer state) {
        super(state);
    }

    @Override
    public void init(Object value) {
        this.state = (Integer) value;
    }

    public NewIntCalculator add(Integer value) {
        this.state = (Integer) state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value) {
        this.state = (Integer) state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value) {
        this.state = (Integer) state * value;
        return this;
    }
}