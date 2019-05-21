package phil.fsst;

import javax.swing.*;
import java.awt.*;

public class uiVersion {
    private JPanel mainframe;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ausgewähltesItemZumKampfButton;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextField textField4;

    public static void main(String[] args) {
        JFrame frame = new JFrame("uiVersion");
        frame.setContentPane(new uiVersion().mainframe);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


