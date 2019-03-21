import java.util.*;
public class Hero extends Squishy
{
    private ArrayList<Potion> potions;
    private Weapon weapon;
    private Armor armor;
    public Hero(){
        super(100);
        weapon = new Dagger();
        armor = new Armor(0);
        potions = new ArrayList<>();
    }
    public void addPotion(){
        potions.add(new Potion());
    }
    public ArrayList<Potion> getPotions(){
        return potions;
    }
    public boolean usePotion(){
        if(potions.size() <= 0){
            return false;
        }else{
            setHealth(potions.get(potions.size() - 1).HEAL);
            potions.remove(potions.size() - 1);
            return true;
        }
    }
    public void changeWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public void getArmor(){
        armor = new Armor(1/3);
    }
}
