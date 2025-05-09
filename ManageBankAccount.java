/**
 * ManageBankAccount class which is the class which control everything related to bank account such as 
 * add card remove card and add deposit , withdraw ,
 */

import java.util.HashMap;

public class ManageBankAccount {
    /**
     * i use hashmap to be easily to get the data related to a specific account such as card number
     */
        private HashMap<String, BankAccount> accountMap = new HashMap<>();

         /**
         * want to add an account
         * 
         * @param account is the account which i want to add it 
         */

    public void addCard(BankAccount account) {
        if (!accountMap.containsKey(account.GetCardNumber())){
        accountMap.put(account.GetCardNumber(), account);
        }
        else {
            System.out.println("that account already exist ");
        }
    }

            /**
         * want to remove an account
         * @param cardNumber the card number of a specific account  
         */

    public void removeCard(String cardNumber) {
        accountMap.remove(cardNumber);
    }

            /**
         * want to make a deposit
         * @param cardnumber is the card number of a user 
         * @param amount it is the amount of money i want to add it to balance 
         */
    public void deposit(String cardNumber, float amount) {
        BankAccount account = accountMap.get(cardNumber);
        if (account != null) {
            account.deposit(amount);
        }
        else {
            System.out.print("False card number !");
        }
    }
            /**
         * want to do withdraw
         * @param cardnumber is the card number of a user 
         * @param amount it is the amount of money i want to recive it from balance 
         */
    public void withdraw(String cardNumber, float amount) {
        BankAccount account = accountMap.get(cardNumber);
        if (account != null) {
            account.withdraw(amount);
        }
        else {
            System.out.print("False card number !") ;
        }
    }
            /**
         * want to get the balance of a specific account 
         * @param cardnumber is the card number of a user 
         * @return the balance in float
         */

    public float checkBalance(String cardNumber) {
        BankAccount account = accountMap.get(cardNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1;
    }

}
