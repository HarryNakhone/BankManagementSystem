package bank.manage.sys;

import com.toedter.calendar.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener {

    JButton next;
    JRadioButton r1, r2, m1, m2;
    JTextField textName, pTextName , emailText, addressText, zipText, cityText, stateText;

    JDateChooser dateChooser;
    Random ran =  new Random();

    long first4 = (ran.nextLong() % 9000L) + 1000L;

    String first = " " + Math.abs(first4);

    Signup(){
        super("SIGN UP FORM");

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/authe.png"));
        Image img = icon1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img);
        JLabel image = new JLabel(icon2);
        image.setBounds(415, 20, 150, 150);
        add(image);

        JLabel label1 =new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(34, 200, 800, 40);
        label1.setFont(new Font("Verdana", Font.BOLD, 29));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Verdana", Font.BOLD, 22));
        label2.setBounds(870, 20, 600, 30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Verdana", Font.BOLD, 19));
        label3.setBounds(34, 250, 600, 30);
        add(label3);

        /***** NAME ****/
        JLabel labelName = new JLabel("Name");
        labelName.setFont(new Font("Verdana", Font.BOLD, 15));
        labelName.setBounds(34, 270, 100, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Verdana", Font.BOLD, 14));
        textName.setBounds(34, 302, 300, 30);
        add(textName);

        /***** Parents NAME ****/
        JLabel labelParent = new JLabel("Parent's Name");
        labelParent.setFont(new Font("Verdana", Font.BOLD, 15));
        labelParent.setBounds(34, 336, 200, 30);
        add(labelParent);

        pTextName = new JTextField();
        pTextName.setFont(new Font("Verdana", Font.BOLD, 14));
        pTextName.setBounds(34, 362, 300, 30);
        add(pTextName);

        /***** DATE OF BIRTH ****/
        JLabel labelDOB = new JLabel("Date of Birth");
        labelDOB.setFont(new Font("Verdana", Font.BOLD, 15));
        labelDOB.setBounds(34, 397, 200, 30);
        add(labelDOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(34, 425, 300, 30);
        add(dateChooser);

        /***** GENDER ****/
        JLabel labelGender = new JLabel("Gender");
        labelGender.setFont(new Font("Verdana", Font.BOLD, 15));
        labelGender.setBounds(34, 452, 200, 30);
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setOpaque(false);
        r1.setFont(new Font("Verdana", Font.BOLD, 15));
        r1.setBackground(new Color(173, 216, 230, 128));
        r1.setBounds(34, 479, 70, 15);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setOpaque(false);
        r2.setFont(new Font("Verdana", Font.BOLD, 15));
        r2.setBackground(new Color(173, 216, 230, 128));
        r2.setBounds(160, 479, 90, 15);
        add(r2);


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        /****** Email *****/
        JLabel labelEmail = new JLabel("Email Address ");
        labelEmail.setFont(new Font("Verdana", Font.BOLD, 15));
        labelEmail.setBounds(34, 503, 200, 30);
        add(labelEmail);

        emailText = new JTextField();
        emailText.setFont(new Font("Verdana", Font.BOLD, 14));
        emailText.setBounds(34, 532, 300, 30);
        add(emailText);

        /****** STATUS *****/
        JLabel status = new JLabel("Marital Status ");
        status.setFont(new Font("Verdana", Font.BOLD, 15));
        status.setBounds(34, 560, 200, 30);
        add(status);


        m1 = new JRadioButton("Single");
        m1.setOpaque(false);
        m1.setFont(new Font("Verdana", Font.BOLD, 15));
        m1.setBackground(new Color(173, 216, 230, 128));
        m1.setBounds(34, 590, 80, 18);
        add(m1);

        m2 = new JRadioButton("Married");
        m2.setOpaque(false);
        m2.setFont(new Font("Verdana", Font.BOLD, 15));
        m2.setBackground(new Color(173, 216, 230, 128));
        m2.setBounds(160, 590, 90, 15);
        add(m2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);



        /****** ADDRESS *****/
        JLabel labelAdd = new JLabel("Address Line 1");
        labelAdd.setFont(new Font("Verdana", Font.BOLD, 15));
        labelAdd.setBounds(400, 270, 200, 30);
        add(labelAdd);

        addressText = new JTextField();
        addressText.setFont(new Font("Verdana", Font.BOLD, 14));
        addressText.setBounds(400, 302, 300, 30);
        add(addressText);

        /****** CITY *****/
        JLabel labelCity = new JLabel("City");
        labelCity.setFont(new Font("Verdana", Font.BOLD, 15));
        labelCity.setBounds(400, 330, 200, 30);
        add(labelCity);

        cityText = new JTextField();
        cityText.setFont(new Font("Verdana", Font.BOLD, 14));
        cityText.setBounds(400, 360, 150, 30);
        add(cityText);

        /****** ZIP CODE *****/
        JLabel labelZip = new JLabel("ZIP CODE");
        labelZip.setFont(new Font("Verdana", Font.BOLD, 15));
        labelZip.setBounds(400, 387, 200, 30);
        add(labelZip);

        zipText = new JTextField();
        zipText.setFont(new Font("Verdana", Font.BOLD, 14));
        zipText.setBounds(400, 413, 70, 30);
        add(zipText);

        /****** STATE *****/
        JLabel labelState = new JLabel("State");
        labelState.setFont(new Font("Verdana", Font.BOLD, 15));
        labelState.setBounds(400, 443, 200, 30);
        add(labelState);

        stateText = new JTextField();
        stateText.setFont(new Font("Verdana", Font.BOLD, 14));
        stateText.setBounds(400, 475, 70, 30);
        add(stateText);

        next = new JButton("Next");
        next.setFont(new Font("Verdana", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setBounds(780, 660, 100, 50);
        next.addActionListener(this);
        add(next);

        /****** Set Location *****/

        getContentPane().setBackground(new Color(173, 216, 230, 128));
        setLayout(null);
        setSize(1000, 800);
        setLocation(550, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNum = first;
        String name = textName.getText();
        String pname = pTextName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;

        if (r1.isSelected()){
            gender = "Male";

        }else if(r2.isSelected()){
            gender = "Female";

        }
        String email= emailText.getText();
        String marital = null;
        if (m1.isSelected()){
            marital = "Single";
        } else if(m2.isSelected()){
            marital = "Married";
        }

        String address = addressText.getText();
        String city = cityText.getText();
        String zipcode = zipText.getText();
        String state= stateText.getText();

        try{

            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else{
                Connec connection = new Connec();
                String q = "insert into signup values('"+formNum+"', '"+name+"', '"+pname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+zipcode+"', '"+state+"')";
                connection.statement.executeUpdate(q);
                new Signup2(formNum);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();

        }

    }

    public static void main(String[] args){
        new Signup();
    }


}
