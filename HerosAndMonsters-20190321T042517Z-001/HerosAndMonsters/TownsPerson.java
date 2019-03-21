
/**
 * Write a description of class TownsPerson here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TownsPerson extends Hidden
{
    private char type;
    private String line;
    private int amtKilled;
    private boolean active;
    public TownsPerson(char type, String line, int amtKilled){
        this.line = line;
        this.amtKilled = amtKilled;
        this.type = type;
        active = true;
    }
    public char getType(){
        return type;
    }   
    public String speak(){
        return line;
    } 
    public int reqs(){
        return amtKilled;
    }
    public boolean active(){
        return active;
    }
    public void deact(){
        active = false;
    }
}
