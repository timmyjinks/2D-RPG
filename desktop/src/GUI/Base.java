package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Base extends JFrame {
     protected Base(){
         this.setLayout(null);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
