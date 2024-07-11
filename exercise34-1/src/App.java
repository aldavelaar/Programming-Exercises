import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    static void view(int  id) {
        Statement sqlSt;
        String output;
        ResultSet result;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/Staff";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();

            result = sqlSt.executeQuery("SELECT * FROM Staff WHERE id = " + id + ";"); // result holds the output from the SQL
            while(result.next() != false) {
                output = result.getString("firstName") + " " + result.getString("lastName");
                System.out.println(output);
            }

            sqlSt.close();
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        }
        catch(SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL IS BAD! " + ex.getMessage());
        }
    }

    static void insert(int  id, String lastName, String firstName, char mi, String address, String city, String state, String telephone, String email) {
        Statement sqlSt;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/Staff";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();
            sqlSt.executeUpdate("INSERT INTO Staff(id, lastName, firstName, mi, address, city, state, telephone, email) VALUES ('" + id + "','" + lastName + "','" + firstName + "','" + mi + "','" + address + "','" + city + "','" + state + "','" + telephone + "','" + email + "')");
            sqlSt.close();
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        }
        catch(SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL IS BAD! " + ex.getMessage());
        }
    }

    static void update(int  id, String lastName, String firstName, char mi, String address, String city, String state, String telephone, String email) {
        Statement sqlSt;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/Staff";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();
            sqlSt.executeUpdate("UPDATE Staff SET id = '" + id + "', lastName = '" + lastName + "', firstName = '" + firstName + "', mi = '" + mi + "', address = '" + address + "', city = '" + city + "', state = '" + state + "', telephone = '" + telephone + "', email = '" + email + "' WHERE id = " + id + ";");
            sqlSt.close();
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        }
        catch(SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL IS BAD! " + ex.getMessage());
        }
    }

    public static void main(String[]args) throws Exception {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("To view one member of the staff by ID, enter \"VIEW\"");
        System.out.println("To add a member to the staff, enter \"ADD\"");
        System.out.println("To update the information for one member of the staff, enter \"UPDATE\"");

        String function = scan.nextLine();  // Read user input
        if (null != function) switch (function) {
            case "VIEW":{
                System.out.println("Enter the ID of the staff member you want to view");
                int n = scan.nextInt();
                view(n);
                    break;
                }
            case "ADD":{
                System.out.println("Create an ID for the new staff member you want to add");
                int n = scan.nextInt();
                System.out.println("Enter the staff member's last name, first name, middle initial, address, city, state, phone number, and email, in that order");
                insert(n, scan.nextLine(), scan.nextLine(), scan.next().charAt(0), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
                    break;
                }
            case "UPDATE":{
                System.out.println("Enter the ID of the staff member you want to update");
                int n = scan.nextInt();
                System.out.println("Enter the staff member's new last name, first name, middle initial, address, city, state, phone number, and email, in that order");
                insert(n, scan.nextLine(), scan.nextLine(), scan.next().charAt(0), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
                    break;
                }
            default:
                break;
        }
    }
}
