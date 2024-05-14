import java.sql.*;

public class Payroll_Service_JDBC {


    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "1999";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected....");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee_payroll ");
            while (rs.next()) {
                System.out.println("Employee ID : " + rs.getInt(1));
                System.out.println("Employee Name : " + rs.getString(2));
                System.out.println("Gender : " + rs.getString(3));
                System.out.println("Salary : " + rs.getInt(4));
                System.out.println("Start Date : " + rs.getDate(5));
                System.out.println("Phone Number : " + rs.getInt(6));
                System.out.println("Address : " + rs.getString(7));
                System.out.println("Department : " + rs.getString(8));
                System.out.println("Basic pay : " + rs.getDouble(9));
                System.out.println("Deduction : " + rs.getDouble(10));
                System.out.println("Taxable pay : " + rs.getDouble(11));
                System.out.println("Income tax : " + rs.getDouble(12));
                System.out.println("Net pay : " + rs.getDouble(13));
                System.out.println();
                }

            System.out.println("------ Sum of salary ------");
                ResultSet rs1 = stmt.executeQuery("SELECT gender,SUM(salary) FROM employee_payroll WHERE gender = 'M' OR gender = 'F' GROUP BY gender");
                while (rs1.next()){
                    System.out.println("Gender : "+rs1.getString(1));
                    System.out.println("Salary : "+rs1.getInt(2));
                }

            System.out.println();
            System.out.println("------ Avg of salary ------");
            ResultSet rs2 = stmt.executeQuery("SELECT gender,AVG(salary) FROM employee_payroll WHERE gender = 'M' OR gender = 'F' GROUP BY gender");
            while (rs2.next()){
                System.out.println("Gender : "+rs2.getString(1));
                System.out.println("Salary : "+rs2.getInt(2));
            }

            System.out.println();
            System.out.println("------ Min of salary ------");
            ResultSet rs3 = stmt.executeQuery("SELECT gender,MIN(salary) FROM employee_payroll WHERE gender = 'M' OR gender = 'F' GROUP BY gender");
            while (rs3.next()){
                System.out.println("Gender : "+rs3.getString(1));
                System.out.println("Salary : "+rs3.getInt(2));
            }

            System.out.println();
            System.out.println("------ Max of salary ------");
            ResultSet rs4 = stmt.executeQuery("SELECT gender,MAX(salary) FROM employee_payroll WHERE gender = 'M' OR gender = 'F' GROUP BY gender");
            while (rs4.next()){
                System.out.println("Gender : "+rs4.getString(1));
                System.out.println("Salary : "+rs4.getInt(2));
            }

            System.out.println();
            System.out.println("------ Count of salary ------");
            ResultSet rs5 = stmt.executeQuery("SELECT gender,COUNT(salary) FROM employee_payroll WHERE gender = 'M' OR gender = 'F' GROUP BY gender");
            while (rs5.next()){
                System.out.println("Gender : "+rs5.getString(1));
                System.out.println("Salary : "+rs5.getInt(2));
            }



            con.close();
            throw new CustomException("Error found in process");
        }
        catch (CustomException e){
            System.out.println("Error found in process");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}