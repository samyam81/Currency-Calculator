package Currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyChange implements ActionListener{

    public static void main(String[] args) {
        new CurrencyChange();
    }
    
    
      JFrame frame=new JFrame();
      JTextField textfield1,textfield2;
      JButton[] numButtons=new JButton[10];
      JButton CanCurrency,USCurrency,AusCurrency;
      JPanel panel=new JPanel();
      JPanel panel2=new JPanel();

      double num1,result;
      String operator;
      Font myFont=new Font("Serif",Font.BOLD,30);
      Font myFont1=new Font("Monospaced",Font.BOLD,15);

     CurrencyChange(){

            frame =new JFrame("Currency-Changer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(new Color(188,198,204));
            frame.setSize(420,700);
            frame.setLayout(null);
             
            textfield1=new JTextField();
            textfield1.setBounds(24,57,200,32);
            textfield1.setBackground(new Color(249, 246, 238));
            textfield1.setFont(myFont);
            textfield1.setEditable(false);


            for (int i = 0; i < 10; i++) {
                numButtons[i]=new JButton(String.valueOf(i));
                numButtons[i].addActionListener(this);
                numButtons[i].setFont(myFont);
                numButtons[i].setFocusable(false);
            }


        panel2.setBounds(49,100,299,299);
        panel2.setLayout(new GridLayout(4,4,10,10));
        panel2.setBackground(new Color(188,198,204));


        panel2.add(numButtons[0]);
        panel2.add(numButtons[3]);
        panel2.add(numButtons[8]);

        panel2.add(numButtons[2]);
        panel2.add(numButtons[7]);
        panel2.add(numButtons[9]);

        panel2.add(numButtons[4]);
        panel2.add(numButtons[5]);
        panel2.add(numButtons[6]);

        panel2.add(new JLabel(""));
        panel2.add(numButtons[1]);


            CanCurrency =new JButton("CanCurrency");
            AusCurrency =new JButton("AusCurrency");
            USCurrency =new JButton("USCurrency");

            CanCurrency.addActionListener(this);
            AusCurrency.addActionListener(this);
            USCurrency.addActionListener(this);

            textfield2=new JTextField();
            textfield2.setBounds(24,500,300,32);
            textfield2.setFont(myFont1);
            textfield2.setEditable(false);


            // panel =new JPanel();
            panel.setBackground(new Color(188,198,204));
            panel.setBounds(18, 420, 380, 64);
            panel.setLayout(new GridLayout(1,3,10,10));

            panel.add(AusCurrency);
            panel.add(CanCurrency);
            panel.add(USCurrency);


            frame.add(textfield1);
            frame.add(panel2);
            frame.add(panel);
            frame.add(textfield2);
            frame.setVisible(true);

     }

@Override
public void actionPerformed(ActionEvent e) {

    for (int i = 0; i < 10; i++) {
        if (e.getSource() == numButtons[i]) {
            textfield1.setText(textfield1.getText().concat(String.valueOf(i)));
        }
    }


    if (e.getSource() == CanCurrency) {
        operator = "Can";
        num1 = Double.parseDouble(textfield1.getText());
    } else if (e.getSource() == USCurrency) {
        operator = "USCurrency";
        num1 = Double.parseDouble(textfield1.getText());
    } else if (e.getSource() == AusCurrency) {
        operator = "Aus";
        num1 = Double.parseDouble(textfield1.getText());
    }

    switch (operator) {
        case "Can":
            result = num1 * 99.28;
            operator=Double.toString(result);
            textfield2.setBackground(new Color(255,215,0));
            textfield2.setText("CanCurrency "+String.valueOf(operator));
            break;
        case "USCurrency":
            result = num1 * 133.98;
            operator=Double.toString(result);
            textfield2.setBackground(new Color(255,215,0));
            textfield2.setText("USCurrency "+String.valueOf(operator));

            break;
        default:
            result = num1 * 87.03;
            operator=Double.toString(result);
            textfield2.setBackground(new Color(255,215,0));
            textfield2.setText("AusCurrency "+String.valueOf(operator));
            break;
    }
    
    for (int j = 0; j < numButtons.length; j++) {
            numButtons[j].setEnabled(false);
            numButtons[j].setBackground(Color.darkGray);
        }

}


}
