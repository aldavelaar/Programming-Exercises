import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    static void addAll(int n) {
        Statement sqlSt;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/Batch";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();
            for (int i = 0; i < n; i++) {
                sqlSt.executeUpdate("INSERT INTO Batch(num) VALUES ('" + Math.random() + "')");
            }
            for (int i = 0; i < n; i++) {
                sqlSt.addBatch("INSERT INTO Batch(num) VALUES ('" + Math.random() + "')");
            }
            sqlSt.executeBatch();
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
        addAll(1000);
    }
}
