import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Payroll_Service_JDBC {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "1999";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected....");
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}