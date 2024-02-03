import  java.sql.*;
public class JDBCDemo2 {
    public static void main(String[] args) throws  Exception{
        String url = "jdbc:postgresql://localhost:8888/demo";
        String username = "postgres";
        String password = "0418";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established!");

        // Fetching all rows from the table student
        String sql = "select * from student";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Executing a loop to print all the rows till next() returns false
        while (resultSet.next()) {
            System.out.print(resultSet.getInt(1) + ": ");
            System.out.print(resultSet.getString(2) + " - ");
            System.out.println(resultSet.getInt(3));
        }

        connection.close();
        System.out.println("Connection closed!");
    }
}

