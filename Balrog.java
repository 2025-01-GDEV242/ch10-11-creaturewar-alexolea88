/**
 * The Balrog class implements a wrapper for the Demon class with the following additions
 * Implements a maximum/minimum strength for the creature type [100/50]
 * Implements a maximum/minimum hitpoint total for the creature type [200/80]
 * Inherits the Demon's 5% chance to deal an additional 50 damage
 * Attacks twice per round, summing the damage of both attacks
 * 
 * @author Alejandro Olea
 * @version 2025.04.10
 */
public class Balrog extends Demon {
    private static final int MAX_STR = 100;
    private static final int MIN_STR = 50;
    private static final int MAX_HP = 200;
    private static final int MIN_HP = 80;

    /**
     * Constructor for objects of class Balrog -
     * The instantiating class asks for a Balrog and the Balrog class is responsible for
     * return a Balrog object with strength and hitpoint values in the appropriate range
     */
    public Balrog() {
        super(
            Randomizer.nextInt(MAX_STR - MIN_STR + 1) + MIN_STR - 1,
            Randomizer.nextInt(MAX_HP - MIN_HP + 1) + MIN_HP - 1
        );
    }

    /**
     * Allows a Balrog to determine how much damage it is causing in this round of battle
     * The Balrog attacks twice, each attack having a 5% chance to add 50 damage from Demon
     * @return the sum of two attacks, each between 1 and str, plus 50 if the magical effect triggers
     */
    @Override
    public int attack() {
        int firstAttack = super.attack();
        int secondAttack = super.attack();
        return firstAttack + secondAttack;
    }
}
