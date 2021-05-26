package Final;

import java.lang.ProcessHandle.Info;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userNameText;
    private static JLabel passLabel;
    private static JPasswordField passText;
    private static JButton button;
    private static JLabel logInfo;

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("UserName:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userNameText = new JTextField(20);
        userNameText.setBounds(100, 20, 165, 25);
        panel.add(userNameText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(10, 50, 80, 25);
        panel.add(passLabel);

        passText = new JPasswordField(20);
        passText.setBounds(100, 50, 165, 25);
        panel.add(passText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        logInfo = new JLabel("");
        logInfo.setBounds(10, 110, 300, 25);
        panel.add(logInfo);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userName = userNameText.getText();
        String password = passText.getText();

        if (userName.equals("TeacherStaff") && password.equals("Library")) {
            logInfo.setText("Login Succesful");
            welcomePage();
            
        } else {
            logInfo.setText("Incorrect Login Information");
        }

    }

    public static void welcomePage() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
        
    }

}
