package lab6.advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewIntCalculatorTest {

    // INIT
    @Test
    void testInit() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator();

        // Act
        calculator.init();

        // Assert
        assertEquals(0, calculator.state);
    }

    // ADD
    @Test
    void testAdd() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init();

        // Act
        calculator.add(5);

        // Assert
        assertEquals(5, calculator.state);
    }

    @Test
    void testAddNull_ShouldThrowException() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init();

        // Act & Assert
        assertThrows(NullPointerException.class, () -> calculator.add(null));
    }

    // SUBTRACT
    @Test
    void testSubtract() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init().add(10);

        // Act
        calculator.subtract(4);

        // Assert
        assertEquals(6, calculator.state);
    }

    @Test
    void testSubtractNull_ShouldThrowException() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init();

        // Act & Assert
        assertThrows(NullPointerException.class, () -> calculator.subtract(null));
    }

    // MULTIPLY
    @Test
    void testMultiply() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init().add(5);

        // Act
        calculator.multiply(2);

        // Assert
        assertEquals(10, calculator.state);
    }

    @Test
    void testMultiplyNull_ShouldThrowException() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init();

        // Act & Assert
        assertThrows(NullPointerException.class, () -> calculator.multiply(null));
    }

    // DIVIDE
    @Test
    void testDivide() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init().add(10);

        // Act
        calculator.divide(2);

        // Assert
        assertEquals(5, calculator.state);
    }

    @Test
    void testDivideByZero_ShouldThrowException() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init().add(10);

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> calculator.divide(0));
    }

    @Test
    void testDivideNull_ShouldThrowException() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(null));
    }

    // CHAIN
    @Test
    void testChainedOperations() {
        // Arrange
        NewIntCalculator calculator = new NewIntCalculator().init();

        // Act
        calculator.add(10)
                .subtract(2)
                .multiply(3)
                .divide(4);

        // Assert
        assertEquals(6, calculator.state);
    }
}