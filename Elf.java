/**
 * The Elf class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [18/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/8]
 * Implements a 10% chance to deal double damage with magical attacks
 * 
 * @author Alejandro Olea
 * @version 2025.04.10
 */
public class Elf extends Creature {
    private static final int MAX_STR = 18;
    private static final int MIN_STR = 5;
    private static final int MAX_HP = 25;
    private static final int MIN_HP = 8;

    /**
     * Constructor for objects of class Elf -
     * The instantiating class asks for an Elf and the Elf class is responsible for
     * return an Elf object with strength and hitpoint values in the appropriate range
     */
    public Elf() {
        super(
            Randomizer.nextInt(MAX_STR - MIN_STR + 1) + MIN_STR - 1,
            Randomizer.nextInt(MAX_HP - MIN_HP + 1) + MIN_HP - 1
        );
    }

    /**
     * Allows an Elf to determine how much damage it is causing in this round of battle
     * There is a 10% chance to deal double damage with a magical attack
     * @return a value between 1 and str, doubled if the magical effect triggers
     */
    @Override
    public int attack() {
        int baseDamage = super.attack();
        if (Randomizer.nextInt(10) == 1) {
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
