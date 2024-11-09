package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox, comboBox2, comboBox3, comboBox4;

    JButton next;
    JTextField ssnText, driverText;

    JRadioButton rButton1, rButton2, rButton3, rButton4;
    String formno;

    Signup2(String first){
        super("APPLICATION FORM");
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/authe.png"));
        Image img = icon1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img);
        JLabel image = new JLabel(icon2);
        image.setBounds(60, 10, 150, 150);
        add(image);

        this.formno = first;

        JLabel formLabel = new JLabel(" Form No." + formno);
        formLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        formLabel.setBounds(250, 60, 200, 30);
        add(formLabel);

        JLabel pageLabel = new JLabel("Page 2");
        pageLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        pageLabel.setBounds(700, 30, 600, 25);
        add(pageLabel);

        JLabel detailLabel = new JLabel("Additional Details");
        detailLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        detailLabel.setBounds(34, 200, 600, 40);
        add(detailLabel);

        JLabel cateLabel = new JLabel("Race: ");
        cateLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        cateLabel.setBounds(34, 240, 200, 25);
        add(cateLabel);

        String race[] = {"White", "Asian", "African American", "Hispanic", "Pacific Islander"};
        comboBox = new JComboBox(race);
        comboBox.setBackground(new Color(252, 208,76));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 14));
        comboBox.setBounds(200, 240, 320, 25);
        add(comboBox);

        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        incomeLabel.setBounds(34, 290, 200, 25);
        add(incomeLabel);

        String incomes[] = {"Null", "<20,000", "<50,000", "<80,000", "<120,000", ">150,000", };
        comboBox2 = new JComboBox(incomes);
        comboBox2.setBackground(new Color(252, 208,76));
        comboBox2.setFont(new Font("Verdana", Font.BOLD, 14));
        comboBox2.setBounds(200, 290, 320, 25);
        add(comboBox2);

        JLabel eduLabel = new JLabel("Education: ");
        eduLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        eduLabel.setBounds(34, 340, 200, 25);
        add(eduLabel);

        String edu[] = {"Undergraduate", "Graduate",  "Doctorate" };
        comboBox4 = new JComboBox(edu);
        comboBox4.setBackground(new Color(252, 208,76));
        comboBox4.setFont(new Font("Verdana", Font.BOLD, 14));
        comboBox4.setBounds(200, 340, 320, 25);
        add(comboBox4);

        JLabel occuLabel = new JLabel("Occupation: ");
        occuLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        occuLabel.setBounds(34, 390, 200, 25);
        add(occuLabel);

        String occu[] = {"Healthcare Professional", "Engineer", "Students", "Business Professional", "IT Specialist", "Lawyer" };
        comboBox3 = new JComboBox(occu);
        comboBox3.setBackground(new Color(252, 208,76));
        comboBox3.setFont(new Font("Verdana", Font.BOLD, 14));
        comboBox3.setBounds(200, 390, 320, 25);
        add(comboBox3);

        JLabel ssnLabel = new JLabel("SSN Number: ");
        ssnLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        ssnLabel.setBounds(34, 440, 200, 25);
        add(ssnLabel);

        ssnText = new JTextField();
        ssnText.setFont(new Font("Verdana", Font.BOLD, 14));
        ssnText.setBounds(200, 440, 300, 25);
        add(ssnText);

        JLabel driverLabel = new JLabel("Driver License: ");
        driverLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        driverLabel.setBounds(34, 490, 200, 25);
        add(driverLabel);

        driverText = new JTextField();
        driverText.setFont(new Font("Verdana", Font.BOLD, 14));
        driverText.setBounds(200, 490, 300, 25);
        add(driverText);

        JLabel labelGender = new JLabel("Preferred Communication");
        labelGender.setFont(new Font("Verdana", Font.BOLD, 15));
        labelGender.setBounds(34, 540, 260, 30);
        add(labelGender);

        rButton1 = new JRadioButton("SMS");
        rButton1.setOpaque(false);
        rButton1.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton1.setBackground(new Color(173, 216, 230, 128));
        rButton1.setBounds(300, 550, 70, 15);
        add(rButton1);

        rButton2 = new JRadioButton("Email");
        rButton2.setOpaque(false);
        rButton2.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton2.setBackground(new Color(173, 216, 230, 128));
        rButton2.setBounds(400, 550, 90, 15);
        add(rButton2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rButton1);
        buttonGroup1.add(rButton2);

        JLabel labelAcc = new JLabel("Account:");
        labelAcc.setFont(new Font("Verdana", Font.BOLD, 15));
        labelAcc.setBounds(34, 590, 260, 30);
        add(labelAcc);

        rButton3 = new JRadioButton("Personal");
        rButton3.setOpaque(false);
        rButton3.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton3.setBackground(new Color(173, 216, 230, 128));
        rButton3.setBounds(300, 600, 110, 15);
        add(rButton3);

        rButton4 = new JRadioButton("Business");
        rButton4.setOpaque(false);
        rButton4.setFont(new Font("Verdana", Font.BOLD, 15));
        rButton4.setBackground(new Color(173, 216, 230, 128));
        rButton4.setBounds(440, 600, 130, 15);
        add(rButton4);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(rButton3);
        buttonGroup2.add(rButton4);

        next = new JButton("Next");
        next.setFont(new Font("Verdana", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setBounds(650, 700, 100, 50);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850, 850);
        setLocation(530, 80);
        getContentPane().setBackground(new Color(252, 208,76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String race = (String) comboBox.getSelectedItem();
        String income = (String) comboBox2.getSelectedItem();
        String education = (String) comboBox3.getSelectedItem();
        String occupation = (String) comboBox4.getSelectedItem();
        String ssn = ssnText.getText();
        String driverId = driverText.getText();

        String pfcom = " ";
        if ((rButton1.isSelected())){
            pfcom = "SMS";
        } else if (rButton2.isSelected()){
            pfcom = "Email";

        }

        String account = " ";
        if ((rButton3.isSelected())){
            account = "Personal";
        } else if ((rButton4.isSelected())){
            account = "Business";
        }

        try{
            if (ssnText.getText().equals("") || driverText.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Make sure Both SSN and Driver License are filled" );

            }else {
                Connec connection = new Connec();
                String query = "insert into signuptwo values('"+formno+"','"+race+"', '"+income+"', '"+education+"', '"+occupation+"', '"+ssn+"', '"+driverId+"', '"+pfcom+"', '"+account+"')";
                connection.statement.executeUpdate(query);

                new Signup3(formno);
                setVisible(false);
            }

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Signup2("");
    }


}
