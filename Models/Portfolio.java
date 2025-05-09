package Models;
import java.util.ArrayList;

import .AbstractZakat;

/**
 * Represents a financial portfolio containing a collection of assets.
 * Allows calculation of total amount and zakat.
 */
public class Portfolio {
    
    /** Total amount of all assets in the portfolio */
    private float amount;

    /** Unique identifier for the portfolio */
    private int portfolioId;

    /**
     * Calculates and sets the total amount based on a list of assets.
     *
     * @param assetarray the list of assets included in the portfolio
     */
    public void setamount(ArrayList<Asset> assetarray) {
        float price = 0;
        for (Asset asset : assetarray) {
            price += asset.getamount();
        }
        this.amount = price;
    }

    /**
     * Returns the total amount/value of the portfolio.
     *
     * @return the portfolio amount
     */
    public float getamount() {
        return amount;
    }

    /**
     * Returns the unique ID of the portfolio.
     *
     * @return the portfolio ID
     */
    public int getportfilioId() {
        return portfolioId;
    }

    /**
     * Manually edits the total amount of the portfolio.
     *
     * @param amount the new amount to set
     */
    public void editamount(float amount) {
        this.amount = amount;
    }

    /**
     * Calculates zakat based on a given strategy and number of family members.
     *
     * @param zakat   the zakat calculation strategy
     * @param members the number of family members
     */
    public void calculatezakat(AbstractZakat zakat, int members) {
        zakat.setmembers(members);
        zakat.calculatezakat(amount);
    }
}
