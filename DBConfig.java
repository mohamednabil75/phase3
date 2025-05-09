public class DBConfig {

    public static void Init() {
        Database.Connect();
        InitUser();
        InitAsset();
    }

    public static void InitUser(){
        Database.Query("CREATE TABLE IF NOT EXISTS User (name TEXT, email TEXT, password TEXT, userId INTEGER PRIMARY KEY, income REAL, balance REAL)");
    }

    public static void InitAsset(){
        Database.Query("CREATE TABLE IF NOT EXISTS Asset (assetId INT, name TEXT, assetType TEXT, purchasePrice REAL, purchaseDate DATA)");
    }
}
