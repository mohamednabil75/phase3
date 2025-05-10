import Models.Asset;
import Models.BankAccount;
import Models.Financegoal;
import Models.Goal;
import Models.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBConfig.Init();

        Scanner sc = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            System.out.println("1. Sign Up\n2. Sign In\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter your name:");
                String name = sc.nextLine();
                System.out.println("Enter your email:");
                String email = sc.nextLine();
                System.out.println("Enter your password:");
                String password = sc.nextLine();
                System.out.println("Enter your userId:");
                int userId = sc.nextInt();
                System.out.println("Enter your income:");
                float income = sc.nextFloat();
                System.out.println("Enter your balance:");
                float balance = sc.nextFloat();

                User user = new User(name, email, password, userId, income, balance);
                Repository.addUser(user);

            } else if (choice == 2) {
                System.out.println("Enter your email:");
                String email = sc.next();
                currentUser = Repository.getUser(email);

                if (currentUser == null) {
                    System.out.println("User not found. Please sign up first.");
                    continue;
                }

                System.out.println("Enter your password:");
                String password = sc.next();

                if (!currentUser.getPassword().equals(password)) {
                    System.out.println("Wrong password");
                    continue;
                }

                System.out.println("Welcome, " + currentUser.getName());

                boolean innerLoop = true;
                while (innerLoop) {
                    System.out.println("1. Add Bank Account\n2. Add Asset\n3. Edit Asset\n4. View Asset\n5.get bank info\n6. logout");
                    int action = sc.nextInt();
                    sc.nextLine();

                    switch (action) {
                        case 1:
                            System.out.println("Enter your bank account ID:");
                            int bankId = sc.nextInt();
                            System.out.println("Enter your bank name:");
                            String bankName = sc.nextLine();
                            System.out.println("Enter your card number:");
                            String cardNumber = sc.nextLine();
                            System.out.println("Enter your account number:");
                            String accountNumber = sc.nextLine();
                            System.out.println("Enter your CVV:");
                            int cvv = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter your expiry date:");
                            String expiryDate = sc.nextLine();
                            System.out.println("Enter your balance:");
                            float bankBalance = sc.nextFloat();

                            BankAccount account = new BankAccount(bankId, bankName, currentUser.getName(), accountNumber, cvv, expiryDate, bankBalance);
                            currentUser.addBankAccount(account);
                            break;

                        case 2:
                            System.out.println("Enter asset ID:");
                            int assetId = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter protofolio ID:");
                            int protofolioId = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter asset name:");
                            String nameAsset = sc.nextLine();
                            System.out.println("Enter asset type:");
                            String typeAsset = sc.nextLine();
                            System.out.println("Enter purchase price:");
                            float priceAsset = sc.nextFloat();
                            sc.nextLine();
                            System.out.println("Enter purchase date (dd-MM-yyyy):");
                            String dateAsset=sc.nextLine();
                            System.out.println("Enter asset amount:");
                            float amountAsset = sc.nextFloat();
                            sc.nextLine();
                            Asset newAsset = new Asset(assetId,protofolioId , nameAsset, amountAsset, typeAsset, priceAsset, dateAsset);
                            currentUser.addAsset(newAsset);
                            break;
                        case 3:
                            currentUser.displayAssets();
                            System.out.println("Enter the index of the asset to edit:");
                            int index = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new asset name:");
                            String newName = sc.nextLine();
                            System.out.println("Enter new asset type:");
                            String newType = sc.nextLine();
                            System.out.println("Enter new purchase price:");
                            float newPrice = sc.nextFloat();
                            sc.nextLine();
                            System.out.println("Enter new asset amount:");
                            float newAmount = sc.nextFloat();
                            sc.nextLine();
                            System.out.println("Enter new purchase date (dd-MM-yyyy):"); 
                            String newPurchaseDate = sc.nextLine();
                            Asset updatedAsset = new Asset(11, 114100, newName, newAmount, newType, newPrice, newPurchaseDate);
                            currentUser.updateAsset(index, updatedAsset);
                            System.out.println("Asset updated successfully.");

                        case 4:
                            currentUser.displayAssets();
                            break;
                        case 5:

                            System.out.println("Enter the index of the bank account to view:");
                            for (int i = 0; i < currentUser.getBankAccounts().size(); i++) {
                                System.out.println(i + ". " + (currentUser.getBankAccounts().get(i)).bankName);
                            }
                            int bankIndex = sc.nextInt();
                            sc.nextLine();
                            if (bankIndex >= 0 && bankIndex < currentUser.getBankAccounts().size()) {
                                BankAccount selectedAccount = currentUser.getBankAccounts().get(bankIndex);
                                System.out.println("Bank Account ID: " + selectedAccount.bankId);
                                System.out.println("Bank Name: " + selectedAccount.bankName);
                                System.out.println("Card Holder Name: " + selectedAccount.cardHolderName);
                                System.out.println("Card Number: " + selectedAccount.cardNumber);
                                System.out.println("CVV: " + selectedAccount.cvv);
                                System.out.println("Expiry Date: " + selectedAccount.expiredDate);
                                System.out.println("Balance: " + selectedAccount.getBalance());
                            } else {
                                System.out.println("Invalid index.");
                            }
                            break;    

                        case 6:
                            innerLoop = false;
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                }

            } else if (choice == 3) {
                break;
            }
        }

        // Example Usage
        BankAccount b1 = new BankAccount(114100, "Bank Masr", "Seif Anwar", "203012", 3343, "12-12-2025", 50000);
        BankAccount b2 = new BankAccount(114100, "Bank Masr", "Ramadan Sobhi", "203989", 9807, "12-8-2025", 98700000);
        BankAccount b3 = new BankAccount(114102, "Bank Alahly", "Samir Kamona", "204546", 7700, "30-12-2025", 98900);
        User exampleUser = new User("Seif", "seif2005", "123123", 12343, 90000, 908080);

        b1.deposit(7000);
        exampleUser.addBankAccount(b1);
        exampleUser.addBankAccount(b2);

        System.out.println("New balance after deposit: " + b1.getBalance());

        Goal g1 = new Goal("Buy a new car", 500000, "1-1-2026");
        Goal g2 = new Goal("Save for house", 890000, "1-1-2029");
        Goal g3 = new Goal("Investment", 500000, "1-1-2028");

        Financegoal fg = new Financegoal(1);
        fg.addNewGoal(g1);
        fg.addNewGoal(g2);
        fg.addNewGoal(g3);
        fg.settargetAmount(1000000);

        System.out.println("Goal reached: " + fg.isGoalReached());
        exampleUser.addGoal(fg);
        System.out.println(exampleUser.getGoals());
    }
}
