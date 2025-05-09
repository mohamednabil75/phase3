public class Asset{
    public AssetManager assetManager ;
    public int assetId;
    public String name;
    private String assetType;
    private float purchasePrice;
    private Date purchaseDate;
    
    public float getpurchasePrice() {
        return (int) purchasePrice;
    }
    public void setpurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public String getAssetType() {
        return assetType;
    }
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    public boolean isZakatEligible() {
        if (assetType.equals("gold") || assetType.equals("silver")) {
            return true;
        } else {
            return false;
        }
    }
}