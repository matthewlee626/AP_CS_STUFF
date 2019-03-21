public class Monster extends Squishy
{
    private int attack, speed;
    public Monster(){
        super((int) (Math.random() * 100 + 1));
        attack = (int) (Math.random() * 30 + 1);
        speed = (int) (Math.random() * 4);
    }
    public String stats(){
        return "Health: " + health + "\nDamage: " + attack + "\nSpeed: " + speed;
    }   
    public int attack(){
        return attack;
    } 
    public int getSpeed(){
        return speed;
    }
}
