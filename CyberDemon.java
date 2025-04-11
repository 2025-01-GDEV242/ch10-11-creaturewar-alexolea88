/**
 * The CyberDemon class implements a wrapper for the Demon class with the following additions
 * Implements a maximum/minimum strength for the creature type [40/20]
 * Implements a maximum/minimum hitpoint total for the creature type [100/25]
 * Inherits the Demon's 5% chance to deal an additional 50 damage
 * 
 * @author Alejandro Olea
 * @version 2025.04.10
 */
public class CyberDemon extends Demon {
    private static final int MAX_STR = 40;
    private static final int MIN_STR = 20;
    private static final int MAX_HP = 100;
    private static final int MIN_HP = 25;

    /**
     * Constructor for objects of class CyberDemon -
     * The instantiating class asks for a CyberDemon and the CyberDemon class is responsible for
     * return a CyberDemon object with strength and hitpoint values in the appropriate range
     */
    public CyberDemon() {
        super(
            Randomizer.nextInt(MAX_STR - MIN_STR + 1) + MIN_STR - 1,
            Randomizer.nextInt(MAX_HP - MIN_HP + 1) + MIN_HP - 1
        );
    }
}
