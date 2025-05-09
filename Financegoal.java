import java.util.ArrayList;

/**
 * Represents a financial goal containing multiple individual goals
 * and tracks the progress toward completing them.
 */
public class Financegoal {
    private int goalId;
    private float currentProgress;
    private ArrayList<Goal> goals = new ArrayList<>();

    /**
     * Constructs a Financegoal with a unique goal ID.
     *
     * @param goalId the unique identifier for this financial goal
     */
    public Financegoal(int goalId) {
        this.goalId = goalId;
        this.currentProgress = 0;
    }

    /**
     * Adds a new individual goal to the list of financial goals.
     *
     * @param goal the Goal object to be added
     */
    public void addNewGoal(Goal goal) {
        goals.add(goal);
    }

    /**
     * Sets the current progress amount toward completing the financial goals.
     *
     * @param amount the current progress amount
     */
    public void settargetAmount(float amount) {
        this.currentProgress = amount;
    }

    /**
     * Gets the unique goal ID.
     *
     * @return the goal ID
     */
    public int getgoalid() {
        return goalId;
    }

    /**
     * Checks whether the combined target amounts of all individual goals
     * have been met or exceeded.
     *
     * @return true if the current progress is enough to reach all goals, false otherwise
     */
    public boolean isGoalReached() {
        float totalTarget = 0;
        for (Goal goal : goals) {
            totalTarget += goal.getTargetAmount();
        }
        return currentProgress >= totalTarget;
    }

    /**
     * Displays the details of all financial goals in a single string.
     *
     * @return a string representation of all goals
     */
    public String displayfinancegoals() {
        String result = "";
        for (Goal g : goals) {
            result += g.getgoal() + "\n";
        }
        return result;
    }
}
