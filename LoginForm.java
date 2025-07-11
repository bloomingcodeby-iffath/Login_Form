package MyProjectLoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class LoginForm extends JFrame {
    Container c;
    JTextField tf;
    JButton bt1, bt2;
    JLabel un, pass;
    Font f;
    JPasswordField pf;
    JCheckBox remember;

    LoginForm() {
        setBounds(150, 200, 480, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Form");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        f = new Font("Arial", Font.BOLD, 14);

        un = new JLabel("Username: ");
        un.setBounds(50, 50, 150, 50);
        un.setFont(f);
        c.add(un);

        tf = new JTextField();
        tf.setBounds(150, 50, 200, 50);
        tf.setFont(f);
        c.add(tf);

        pass = new JLabel("Password ");
        pass.setBounds(50, 120, 150, 50);
        pass.setFont(f);
        c.add(pass);

        pf = new JPasswordField();
        pf.setBounds(150, 120, 200, 50);
        pf.setFont(f);
        pf.setEchoChar('•');
        c.add(pf);

        JButton eyeButton = new JButton("show");
        eyeButton.setBounds(360, 120, 80, 50);
        eyeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        eyeButton.setFocusPainted(false);
        c.add(eyeButton);

        eyeButton.addActionListener(new ActionListener() {
            boolean showing = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (showing) {
                    pf.setEchoChar('•');
                } else {
                    pf.setEchoChar((char) 0);
                }
                showing = !showing;
            }
        });

        //  Remember Me Checkbox
        remember = new JCheckBox("Remember me");
        remember.setBounds(150, 170, 150, 20);
        remember.setBackground(Color.LIGHT_GRAY);
        remember.setFont(new Font("Arial", Font.PLAIN, 12));
        c.add(remember);

        bt1 = new JButton("Login");
        bt1.setBounds(100, 210, 100, 40);
        c.add(bt1);

        bt2 = new JButton("Clear");
        bt2.setBounds(220, 210, 100, 40);
        c.add(bt2);

        //  Login Button
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tf.getText().trim();
                String s2 = pf.getText().trim();

                if (s.isEmpty() || s2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both Username and Password.");
                } else if (s.equals("Iffath_Sanjida") && s2.equals("222")) {
                    JOptionPane.showMessageDialog(null, "Welcome to the page!");

                    // Save login info (optional, only if "Remember me" checked)
                    if (remember.isSelected()) {
                        try (FileWriter fw = new FileWriter("login.txt", true)) {
                            fw.write("Username: " + s + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    NewFrame frame2 = new NewFrame();
                    frame2.setVisible(true);
                    dispose(); // close login frame
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid password or Username");
                }
            }
        });

        //  Clear Button
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pf.setText("");
                tf.setText("");
                remember.setSelected(false);
            }
        });
    }

    public static void main(String[] args) {
        LoginForm frame = new LoginForm();
        frame.setVisible(true);
    }
}
