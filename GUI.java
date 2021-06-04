/*
 * Name:Daniel, Muhammad, Ubaid, Williamson
 * Teacher Name: Mr. Ho
 * Date: June 4, 2021
 * Description: This program allows users to efficiently and orgranize the booking of computers
 * Details to run the program: 
 * - Once you book computers, close the booking page but not the login page. Once you relogin your booking information would appear for the next person that wishes to book computers.
 * - The computers.csv file location must be changed for the certain user laptop
 * - The conformation csv file location must be changed for the certain user labtop
 * - The username is: TeacherStaff
 * - The password is: Library
*/

//Import necessary packages
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    //Initializing necessary global variables
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
    private static String data[][] = {{"9:00-10:00","","", ""},        
                                      {"10:00-11:00","","", ""},   
                                      {"11:00-12:00","","", ""},
                                      {"12:00-1:00","","",""},
                                      {"1:00-2:00","","",""},
                                      {"2:00-3:00","","",""}
                                     };   


    public static void main(String[] args) {
        //Display login page
        loginPage();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Get which button was clicked
        String action = ae.getActionCommand();

        //If login button was clicked
        if(action.equals("Login")) {
            //get what username and password was inputed by the user
            String userName = userNameText.getText();
            String password = passText.getText();
            //validate the username and password
            validateLogin(userName, password);    
        }
        //If book button was clicked
        else if(action.equals("Book")) {
            //Validate booking information
            validateInfo();
        }   
    }

    public static void loginPage() {
        //Create frame and panel
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //add panel to frame
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("UserName:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        //Allow user to input username
        userNameText = new JTextField(20);
        userNameText.setBounds(100, 20, 165, 25);
        panel.add(userNameText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(10, 50, 80, 25);
        panel.add(passLabel);

        //Allow user to input password
        passText = new JPasswordField(20);
        passText.setBounds(100, 50, 165, 25);
        panel.add(passText);

        //Button for user to click when they want to login
        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        //Text allowing them to know if the username and password is correct or not
        logInfo = new JLabel("");
        logInfo.setBounds(10, 110, 300, 25);
        panel.add(logInfo);

        frame.setVisible(true);
    }

    public static void welcomePage() {
        //Create frame and panel
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(1000, 450);

        //Create closing operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);

        JLabel title;
        title = new JLabel("Computer Schedule");
        title.setBounds(20, 70, 200, 25);
        panel.add(title);

        //Displaying how much computers are available for signing out
        JLabel available;
        computerNum = compNum(computerNum);
        available = new JLabel("Computer's available today: " + computerNum); 
                                                                                                                                                
        available.setBounds(548, 70, 200, 25);
        panel.add(available);

        JLabel book;
        book = new JLabel("Book Computers");
        book.setBounds(800, 100, 200, 25);
        panel.add(book);

        //The time user wants to book for
        time = new JLabel("Time:");
        time.setBounds(750, 130, 200, 25);
        panel.add(time);

        //Allow user to input the time they want to book for
        timeText = new JTextField(20);
        timeText.setBounds(750, 150, 200, 25);
        panel.add(timeText);

        teacherName = new JLabel("Teacher Name:");
        teacherName.setBounds(750, 170, 200, 25);
        panel.add(teacherName);

        //Allow user to input their name
        teacherNameText = new JTextField(20);
        teacherNameText.setBounds(750, 190, 200, 25);
        panel.add(teacherNameText);

        roomNumber = new JLabel("Room Number:");
        roomNumber.setBounds(750, 210, 200, 25);
        panel.add(roomNumber);

        //Allow user to input their room number
        roomNumberText = new JTextField(20);
        roomNumberText.setBounds(750, 230, 200, 25);
        panel.add(roomNumberText);

        numComputers = new JLabel("Number of Computers");
        numComputers.setBounds(750, 250, 200, 25);
        panel.add(numComputers);

        //Allow user to input the number of computers they want to book for
        numComputersText = new JTextField(20);
        numComputersText.setBounds(750, 270, 200, 25);
        panel.add(numComputersText);

        //Jbutton which users click when they have added all the booking information and they want to book them
        JButton bookComp;
        bookComp = new JButton("Book");
        bookComp.setBounds(800, 300, 100, 25);
        bookComp.addActionListener(new GUI());
        panel.add(bookComp);

        //Tells user if the booking as successfully happend or not
        bookOrNot = new JLabel("");
        bookOrNot.setBounds(730, 320, 300, 25);
        panel.add(bookOrNot);

        //The columns of the time table
        String column[] = { "Time", "Teacher Name", "Room Number", "Number of Computers" }; // This is a constant.

        //Create time table with booking information
        JTable compTable = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(compTable);
        scrollPane.setBounds(20, 100, 700, 250);
        panel.add(scrollPane);

    }

    public static void validateLogin(String userName, String password) {
        //If the username and password is correct
        if (userName.equals("TeacherStaff") && password.equals("Library")) {
            logInfo.setText("Login Succesful");
            //Open booking page
            welcomePage();    
        } 
        else {
            logInfo.setText("Incorrect Login Information");
        }
        //Reset the username and password feilds
        userNameText.setText("");
        passText.setText("");
    }

    public static int compNum(int computerNumber) {
        try {
            //computers.csv file location. Depends on user laptop
            String filePath = "C://Users//Ubaid Khan//OneDrive//Desktop//computers.csv"; 
            //Initialze scanner                                                                          
            Scanner scan = new Scanner(new File(filePath));
            //Counts how many computers are there
            int lineCounters = 0;

            //While reading csv file
            while (scan.hasNextLine()) {
                String currentLine = scan.nextLine();
                lineCounters = lineCounters + 1;
            }
            //Subtract initial line
            lineCounters = lineCounters - 1;
            computerNumber = lineCounters;
        } 
        //Catch any errors that occur due to the file or reading of the file
        catch (IOException e) {
            e.printStackTrace();
        }

        return computerNumber;
    }

    public static void validateInfo() {
        //If the user as not inputted any information
        if(timeText.getText().isEmpty() || teacherNameText.getText().isEmpty() || roomNumberText.getText().isEmpty() || numComputersText.getText().isEmpty()) {
            bookOrNot.setText("Please Enter Information");
        }
        else {
            try {
                //Convert string to int
                int num = Integer.parseInt(numComputersText.getText());
                //If the user inputted the incorrect amount of computers
                if(num > computerNum || num <= 0) {
                    bookOrNot.setText("Incorrect number of computers");
                }
                else{
                    String bookTime = timeText.getText();
                    String bookName = teacherNameText.getText();
                    String bookRoom = roomNumberText.getText();
                    String numBook = numComputersText.getText(); 
                    
                    //Check to see if the time is not already taken
                    String open = openSlot(data, bookTime, bookName, bookRoom, numBook);
        
                    //If time is available
                    if(open.equals("open")) {
                       
                        bookOrNot.setText("Computers Are Booked!!!"); 
                        conformation(bookTime, bookName, bookRoom, numBook);
                        JOptionPane.showMessageDialog(null, "There should be a conformation CSV file on your desktop", "Conformation", JOptionPane.PLAIN_MESSAGE);
                    }
                    //If time is taken already
                    if(open.equals("closed")){
                        bookOrNot.setText("Computers are not available for this time");
                    }
                    
                }
            }
            //If number of computers are not a integer or any errors occur due to the inputted information
            catch(Exception e) {
                bookOrNot.setText("Incorrect number of computers");
            }
        }
    }

    public static String openSlot(String data[][], String bookTime, String bookName, String bookRoom, String numBook) {
        String book = "closed";

        //Iterate through the 2D array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                //If time equals inputted time and no one as booked it
                if (data[i][j].equals(bookTime) && data[i][1].equals("") && data[i][2].equals("") && data[i][3].equals("")) {
                    //Add the user information
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
        //Location of conformation csv file. Depends on user laptop
        String fileLocation = "C://Users//Ubaid Khan//OneDrive//Desktop//conformation.csv";

        try {
            //Add user information
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation));
            bw.write("Time, Name, Room Number, Number of Computers \n");
            bw.write(bookTime + "," + bookName + "," + bookRoom + "," + numBook);
            bw.close();
        } 
        //Catch any errors due to the file location or writting the file
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
