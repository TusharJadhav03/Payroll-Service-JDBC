import java.sql.*;
import java.util.List;

public class Payroll_Service_JDBC {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "1999";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected....");
            String query = "SELECT * FROM employee_payroll";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                System.out.println("Employee ID : "+rs.getInt(1));
                System.out.println("Employee Name : "+rs.getString(2));
                System.out.println("Gender : "+rs.getString(3));
                System.out.println("Salary : "+rs.getInt(4));
                System.out.println("Start Date : "+rs.getDate(5));
                System.out.println("Phone Number : "+rs.getInt(6));
                System.out.println("Address : "+rs.getString(7));
                System.out.println("Department : "+rs.getString(8));
                System.out.println("Basic pay : "+rs.getDouble(9));
                System.out.println("Deduction : "+rs.getDouble(10));
                System.out.println("Taxable pay : "+rs.getDouble(11));
                System.out.println("Income tax : "+rs.getDouble(12));
                System.out.println("Net pay : "+rs.getDouble(13));
                System.out.println();
            }
            System.out.println("Read data Successfully");
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}