import java.util.ArrayList;

public class AssetManager {
    ArrayList<Asset> assetslist = new ArrayList<>() ; // Must store in database 
    /**
     * 
     * @param asset assets that will add 
     */
    public void addAsset(Asset asset) {
        assetslist.add(asset);
    }
    /**
     * 
     * @param asset assets that will remove
     */
    public void removeAsset(Asset asset) {
        assetslist.remove(asset);
    }
    /**
     * 
     * @param assetId the index of assets list 
     * @param asset new asset
     */
    public void editAsset(int assetId,Asset asset) {
        assetslist.set(assetId,asset) ;
    }
    /**
     * 
     * @return array of all assets added 
     */
    public ArrayList<Asset> getAssets(){
        return assetslist ;
    }
    /**
     * display all assets
     */
    public void displayAssets() {
        for(Asset a : assetslist){
            System.out.print(a);
        }
    }
}
