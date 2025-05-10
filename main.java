
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
        
        while (true) { 
            int choice;
            Scanner sc = new Scanner(System.in);
            System.out.println("1.sign up\n2.sign in\n3.exit");
            choice = sc.nextInt();
            if (choice == 1) {
                // System.out.println("enter your name");
                // String name = sc.next();
                // System.out.println("enter your email");
                // String email = sc.next();
                // System.out.println("enter your password");
                // String password = sc.next();
                // System.out.println("enter your userId");
                // int userId = sc.nextInt();
                // System.out.println("enter your income");
                // float income = sc.nextFloat();
                // System.out.println("enter your balance");
                // float balance = sc.nextFloat();

                User u1 = new User("m", "m", "m", 1000, 40, 60);
                Repository.addUser(u1);
            } else if (choice == 2) {
                System.out.println("enter your email");
                String email = sc.next();
                User u1 = Repository.getUser(email);
                if (u1 != null) {
                    System.out.println("Welcome " + u1.getName());
                   
                    break;
                } else {
                    System.out.println("User not found.\n\nPlease,sign up first.");
                }
                System.err.println("enter your password");
                String password = sc.next();
                if (u1.getPassword()==password) {
                    System.out.println("Welcome " + u1.getName());
                    break;
                } else {
                    System.out.println("Wrong password");
                }
                System.err.println("1)add bank account\n2) add Asset\n3) editAsset 4)exit");
                int choice2 = sc.nextInt();
                if (choice2 == 1) {
                    System.out.println("enter your bank name");
                    String bankName = sc.next();
                    System.out.println("enter your card number");
                    String cardNumber = sc.next();
                    System.out.println("enter your account number");
                    String accountNumber = sc.next();
                    System.out.println("enter your cvv");
                    int cvv = sc.nextInt();
                    System.out.println("enter your expired date");
                    String expiredDate = sc.next();
                    System.out.println("enter your balance");
                    float balance = sc.nextFloat();

                    BankAccount b1 = new BankAccount(114100, bankName, u1.getName(), accountNumber, cvv, expiredDate, balance);
                    u1.addBankAccount(b1);
                } else if (choice2 == 2) {
                    System.out.println("enter your asset name");
                    String assetName = sc.next();
                    System.out.println("enter your asset type");
                    String assetType = sc.next();
                    System.out.println("enter your purchase price");
                    float purchasePrice = sc.nextFloat();
                    System.out.println("enter your purchase date");
                    Date purchaseDate = new Date();
                    System.out.println("enter your asset amount");
                    float amount = sc.nextFloat();
                    Asset a1 = new Asset(114100, 114100, assetName, amount, assetType, purchasePrice, purchaseDate);
                    u1.asset=a1;

                } else if (choice2 == 3) {
                    System.out.println("enter your asset name");
                    String assetName = sc.next();
                    System.out.println("enter your asset type");
                    String assetType = sc.next();
                    System.out.println("enter your purchase price");
                    float purchasePrice = sc.nextFloat();
                    System.out.println("enter your purchase date");
                    Date purchaseDate = new Date();
                    System.out.println("enter your asset amount");
                    float amount = sc.nextFloat();
                    Asset a1 = new Asset(114100, 114100, assetName, amount, assetType, purchasePrice, purchaseDate);
                    u1.asset=a1;
                    
                }

            } else if (choice == 3) {
                break;
            }
            
        }
        BankAccount b1 = new BankAccount(114100, "Bank masr", "seif anwar", "203012", 3343, "12-12-2025", 50000) ;
        BankAccount b2 = new BankAccount(114100, "Bank masr", "ramadan sobhi", "203989", 9807, "12-8-2025", 98700000) ;
        BankAccount b3 = new BankAccount(114102, "Bank Alahly", "samir kamona", "204546", 7700, "30-12-2025", 98900) ;
        User u1 = new User("seif", "seif2005", "123123", 12343, 90000, 908080);
        b1.deposit(7000);
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








    }
}
