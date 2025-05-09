/**
 * this class have data about target goal 
 */

public class Goal {
    protected String goalType;
    protected float targetAmount;
    protected String targetDate;

    /**
     * @param goalType is the type of goal i will set it 
     * @param targetAmount is the the amount i put to be my target
     * @param targetDAte is the date my goal must reach 
     */
    public Goal(String goalType, float targetAmount, String targetDate) {
        this.goalType = goalType;
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
    }
    public float getTargetAmount() {
        return targetAmount;
    }

    /**
     * @return the goal type 
     */
    public String getGoalType() {
        return goalType;
    }

    /**
     * 
     * @return target date
     */
    public String getTargetDate() {
        return targetDate;
    }
    /**
     * 
     * @return the setted goal in String
     */
    public String getgoal(){
        return  "Target amount : " + Float.toString(targetAmount) + " Target type : "  + goalType + " Target date : "  + targetDate + " "  ;
        
    }

}
