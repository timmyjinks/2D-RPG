package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Base extends JFrame {
    Image img;
     protected Base(){

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.getContentPane().setBackground(Color.black);
         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         this.setLayout(null);
         this.setVisible(true);
    }

}
