package DGP.CJLU.CourseDesign;

import javax.swing.*;

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

        instance.calculateButton.addActionListener(e -> {
            if (!"".equals(instance.expressionText.getText())) {
                try {
                    Infix infix = new Infix(instance.expressionText.getText());
                    instance.resultText.setText(String.valueOf(infix.toSuffix().evaluate()));
                } catch (Throwable throwable) {
                    instance.resultText.setText("表达式不正确");
                }
            } else {
                instance.resultText.setText("表达式不能为空");
            }
        });

    }
}
