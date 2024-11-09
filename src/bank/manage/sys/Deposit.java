package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField textDepo;

    String pin;

    JButton depositButton, cancelButton;


    Deposit(String pin){
        this.pin = pin;

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/file.png"));
        Image img1 = icon1.getImage().getScaledInstance(1300, 960, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img1);
        JLabel image = new JLabel(icon2);
        image.setBounds(0,0,1550, 1000);
        add(image);

        JLabel label1 = new JLabel("Enter the amount to deposit");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 24));
        label1.setBounds(621,140, 400, 35);
        image.add(label1);

        textDepo  = new JTextField();
        textDepo.setFont(new Font("Verdana", Font.BOLD, 21));
        textDepo.setBounds(582, 170, 400, 35);
        image.add(textDepo);


        depositButton =  new JButton("Deposit");
        depositButton.setBounds(920, 320, 120, 35);
        depositButton.setBackground(new Color(241, 241, 238));
        depositButton.setForeground(Color.BLACK);
        depositButton.addActionListener(this);
        image.add(depositButton);

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

        try {
            String amount = textDepo.getText();
            Date date = new Date();
            if (e.getSource() == depositButton) {

                if (textDepo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");

                } else {
                    Connec connection = new Connec();
                    connection.statement.executeUpdate("insert  into bankacc values('" + pin + "','" + date + "','Deposit','" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Successfully Deposited : " + amount );
                    setVisible(false);
                    new MainB(pin);
                }
            }else if (e.getSource()==cancelButton){
                setVisible(false);
                new MainB(pin);

            }
        }catch (Exception E) {

            E.printStackTrace();
        }
    }

    public static void main(String[]args ){
        new Deposit("");
    }



    }

