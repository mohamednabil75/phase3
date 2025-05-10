package Models;
import java.util.ArrayList;

/**
 * Represents a user in the system with personal, financial,
 * and goal-tracking information.
 */
public class User {

    private String name;
    private String email;
    private String password;
    private int userId;
    private float income;
    private float balance;

    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private ArrayList<Financegoal> fg = new ArrayList<>();
    private ArrayList<Asset> assets = new ArrayList<>();


    public User(String name, String email, String password, int userId, float income, float balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userId = userId;
        this.income = income;
        this.balance = balance;
    }

    // ===== User Info Getters/Setters =====
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getUserId() { return userId; }
    public float getIncome() { return income; }
    public float getBalance() { return balance; }

    // ===== Bank Accounts =====
    public void addBankAccount(BankAccount account) {
        accounts.add(account);
    }
    public ArrayList<BankAccount> getBankAccounts() {
        return accounts;
    }

    // ===== Finance Goals =====
    public void addGoal(Financegoal goal) {
        fg.add(goal);
    }
    public String getGoals() {
        StringBuilder sb = new StringBuilder();
        for (Financegoal goal : fg) {
            sb.append(goal.displayfinancegoals()).append("\n");
        }
        return sb.toString();
    }

  
    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public void removeAsset(int index) {
        if (index >= 0 && index < assets.size()) {
            assets.remove(index);
        }
    }

    public void updateAsset(int index, Asset newAsset) {
        assets.set(index, newAsset);
    }

    public ArrayList<Asset> getAssets() {
        return assets;
    }

    public void displayAssets() {
        if (assets.isEmpty()) {
            System.out.println("No assets found.");
        } else {
            for (int i = 0; i < assets.size(); i++) {
               System.out.println("Asset " + (i + 1) + ": " + assets.get(i).name);
                System.out.println("Asset ID: " + assets.get(i).assetId);
                System.out.println("Portfolio ID: " + assets.get(i).portfolioId);
                System.out.println("Amount: " + assets.get(i).amount);
                System.out.println("Asset Type: " + assets.get(i).assetType);
                System.out.println("Purchase Price: " + assets.get(i).purchasePrice);
                System.out.println("Purchase Date: " + assets.get(i).purchaseDate);
                System.out.println("------------------------------");
            }
        }
    }
}
