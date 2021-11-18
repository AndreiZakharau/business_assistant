package jframes;

import javax.swing.*;
import java.awt.*;

public class DeleteObject extends JFrame {

    public DeleteObject(){
        setLocationRelativeTo(null);
        setTitle("Object delete");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel("OBJECT HAS BEEN REMOVED."));
        setSize(300,200);
        setVisible(true);
    }
}
