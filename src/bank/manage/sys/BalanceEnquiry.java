package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;
    JLabel balanceNum;

    JButton back;
    BalanceEnquiry(String pin){
        this.pin = pin;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/file.png"));
        Image img1 = icon1.getImage().getScaledInstance(1300, 960, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img1);
        JLabel image = new JLabel(icon2);
        image.setBounds(0,0,1550, 1000);
        add(image);

        JLabel label1 = new JLabel("Total Balance In the Account");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 24));
        label1.setBounds(600,140, 400, 35);
        image.add(label1);

        balanceNum = new JLabel();
        balanceNum.setForeground(Color.WHITE);
        balanceNum.setFont(new Font ("System", Font.BOLD, 21));
        balanceNum.setBounds(500,210, 400, 21);
        image.add(balanceNum);

        back =  new JButton("Back");
        back.setBounds(923, 370, 120, 35);
        back.setBackground(new Color(241, 241, 238));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;

        try{
            Connec connection  = new Connec();
            ResultSet resultSet = connection.statement.executeQuery("select * from bankacc where pin = '"+pin+"'");
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));

                }else{
                    balance -=Integer.parseInt(resultSet.getString("amount"));
                }

            }

        }catch(Exception E){
            E.printStackTrace();
        }

        balanceNum.setText("Balance: " + String.valueOf(balance));



        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new MainB(pin);
    }
}
