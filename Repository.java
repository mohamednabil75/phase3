import java.util.List;
import java.util.Map;

public class Repository {
    
    public static void addUser(User user) {

        try {
        
            String query = "INSERT INTO User (name, email, password, userId, income, balance) VALUES ('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', " + user.getUserId() + ", " + user.getIncome() + ", " + user.getBalance() + ")";
            Database.Query(query);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String email) {
        try {
            String query = "SELECT * FROM User WHERE email = '" + email + "'";
            List<Map<String, String>> result = Database.FetchQuery(query);
            
            if (!result.isEmpty()) {
                Map<String, String> row = result.get(0);

                User user = new User(
                    row.get("name"), 
                    row.get("email"), 
                    row.get("password"), 
                    Integer.parseInt(row.get("userId")), 
                    Float.parseFloat(row.get("income")), 
                    Float.parseFloat(row.get("balance"))
                );

                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
}
