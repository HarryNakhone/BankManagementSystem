package bank.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;

    JButton exit;
    MiniStatement(String pin){
        this.pin= pin;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        JLabel labelDate = new JLabel();
        labelDate.setBounds(20, 140, 400, 200);
        add(labelDate);

        JLabel labelN = new JLabel();
        labelN.setFont(new Font("System", Font.BOLD, 15));
        labelN.setBounds(150, 20, 200, 20);
        add(labelN);

        JLabel labelCardN =  new JLabel();
        labelCardN.setBounds(20, 80, 300, 20);
        add(labelCardN);

        JLabel labelBalance = new JLabel();
        labelBalance.setBounds(20, 400, 300, 20);
        add(labelBalance);

        exit = new JButton("Back");
        exit.setBounds(20, 500, 100, 25) ;
        exit.addActionListener(this);
        add(exit);


        try{

            int balance = 0;
            Connec connection = new Connec();
            ResultSet resultSet = connection.statement.executeQuery("select * from bankacc where pin = '" + pin + "'");


            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setEditable(false);

            StringBuilder dataBuilder = new StringBuilder("<html>");
            while (resultSet.next()) {
                dataBuilder.append(resultSet.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(resultSet.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(resultSet.getString("amount"))
                        .append("<br><br>");

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            dataBuilder.append("</html>");

            editorPane.setText(dataBuilder.toString());

            JScrollPane scrollPane = new JScrollPane(editorPane);
            scrollPane.setPreferredSize(new Dimension(400, 150));


            labelBalance.setText("Your Total Balance is: " + balance);


            this.setLayout(new BorderLayout());
            this.add(scrollPane, BorderLayout.CENTER);
            this.add(labelBalance, BorderLayout.SOUTH);

            JPanel southPanel = new JPanel();
            southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            southPanel.add(labelBalance);
            southPanel.add(exit);

            this.add(southPanel, BorderLayout.SOUTH);

            this.setSize(500, 500);
            this.setVisible(true);

        }catch (Exception E){
            E.printStackTrace();
        }



        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new MainB(pin);
    }
    public static void main(String[]args){
        new MiniStatement(" ");
    }


}
