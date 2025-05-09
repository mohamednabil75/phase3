public class Main {
    public static void main(String[] args) {
        DBConfig.Init();

        User fetchedUser = Repository.getUser("email@gmail.com");
        if (fetchedUser != null) {
            System.out.println("User found: " + fetchedUser.getName());
        } else {
            System.out.println("User not found.");
        }
    }
}