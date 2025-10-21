package dk.easv.countculator1.business;

public class Calculator {

    public double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "X": return a * b;
            case "/": return b != 0 ? a / b : 0; // avoid divide by zero
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public double toggleSign(double number) {
        return -number;
    }

    public double percentage(double number) {
        return number / 100;
    }
}
