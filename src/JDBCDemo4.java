import  java.sql.*;
import java.util.Scanner;
public class JDBCDemo4 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:8888/demo";
        String username = "postgres";
        String password = "0418";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established!");

        // Prepared statements are used -
        // 1. When the query is dynamic
        // 2. To avoid SQL injection attacks
        // 3. To avoid multiple string concatenation in the query

        // We use ? to replace the dynamic data in PreparedStatements
        String query = "insert into student values(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student id: ");
        int studentId = sc.nextInt();

        System.out.print("Enter student name: ");
        String  studentName = sc.next();

        System.out.print("Enter student marks: ");
        int studentMarks = sc.nextInt();

        // Assigning the console input into the PreparedStatement
        preparedStatement.setInt(1, studentId);
        preparedStatement.setString(2, studentName);
        preparedStatement.setInt(3, studentMarks);

        Boolean result = preparedStatement.execute();
        System.out.println("Insert status: " + result);

        connection.close();
        System.out.println("Connection closed!");
    }
}
