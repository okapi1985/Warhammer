package armies.vampireCounts;

import armies.Model;

public class Zombie extends Model {
    public Zombie(String name, int movement, int weaponSkill, int ballisticSkill, int strength, int toughness,
                         int wounds, int initiative, int attack, int leadership,
                         int unitStrength, int save) {
        super(name, movement, weaponSkill, ballisticSkill,
                strength, toughness, wounds, initiative, attack, leadership,
                unitStrength, save);
    }
}
