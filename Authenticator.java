
import Models.User;
public class Authenticator {

    private static int loggedUser = -1;

    public static boolean login(String email, String password) {

        try {
            User user = Repository.getUser(email);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    loggedUser = user.getUserId();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
      

    public static void signup(User user) {
        try {
            Repository.addUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isLoggedIn() {
        return loggedUser != -1;
    }

    public static void logout() {
        loggedUser = -1;
    }
}