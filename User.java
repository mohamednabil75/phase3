public class User {

    private int userId=0;
    
    private String name;
    private String email;
    private String password;
    private float income;
    private float balance;

    public User(String name, String email, String password, int userId, float income, float balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userId = userId;
        this.income = income;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public int getUserId() {
        userId++;
        return userId;
    }

    public float getIncome() {
        return income;
    }

    public float getBalance() {
        return balance;
    }

}