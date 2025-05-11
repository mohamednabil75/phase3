package Models;

/**
 * Represents a financial asset owned by a user.
 * This includes properties such as asset type, purchase price, and eligibility for zakat.
 */
public class Asset {
 
    /** Unique identifier for the asset */
    public int assetId;

    /** Name or label of the asset */
    public String name;

    /** Current amount or value of the asset */
    public float amount;

    /** Type of asset (e.g., gold, silver, stock, etc.) */
    public String assetType;

    /** Purchase price of the asset */
    public float purchasePrice;

    /** Date when the asset was purchased */
    public String purchaseDate;

    public int portfolioId;

    public Asset(int assetId, int portfolioId, String name,  String assetType, float purchasePrice, String purchaseDate) {
        this.assetId = assetId;
        this.portfolioId = portfolioId;
        this.name = name;
        this.assetType = assetType;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
    }

    /**
     * Sets the current amount or value of the asset.
     *
     * @param amount the new amount
     */
    public void setamount(float amount) {
        this.amount = amount;
    }

    /**
     * Gets the current amount or value of the asset.
     *
     * @return the amount
     */
    public float getamount() {
        return amount;
    }

    /**
     * Gets the purchase price of the asset.
     *
     * @return the purchase price
     */
    public float getpurchasePrice() {
        return purchasePrice;
    }

    /**
     * Sets the purchase price of the asset.
     *
     * @param purchasePrice the price at which the asset was bought
     */
    public void setpurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Gets the type of the asset.
     *
     * @return the asset type
     */
    public String getAssetType() {
        return assetType;
    }

    /**
     * Sets the type of the asset.
     *
     * @param assetType the asset type (e.g., "gold", "stock")
     */
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    /**
     * Gets the date the asset was purchased.
     *
     * @return the purchase date
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Determines if the asset is eligible for zakat.
     * Assets like "gold" or "silver" are considered zakat-eligible.
     *
     * @return true if zakat-eligible, false otherwise
     */
    public boolean isZakatEligible() {
        return assetType.equals("gold") || assetType.equals("silver");
    }
}
