import java.sql.*;
import java.io.*;

public class DBToCSV {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "password"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT id, name, department, salary FROM employees"
            );

            FileWriter fw = new FileWriter("employees.csv");

            // write header
            fw.write("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                fw.write(
                        rs.getInt(1) + "," +
                        rs.getString(2) + "," +
                        rs.getString(3) + "," +
                        rs.getInt(4) + "\n"
                );
            }

            fw.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

