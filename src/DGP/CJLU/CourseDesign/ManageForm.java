package DGP.CJLU.CourseDesign;

import javax.swing.*;

/**
 * 3.5 身份证信息管理系统
 * 【问题描述】
 * 建立一个身份证信息管理系统，能够进行身份证信息的录入、查找，要求考虑查找效率。
 * 【任务要求】
 * (1)能够进行身份证号码及相关信息的录入，相关信息包括姓名、地址和手机号；
 * (2)能够快速进行身份证号码的查询，并输出相关信息；
 * (3)可以修改身份证号码对应的其他信息，如姓名、地址；
 * (4)可以完成身份证信息的删除；
 * (5)根据需求分析结果确定程序的总体设计，每个功能有输入和输出，采用交互式。
 *
 * @author 16861
 */
public class ManageForm {
    public static ManageForm thisForm;
    private JPanel panel;
    private JTable dataView;
    private JButton insertButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ManageForm");
        thisForm = new ManageForm();
        frame.setContentPane(thisForm.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        thisForm.insertButton.addActionListener(e -> {
            openInsertDialog();
        });
    }

    public static void openInsertDialog() {
        new InsertDialog().show();
    }

    private static void addActionListener(JButton button) {
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "保存成功！");
        });
    }
}
