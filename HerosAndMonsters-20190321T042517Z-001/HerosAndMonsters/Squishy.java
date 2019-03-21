public class Squishy extends Hidden
{
    protected int health;
    public Squishy(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void takeDamage(int damage){
        if(getHealth() - damage > 0){
            setHealth(getHealth() - damage);
        }else{
            setHealth(0);
        }
    }
    public boolean isDead(){
        if(getHealth() <= 0){
            return true;
        }else{
            return false;
        }
    }
    
}
