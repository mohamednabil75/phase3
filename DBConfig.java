public class DBConfig {

    public static void Init() {
        Database.Connect();
        InitUser();
        InitAsset();
        InitPortfolio();
        InitFinancialGoal();
        InitBankAccount();
    }

    public static void InitUser(){
        Database.Query("CREATE TABLE IF NOT EXISTS User (name TEXT, email TEXT, password TEXT, userId INTEGER PRIMARY KEY, income REAL, balance REAL)");
    }

    public static void InitAsset(){
        Database.Query("CREATE TABLE IF NOT EXISTS Asset (assetId INT, portfolio INT, name TEXT, assetType TEXT, purchasePrice REAL, purchaseDate DATA)");
    }

    public static void InitPortfolio(){
        Database.Query("CREATE TABLE IF NOT EXISTS Portfolio (portfolioId INT, amount REAL)");
    }

    public static void InitFinancialGoal(){
        Database.Query("CREATE TABLE IF NOT EXISTS FinancialGoal (goalId INT, userId INT, goalType TEXT, targetAmount REAL, currentAmount REAL, targetDate DATE)");
    }

    public static void InitBankAccount(){
        Database.Query("CREATE TABLE IF NOT EXISTS BankAccount (bankId INT, userId INT, bankName TEXT, cardHolderName TEXT, cardNumber TEXT, cvv INT, expiredDate DATE, balance REAL)");
    }
}
