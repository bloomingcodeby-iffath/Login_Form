package MyProjectLoginForm;

import javax.swing.*;
import java.awt.*;

public class NewFrame extends JFrame {
    Container c;
    JLabel l;
    NewFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome, Iffath!", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        add(label);
    }

    public static void main(String[] args) {
        NewFrame fr=new NewFrame();
        fr.setVisible(true);
    }

}
