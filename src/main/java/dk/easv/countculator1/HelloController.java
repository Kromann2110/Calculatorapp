package dk.easv.countculator1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML
    private TextArea Result;

    @FXML private Button bntDelete;
    @FXML private Button bntPlusMinus;
    @FXML private Button bntDivide;
    @FXML private Button bnt7;
    @FXML private Button btn8;
    @FXML private Button btn9;
    @FXML private Button btnTimes;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btnMinus;
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;   // maybe rename to btn3 in both FXML + code for consistency
    @FXML private Button btnPlus;
    @FXML private Button btn0;
    @FXML private Button btnComma;
    @FXML private Button btnEqual;

    // Calculator state
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    protected void onHelloButtonClick(javafx.event.ActionEvent event) {
        Object source = event.getSource();

        // Number buttons
        if (source == btn0) appendNumber("0");
        else if (source == btn1) appendNumber("1");
        else if (source == btn2) appendNumber("2");
        else if (source == btn3) appendNumber("3");
        else if (source == btn4) appendNumber("4");
        else if (source == btn5) appendNumber("5");
        else if (source == btn6) appendNumber("6");
        else if (source == bnt7) appendNumber("7");
        else if (source == btn8) appendNumber("8");
        else if (source == btn9) appendNumber("9");

            // Decimal
        else if (source == btnComma) appendDecimal();

            // Operators
        else if (source == btnPlus) setOperator("+");
        else if (source == btnMinus) setOperator("-");
        else if (source == btnTimes) setOperator("X");
        else if (source == bntDivide) setOperator("/");

            // Special
        else if (source == btnEqual) calculateResult();
        else if (source == bntDelete) clear();
        else if (source == bntPlusMinus) toggleSign();
    }

    // === Helper methods ===

    private void appendNumber(String num) {
        if (startNewNumber) {
            Result.setText(num);
            startNewNumber = false;
        } else {
            Result.appendText(num);
        }
    }

    private void appendDecimal() {
        if (startNewNumber) {
            Result.setText("0.");
            startNewNumber = false;
        } else if (!Result.getText().contains(".")) {
            Result.appendText(".");
        }
    }

    private void setOperator(String op) {
        firstNumber = Double.parseDouble(Result.getText().replace(",", "."));
        operator = op;
        startNewNumber = true;
    }

    private void calculateResult() {
        double secondNumber = Double.parseDouble(Result.getText().replace(",", "."));
        double result = calculate(firstNumber, secondNumber, operator);
        Result.setText(String.valueOf(result));
        startNewNumber = true;
    }

    private void clear() {
        Result.clear();
        firstNumber = 0;
        operator = "";
        startNewNumber = true;
    }

    private void toggleSign() {
        if (!Result.getText().isEmpty()) {
            double current = Double.parseDouble(Result.getText().replace(",", "."));
            current = -current;
            Result.setText(String.valueOf(current));
        }
    }

    private double calculate(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "X" -> a * b;
            case "/" -> b != 0 ? a / b : 0; // safe divide
            default -> 0;
        };
    }
}
