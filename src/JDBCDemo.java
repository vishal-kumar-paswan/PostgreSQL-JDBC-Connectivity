// 1. Import package
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {

        // 2. Load and register (Optional above JDBC v4.0)
        Class.forName("org.postgresql.Driver");

        // 3. Create connection
        // Our java code will be first connecting with JDBC API, JDBC will connect to the Postgresql
        // database located at url with the provided port number
        String url = "jdbc:postgresql://localhost:8888/demo";
        String username = "postgres";
        String password = "0418";

        Connection connection = DriverManager.getConnection(url, username, password);

        // Print a statement to test if connection is established or not
        System.out.println("Connection established!");

        // 4. Create statement
        String sql = "select sname from student where sid = 1";
        Statement statement = connection.createStatement();

        // 5. Execute statement
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next(); // next() is executed to point to first row

        String sName = resultSet.getString("sname"); // Apart from column name, getString() also accepts column index
        System.out.println("Student name: " + sName);

        // 6. Close connection
        connection.close();
        System.out.println("Connection closed!");
    }
}
