package armies;

import java.util.Comparator;

public class Model implements Comparable<Model>{
    private String name;
    private int movement;
    private int weaponSkill;
    private int ballisticSkill;
    private int strength;
    private int toughness;
    private int wounds;
    private int initiative;
    private int attack;
    private int leadership;

    private int unitStrength;

    private int save;

    public Model(String name, int movement, int weaponSkill, int ballisticSkill,
                 int strength, int toughness, int wounds, int initiative, int attack, int leadership,
                 int unitStrength, int save) {
        this.name = name;
        this.movement = movement;
        this.weaponSkill = weaponSkill;
        this.ballisticSkill = ballisticSkill;
        this.strength = strength;
        this.toughness = toughness;
        this.wounds = wounds;
        this.initiative = initiative;
        this.attack = attack;
        this.leadership = leadership;
        this.unitStrength = unitStrength;
        this.save = save;
    }

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(int weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public int getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(int ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public int getWounds() {
        return wounds;
    }

    public void setWounds(int wounds) {
        this.wounds = wounds;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getUnitStrength() {
        return unitStrength;
    }

    public void setUnitStrength(int unitStrength) {
        this.unitStrength = unitStrength;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;

        Model model = (Model) o;

        if (movement != model.movement) return false;
        if (weaponSkill != model.weaponSkill) return false;
        if (ballisticSkill != model.ballisticSkill) return false;
        if (strength != model.strength) return false;
        if (toughness != model.toughness) return false;
        if (wounds != model.wounds) return false;
        if (initiative != model.initiative) return false;
        if (attack != model.attack) return false;
        if (leadership != model.leadership) return false;
        if (unitStrength != model.unitStrength) return false;
        if (save != model.save) return false;
        return name != null ? name.equals(model.name) : model.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + movement;
        result = 31 * result + weaponSkill;
        result = 31 * result + ballisticSkill;
        result = 31 * result + strength;
        result = 31 * result + toughness;
        result = 31 * result + wounds;
        result = 31 * result + initiative;
        result = 31 * result + attack;
        result = 31 * result + leadership;
        result = 31 * result + unitStrength;
        result = 31 * result + save;
        return result;
    }

    public int compareTo(Model o) {
        if (this.getInitiative() < o.getInitiative()){
            return -1;
        } else
        return 1;
    }

    public static Comparator<Model> modelLeadershipComparator = new Comparator<Model>() {
        @Override
        public int compare(Model model1, Model model2) {
            Integer model1Leadership = model1.getLeadership();
            Integer model2Leadership = model2.getLeadership();
            return model1Leadership.compareTo(model2Leadership);
        }
    };


}
