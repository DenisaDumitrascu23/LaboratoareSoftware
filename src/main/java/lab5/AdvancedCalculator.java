package lab5;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int state) {
        super(state);
    }

    public AdvancedCalculator divide(int value) {
        if (value != 0) {
            this.state /= value;
        } else {
            System.out.println("Nu se poate imparti la 0");
        }
        return this;
    }

    public AdvancedCalculator power(int exponent) {
        this.state = (int) Math.pow(this.state, exponent);
        return this;
    }

    public AdvancedCalculator root(int n) {
        if (n > 0) {
            this.state = (int) Math.pow(this.state, 1.0 / n);
        } else {
            System.out.println("Nu se poate calcula radicalul");
        }
        return this;
    }
}