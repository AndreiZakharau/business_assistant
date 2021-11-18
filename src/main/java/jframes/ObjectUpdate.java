package jframes;

import javax.swing.*;
import java.awt.*;

public class ObjectUpdate extends JFrame {

    public ObjectUpdate() {
       setLocationRelativeTo(null);
       setTitle("Object update");
       setLayout(new FlowLayout());
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       add(new JLabel(" UPDATE SAVE. "));
       setSize(300,200);
       setVisible(true);
    }

}
