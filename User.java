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

    /**
     * Constructs a User with the given parameters.
     *
     * @param name     the user's name
     * @param email    the user's email address
     * @param password the user's password
     * @param userId   the user's unique ID
     * @param income   the user's income
     * @param balance  the user's current balance
     */
    public User(String name, String email, String password, int userId, float income, float balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userId = userId;
        this.income = income;
        this.balance = balance;
    }

    /**
     * Gets the user's name.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the user's income.
     *
     * @return the user's income
     */
    public float getincome() {
        return income;
    }

    /**
     * Sets the user's name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's email.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     *
     * @param email the new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user's password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's unique ID.
     *
     * @return the incremented user ID
     */
    public int getUserId() {
        userId++;
        return userId;
    }

    /**
     * Gets the user's balance.
     *
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * Adds a bank account to the user's list of accounts.
     *
     * @param account the bank account to add
     */
    public void addBankAccount(BankAccount account) {
        accounts.add(account);
    }

    /**
     * Retrieves the list of the user's bank accounts.
     *
     * @return a list of BankAccount objects
     */
    public ArrayList<BankAccount> getBankAccounts() {
        return accounts;
    }

    /**
     * Adds a financial goal to the user's list of financial goals.
     *
     * @param goal the Financegoal to add
     */
    public void addGoal(Financegoal goal) {
        fg.add(goal);
    }

    /**
     * Retrieves all the user's financial goals as a formatted string.
     *
     * @return a string representation of all financial goals
     */
    public String getGoals() {
        StringBuilder sb = new StringBuilder();
        for (Financegoal goal : fg) {
            sb.append(goal.displayfinancegoals()).append("\n");
        }
        return sb.toString();
    }
}
