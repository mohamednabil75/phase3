/**
 * Represents a bank account with basic information and operations like deposit and withdrawal.
 */
public class BankAccount {
    private int bankId;
    private String bankName;
    private String cardHolderName;
    private String cardNumber;
    private int cvv;
    private String expiredDate;
    private float balance;

    /**
     * Constructs a new BankAccount with the given details.
     *
     * @param bankid        the ID of the bank
     * @param bankname      the name of the bank
     * @param cardholdername the name of the cardholder
     * @param cardnumber    the card number
     * @param cvv           the CVV of the card
     * @param expireddate   the card's expiration date
     * @param balance       the initial balance of the account
     */
    public BankAccount(int bankid, String bankname, String cardholdername, String cardnumber,
                       int cvv, String expireddate, float balance) {
        this.balance = balance;
        this.bankId = bankid;
        this.bankName = bankname;
        this.cardHolderName = cardholdername;
        this.cardNumber = cardnumber;
        this.cvv = cvv;
        this.expiredDate = expireddate;
    }

    /**
     * Dummy method to simulate linking a BankAccount to a User.
     *
     * @param data the BankAccount to link
     * @return the same BankAccount object passed in
     */
    public BankAccount linktoUser(BankAccount data) {
        return data;
    }

    /**
     * Sets the card number.
     *
     * @param cardnumber the new card number
     */
    public void SetCardNumber(String cardnumber) {
        this.cardNumber = cardnumber;
    }

    /**
     * Sets the CVV code.
     *
     * @param cvv the new CVV code
     */
    public void Setcvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Sets the expiration date of the card.
     *
     * @param date the new expiration date
     */
    public void SetExpiredDate(String date) {
        this.expiredDate = date;
    }

    /**
     * Gets the expiration date of the card.
     *
     * @return the expiration date as a string
     */
    public String getexpireddate() {
        return expiredDate;
    }

    /**
     * Gets the card number.
     *
     * @return the card number
     */
    public String GetCardNumber() {
        return cardNumber;
    }

    /**
     * Deposits an amount into the account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(float amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.print("Invalid amount!");
        }
    }

    /**
     * Withdraws an amount from the account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(float amount) {
        if (amount < balance && amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Error process!");
        }
    }

    /**
     * Gets the account balance.
     *
     * @return the current balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * Gets the card holder's name.
     *
     * @return the name of the card holder
     */
    public String getCardHolderName() {
        return cardHolderName;
    }
}
