package bank.manage.sys;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
        JLabel labelText, labelText2, labelText3;

        JTextField textField;
        JPasswordField passwordField;

        JButton button1, button2, button3;
    Login(){
        super(" ATM and User Management System"); /// Set header



        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank25.png"));  //// Get image
        Image img1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  //// Convert into Image Object to adjust the scale
        ImageIcon icon2 = new ImageIcon(img1);      //// Convert back to ImageIcon
        JLabel image1 = new JLabel(icon2);   //// Pass in the ImageIcon (JLabel only accept the ImageIcon Object)
        image1.setBounds(410, 10, 100, 100); /// Position and Size of the image
        add(image1);

        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/card25.png"));
        Image img2 = icon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon4 = new ImageIcon(img2);
        JLabel image2 = new JLabel(icon4);
        image2.setBounds(145, 385, 100, 100);
        add(image2);

        /**** WElCOME ****/
        labelText =  new JLabel("Welcome to ATM");
        labelText.setForeground(Color.BLACK);
        labelText.setFont(new Font("Verdana", Font.BOLD, 38));
        labelText.setBounds(290, 125, 450, 40);
        add(labelText);

        /**** CARD NO. ****/
        labelText2 = new JLabel("Card No:");
        labelText2.setFont(new Font("Verdana", Font.BOLD, 28));
        labelText2.setForeground(Color.BLACK);
        labelText2.setBounds(160, 190, 375, 30);
        add(labelText2);

        textField = new JTextField(15);
        textField.setBounds(325, 190, 230, 30);
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField);


        /**** PIN ****/
        labelText3 =new JLabel("PIN: ");
        labelText3.setFont(new Font("Verdana", Font.BOLD, 28));
        labelText3.setForeground(Color.black);
        labelText3.setBounds(220, 250, 375, 30);
        add(labelText3);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(325, 250, 230, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField);


        /**** Buttons ****/
        button1 = new JButton("LOG IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.BLACK);
        button1.setBounds(315, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("RESET");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.BLACK);
        button2.setBounds(460, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.BLACK);
        button3.setBounds(315, 350, 246, 30);
        button3.addActionListener(this);
        add(button3);

        /**** Background ****/
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/backg.png"));
        Image img3 =  icon5.getImage().getScaledInstance(900, 460, Image.SCALE_DEFAULT);
        ImageIcon icon6 = new ImageIcon(img3);
        JLabel image3 = new JLabel(icon6);
        image3.setBounds(0, 0, 900, 460);
        add(image3);

        setLayout(null);
        setSize(900, 500);;
        setLocation(450,  225);

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if (e.getSource() == button1){
                Connec connection  = new Connec();
                String cardNum = textField.getText();
                String pin = new String(passwordField.getPassword());
                String query = "select * from login where card_number = "+cardNum+" and pin = "+pin+"";
                ResultSet resultSet = connection.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new MainB(pin);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin");
                }



            }else if(e.getSource() == button2){
                textField.setText("");
                passwordField.setText("");
            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);

            }

        }catch(Exception E){
            E.printStackTrace();

        }

    }

    public static void main (String[] args){
        new Login();
    }


}
