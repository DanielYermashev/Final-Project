//package Final;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userNameText;
    private static JLabel passLabel;
    private static JPasswordField passText;
    private static JButton button;
    private static JLabel logInfo;
    private static JLabel bookOrNot;
    private static JLabel time;
    private static JTextField timeText;
    private static JLabel teacherName;
    private static JTextField teacherNameText;
    private static JLabel roomNumber;
    private static JTextField roomNumberText;
    private static JLabel numComputers;
    private static JTextField numComputersText;
    private static int computerNum;
    private static String data[][] = { { "9:00-10:00", "Mr.ho", "123", "25" },
            { "10:00-11:00", "Mr.ubaid", "305", "30" }, { "11:00-12:00", "Mr.Muhammad", "234", "20" },
            { "12:00-1:00", "", "", "" }, { "1:00-2:00", "", "", "" }, { "2:00-3:00", "", "", "" } };

    public static void main(String[] args) {

        loginPage();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String userName = userNameText.getText();
        String password = passText.getText();
        String action = ae.getActionCommand();

        if (action.equals("Login")) {
            if (userName.equals("TeacherStaff") && password.equals("Library")) {
                logInfo.setText("Login Succesful");
                welcomePage();
            } else {
                logInfo.setText("Incorrect Login Information");
            }
            userNameText.setText("");
            passText.setText("");
        }
        if (action.equals("Book")) {
            if (timeText.getText().isEmpty() || teacherNameText.getText().isEmpty()
                    || roomNumberText.getText().isEmpty() || numComputersText.getText().isEmpty()) {
                bookOrNot.setText("Please Enter Information");
            } else {
                try {
                    int num = Integer.parseInt(numComputersText.getText());

                    if (num > computerNum || num <= 0) {
                        bookOrNot.setText("Incorrect number of computers");
                    } else {
                        String bookTime = timeText.getText();
                        String bookName = teacherNameText.getText();
                        String bookRoom = roomNumberText.getText();
                        String numBook = numComputersText.getText();

                        String open = openSlot(data, bookTime, bookName, bookRoom, numBook);

                        if (open.equals("open")) {

                            bookOrNot.setText("Computers Are Booked!!!");
                            conformation(bookTime, bookName, bookRoom, numBook);
                        }
                        if (open.equals("closed")) {
                            bookOrNot.setText("Computers are not available for this time");
                        }

                    }
                } catch (Exception e) {
                    bookOrNot.setText("Incorrect number of computers");
                }
            }
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
        computerNum = compNum(computerNum);
        available = new JLabel("Computer's available today: " + computerNum); // This is determined by a method which
                                                                              // reads the csv file and counts how many
                                                                              // are available. max being 30.
        available.setBounds(548, 70, 200, 25);
        panel.add(available);

        JLabel book;
        book = new JLabel("Book Computers");
        book.setBounds(800, 100, 200, 25);
        panel.add(book);

        time = new JLabel("Time:");
        time.setBounds(750, 130, 200, 25);
        panel.add(time);

        timeText = new JTextField(20);
        timeText.setBounds(750, 150, 200, 25);
        panel.add(timeText);

        teacherName = new JLabel("Teacher Name:");
        teacherName.setBounds(750, 170, 200, 25);
        panel.add(teacherName);

        teacherNameText = new JTextField(20);
        teacherNameText.setBounds(750, 190, 200, 25);
        panel.add(teacherNameText);

        roomNumber = new JLabel("Room Number:");
        roomNumber.setBounds(750, 210, 200, 25);
        panel.add(roomNumber);

        roomNumberText = new JTextField(20);
        roomNumberText.setBounds(750, 230, 200, 25);
        panel.add(roomNumberText);

        numComputers = new JLabel("Number of Computers");
        numComputers.setBounds(750, 250, 200, 25);
        panel.add(numComputers);

        numComputersText = new JTextField(20);
        numComputersText.setBounds(750, 270, 200, 25);
        panel.add(numComputersText);

        JButton bookComp;
        bookComp = new JButton("Book");
        bookComp.setBounds(800, 300, 100, 25);
        bookComp.addActionListener(new GUI());
        panel.add(bookComp);

        bookOrNot = new JLabel("");
        bookOrNot.setBounds(730, 320, 300, 25);
        panel.add(bookOrNot);

        String column[] = { "Time", "Teacher Name", "Room Number", "Number of Computers" }; // This is a constant.

        JTable compTable = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(compTable);
        scrollPane.setBounds(20, 100, 700, 250);
        panel.add(scrollPane);

    }

    public static void loginPage() {
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

    public static int compNum(int computerNumber) {
        try {
            String filePath = "C://Users//Ubaid Khan//OneDrive//Desktop//computers.csv"; // need to add your file
                                                                                         // location
            Scanner scan = new Scanner(new File(filePath));

            int lineCounters = 0;

            while (scan.hasNextLine()) {
                String currentLine = scan.nextLine();
                lineCounters = lineCounters + 1;

            }

            lineCounters = lineCounters - 1;
            computerNumber = lineCounters;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return computerNumber;
    }

    public static String openSlot(String data[][], String bookTime, String bookName, String bookRoom, String numBook) {
        String book = "closed";

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j].equals(bookTime) && data[i][1].equals("") && data[i][2].equals("")
                        && data[i][3].equals("")) {
                    data[i][1] = bookName;
                    data[i][2] = bookRoom;
                    data[i][3] = numBook;
                    book = "open";
                }
            }
        }
        return book;
    }

    public static void conformation(String bookTime, String bookName, String bookRoom, String numBook) {
        String fileLocation = "C://Users//Ubaid Khan//OneDrive//Desktop//conformation.csv";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation));
            bw.write("Time, Name, Room Number, Number of Computers \n");
            bw.write(bookTime + "," + bookName + "," + bookRoom + "," + numBook);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
