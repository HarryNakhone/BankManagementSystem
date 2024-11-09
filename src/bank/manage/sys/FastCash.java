package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, fastC, pinC, cashW, miniS, balanceE, exit;
    String pin;


    public FastCash(String pin){

        this.pin = pin;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/file.png"));
        Image img1 = icon1.getImage().getScaledInstance(1300, 960, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img1);
        JLabel image = new JLabel(icon2);
        image.setBounds(0,0,1550, 1000);
        add(image);

        JLabel headerLabel= new JLabel("Select Withdrawal Amount");
        headerLabel.setFont(new Font("System", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(621,140, 400, 35);
        image.add(headerLabel);

        deposit = new JButton("Amount No.1: $20");
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(new Color(241, 241, 238));
        deposit.setBounds(497, 190, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);

        cashW = new JButton("Amount No.2: $50");
        cashW.setForeground(Color.BLACK);
        cashW.setBackground(new Color(241, 241, 238));
        cashW.setBounds(497, 254, 150, 35);
        cashW.addActionListener(this);
        image.add(cashW);

        balanceE = new JButton("Amount No.3: $100");
        balanceE.setForeground(Color.BLACK);
        balanceE.setBackground(new Color(241, 241, 238));
        balanceE.setBounds(497, 318, 150, 35);
        balanceE.addActionListener(this);
        image.add(balanceE);


        fastC = new JButton("Amount No.4: $200");
        fastC.setForeground(Color.BLACK);
        fastC.setBackground(new Color(241, 241, 238));
        fastC.setBounds(908, 190, 150, 35);
        fastC.addActionListener(this);
        image.add(fastC);

        pinC = new JButton("Amount No.5: $300");
        pinC.setForeground(Color.BLACK);
        pinC.setBackground(new Color(241, 241, 238));
        pinC.setBounds(908, 254, 150, 35);
        pinC.addActionListener(this);
        image.add(pinC);

        miniS = new JButton("Amount No.6: $500");
        miniS.setForeground(Color.BLACK);
        miniS.setBackground(new Color(241, 241, 238));
        miniS.setBounds(908, 318, 150, 35);
        miniS.addActionListener(this);
        image.add(miniS);

        exit = new JButton("BACK");
        exit.setForeground(Color.BLACK);
        exit.setBackground(new Color(241, 241, 238));
        exit.setBounds(908, 382, 150, 35);
        exit.addActionListener(this);
        image.add(exit);



        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);

    }

    public static void main(String[] args){
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            setVisible(false);
            new MainB(pin);
        }else{
            String amount = ((JButton)e.getSource()).getText().substring(14);
            Connec connection = new Connec();
            Date date =new Date();


            try{
                ResultSet resultSet = connection.statement.executeQuery("select * from bankacc where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));

                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "");
                    return;
                }

                connection.statement.executeUpdate("insert into bankacc values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null,  " Fast Cash withdrawal has been successfully completed");

            }catch (Exception E){
                E.printStackTrace();
            }

            setVisible(false);
            new MainB(pin);
        }

    }
}
