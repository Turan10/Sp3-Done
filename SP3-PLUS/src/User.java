import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private String nameOfUser;
    private String lastName;
    private String userName;
    private String password;
    private ArrayList<User> users;
// Constructor for creating user


    //Log-in constructor
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static User UserCreation() throws IOException {

        Scanner scan = new Scanner(System.in);
        ArrayList<User> userList = new ArrayList<>();
        User user = new User("Turan", "Password");
        BufferedWriter userWriter = new BufferedWriter(new FileWriter("/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/ListOfUsers.txt", true));


        try {

            System.out.println("Please create a username");

            String name = scan.nextLine();
            user.setUserName(name);


            System.out.println("please create a password");

            String password = scan.nextLine();
            user.setPassword(password);


            userList.add(user);
            //System.out.println(userList);

            userWriter.write(user.userName + " " + user.password + "\n");

            userWriter.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return user;
    }


    public static void userlogin() {
        Scanner scanner = new Scanner(System.in);
        File file = new File("/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/ListOfUsers.txt");


        try {
            boolean found = false;
            int maxAttempt = 3;
            int counter = 1;

            while (found == false) {

                System.out.println("Username");
                String username = scanner.nextLine();

                System.out.println("Password");
                String password = scanner.nextLine();

                Scanner scan = new Scanner(file);

                while (scan.hasNextLine()) {
                    String line = scan.nextLine();

                    if (line.contains(username) && line.contains(password)) {

                        System.out.println("Login succesfull");
                        System.out.println("Welcome" + " " + username);
                        found = true;
                        Menu menu = new Menu();
                        menu.runProgram();
                        break;
                    } else if (!scan.hasNextLine()) {
                        if (counter < maxAttempt) {


                            System.out.println("The username or password is wrong");
                            counter++;
                        } else {
                            System.out.println("You've tried to many times. Try again later");
                            found = true;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public String toString() {
        return "Name" + " " + userName + " " + "Password" + " " + password;
    }
}











