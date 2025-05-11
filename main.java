import Models.Asset;
import Models.BankAccount;
import Models.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                            sc.nextLine();
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
                            // Validate priceAsset
                            System.out.println("enter index of bank account to pay");
                            if(currentUser.getBankAccounts().size()==0){
                                System.out.println("No bank accounts found. Please add a bank account first.");
                                continue;
                            }
                            for (int i = 0; i < currentUser.getBankAccounts().size(); i++) {
                                System.out.println(i + ". " + (currentUser.getBankAccounts().get(i)).bankName);
                            }
                            int bankIndex = sc.nextInt();
                            sc.nextLine();
                            if (bankIndex < 0 || bankIndex >= currentUser.getBankAccounts().size()) {
                                System.out.println("Invalid index.");
                                continue;
                            }
                            
                            if(priceAsset <= 0) {
                                System.out.println("Invalid price. Please enter a positive value.");
                                continue;
                            }
                            else if(priceAsset > currentUser.accounts.get(bankIndex).balance) {
                                System.out.println("Insufficient balance. Please deposit more funds.");
                                continue;
                            }
                            else{
                                currentUser.accounts.get(bankIndex).balance=(currentUser.accounts.get(bankIndex).balance - priceAsset);
                                System.out.println("New balance after purchase: " + currentUser.accounts.get(bankIndex).balance);
                            }
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String dateAsset = now.format(formatter);
                            Asset newAsset = new Asset(assetId,protofolioId , nameAsset,  typeAsset, priceAsset, dateAsset);
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
                            if(newPrice <= 0) {
                                System.out.println("Invalid price. Please enter a positive value.");
                                continue;
                            }
                            else if(newPrice-currentUser.assets.get(index).purchasePrice > currentUser.getBalance()) {
                                System.out.println("Insufficient balance. Please deposit more funds.");
                                continue;
                            }
                            else{
                                currentUser.setBalance(currentUser.getBalance() - (newPrice-currentUser.assets.get(index).purchasePrice));
                                System.out.println("New balance after purchase: " + currentUser.getBalance());
                            }
                            LocalDateTime now1 = LocalDateTime.now();
                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String newPurchaseDate = now1.format(formatter1);
                            Asset updatedAsset = new Asset(currentUser.assets.get(index).assetId, currentUser.assets.get(index).portfolioId, newName, newType, newPrice, newPurchaseDate);
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
                             bankIndex = sc.nextInt();
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

       
    }
}
