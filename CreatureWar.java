import java.util.ArrayList;

/**
 * CreatureWar manages a large-scale battle simulation between two armies of creatures.
 * The simulation pits a "good" army of Humans and Elves against an "evil" army of Humans,
 * CyberDemons, and Balrogs in a narrow passageway, where one creature from each army
 * fights at a time until one army is depleted.
 * 
 * @author Alejandro Olea
 * @version 2025.04.10
 */
public class CreatureWar {
    private ArrayList<Creature> goodArmy;
    private ArrayList<Creature> evilArmy;
    private int battlesFought;
    private int goodCasualties;
    private int evilCasualties;

    /**
     * Constructor - initializes and populates both armies
     */
    public CreatureWar() {
        goodArmy = new ArrayList<>();
        evilArmy = new ArrayList<>();
        battlesFought = 0;
        goodCasualties = 0;
        evilCasualties = 0;
        populateArmies();
    }

    /**
     * Populates the good and evil armies with creatures based on random selection.
     * Good army: 100 creatures (Humans 60%, Elves 20%).
     * Evil army: 40 creatures (Humans 72%, CyberDemons 24%, Balrogs 4%).
     */
    private void populateArmies() {
        // Populate good army (100 creatures)
        for (int i = 0; i < 100; i++) {
            int roll = Randomizer.nextInt(10);
            if (roll <= 6) { // 1-6: Human (60%)
                goodArmy.add(new Human());
            } else { // 7-8: Elf (20%)
                goodArmy.add(new Elf());
            }
        }

        // Populate evil army (40 creatures)
        for (int i = 0; i < 40; i++) {
            int roll = Randomizer.nextInt(25);
            if (roll <= 18) { // 1-18: Human (72%)
                evilArmy.add(new Human());
            } else if (roll <= 24) { // 19-24: CyberDemon (24%)
                evilArmy.add(new CyberDemon());
            } else { // 25: Balrog (4%)
                evilArmy.add(new Balrog());
            }
        }
    }

    /**
     * Runs the battle simulation until one or both armies are depleted
     * @return a string summarizing the outcome and statistics
     */
    public String runSimulation() {
        while (!goodArmy.isEmpty() && !evilArmy.isEmpty()) {
            Creature goodFighter = goodArmy.get(0);
            Creature evilFighter = evilArmy.get(0);
            battlesFought++;

            // Fight until at least one is knocked out
            while (goodFighter.isAlive() && evilFighter.isAlive()) {
                // Simultaneous attacks
                int goodDamage = goodFighter.attack();
                int evilDamage = evilFighter.attack();
                evilFighter.takeDamage(goodDamage);
                goodFighter.takeDamage(evilDamage);
            }

            // Remove defeated creatures
            if (goodFighter.isKnockedOut()) {
                goodArmy.remove(0);
                goodCasualties++;
            }
            if (evilFighter.isKnockedOut()) {
                evilArmy.remove(0);
                evilCasualties++;
            }
        }

        // Generate after-action report
        return generateReport();
    }

    /**
     * Generates a report on the battle's outcome and statistics
     * @return a string describing which army won and statistics
     */
    private String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== CreatureWar After Action Report ===\n");

        // Determine winner
        if (goodArmy.isEmpty() && evilArmy.isEmpty()) {
            report.append("Both armies have been annihilated! It's a draw.\n");
        } else if (goodArmy.isEmpty()) {
            report.append("The Evil Army came out victorious!\n");
        } else {
            report.append("The Good Army came out victorious!\n");
        }

        // Statistics
        report.append("Battles fought: ").append(battlesFought).append("\n");
        report.append("Good Army casualties: ").append(goodCasualties).append("\n");
        report.append("Evil Army casualties: ").append(evilCasualties).append("\n");
        report.append("Good Army survivors: ").append(goodArmy.size()).append("\n");
        report.append("Evil Army survivors: ").append(evilArmy.size()).append("\n");

        return report.toString();
    }

    /**
     * Main method to start the CreatureWar simulation
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        CreatureWar war = new CreatureWar();
        System.out.println(war.runSimulation());
    }
}
