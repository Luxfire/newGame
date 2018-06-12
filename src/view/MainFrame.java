package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public JFrame frame;

    public MainFrame()
    {
        frame = new JFrame("Аэропорт");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int size=Toolkit.getDefaultToolkit().getScreenSize().height;
        frame.setSize(size,size);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
