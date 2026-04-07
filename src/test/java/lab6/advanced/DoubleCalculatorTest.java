package lab6.advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoubleCalculatorTest {

    // INIT
    @Test
    void testInit() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator();

        // Act
        calculator.init();

        // Assert
        assertEquals(0.0, calculator.state);
    }

    // ADD
    @Test
    void testAdd() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init();

        // Act
        calculator.add(5.0);

        // Assert
        assertEquals(5.0, calculator.state);
    }

    @Test
    void testAddNull_ShouldThrowException() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init();

        // Act & Assert
        assertThrows(NullPointerException.class, () -> calculator.add(null));
    }

    // SUBTRACT
    @Test
    void testSubtract() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init().add(10.0);

        // Act
        calculator.subtract(4.0);

        // Assert
        assertEquals(6.0, calculator.state);
    }

    @Test
    void testSubtractNull_ShouldThrowException() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init();

        // Act & Assert
        assertThrows(NullPointerException.class, () -> calculator.subtract(null));
    }

    // MULTIPLY
    @Test
    void testMultiply() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init().add(5.0);

        // Act
        calculator.multiply(2.0);

        // Assert
        assertEquals(10.0, calculator.state);
    }

    @Test
    void testMultiplyNull_ShouldThrowException() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init();

        // Act & Assert
        assertThrows(NullPointerException.class, () -> calculator.multiply(null));
    }

    // DIVIDE
    @Test
    void testDivide() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init().add(10.0);

        // Act
        calculator.divide(2.0);

        // Assert
        assertEquals(5.0, calculator.state);
    }

    @Test
    void testDivideByZero_ShouldThrowException() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init().add(10.0);

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> calculator.divide(0.0));
    }

    @Test
    void testDivideNull_ShouldThrowException() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(null));
    }

    // CHAIN
    @Test
    void testChainedOperations() {
        // Arrange
        DoubleCalculator calculator = new DoubleCalculator().init();

        // Act
        calculator.add(10.0)
                .subtract(2.0)
                .multiply(3.0)
                .divide(4.0);

        // Assert
        assertEquals(6.0, calculator.state);
    }
}