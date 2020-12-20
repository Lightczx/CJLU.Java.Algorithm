package DGP.CJLU.CourseDesign;

import javax.swing.*;

/**
 * @author 16861
 */
public class InsertDialog {
    private JPanel panel;
    private JTextField numberText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField phoneText;
    private JButton confirmButton;

    public void show() {
        JFrame frame = new JFrame("插入");
        frame.setContentPane(this.panel);
        frame.pack();
        frame.setVisible(true);
    }

}
