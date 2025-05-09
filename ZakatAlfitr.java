/**
 * zakatAlfitr strategy
 */
public class ZakatAlfitr extends AbstractZakat { 
    /**
     * it is a dummy implementation of zakat according to price of 1kg of rice 
     */
    public void calculatezakat(float amount){
        System.out.print("According to the price of 1 kg of Rice = 30 Al Zakat must me = " +getmember()*30*2.75);
    }
}
