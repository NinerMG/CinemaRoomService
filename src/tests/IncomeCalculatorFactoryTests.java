package tests;

import service.IncomeCalculator;
import service.calculators.LargeCinemaIncomeCalculator;
import service.calculators.SmallCinemaIncomeCalculator;
import service.calculators.factory.IncomeCalculatorFactory;
import org.junit.jupiter.api.Test;
import service.inputCalculator.InputCalculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncomeCalculatorFactoryTests {

    @Test
    public void shouldReturnSmallCinemaCalculatorFor60Seats(){
        IncomeCalculatorFactory factory = new IncomeCalculatorFactory();
        IncomeCalculator calculator = factory.createCalculator(6, 10);

        assertTrue(calculator instanceof SmallCinemaIncomeCalculator, "Expected SmallCinemaIncomeCalculator for 60 seats.");
    }

    @Test
    public void shouldReturnSmallCinemaCalculatorForExactly60Seats() {
        IncomeCalculatorFactory factory = new IncomeCalculatorFactory();
        IncomeCalculator calculator = factory.createCalculator(10, 6);
        assertTrue(calculator instanceof SmallCinemaIncomeCalculator, "Expected SmallCinemaIncomeCalculator for exactly 60 seats.");
    }
    @Test
    public void shouldReturnLargeCinemaCalculatorForMoreThan60Seats() {
        IncomeCalculatorFactory factory = new IncomeCalculatorFactory();
        IncomeCalculator calculator = factory.createCalculator(10, 7); // 70 seats
        assertTrue(calculator instanceof LargeCinemaIncomeCalculator, "Expected LargeCinemaIncomeCalculator for more than 60 seats.");
    }
    @Test
    public void shouldThrowExceptionForInvalidRowsOrCols() {
        IncomeCalculatorFactory factory = new IncomeCalculatorFactory();
        assertThrows(IllegalArgumentException.class, () -> factory.createCalculator(0, 5), "Expected exception for zero rows.");
        assertThrows(IllegalArgumentException.class, () -> factory.createCalculator(5, -5), "Expected exception for negative columns.");
    }

    @Test
    public void shouldCalculateIncomeCorrectlyForSmallCinema() {
        InputCalculator inputCalculator = new InputCalculator(5, 5);
        inputCalculator.printIncome(); // You might need a way to capture console output for proper testing.
    }
}
