//package Final;

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
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
        frame.setSize(1000, 450);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
        
        JLabel title;
        title = new JLabel("Computer Schedule");
        title.setBounds(20, 70, 200, 25);
        panel.add(title);

        JLabel available;
        available = new JLabel("Computer's available today: 30"); // This is determined by a method which reads the csv file and counts how many are available. max being 30.
        available.setBounds(548, 70, 200, 25);
        panel.add(available);

        JButton logOut;
        logOut = new JButton("Log out");
        logOut.setBounds(865, 20, 80, 25);
        logOut.addActionListener(new GUI());
        panel.add(logOut);

        JLabel book;
        book = new JLabel("Book Computers");
        book.setBounds(800, 100, 200, 25);
        panel.add(book);

        JLabel time;
        time = new JLabel("Time:");
        time.setBounds(750, 130, 200, 25);
        panel.add(time);
        
        JTextField timeText;
        timeText = new JTextField(20);
        timeText.setBounds(750, 150, 200, 25);
        panel.add(timeText);

        JLabel teacherName;
        teacherName = new JLabel("Teacher Name:");
        teacherName.setBounds(750, 170, 200, 25);
        panel.add(teacherName);
        
        JTextField teacherNameText;
        teacherNameText = new JTextField(20);
        teacherNameText.setBounds(750, 190, 200, 25);
        panel.add(teacherNameText);

        JLabel roomNumber;
        roomNumber = new JLabel("Room Number:");
        roomNumber.setBounds(750, 210, 200, 25);
        panel.add(roomNumber);

        JTextField roomNumberText;
        roomNumberText = new JTextField(20);
        roomNumberText.setBounds(750, 230, 200, 25);
        panel.add(roomNumberText);

        JLabel numComputers;
        numComputers = new JLabel("Number of Computers");
        numComputers.setBounds(750, 250, 200, 25);
        panel.add(numComputers);

        JTextField numComputersText;
        numComputersText = new JTextField(20);
        numComputersText.setBounds(750, 270, 200, 25);
        panel.add(numComputersText);

        JButton bookComp;
        bookComp = new JButton("Book");
        bookComp.setBounds(800, 300, 100, 25);
        bookComp.addActionListener(new GUI());
        panel.add(bookComp);

        String data[][]={ {"9:00-10:00","Mr.ho","123", "25"},        //This is determined by a method. A method which reads the csv file and puts the according info into the array for which then is displayed on the GUI
                          {"10:00-11:00","Mr.ubaid","305", "30"},    //This info is just being used as an example/placeholder
                          {"11:00-12:00","Mr.Daniel","234", "20"}};   

        String column[]={"Time","Teacher Name","Room Number", "Number of Computers"};     //This is a constant.    
        
        JTable compTable = new JTable(data, column);
        JScrollPane scrollPane=new JScrollPane(compTable); 
        scrollPane.setBounds(20,100,700,200);      
        panel.add(scrollPane);             
        
    }

}
