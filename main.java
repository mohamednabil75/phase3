import Models.Asset;
import Models.BankAccount;
import Models.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
              
              

                User user = new User(name, email, password, userId, 0, 0);
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

                            BankAccount account = new BankAccount(currentUser.getUserId(), bankName, currentUser.getName(), accountNumber, cvv, expiryDate, bankBalance);
                            Repository.addBankAccount(account);
                            break;

                        case 2:
                            System.out.println("Enter asset ID:");
                            int assetId = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter asset name:");
                            String nameAsset = sc.nextLine();
                            System.out.println("Enter asset type:");
                            String typeAsset = sc.nextLine();
                            System.out.println("Enter purchase price:");
                            float priceAsset = sc.nextFloat();
                            sc.nextLine();
                            BankAccount bankAccount = Repository.getBankAccount(currentUser.getUserId());
                            if(priceAsset <= 0) {
                                System.out.println("Invalid price. Please enter a positive value.");
                                continue;
                            }
                            else if(priceAsset > bankAccount.balance) {
                                System.out.println("Insufficient balance. Please deposit more funds.");
                                continue;
                            }
                            else{
                                bankAccount.balance=(bankAccount.balance - priceAsset);
                                System.out.println("New balance after purchase: " + bankAccount.balance);
                            }
                            Repository.updateBankAccount(bankAccount);
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String dateAsset = now.format(formatter);
                            Asset newAsset = new Asset(assetId,currentUser.getUserId() , nameAsset,  typeAsset, priceAsset, dateAsset);
                            Repository.AddAsset(newAsset);
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
                            Repository.AddAsset(updatedAsset);


                        case 4:
                            List<Asset>assets=Repository.getAssets(currentUser.getUserId());
                            if (assets.isEmpty()) {
                                System.out.println("No assets found.");
                            } else {
                                for (int i = 0; i < assets.size(); i++) {
                                    System.out.println("Asset " + (i + 1) + ": " + assets.get(i).name);
                                    System.out.println("Asset ID: " + assets.get(i).assetId);
                                    System.out.println("Portfolio ID: " + assets.get(i).portfolioId);
                                    System.out.println("Asset Type: " + assets.get(i).assetType);
                                    System.out.println("Purchase Price: " + assets.get(i).purchasePrice);
                                    System.out.println("Purchase Date: " + assets.get(i).purchaseDate);
                                    System.out.println("------------------------------");
                                }
                            }
                            break;
                        case 5:

                            BankAccount account1= Repository.getBankAccount(currentUser.getUserId());
                            System.out.println("Bank Account ID: " + account1.bankId);
                            System.out.println("Bank Name: " + account1.bankName);
                            System.out.println("Card Holder Name: " + account1.cardHolderName);
                            System.out.println("Card Number: " + account1.cardNumber);
                            System.out.println("CVV: " + account1.cvv);
                            System.out.println("Expiry Date: " + account1.expiredDate);
                            System.out.println("Balance: " + account1.balance);
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
