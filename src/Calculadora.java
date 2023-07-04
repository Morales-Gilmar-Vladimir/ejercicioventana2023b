import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;
    private double num1;
    private double num2;
    private String operator;
    private boolean isResultShown;

    public Calculadora() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        panel.add(display, BorderLayout.NORTH);
        panel.add(createButtonPanel(), BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String buttonText = ((JButton) e.getSource()).getText();

            if (buttonText.matches("[0-9.]")) {
                if (isResultShown) {
                    display.setText("");
                    isResultShown = false;
                }
                display.setText(display.getText() + buttonText);
            } else if (buttonText.matches("[/+\\-*]")) {
                num1 = Double.parseDouble(display.getText());
                operator = buttonText;
                display.setText("");
            } else if (buttonText.equals("=")) {
                num2 = Double.parseDouble(display.getText());
                double result = calculateResult();
                display.setText(String.valueOf(result));
                isResultShown = true;
            }
        }

        private double calculateResult() {
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculadora();
            }
        });
    }
}