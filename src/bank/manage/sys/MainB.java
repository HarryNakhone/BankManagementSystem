package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainB extends JFrame implements ActionListener {
    JButton deposit, fastC, pinC, cashW, miniS, balanceE, exit;
    String pin;

    MainB (String pin){

        this.pin = pin;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/file.png"));
        Image img1 = icon1.getImage().getScaledInstance(1300, 960, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img1);
        JLabel image = new JLabel(icon2);
        image.setBounds(0,0,1550, 1000);
        add(image);

        JLabel headerLabel= new JLabel("Please Select your Transaction");
        headerLabel.setFont(new Font("System", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(621,140, 400, 35);
        image.add(headerLabel);

        deposit = new JButton("DEPOSIT");
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(new Color(241, 241, 238));
        deposit.setBounds(497, 190, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);

        cashW = new JButton("CASH WITHDRAWL");
        cashW.setForeground(Color.BLACK);
        cashW.setBackground(new Color(241, 241, 238));
        cashW.setBounds(497, 254, 150, 35);
        cashW.addActionListener(this);
        image.add(cashW);

        balanceE = new JButton("BALANCE ENQUIRY");
        balanceE.setForeground(Color.BLACK);
        balanceE.setBackground(new Color(241, 241, 238));
        balanceE.setBounds(497, 318, 150, 35);
        balanceE.addActionListener(this);
        image.add(balanceE);


        fastC = new JButton("FAST CASH");
        fastC.setForeground(Color.BLACK);
        fastC.setBackground(new Color(241, 241, 238));
        fastC.setBounds(908, 190, 150, 35);
        fastC.addActionListener(this);
        image.add(fastC);

        pinC = new JButton("PIN CHANGE");
        pinC.setForeground(Color.BLACK);
        pinC.setBackground(new Color(241, 241, 238));
        pinC.setBounds(908, 254, 150, 35);
        pinC.addActionListener(this);
        image.add(pinC);

        miniS = new JButton("MINI STATEMENT");
        miniS.setForeground(Color.BLACK);
        miniS.setBackground(new Color(241, 241, 238));
        miniS.setBounds(908, 318, 150, 35);
        miniS.addActionListener(this);
        image.add(miniS);

        exit = new JButton("EXIT");
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

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==deposit){
            new Deposit(pin);
            setVisible(false);
        }else if(e.getSource()==cashW){
            new Withdrawal(pin);
            setVisible(false);

        }else if(e.getSource()==balanceE){
            new BalanceEnquiry(pin);
            setVisible(false);

        }else if (e.getSource()==fastC){
            new FastCash(pin);
            setVisible(false);
        }else if (e.getSource() ==pinC){
            new PinChange(pin);
            setVisible(false);
        }else if (e.getSource() == miniS){
            new MiniStatement(pin);
        }

        else if (e.getSource()==exit){
            System.exit(0);
        }

    }
    public static void main(String[] args){
        System.out.println(new MainB(""));

    }
}
