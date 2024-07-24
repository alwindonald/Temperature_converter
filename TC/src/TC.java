import javax.swing.*;
import java.awt.event.*;

public class TC extends JFrame {
    JLabel l1, l2, l3, l4;
    JComboBox tc1, tc2;

    JTextField t1, t2;
    JButton b;


    public TC(String s) {
        super(s);
    }

    public void setComp() {
        String arr1[] = { "Celsius", "Fahrenheit", "Kelvin"};
        String arr2[] = { "Celsius", "Fahrenheit", "Kelvin"};
        l1 = new JLabel("To");
        l2 = new JLabel("Enter the Value:");
        l3 = new JLabel("Converted Value:");
        l4 = new JLabel("From");
        tc1 = new JComboBox(arr1);
        tc2 = new JComboBox(arr2);
        t1 = new JTextField();
        t2 = new JTextField();
        b = new JButton("Convert");

        setLayout(null);
        tc1.setBounds(75, 50, 100, 20);
        t1.setBounds(200, 50, 100, 20);
        l1.setBounds(100, 75, 50, 20);
        l4.setBounds(90, 25, 50, 20);
        l2.setBounds(200, 35, 100, 20);
        l3.setBounds(200, 85, 100, 20);
        tc2.setBounds(75, 100, 100, 20);
        t2.setBounds(200, 100, 100, 20);
        b.setBounds(138, 150, 100, 20);

        b.addActionListener(new Handler());

        add(tc1);
        add(tc2);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(b);

        t2.setEditable(false);
    }

    class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String x, y;
            x = (String) tc1.getSelectedItem();
            y = (String) tc2.getSelectedItem();


            if (e.getSource() == b) {

                // Celsius to others.........................
                if (x == "Celsius" && y == "Fahrenheit") {
                    String s = t1.getText();
                    float a = Float.parseFloat(s);
                    float b = (float) ((a * 9 / 5) + 32);
                    t2.setText("" + b);
                } else if (x == "Celsius" && y == "Kelvin") {
                    String s = t1.getText();
                    float a = Float.parseFloat(s);
                    float b = (float) (a + 273.15);
                    t2.setText("" + b);
                }
                // Fahrenheit to others......................
                else if (x == "Fahrenheit" && y == "Celsius") {
                    String s = t1.getText();
                    float a = Float.parseFloat(s);
                    float b = (float) ((a - 32) * 5 / 9);
                    t2.setText("" + b);
                } else if (x == "Fahrenheit" && y == "Kelvin") {
                    String s = t1.getText();
                    float a = Float.parseFloat(s);
                    float b = (float) ((a - 32) * 5 / 9 + 273.15);
                    t2.setText("" + b);
                }
                // Kelvin to others.........................
                else if (x == "Kelvin" && y == "Celsius") {
                    String s = t1.getText();
                    float a = Float.parseFloat(s);
                    float b = (float) (a - 273.15);
                    t2.setText("" + b);
                } else if (x == "Kelvin" && y == "Fahrenheit") {
                    String s = t1.getText();
                    float a = Float.parseFloat(s);
                    float b = (float) ((a - 273.15) * 9 / 5 + 32);
                    t2.setText("" + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        TC jf = new TC("Temperature Converter");
        jf.setComp();
        jf.setSize(400, 500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}