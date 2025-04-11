/**
 * Abstract class Demon -
 * The Demon class is the base class for all demonic creatures, extending Creature.
 * It implements a 5% chance to deal an additional 50 damage with magical attacks.
 * This class should not be instantiated directly.
 * 
 * @author Alejandro Olea
 * @version 2025.04.10
 */
public abstract class Demon extends Creature {
    /**
     * Create a Demon with a given strength and hit point level
     * @param str the strength of the Demon, used to calculate damage
     * @param hp the health of the Demon at the start of the simulation, and the current health levels during battle
     */
    public Demon(int str, int hp) {
        super(str, hp);
    }

    /**
     * Allows a Demon to determine how much damage it is causing in this round of battle
     * There is a 5% chance to add 50 damage with a magical attack
     * @return a value between 1 and str, plus 50 if the magical effect triggers
     */
    @Override
    public int attack() {
        int baseDamage = super.attack();
        if (Randomizer.nextInt(20) == 1) {
            return baseDamage + 50;
        }
        return baseDamage;
    }
}
