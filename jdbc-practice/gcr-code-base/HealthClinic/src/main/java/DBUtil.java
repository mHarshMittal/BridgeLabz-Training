import java.sql.*;

public class DBUtil {
    static final String URL="jdbc:mysql://localhost:3306/clinic";
    static final String USER="root";
    static final String PASS="password";

    public static Connection getConn() throws Exception {
        return DriverManager.getConnection(URL,USER,PASS);
    }
}
