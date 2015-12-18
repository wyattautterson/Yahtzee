/**
 * Created by wautterson16 on 12/17/15.
 */
/**
 * Created by wautterson16 on 12/17/15.
 */

import java.util.Random;

public class YahtzeeDie
{
	/* instance data should include a Random number generator, a numOfSides which
	contains the number of sides the die has, value which is the current value
	of the die and isFrozen	which is true if die is frozen, false if not */

    private Random r;
    private int numOfSides;
    private int value;
    private boolean isFrozen;

    /* initialize the Random object appropriately, initialize an int containing the value to 0,
    a boolean isFrozen to false and numOfSides to the argument passed in */
    public YahtzeeDie(int sides)
    {
        r = new Random();
        numOfSides = sides;
        value = 0;
        isFrozen = false;

    }

    /* Set the new value for the die using the Random object */
    public void rollDie()
    {
        value = r.nextInt(6)+1;
    }

    /* Gets the current die value */
    public int getValue()
    {
        if ( value > 0 && value < 7)
            return value;
        else {
            return -999;
        }
    }

    /* Set the value of isFrozen to true */
    public void freezeDie()
    {
        isFrozen = true;
    }

    /* Set the value of isFrozen to false */
    public void unfreezeDie()
    {
        isFrozen = false;
    }

    /* Return true if die is frozen, false if it is unfrozen */
    public boolean isFrozen()
    {
        if (isFrozen == true)
            return true;
        return false;
    }

}

