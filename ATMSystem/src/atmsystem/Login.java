package atmsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;

    Login() {
        setTitle("AUTOMATED TALLER MACHINE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atmsystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(60, 5, 90, 270);
        add(l11);

        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l2 = new JLabel("CARD NO :");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));

        l3 = new JLabel("PIN :");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));

        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);

        b1 = new JButton("Sign In");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Clear");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("Sign up");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        setLayout(null);

        l1.setBounds(175, 50, 450, 200);
        add(l1);

        l2.setBounds(125, 150, 375, 200);
        add(l2);

        l3.setBounds(125, 225, 375, 200);
        add(l3);

        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(300, 235, 230, 30);
        add(tf1);

        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 310, 230, 30);
        add(pf2);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 400, 100, 30);
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 400, 100, 30);
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300, 450, 230, 30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(750, 750);
        setLocation(500, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            if (ae.getSource() == b1) {
                Conn c1 = new Conn();

                String cardno = tf1.getText();
                String pin = pf2.getText();

                String q = "select * from login where cardno = '" + cardno + "'and pin='" + pin + "'";
                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    setVisible(false);
                    new Transcation(pin).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Password");
                }
            } else if (ae.getSource() == b2) {
                tf1.setText("");
                pf2.setText("");
            } else if (ae.getSource() == b3) {
                setVisible(false);
                new Signup().setVisible(true);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error :" + e);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}
