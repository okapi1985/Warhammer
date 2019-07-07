package armies.lizardmen;

import armies.Model;

public class SaurusWarrior extends Model {
    public SaurusWarrior(String name, int movement, int weaponSkill, int ballisticSkill, int strength, int toughness,
                         int wounds, int initiative, int attack, int leadership,
                         int unitStrength, int save) {
        super(name, movement, weaponSkill, ballisticSkill,
                strength, toughness, wounds, initiative, attack, leadership,
                unitStrength, save);
    }
}
