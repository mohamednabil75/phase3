<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        DBConfig.Init();

        User fetchedUser = Repository.getUser("email@gmail.com");
        if (fetchedUser != null) {
            System.out.println("User found: " + fetchedUser.getName());
        } else {
            System.out.println("User not found.");
        }
=======
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Asset a = new Asset();
        // a.setAssetType("gold");
        // a.setamount(40000);
        // Asset b = new Asset();
        // b.setAssetType("silver");
        // b.setamount(70000);

        // AssetManager Am = new AssetManager();
        // Am.addAsset(a);
        // Am.addAsset(b);

        // ArrayList<Asset> arrayList = Am.getAssets();
        // ZakatAlMal z1 = new ZakatAlMal() ;
        // ZakatAlfitr z2 = new ZakatAlfitr() ;

        // Portfolio p = new Portfolio() ;
        // p.setamount(arrayList);
        // p.calculatezakat(z1,9);
        // System.out.print("\n");
        // p.calculatezakat(z2, 7);

        BankAccount b1 = new BankAccount(114100, "Bank masr", "seif anwar", "203012", 3343, "12-12-2025", 50000) ;
        BankAccount b2 = new BankAccount(114100, "Bank masr", "ramadan sobhi", "203989", 9807, "12-8-2025", 98700000) ;
        BankAccount b3 = new BankAccount(114102, "Bank Alahly", "samir kamona", "204546", 7700, "30-12-2025", 98900) ;

        b1.deposit(7000);
        User u1 = new User("seif", "seif2005", "123123", 12343, 90000, 908080);
        u1.addBankAccount(b1);
        u1.addBankAccount(b2);
        System.out.println(b1.getBalance()); 

        Goal g1 = new Goal("buy new car" , 500000 , "1-1-2026") ;
        Goal g2 = new Goal("ay 7aga" , 890000 , "1-1-2029") ;
        Goal g3 = new Goal("...." , 500000 , "1-1-2028") ;
        Financegoal fg = new Financegoal(1);
        fg.addNewGoal(g1);
        fg.addNewGoal(g2);
        fg.addNewGoal(g3);
        fg.settargetAmount(1000000);
        System.out.println(fg.isGoalReached());
        u1.addGoal(fg);
        System.out.println(u1.getGoals());








>>>>>>> 534c2fc5888420c8324d5d084ec87ab89d4d1a3a
    }
}
