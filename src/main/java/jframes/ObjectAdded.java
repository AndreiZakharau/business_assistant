package jframes;

import javax.swing.*;
import java.awt.*;

public class ObjectAdded extends JFrame {
    public ObjectAdded(){
        setLocationRelativeTo(null);
        setTitle("     Object added");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(2);
        add(new JLabel("OK.   \n OBJECT ADDED."));
        setSize(300,200);
        setVisible(true);

    }
}
