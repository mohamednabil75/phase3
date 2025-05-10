
import Models.Asset;
import Models.BankAccount;
import Models.Financegoal;
import Models.Goal;
import Models.User;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        DBConfig.Init();

        User user = new User("Ahmed", "ahmed@gmail.com", "password123", 1000, 5000, 10000);
        Repository.addUser(user);
    }
}
