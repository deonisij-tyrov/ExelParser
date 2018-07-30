import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

@Data
public class Panel extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JTextField textField2;
    private JButton exitButton;
    private JButton goButton;

    public Panel() {
        this.getContentPane().add(panel);
        this.button1.addActionListener(new Button1Listener());
        this.button2.addActionListener(new Button2Listener());
        this.exitButton.addActionListener(new CloseListener());
        this.goButton.addActionListener(new FileWorkListener());
    }

    public String returnPath1() {
        if (textField1.getText() != null && !textField1.getText().equals("")) {
            return textField1.getText();
        } else {
            JOptionPane.showMessageDialog(this, "error");
            dispose();
            System.exit(0);
        }
        return null;
    }

    public String returnPath2() {
        if (textField2.getText() != null && !textField2.getText().equals("")) {
            return textField2.getText();
        } else {
            JOptionPane.showMessageDialog(this, "error");
            dispose();
            System.exit(0);
        }
        return null;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        textField1 = new JTextField();
        panel.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        button1 = new JButton();
        button1.setHorizontalAlignment(0);
        button1.setText("...");
        panel.add(button1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, 20), new Dimension(50, 20), 0, false));
        textField2 = new JTextField();
        panel.add(textField2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        button2 = new JButton();
        button2.setHorizontalAlignment(0);
        button2.setText("...");
        panel.add(button2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, 20), new Dimension(50, 20), 0, false));
        exitButton = new JButton();
        exitButton.setText("Exit");
        panel.add(exitButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(100, 20), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        goButton = new JButton();
        goButton.setText("go");
        panel.add(goButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(50, 20), 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

    private class Button1Listener implements ActionListener {
        private File file;

        public File getFile() {
            return file;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = fileopen.getSelectedFile();
                textField1.setText(file.getAbsolutePath());
            }
        }
    }

    private class Button2Listener implements ActionListener {
        private File file;

        public File getFile() {
            return file;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = fileopen.getSelectedFile();
                textField2.setText(file.getAbsolutePath());
            }
        }
    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class FileWorkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FormExel formExel = new FormExel();
            FirstFileLoader firstFileLoader = new FirstFileLoader();
            firstFileLoader.pars(textField1.getText());
            SecondFileLoader secondFileClass = new SecondFileLoader();
            secondFileClass.pars(textField2.getText());
            formExel.pars(firstFileLoader.getCellMap(), secondFileClass.getCells());
            JOptionPane.showMessageDialog(null, "OK");
        }

//        private void printFirstFile() {
//            FirstFileLoader firstFileLoader = new FirstFileLoader();
//            firstFileLoader.pars(textField1.getText());
//            Map<Integer, FirstFileClass> map = firstFileLoader.getCellMap();
//            for (Map.Entry<Integer, FirstFileClass> m : map.entrySet()) {
//                System.out.println(m.getKey() + " " + m.getValue().toString());
//            }
//        }
//
//        private void printSecondFile() {
//            SecondFileLoader secondFileClass = new SecondFileLoader();
//            secondFileClass.pars(textField2.getText());
//            for (SecondFileClass f : secondFileClass.getCells()) {
//                System.out.println(f.toString());
//            }
//        }
    }
}
