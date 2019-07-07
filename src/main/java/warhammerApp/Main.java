package warhammerApp;

import armies.Fight;
import armies.Model;
import armies.dwarf.Clansman;
import armies.lizardmen.SaurusWarrior;
import armies.skaven.ClanratSkaven;
import armies.vampireCounts.Zombie;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Model model = new Model();
        Fight fight = new Fight();
        Formation formation = new Formation();

        ClanratSkaven clanrat = new ClanratSkaven("Skaven Clanrat", 5, 3, 3, 3, 3,
                1, 4, 1, 5, 1, 5);
        Clansman clansman = new Clansman("Dwarf Clansman", 3, 4, 3, 3, 4,
                1, 2, 1, 9, 1, 5);
        Zombie zombie = new Zombie("Zombie", 4, 2, 0, 3, 3,
                1, 0, 1, 2, 1, 7);
        SaurusWarrior saurus = new SaurusWarrior("Saurus Warrior", 4, 3, 0, 4, 4,
                1, 1, 2, 8, 1, 5);


        //Tworzymy regiment clanratów do walki
        List<Model> clanratRank = formation.createRank(clanrat, 6);
        List<List<Model>> clanratRegiment = formation.createRegiment(formation.getRank(), 5);
        System.out.println();
        formation.printRegiment(formation.getRank(), formation.getRegiment(), '@');
        System.out.println();


//        //Tworzymy regiment zombi do walki
//        List<Model> zombieRank = formation.createRank(clanrat,6);
//        List<List<Model>> zombieRegiment = formation.createRegiment(formation.getRank(),6);
//        System.out.println();
//        formation.printRegiment(formation.getRank(),formation.getRegiment(),'O');
//        System.out.println();

        //Tworzymy regiment clansmanów do walki
        List<Model> clansmanRank = formation.createRank(clansman, 6);
        List<List<Model>> clansmanRegiment = formation.createRegiment(formation.getRank(), 4);
        System.out.println();
        formation.printRegiment(formation.getRank(), formation.getRegiment(), 'O');
        System.out.println();


        List<Model> initTest = fight.whoAttackFirst(clanrat, clansman);

        System.out.println();
        fight.attackerHit(initTest);
        System.out.println();
        fight.attackerWound(initTest);
        System.out.println();
        List<Model> defendWounded = fight.ifDefenderSurvive(initTest);
        System.out.println();
        System.out.println("Obrońcy oddają");
        System.out.println();
        fight.defenderHit(initTest);
        System.out.println();
        fight.defenderWound(initTest);
        System.out.println();
        List<Model> attackWounded = fight.ifAttackerSurvive(initTest);
        System.out.println();
        fight.combatResult(defendWounded, attackWounded, clanratRank, clansmanRank, clanratRegiment, clansmanRegiment);
        System.out.println();
        fight.modelRemove(defendWounded,attackWounded,clanratRank,clansmanRank,clanratRegiment,clansmanRegiment);
        System.out.println();

    }
}
