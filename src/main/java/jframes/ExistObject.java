package jframes;

import javax.swing.*;
import java.awt.*;


public class ExistObject extends JFrame {

    public ExistObject() {

        setLocationRelativeTo(null);
        setTitle(" Already exists ");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel("ALREADY EXIST, TRY AGAIN."));
        setSize(300, 100);
        setVisible(true);
    }

}

