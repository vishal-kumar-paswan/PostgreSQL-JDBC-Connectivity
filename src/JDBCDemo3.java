import java.sql.*;

public class JDBCDemo3 {
    public static void main(String[] args) throws  Exception{
        String url = "jdbc:postgresql://localhost:8888/demo";
        String username = "postgres";
        String password = "0418";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established!");
        Statement statement = connection.createStatement();

        // 1. Insert query
        String insertQuery = "insert into student values(5, 'Subho', 70)";
        Boolean insertStatus = statement.execute(insertQuery); // The execute() method only returns true when a ResultSet is found, in other cases it will return false
        System.out.println("Insert status: " + insertStatus);

        // 2. Update query
        String updateQuery = "update student set sname='Sandipan' where sid=4";
        Boolean updateStatus = statement.execute(updateQuery);
        System.out.println("Update status: " + updateStatus);

        // 3. Delete query
        String deleteQuery = "delete from student where sid=5";
        Boolean deleteStatus = statement.execute(deleteQuery);
        System.out.println("Delete status: " + deleteStatus);

        connection.close();
        System.out.println("Connection closed!");

    }
}
