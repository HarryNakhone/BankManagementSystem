package bank.manage.sys;

import com.mysql.cj.protocol.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField textWit;

    String pin;

    JButton withDrawButton, cancelButton;

    public Withdrawal(String pin){
        this.pin = pin;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/file.png"));
        Image img1 = icon1.getImage().getScaledInstance(1300, 960, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img1);
        JLabel image = new JLabel(icon2);
        image.setBounds(0,0,1550, 1000);
        add(image);

        JLabel label1 = new JLabel("Enter The Amount");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 24));
        label1.setBounds(660,140, 400, 35);
        image.add(label1);

        textWit  = new JTextField();
        textWit.setFont(new Font("Verdana", Font.BOLD, 21));
        textWit.setBounds(582, 170, 400, 35);
        add(textWit);

        JLabel label2 = new JLabel("(Notes: Maximum Amount that can be Withdrawn is 10,000)");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font ("System", Font.BOLD, 11));
        label2.setBounds(582,210, 400, 20);
        image.add(label2);


        withDrawButton =  new JButton("Withdraw");
        withDrawButton.setBounds(920, 320, 120, 35);
        withDrawButton.setBackground(new Color(241, 241, 238));
        withDrawButton.setForeground(Color.BLACK);
        withDrawButton.addActionListener(this);
        image.add(withDrawButton);

        cancelButton =  new JButton("Cancel");
        cancelButton.setBounds(920, 370, 120, 35);
        cancelButton.setBackground(new Color(241, 241, 238));
        cancelButton.setForeground(Color.BLACK);
        cancelButton.addActionListener(this);
        image.add(cancelButton);


        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==withDrawButton) {


            try {
                String amount = textWit.getText();
                Date date = new Date();
                if (textWit.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");

                } else {
                    Connec connection = new Connec();
                    ResultSet resultSet = connection.statement.executeQuery("select * from bankacc where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));

                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    connection.statement.executeUpdate("insert into bankacc values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Your withdrawal was processed successfully");
                    setVisible(false);
                    new MainB(pin);
                }

            } catch (Exception E) {
                E.printStackTrace();

            }
        }else if(e.getSource()==cancelButton){
            setVisible(false);
            new MainB(pin);
        }
    }

    public static void main(String [] args){
        new Withdrawal("");

    }
}
