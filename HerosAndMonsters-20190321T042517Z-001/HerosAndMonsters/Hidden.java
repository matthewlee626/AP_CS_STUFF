
/**
 * Write a description of interface Hidden here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Hidden
{
    boolean isHidden = true;
    public boolean isHidden(){
        return isHidden;
    }
    public void reveal(){
        isHidden = false;
    }
    //compatibility stuff with the map
    public int getHealth(){
        return 0;
    }
    public int attack(){
        return 0;
    }
    public int getSpeed(){
        return 0;
    }
    public void setHealth(int health){
    }
    public void takeDamage(int damage){
    }
    public boolean isDead(){
        return true;
    }
    public String speak(){
        return "";
    } 
    public int reqs(){
        return 0;
    }
    public boolean active(){
        return true;
    }
    public void deact(){
    }
    public char getType(){
        return 'h';
    }
    //i hope theres something better than this
}
