package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField newPin, reNewPin;
    JButton update, back;

    String pin;
    PinChange(String pin){
        this.pin = pin;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/file.png"));
        Image img1 = icon1.getImage().getScaledInstance(1300, 960, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img1);
        JLabel image = new JLabel(icon2);
        image.setBounds(0,0,1550, 1000);
        add(image);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 23));
        label1.setBounds(520, 140, 400, 35);
        image.add(label1);


        JLabel label2 = new JLabel("New Pin: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(480, 205, 400, 35);
        image.add(label2);

        newPin =  new JPasswordField();
        newPin.setFont(new Font("Verdana", Font.BOLD, 21));
        newPin.setBounds(650, 210, 120, 25);
        image.add(newPin);


        JLabel label3 = new JLabel("Re-enter New Pin: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(480, 255, 400, 35);
        image.add(label3);

        reNewPin =  new JPasswordField();
        reNewPin.setFont(new Font("Verdana", Font.BOLD, 21));
        reNewPin.setBounds(650, 260, 120, 25);
        image.add(reNewPin);





        update =  new JButton("Update Pin");
        update.setBounds(920, 320, 120, 35);
        update.setBackground(new Color(241, 241, 238));
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        image.add(update);

        back =  new JButton("Back");
        back.setBounds(920, 370, 120, 35);
        back.setBackground(new Color(241, 241, 238));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);


        setSize(1550, 1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String nPin = String.valueOf(newPin.getPassword());
            String rnPin = String.valueOf(reNewPin.getPassword());

            if (!nPin.equals(rnPin)){
                JOptionPane.showMessageDialog(null, "Pin does not Match, Re-type the pin");
            }
            if (e.getSource()==update){
                if (nPin.equals("")){
                    JOptionPane.showMessageDialog(null, "New Pin Is Empty");
                    return;
                }
                if (rnPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-enter Pin is Empty");
                    return;
                }

                Connec connection =  new Connec();
                String queryBank = "update bankacc set pin = '"+nPin+"' where pin ='"+pin+"'";
                String queryLogin = "update login set pin = '"+nPin+"' where pin ='"+pin+"'";
                String queryS3 = "update signupthree set pin = '"+nPin+"' where pin ='"+pin+"'";

                connection.statement.executeUpdate(queryBank);
                connection.statement.executeUpdate(queryLogin);
                connection.statement.executeUpdate(queryS3);

                JOptionPane.showMessageDialog(null, "Updated Pin Successfully");
                setVisible(false);
                new MainB(pin);

            }else if (e.getSource()==back){
                new MainB(pin);
                setVisible(false);

            }
        }catch(Exception E){

        }
    }

    public static void main(String[] args){
        new PinChange(" ");
    }
}
