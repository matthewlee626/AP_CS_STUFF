
/**
 * Write a description of class GameDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class GameDriver
{
    public static void main(String args[]){
        Hidden[][] map = new Hidden[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                map[i][j] = new Blank();
                /*
                System.out.println(map[i][j]);
                System.out.println(map[i][j] instanceof Monster );*/
            }
        }
        for(int j = 0; j < 6; j++){
            int i, k;
            while(true){
                i = (int) (Math.random() * 10);
                k = (int) (Math.random() * 10);
                if(!(map[i][k] instanceof Monster )&& !(i == 9 && k == 0)){

                    map[i][k] = new Monster();
                    //System.out.println("A");
                    break;
                }
                //System.out.println("B");
            }
        }
        for(int j = 0; j < 2; j++){
            while(true){
                int i = (int) (Math.random() * 10);
                int k = (int) (Math.random() * 10);
                if(!(map[i][k] instanceof Monster) && !(map[i][k] instanceof Potion)&& !(i == 9 && k == 0)){
                    map[i][k] = new Potion();
                    //System.out.println("C");
                    break;
                }
                //System.out.println("D");
            }
        }
        while(true){
            int i = (int) (Math.random() * 10);
            int k = (int) (Math.random() * 10);
            if(!(map[i][k] instanceof Monster) && !(map[i][k] instanceof Potion)&& !(i == 9 && k == 0)){
                map[i][k] = new TownsPerson('a', "My sheep have been taken… My family is gone and I have nothing left except for bronze armor I have buried… Only a true hero will receive this.", 2);
                //System.out.println("E");
                break;
            }
           // System.out.println("F");
        }
        while(true){
            int i = (int) (Math.random() * 10);
            int k = (int) (Math.random() * 10);
            if(!(map[i][k] instanceof Monster) && !(map[i][k] instanceof Potion )&& !(map[i][k] instanceof TownsPerson )&& !(i == 9 && k == 0)){
                map[i][k] = new TownsPerson('w', "My sheep have been taken… My family is gone and I have nothing left except for a broadsword I have buried… Only a true hero will receive this.", 4);
                //System.out.println("G");
                break;
            }
            //System.out.println("H");
        }
        int x = 9;
        int y = 0;
        Hero hero = new Hero();
        map[x][y] = hero;
        hero.reveal();
        Scanner in = new Scanner(System.in);
        int monsters_killed = 0;
        //if(!(hero.isDead()))System.out.println("I");
        //if(monsters_killed != 6)System.out.println("J");
        while(!(hero.isDead()) && monsters_killed != 6){//game time
            //System.out.println(x + " " + y);
            try{
                map[x-1][y].reveal();
 
            }catch(IndexOutOfBoundsException e){}
            try{
                map[x+1][y].reveal();

            }catch(IndexOutOfBoundsException e){}
            try{
                map[x][y-1].reveal();
            }catch(IndexOutOfBoundsException e){}
            try{
                map[x][y+1].reveal();
            }catch(IndexOutOfBoundsException e){}
            System.out.println(printMap(map));
            //System.out.println(x + " " + y);
            try{
                if(map[x-1][y] instanceof Potion){
                    System.out.println("Potion added.");
                    hero.addPotion();
                    map[x-1][y] = new Blank();
                    map[x-1][y].reveal();
                    }
            }catch(IndexOutOfBoundsException e){}
            try{
                if(map[x+1][y] instanceof Potion){
                    System.out.println("Potion added.");
                    hero.addPotion();
                    map[x+1][y] = new Blank();
                    map[x+1][y].reveal();
               }
            }catch(IndexOutOfBoundsException e){}
            try{
                if(map[x][y-1] instanceof Potion){
                    System.out.println("Potion added.");
                    hero.addPotion();
                    map[x][y-1] = new Blank();
                    map[x][y-1].reveal();
                }
            }catch(IndexOutOfBoundsException e){} 
              try{
               if(map[x][y+1] instanceof Potion){
                    System.out.println("Potion added.");
                    hero.addPotion();
                    map[x][y+1] = new Blank();
                    map[x][y+1].reveal();
                }
            }catch(IndexOutOfBoundsException e){}
            try{
                if(map[x-1][y] instanceof TownsPerson){
                    if(map[x-1][y].active()){
                        System.out.println(map[x-1][y].speak());
                        if(map[x-1][y].reqs() <= monsters_killed){
                            System.out.println("My possesion is yours.");
                            if(map[x-1][y].getType() == 'a'){
                                hero.getArmor();
                            }else if(map[x-1][y].getType() == 'w'){
                                hero.changeWeapon(new Broadsword());
                            }
                            map[x-1][y].deact();
                        }
                    }
                }
            }catch(IndexOutOfBoundsException e){}
            try{
                if(map[x+1][y] instanceof TownsPerson){
                    if(map[x+1][y].active()){
                        System.out.println(map[x+1][y].speak());
                        if(map[x+1][y].reqs() <= monsters_killed){
                            System.out.println("My possesion is yours.");
                            if(map[x+1][y].getType() == 'a'){
                                hero.getArmor();
                            }else if(map[x+1][y].getType() == 'w'){
                                hero.changeWeapon(new Broadsword());
                            }
                            map[x+1][y].deact();
                        }
                    }    
                }
            }catch(IndexOutOfBoundsException e){}try{
            if(map[x][y-1] instanceof TownsPerson){
                if(map[x][y-1].active()){
                    System.out.println(map[x][y-1].speak());
                    if(map[x][y-1].reqs() <= monsters_killed){
                        System.out.println("My possesion is yours.");
                        if(map[x][y-1].getType() == 'a'){
                            hero.getArmor();
                        }else if(map[x][y-1].getType() == 'w'){
                            hero.changeWeapon(new Broadsword());
                        }
                        map[x][y-1].deact();
                    }
                }
            }
            }catch(IndexOutOfBoundsException e){}try{
            if(map[x][y+1] instanceof TownsPerson){
                if(map[x][y+1].active()){
                    System.out.println(map[x][y+1].speak());
                    if(map[x][y+1].reqs() <= monsters_killed){
                        System.out.println("My possesion is yours.");
                        if(map[x][y+1].getType() == 'a'){
                            hero.getArmor();
                        }else if(map[x][y+1].getType() == 'w'){
                            hero.changeWeapon(new Broadsword());
                        }
                        map[x][y+1].deact();
                    }
                }
            }}catch(IndexOutOfBoundsException e){}try{
            if(map[x-1][y] instanceof Monster){
                System.out.println("Hero encounters a monster! The monster engages!");
                int speed = map[x-1][y].getSpeed() + 1;
                boolean hasNotRun = true;
                while(!(hero.isDead()) && !(map[x-1][y].isDead()) && hasNotRun == true){
                    System.out.println("Enter an action (run, attack): ");
                    String input = in.nextLine();
                    switch(input){
                        case "run":
                        case "Run":
                            if(Math.random() * 4 > speed){
                                System.out.println("The hero escapes.");
                                hasNotRun = false;
                                break;
                            }else{
                                System.out.println("Hero tries to run! The monster is too fast!");
                                hero.takeDamage(map[x-1][y].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                                break;
                            }               
                        case "attack":
                        case "Attack":
                            int z = hero.getWeapon().doDamage();
                            map[x-1][y].takeDamage(z);
                            System.out.println("The hero attacks with " + z + " damage! Monster's health goes down to " + map[x-1][y].getHealth());
                            if(!(map[x-1][y].isDead())){
                                hero.takeDamage(map[x-1][y].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                            }
                            break;
                    }
               }
               if(map[x-1][y].isDead()){
                   System.out.println("The monster has been slain.");
                   map[x-1][y] = new Blank();
                   monsters_killed++;
               }
            }}catch(IndexOutOfBoundsException e){}try{
            if(map[x+1][y] instanceof Monster){
                System.out.println("Hero encounters a monster! The monster engages!");
                int speed = map[x+1][y].getSpeed() + 1;
                boolean hasNotRun = true;
                while(!(hero.isDead()) && !(map[x+1][y].isDead()) && hasNotRun == true){
                    System.out.println("Enter an action (run, attack): ");
                    String input = in.nextLine();
                    switch(input){
                        case "run":
                        case "Run":
                            if(Math.random() * 4 > speed){
                                System.out.println("The hero escapes.");
                                hasNotRun = false;
                                break;
                            }else{
                                System.out.println("Hero tries to run! The monster is too fast!");
                                hero.takeDamage(map[x+1][y].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                                break;
                            }               
                        case "attack":
                        case "Attack":
                            int z = hero.getWeapon().doDamage();
                            map[x+1][y].takeDamage(z);
                            System.out.println("The hero attacks with " + z + " damage! Monster's health goes down to " + map[x+1][y].getHealth());
                            if(!(map[x+1][y].isDead())){
                                hero.takeDamage(map[x+1][y].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                            }
                            break;
                    }
               }
               if(map[x+1][y].isDead()){
                   System.out.println("The monster has been slain.");
                   map[x+1][y] = new Blank();
                   monsters_killed++;
               }
            }}catch(IndexOutOfBoundsException e){}try{
            if(map[x][y-1] instanceof Monster){
                System.out.println("Hero encounters a monster! The monster engages!");
                int speed = map[x][y-1].getSpeed() + 1;
                boolean hasNotRun = true;
                while(!(hero.isDead()) && !(map[x][y-1].isDead()) && hasNotRun == true){
                    System.out.println("Enter an action (run, attack): ");
                    String input = in.nextLine();
                    switch(input){
                        case "run":
                        case "Run":
                            if(Math.random() * 4 > speed){
                                System.out.println("The hero escapes.");
                                hasNotRun = false;
                                break;
                            }else{
                                System.out.println("Hero tries to run! The monster is too fast!");
                                hero.takeDamage(map[x][y-1].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                                break;
                            }               
                        case "attack":
                        case "Attack":
                            int z = hero.getWeapon().doDamage();
                            map[x][y-1].takeDamage(z);
                            System.out.println("The hero attacks with " + z + " damage! Monster's health goes down to " + map[x][y-1].getHealth());
                            if(!(map[x][y-1].isDead())){
                                hero.takeDamage(map[x][y-1].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                            }
                            break;
                    }
               }
               if(map[x][y-1].isDead()){
                   System.out.println("The monster has been slain.");
                   map[x][y-1] = new Blank();
                   monsters_killed++;
               }
            }}catch(IndexOutOfBoundsException e){}try{
            if(map[x][y+1] instanceof Monster){
                System.out.println("Hero encounters a monster! The monster engages!");
                int speed = map[x][y+1].getSpeed() + 1;
                boolean hasNotRun = true;
                while(!(hero.isDead()) && !(map[x][y+1].isDead()) && hasNotRun == true){
                    //System.out.println(map[x][y+1].getHealth());
                    System.out.println("Enter an action (run, attack): ");
                    String input = in.nextLine();
                    switch(input){
                        case "run":
                        case "Run":
                            if(Math.random() * 4 > speed){
                                System.out.println("The hero escapes.");
                                hasNotRun = false;
                                break;
                            }else{
                                System.out.println("Hero tries to run! The monster is too fast!");
                                hero.takeDamage(map[x][y+1].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                                break;
                            }               
                        case "attack":
                        case "Attack":
                            int z = hero.getWeapon().doDamage();
                            map[x][y+1].takeDamage(z);
                            System.out.println("The hero attacks with " + z + " damage! Monster's health goes down to " + map[x][y+1].getHealth());
                            if(!(map[x][y+1].isDead())){
                                hero.takeDamage(map[x][y+1].attack());
                                System.out.println("The monster attacks! Hero's health goes down to " + hero.getHealth());
                            }
                            break;
                    }
                    //System.out.println(!(map[x][y+1].isDead()));
                    //System.out.println(hasNotRun == true);
               }
               if(map[x][y+1].isDead()){
                   System.out.println("The monster has been slain.");
                   map[x][y+1] = new Blank();
                   monsters_killed++;
               }
            }}catch(IndexOutOfBoundsException e){}
            if(!(hero.isDead())){
                System.out.println("Enter direction: w(north), s(south), d(east), and a(west), or p(potion): ");
                String input;
                boolean repeat;
                do {
                    input = in.nextLine();
                    repeat  = false;
                    switch(input){
                        case "w":
                        case "W":
                            try{
                                if(map[x-1][y] instanceof Blank){
                                    map[x][y] = new Blank();
                                    map[x-1][y] = hero;
                                    hero.reveal();
                                    x-=1;
                                    break;
                                }else{
                                    System.out.println("You are obstructed.");
                                    break;
                                }
                            }catch(IndexOutOfBoundsException e){
                                System.out.println("Stay within the map!");
                                break;
                            }
                        case "s":
                        case "S":
                            try{
                                if(map[x+1][y] instanceof Blank){
                                    map[x][y] = new Blank();
                                    map[x+1][y] = hero;
                                    hero.reveal();
                                    x+=1;
                                    break;
                                }else{
                                    System.out.println("You are obstructed.");
                                    break;
                                }
                            }catch(IndexOutOfBoundsException e){
                                System.out.println("Stay within the map!");
                                break;
                            }
                        case "a":
                        case "A":
                            try{
                                if(map[x][y-1] instanceof Blank){
                                    map[x][y] = new Blank();
                                    map[x][y-1] = hero;
                                    hero.reveal(); 
                                    y-=1;
                                    break;
                                }else{
                                    System.out.println("You are obstructed.");
                                    break;
                                }
                            }catch(IndexOutOfBoundsException e){
                                System.out.println("Stay within the map!");
                                break;
                            }
                        case "d":
                        case "D":
                            try{
                                if(map[x][y+1] instanceof Blank){
                                    map[x][y] = new Blank();
                                    map[x][y+1] = hero;
                                    hero.reveal();
                                    y+=1;
                                    break;
                                }else{
                                    System.out.println("You are obstructed.");
                                    break;
                                }
                            }catch(IndexOutOfBoundsException e){
                                System.out.println("Stay within the map!");
                                break;
                            }
                        case "p":
                        case "P":
                            if(hero.getPotions().size() > 0){
                                hero.usePotion();
                                System.out.println("Hero's health is now " + hero.getHealth());
                                break;
                            }else{
                                System.out.println("No potions left");
                            }
                            repeat = true;
                            break;
                        default:
                            System.out.println("Error! Enter W, A, S, or D.");
                            repeat = true;
                            break;
                    }
                }while(repeat);
            }
        }
        if(monsters_killed == 6)System.out.println("You won!");
        else System.out.println("The hero has fallen.");
        }
    public static String printMap(Hidden [][] map){
        String mapString = "";
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                Hidden x = map[i][j];
                //if(x.isHidden())mapString += "X "; 
                if(x instanceof Monster) mapString += "M ";
                else if(x instanceof Potion) mapString += "P ";
                else if(x instanceof TownsPerson) mapString += "T ";
                else if(x instanceof Hero) mapString += "H ";
                else mapString += ". ";
            }
            mapString += "\n";
        }
        return mapString;
    }
}