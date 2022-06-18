package fromzero;

public class Titan extends Character{
    private int defense;
    private int attack;
    private int HP;

    Titan(int defense, int attack, int HP){
        super(defense, attack, HP);
        this.defense = defense;
        this.attack = attack;
        this.HP = HP;
    }
    public boolean attack(){
        double Hit = Math.random();
        if(Hit < 0.40) {
            return true;
        }
        return false;
    }
}

