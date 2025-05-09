/**
 * it is the abstract class of zakat help us to apply strategy pattern 
 */
public abstract class AbstractZakat {
    private int members ;
    /**
     * 
     * @param number sets the number of members of a family
     */
public void setmembers(int number){
    this.members = number ;
}
/**
 * 
 * @return number of members of a family
 */
public int getmember(){
    return members ;
}
/**
 * it is a abstract function each strategy will inherit it and do these own calculations 
 * 
 * @param amount
 */
public abstract void calculatezakat(float amount);  
}
