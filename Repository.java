import Models.Asset;
import Models.BankAccount;
import Models.User;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Repository {
    
    public static void addUser(User user) {

        try {
        
            String query = "INSERT INTO User (name, email, password, userId, income, balance) VALUES ('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', " + user.getUserId() + ", " + user.getIncome() + ", " + user.getBalance() + ")";

            // Create a portfolio for the user
            String portfolioQuery = "INSERT INTO Portfolio (portfolioId, amount) VALUES (" + user.getUserId() + ", " + "0)";
            
            Database.Query(query);
            Database.Query(portfolioQuery);

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

    public static void AddAsset(Asset asset){
        try {
            String query = "INSERT INTO Asset (assetId, portfolio, name, assetType, purchasePrice, amount, purchaseDate) VALUES (" + asset.assetId + ", '" + asset.portfolioId + ", '" + asset.name + "', '" + asset.assetType + "', " + asset.purchasePrice + ", 0, '"  + asset.purchaseDate + "')";
            Database.Query(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Asset getAsset(int assetId) {
        try {
            String query = "SELECT * FROM Asset WHERE assetId = " + assetId;
            List<Map<String, String>> result = Database.FetchQuery(query);
            
            if (!result.isEmpty()) {
                Map<String, String> row = result.get(0);

                Asset asset = new Asset(
                    Integer.parseInt(row.get("assetId")), 
                    Integer.parseInt(row.get("portfolioId")),
                    row.get("name"),
                    row.get("assetType"), 
                    Float.parseFloat(row.get("purchasePrice")), 
                    new Date(row.get("purchaseDate")).toString()
                );

                asset.setamount(Float.parseFloat(row.get("amount")));

                return asset;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addBankAccount(BankAccount bankAccount) {
        try {
            String query = "INSERT INTO BankAccount (bankId, userId, bankName, cardHolderName, cardNumber, cvv, expiredDate, balance) VALUES (" + bankAccount.bankId + ", " + bankAccount.userId + ", '" + bankAccount.bankName + "', '" + bankAccount.cardHolderName + "', '" + bankAccount.cardNumber + "', " + bankAccount.cvv + ", '" + bankAccount.expiredDate + "', " + bankAccount.balance + ")";
            Database.Query(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateBankAccount(BankAccount bankAccount) {
        try {
            String query = "UPDATE BankAccount SET bankName = '" + bankAccount.bankName + "', cardHolderName = '" + bankAccount.cardHolderName + "', cardNumber = '" + bankAccount.cardNumber + "', cvv = " + bankAccount.cvv + ", expiredDate = '" + bankAccount.expiredDate + "', balance = " + bankAccount.balance + " WHERE bankId = " + bankAccount.bankId;
            Database.Query(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static BankAccount getBankAccount(int bankId) {
        try {
            String query = "SELECT * FROM BankAccount WHERE bankId = " + bankId;
            List<Map<String, String>> result = Database.FetchQuery(query);
            
            if (!result.isEmpty()) {
                Map<String, String> row = result.get(0);

                BankAccount bankAccount = new BankAccount(
                    Integer.parseInt(row.get("bankId")), 
                    row.get("bankName"), 
                    row.get("cardHolderName"), 
                    row.get("cardNumber"), 
                    Integer.parseInt(row.get("cvv")), 
                    row.get("expiredDate"), 
                    Float.parseFloat(row.get("balance"))
                );

                return bankAccount;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
