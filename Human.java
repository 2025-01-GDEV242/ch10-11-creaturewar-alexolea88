

/**
 * The Human class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [20/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/5]
 * 
 * @author Bill Crosbie
 * @author Alejandro Olea
 * 
 * @version 2025-04 v1.1
 */
public class Human extends Creature
{
    // instance variables - replace the example below with your own
    private static final int MAX_HUMAN_HP = 25;
    private static final int MIN_HUMAN_HP = 5;
    private static final int MAX_HUMAN_STR = 20;
    private static final int MIN_HUMAN_STR = 5;

    /**
     * Constructor for objects of class Human -
     * Note that the calling class does not need to know anything about the 
     * requirements of human minimum and maximum values
     * 
     * The instantiating class asks for a Human and the human class is responsible for
     * return a Human object with values in the appropriate range
     * 
     */
    public Human()
    {
        // range + min ensures that the values don't start at one.
        super(
            Randomizer.nextInt(MAX_HUMAN_STR - MIN_HUMAN_STR + 1) + MIN_HUMAN_STR - 1, // 5-20
            Randomizer.nextInt(MAX_HUMAN_HP - MIN_HUMAN_HP + 1) + MIN_HUMAN_HP - 1     // 5-25
        );
          
    }
    
    
    // attack() - not overridden because Humans generate basic damage
    // takeDamage(int) - not overridden, because Humans take all damage assigned to them

}
