package warhammerApp;

import armies.Fight;
import armies.Model;

import java.util.ArrayList;
import java.util.List;

public class Formation {

    private List<List<Model>> regiment;
    private List<Model> rank;
    private int attackers;

    public Formation(int attackers) {
        this.attackers = attackers;
    }

    public Formation() {
    }

    public List<List<Model>> getRegiment() {
        return regiment;
    }

    public void setRegiment(List<List<Model>> regiment) {
        this.regiment = regiment;
    }

    public List<Model> getRank() {
        return rank;
    }

    public void setRank(List<Model> rank) {
        this.rank = rank;
    }

    public int getAttackers() {
        return attackers;
    }

    public void setAttackers(int attackers) {
        this.attackers = attackers;
    }

    public List<Model> createRank(Model model, int rankSize){
        rank = new ArrayList<>();
//        int j = 1;
        for (int i = 0;i < rankSize; rankSize--){
            rank.add(model);
        }
//        for (Model m: rank){
//            System.out.println(j+" - "+m.getName());
//            j++;
//        }
        return rank;
    }

    public List<List<Model>> createRegiment(List<Model> rank, int rankAmount){
        regiment = new ArrayList<>();
        int j = 1;
        for (int i = 0;i < rankAmount; rankAmount--){
            regiment.add(rank);
        }
        for (List<Model> r: regiment){
            System.out.println(j+" - "+r);
            j++;
        }
        return regiment;
    }

    public void printRegiment(List<Model> rank, List<List<Model>> regiment, char singleModel){
        for (int i = 0; i < regiment.size(); i++){
            for (int j = 0; j <rank.size(); j++){
                System.out.print(singleModel+" ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formation)) return false;

        Formation formation = (Formation) o;

        if (attackers != formation.attackers) return false;
        if (regiment != null ? !regiment.equals(formation.regiment) : formation.regiment != null) return false;
        return rank != null ? rank.equals(formation.rank) : formation.rank == null;
    }

    @Override
    public int hashCode() {
        int result = regiment != null ? regiment.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + attackers;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Formation{");
        sb.append("regiment=").append(regiment);
        sb.append(", rank=").append(rank);
        sb.append(", attackers=").append(attackers);
        sb.append('}');
        return sb.toString();
    }
}
