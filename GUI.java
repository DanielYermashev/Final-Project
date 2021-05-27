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
        frame.setSize(800, 700);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
        JLabel title;
        title = new JLabel("Computer Schedule");
        title.setBounds(200, 60, 200, 25);
        panel.add(title);

        JButton logOut;
        logOut = new JButton("Log out");
        logOut.setBounds(670, 20, 80, 25);
        logOut.addActionListener(new GUI());
        panel.add(logOut);

        JButton manage;
        manage = new JButton("Manage Computers");
        manage.setBounds(520, 20, 150, 25);
        manage.addActionListener(new GUI());
        panel.add(manage);

        JLabel book;
        book = new JLabel("Book Computers");
        book.setBounds(580, 240, 200, 25);
        panel.add(book);

        JLabel teacherName;
        teacherName = new JLabel("Teacher Name:");
        teacherName.setBounds(580, 270, 200, 25);
        panel.add(teacherName);
        
        JTextField teacherNameText;
        teacherNameText = new JTextField(20);
        teacherNameText.setBounds(580, 290, 200, 25);
        panel.add(teacherNameText);

        JLabel roomNumber;
        roomNumber = new JLabel("Room Number:");
        roomNumber.setBounds(580, 310, 200, 25);
        panel.add(roomNumber);

        JTextField roomNumberText;
        roomNumberText = new JTextField(20);
        roomNumberText.setBounds(580, 330, 200, 25);
        panel.add(roomNumberText);

        JLabel numComputers;
        numComputers = new JLabel("Number of Computers");
        numComputers.setBounds(580, 350, 200, 25);
        panel.add(numComputers);

        JTextField numComputersText;
        numComputersText = new JTextField(20);
        numComputersText.setBounds(580, 370, 200, 25);
        panel.add(numComputersText);

        JButton bookComp;
        bookComp = new JButton("Book");
        bookComp.setBounds(580, 410, 200, 25);
        bookComp.addActionListener(new GUI());
        panel.add(bookComp);
        
    }

}
