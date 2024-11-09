package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton rButton1, rButton2, rButton3, rButton4;

    JCheckBox cBox1, cBox2, cBox3, cBox4, cBox5, cBox6;

    JButton submit, cancel;

    String formno;
    Signup3(String formno){

        super("APPLICATION FORM");
        this.formno = formno;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/authe.png"));
        Image img = icon1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img);
        JLabel image = new JLabel(icon2);
        image.setBounds(60, 10, 150, 150);
        add(image);

        JLabel formNum = new JLabel("Form No: " + formno );
        formNum.setFont(new Font("Verdana", Font.BOLD, 16));
        formNum.setBounds(250, 60, 200, 30);
        add(formNum);

        JLabel page= new JLabel("Page 3");
        page.setFont(new Font("Verdana", Font.BOLD, 16));
        page.setBounds(700, 30, 200, 34);
        add(page);

        /***** Account ******/
        JLabel labelAcc = new JLabel("Account Type:");
        labelAcc.setFont(new Font("Verdana", Font.BOLD, 15));
        labelAcc.setBounds(68, 160, 200, 30);
        add(labelAcc);

        rButton1 = new JRadioButton("Saving Account");
        rButton1.setOpaque(false);
        rButton1.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton1.setBackground(new Color(173, 216, 230, 128));
        rButton1.setBounds(80, 215, 300, 15);
        add(rButton1);

        rButton2 = new JRadioButton("Current Account");
        rButton2.setOpaque(false);
        rButton2.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton2.setBackground(new Color(173, 216, 230, 128));
        rButton2.setBounds(360, 215, 300, 15);
        add(rButton2);

        rButton3 = new JRadioButton("Fixed Deposit Account");
        rButton3.setOpaque(false);
        rButton3.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton3.setBackground(new Color(173, 216, 230, 128));
        rButton3.setBounds(80, 260, 300, 15);
        add(rButton3);

        rButton4 = new JRadioButton("Recurring Deposit Account");
        rButton4.setOpaque(false);
        rButton4.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton4.setBackground(new Color(173, 216, 230, 128));
        rButton4.setBounds(360, 260, 300, 15);
        add(rButton4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rButton1);
        buttonGroup.add(rButton2);
        buttonGroup.add(rButton3);
        buttonGroup.add(rButton4);

        /***** Card Number****/
        JLabel labelCard = new JLabel("Card Number:");
        labelCard.setFont(new Font("Verdana", Font.BOLD, 15));
        labelCard.setBounds(68, 300, 200, 30);
        add(labelCard);

        JLabel labelCard2 = new JLabel("(16-digit card number)");
        labelCard2.setFont(new Font("Verdana", Font.BOLD, 10));
        labelCard2.setBounds(68, 320, 200, 30);
        add(labelCard2);

        JLabel labelCard3 = new JLabel("XXXX-XXXX-XXXX-8498");
        labelCard3.setFont(new Font("Verdana", Font.BOLD, 15));
        labelCard3.setBounds(300, 300, 200, 30);
        add(labelCard3);

        JLabel labelCard4 = new JLabel("(It would appear in the ATM statement)");
        labelCard4.setFont(new Font("Verdana", Font.BOLD, 10));
        labelCard4.setBounds(300, 320, 350, 30);
        add(labelCard4);


        JLabel labelPin = new JLabel("PIN :");
        labelPin.setFont(new Font("Verdana", Font.BOLD, 15));
        labelPin.setBounds(140, 350, 200, 30);
        add(labelPin);

        JLabel labelPin2 = new JLabel("XXXX");
        labelPin2.setFont(new Font("Verdana", Font.BOLD, 15));
        labelPin2.setBounds(300, 350, 200, 30);
        add(labelPin2);

        JLabel labelSrv = new JLabel("Services Required:");
        labelSrv.setFont(new Font("Verdana", Font.BOLD, 15));
        labelSrv.setBounds(68, 390, 200, 30);
        add(labelSrv);

        cBox1 = new JCheckBox("ATM CARD");
        cBox1.setBackground(new Color(215, 252, 252));
        cBox1.setFont(new Font("Verdana", Font.BOLD, 16));
        cBox1.setBounds(68, 420, 160, 30);
        add(cBox1);

        cBox2 = new JCheckBox("Internet Banking");
        cBox2.setBackground(new Color(215, 252, 252));
        cBox2.setFont(new Font("Verdana", Font.BOLD, 16));
        cBox2.setBounds(290, 420, 210, 30);
        add(cBox2);

        cBox3 = new JCheckBox("Mobile Banking");
        cBox3.setBackground(new Color(215, 252, 252));
        cBox3.setFont(new Font("Verdana", Font.BOLD, 16));
        cBox3.setBounds(68, 451, 160, 30);
        add(cBox3);

        cBox4 = new JCheckBox("Email Alerts");
        cBox4.setBackground(new Color(215, 252, 252));
        cBox4.setFont(new Font("Verdana", Font.BOLD, 16));
        cBox4.setBounds(290, 451, 160, 30);
        add(cBox4);

        cBox5 = new JCheckBox("Cheque Book");
        cBox5.setBackground(new Color(215, 252, 252));
        cBox5.setFont(new Font("Verdana", Font.BOLD, 16));
        cBox5.setBounds(68, 482, 160, 30);
        add(cBox5);

        cBox6 = new JCheckBox("E-Statement");
        cBox6.setBackground(new Color(215, 252, 252));
        cBox6.setFont(new Font("Verdana", Font.BOLD, 16));
        cBox6.setBounds(290, 482, 160, 30);
        add(cBox6);

        JCheckBox c7 = new JCheckBox("<html>I certify that the above facts are true to the best of my knowledge and belief and I understand that I subject myself to disciplinary action in the event that the above facts are found to be falsified</html>");
        c7.setBackground(new Color(215, 252, 252));
        c7.setFont(new Font("Verdana", Font.BOLD, 10));
        c7.setBounds(80, 650, 700, 40);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Verdana", Font.BOLD, 14));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(280, 710, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Verdana", Font.BOLD, 14));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(470, 710, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(850, 850);
        setLocation(530, 80);
        getContentPane().setBackground(new Color(215, 252,252));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String atype = "";
        if (rButton1.isSelected()){
            atype = "Saving Account";

        }else if (rButton2.isSelected()){
            atype = "Fixed Deposit Account";
        }else if (rButton3.isSelected()){
            atype = "Current Account";

        }else if (rButton4.isSelected()){
            atype = "Recurring Deposit Account";
        }

        Random random = new Random();
        long first7  =(random.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = " " +  Math.abs(first7);

        long first3 = (random.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String service = "";
        if (cBox1.isSelected()){
            service += "ATM CARD";
        } else if (cBox2.isSelected()){
            service += "Internet Banking";

        } else if (cBox3.isSelected()){
            service += "Mobile Banking";
        } else if (cBox4.isSelected()){
            service += "Email Alerts";
        } else if (cBox5.isSelected()){
            service += "Cheque Book";
        } else if (cBox6.isSelected()){
            service += "E-Statement";
        }

        try {
            if (e.getSource() ==submit){
                if (atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Make sure to select the Account type ");
                } else {
                    Connec connection = new Connec();
                    String query1 = "insert into signupthree values('"+formno+"', '"+atype+"', '"+cardno+"', '"+pin+"', '"+service+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardno+"', '"+pin+"')";
                    connection.statement.execute(query1);
                    connection.statement.execute(query2);
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardno+ "\n Pin : "+pin );
                    new Deposit(pin);
                    setVisible(false);
                }
            }else if (e.getSource() == cancel){
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String[] args){
        new Signup3(" ");
    }


}
