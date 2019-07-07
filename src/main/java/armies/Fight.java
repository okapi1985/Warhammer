package armies;

import warhammerApp.Formation;

import java.util.*;

public class Fight {

    List<Model> rank;
    List<List<Model>> regiment;

    Formation model1Formation = new Formation(5);
    Formation model2Formation = new Formation(6);

    List<Model> attackHitters;
    List<Model> defendHitters;
    List<Model> attackWounders;
    List<Model> defendWounders;
    List<Model> defendWounded;
    List<Model> attackWounded;
    List<Model> initTest;
    List<Model> leaderTest;
//Rozstrzygamy kto ma większą inicjatywę i pierwszy atakuje
    public List<Model> whoAttackFirst(Model model1, Model model2) {
        initTest = new ArrayList<>();
        initTest.add(model1);
        initTest.add(model2);
        Collections.sort(initTest, Collections.reverseOrder());
        return initTest;
    }
//Rozstrzyga czy atakujący trafia przeciwnika
    public List<Model> attackerHit(List<Model> initTest) {
        Model model1 = initTest.get(0);
        Model model2 = initTest.get(1);
        attackHitters = new ArrayList<>();
        int test = model1.getWeaponSkill() - model2.getWeaponSkill();
        int attack = model1.getAttack();
        int attackers = model1Formation.getAttackers();

        for (int i = 0; i < attackers; i++) {
            for (int j = 0; j < attack; j++) {
                if ((test >= 1 && Dice.rollDice() >= 3) ||
                        ((test < 1 && (model2.getWeaponSkill() / model1.getWeaponSkill()) < 2) && Dice.rollDice() >= 4) ||
                        (model2.getWeaponSkill() / model1.getWeaponSkill()) >= 2 && Dice.rollDice() >= 5) {
                    System.out.println(model1.getName() + " trafił " + model2.getName());
                    attackHitters.add(model1);
                } else
                    System.out.println(model1.getName() + " nie trafił " + model2.getName());
            }
        }
        return attackHitters;
    }
//Rozstrzyga czy trafienia są śmiertelne
    public List<Model> attackerWound(List<Model> initTest) {
        Model model1 = initTest.get(0);
        Model model2 = initTest.get(1);
        attackWounders = new ArrayList<>();
        int test = model1.getStrength() - model2.getToughness();
        int attacks = attackHitters.size();

        while (attacks > 0) {
            if ((test >= 2 && Dice.rollDice() >= 2) ||
                    (test == 1 && Dice.rollDice() >= 3) ||
                    (test == 0 && Dice.rollDice() >= 4) ||
                    (test == -1 && Dice.rollDice() >= 5) ||
                    (test == -2 && Dice.rollDice() >= 6) ||
                    ((test == -3 && Dice.rollDice() == 6) && Dice.rollDice() >= 4) ||
                    ((test == -4 && Dice.rollDice() == 6) && Dice.rollDice() >= 5)) {
                System.out.println(model1.getName() + " ranił " + model2.getName());
                attackWounders.add(model1);
            } else
                System.out.println(model1.getName() + " nie zranił " + model2.getName());
            attacks--;
        }
        return attackWounders;
    }
//obrońca ma szansę obronić się tarczą lub zbroją
    public List<Model> ifDefenderSurvive(List<Model> initTest) {
        Model model1 = initTest.get(0);
        Model model2 = initTest.get(1);
        defendWounded = new ArrayList<>();
        int modifier = model1.getStrength() - 3;
        int save = model2.getSave();
        int saveTest = attackWounders.size();

        if (modifier < 0) {
            modifier = 0;
        }

        while (saveTest > 0) {
            if (model2.getSave() > 6) {
                defendWounded.add(model2);
                if (model2.getWounds() == 1) {
                    System.out.println(model2.getName() + " poległ");
                } else {
                    model2.setWounds(model2.getWounds() - 1);
                    System.out.println(model2.getName() + " otrzymał ranę");
                }
            } else if (save + modifier <= Dice.rollDice()) {
                System.out.println(model2.getName() + " obronił się");
            } else {
                defendWounded.add(model2);
                if (model2.getWounds() == 1) {
                    System.out.println(model2.getName() + " poległ");
                } else {
                    model2.setWounds(model2.getWounds() - 1);
                    System.out.println(model2.getName() + " otrzymał ranę");
                }
            }
            saveTest--;
        }
        return defendWounded;
    }
//teraz atakują obrońcy.
    public List<Model> defenderHit(List<Model> initTest) {
        Model model1 = initTest.get(0);
        Model model2 = initTest.get(1);
        defendHitters = new ArrayList<>();
        int test = model2.getWeaponSkill() - model1.getWeaponSkill();
        int attack = model2.getAttack();
        int attackers = model2Formation.getAttackers() - defendWounded.size();

        for (int i = 0; i < attackers; i++) {
            for (int j = 0; j < attack; j++) {
                if ((test >= 1 && Dice.rollDice() >= 3) ||
                        ((test < 1 && (model1.getWeaponSkill() / model2.getWeaponSkill()) < 2) && Dice.rollDice() >= 4) ||
                        (model1.getWeaponSkill() / model2.getWeaponSkill()) >= 2 && Dice.rollDice() >= 5) {
                    System.out.println(model2.getName() + " trafił " + model1.getName());
                    defendHitters.add(model2);
                } else
                    System.out.println(model2.getName() + " nie trafił " + model1.getName());
            }
        }
        return defendHitters;
    }
//czy zranili
    public List<Model> defenderWound(List<Model> initTest) {
        Model model1 = initTest.get(0);
        Model model2 = initTest.get(1);
        defendWounders = new ArrayList<>();
        int test = model2.getStrength() - model1.getToughness();
        int attacks = defendHitters.size();

        while (attacks > 0) {
            if ((test >= 2 && Dice.rollDice() >= 2) ||
                    (test == 1 && Dice.rollDice() >= 3) ||
                    (test == 0 && Dice.rollDice() >= 4) ||
                    (test == -1 && Dice.rollDice() >= 5) ||
                    (test == -2 && Dice.rollDice() >= 6) ||
                    ((test == -3 && Dice.rollDice() == 6) && Dice.rollDice() >= 4) ||
                    ((test == -4 && Dice.rollDice() == 6) && Dice.rollDice() >= 5)) {
                System.out.println(model2.getName() + " ranił " + model1.getName());
                defendWounders.add(model2);
            } else
                System.out.println(model2.getName() + " nie zranił " + model1.getName());
            attacks--;
        }
        return defendWounders;
    }
//czy atakujący się obronił
    public List<Model> ifAttackerSurvive(List<Model> initTest) {
        Model model1 = initTest.get(0);
        Model model2 = initTest.get(1);
        attackWounded = new ArrayList<>();
        int modifier = model2.getStrength() - 3;
        int save = model1.getSave();
        int saveTest = defendWounders.size();

        if (modifier < 0) {
            modifier = 0;
        }

        while (saveTest > 0) {
            if (model1.getSave() > 6) {
                attackWounded.add(model1);
                if (model1.getWounds() == 1) {
                    System.out.println(model1.getName() + " poległ");
                } else {
                    model1.setWounds(model1.getWounds() - 1);
                    System.out.println(model1.getName() + " otrzymał ranę");
                }
            } else if (save + modifier <= Dice.rollDice()) {
                System.out.println(model1.getName() + " obronił się");
            } else {
                attackWounded.add(model1);
                if (model1.getWounds() == 1) {
                    System.out.println(model1.getName() + " poległ");
                } else {
                    model1.setWounds(model1.getWounds() - 1);
                    System.out.println(model1.getName() + " otrzymał ranę");
                }
            }
            saveTest--;
        }
        System.out.println();
        for (Model dw : defendWounded) {
            System.out.println("Polegli obrońcy - " + dw);
        }
        System.out.println();
        for (Model aw : attackWounded) {
            System.out.println("Polegli atakujący - " + aw);
        }
        return attackWounded;
    }
//ustala wynik walki gdzie brane pod uwage są przewaga liczebna i ilość zadanych ran
    public int combatResult(List<Model> defendWounded, List<Model> attackWounded,
                            List<Model> rank1, List<Model> rank2,
                            List<List<Model>> regiment1, List<List<Model>> regiment2) {
        int model1Pts = defendWounded.size();
        int model2Pts = attackWounded.size();
        int unit1Us = rank1.size() * regiment1.size();
        int unit2Us = rank2.size() * regiment2.size();
        int ldModify;

        if (unit1Us > unit2Us) {
            model1Pts += 1;
        } else if (unit1Us < unit2Us) {
            model2Pts += 1;
        }

        if (regiment1.size() > 1 && rank1.size() >= 5) {
            for (int i = 0; i < 3; i++) {
                model1Pts += 1;
            }
        }
        if (regiment2.size() > 1 && rank2.size() >= 5) {
            for (int i = 0; i < 3; i++) {
                model2Pts += 1;
            }
        }

        ldModify = model1Pts - model2Pts;

        System.out.println(model1Pts);
        System.out.println(model2Pts);
        System.out.println(ldModify);

        return ldModify;
    }
//Ta metoda ma usuwać poległe modele z ostatniego szeregu
    public void modelRemove(List<Model> defendWounded, List<Model> attackWounded,
                            List<Model> rank1, List<Model> rank2,
                            List<List<Model>> regiment1, List<List<Model>> regiment2) {
        int toRemove1 = defendWounded.size();
        int toRemove2 = attackWounded.size();
        int rankNumber1 = regiment1.size() - 1;
        int rankNumber2 = regiment2.size() - 1;

        //Trzeba zastosować iterator zamiast pętli

//        for (List<Model> m : regiment1) {
//            m.removeAll(defendWounded);
//        }
//        for (List<Model> szereg : regiment1) {
//            // szereg.delete( element z wounded ) if true then delete from wounded
//            //else keep it in wounded
//
//        }
//        while (toRemove1 > 0) {
//            if (!regiment2.get(rankNumber2).isEmpty()) {
//                Iterator<Model> iterator = regiment2.get(rankNumber2).iterator();
//                while (iterator.hasNext()) {
//                    Model n = iterator.next();
//                    iterator.remove();
//                    toRemove1--;
//                }
//            }
//            rankNumber2--;
//        }
//
//        for (List<Model> m : regiment2) {
//            System.out.println(m);
//        }
//        System.out.println();


//        Iterator<Model> iterator = regiment1.get(0).iterator();
//        while (iterator.hasNext()) {
//            Model model = iterator.next();
//            if (toRemove2 > 0) {
//                iterator.remove();
//            } else {
//                break;
//            }
//            toRemove2--;
//        }



//        for (List<Model> m : regiment2) {
//            regiment2.get(regiment2.size() - 1).remove(0);
//            System.out.println(m);
//        }
}
}


