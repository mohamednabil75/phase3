/**
 * zakat AlMal Strategy
 */
public class ZakatAlMal extends AbstractZakat {
    /**
     * get the amount of wealth and get the amount of money to pay 
     */
    public void calculatezakat(float amount){
        System.out.print("You have to pay for Zakat al mal amount of money = " +(2.5/100) * amount);
    }
    
}
