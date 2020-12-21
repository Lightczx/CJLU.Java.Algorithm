package DGP.CJLU.CourseDesign;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Calculator {
    private static Calculator instance;
    private JTextField expressionText;
    private JLabel resultText;
    private JPanel panel;
    private JButton calculateButton;

    public Calculator() {
        instance = this;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 300);

        instance.calculateButton.addActionListener(Calculator::getResult);
    }

    private static void getResult(ActionEvent e) {
        if (!"".equals(instance.expressionText.getText())) {
            try {
                Infix infix = new Infix(instance.expressionText.getText());
                String result = String.valueOf(infix.toSuffix().evaluate());
                instance.resultText.setText(result);
            } catch (Throwable throwable) {
                instance.resultText.setText("表达式不正确");
            }
        } else {
            instance.resultText.setText("表达式不能为空");
        }
    }
}
