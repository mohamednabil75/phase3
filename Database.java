import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {
    
    public static Connection connection = null;

    public static void Connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mydata.db");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Query(String query){
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }

    public static List<Map<String, String>> FetchQuery(String query) {

        List<Map<String, String>> resultList = new ArrayList<>();
    
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, String> row = new java.util.HashMap<>();

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    row.put(columnName, columnValue);
                }

                resultList.add(row);
            }

            return resultList;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
