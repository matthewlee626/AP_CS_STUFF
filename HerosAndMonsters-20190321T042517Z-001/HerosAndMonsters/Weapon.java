
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon
{
    private int damage_min, damage_max;
    
    public Weapon(int damage_min, int damage_max){
        this.damage_min = damage_min;
        this.damage_max = damage_max;
    }
    
    public int doDamage(){
        return (int) (Math.random()*(damage_max - damage_min + 1) + damage_min);
    }
}
 