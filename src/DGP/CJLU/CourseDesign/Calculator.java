package DGP.CJLU.CourseDesign;

import javax.swing.*;

/**
 * @author 16861
 */

//TODO:-1*(-(-1))
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

        instance.calculateButton.addActionListener(e -> getResult());
    }

    private static void getResult() {
        if (!"".equals(instance.expressionText.getText())) {
            try {
                Infix infix = new Infix(instance.expressionText.getText());
                Suffix suffix = infix.toSuffix();
                //System.out.println(suffix);
                String result = String.valueOf(suffix.evaluate());
                instance.resultText.setText(result);
            } catch (Throwable throwable) {
                instance.resultText.setText(throwable.getClass().getSimpleName() + throwable.getMessage());
                System.out.println(throwable.getClass().getSimpleName());
            }
        } else {
            instance.resultText.setText("表达式不能为空");
        }
    }
}
