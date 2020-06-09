/**
 * Write a description of class Level here.
 * 
 * @author ( Elysha Fitriana ) 
 * @version (a version number or a date)
 */
public class Level  
{
    private int spawnRate;
    private int vehicleSpeed;
    private int chanceOfDouble;
    private int chanceOfTriple;
    private int froggerSpeed;
    /**
     * Constructor for objects of class Level
     */
    public Level(int levelNum)
    {
        loadLevel (levelNum);
    }

    // Load the data for the current level
    // - crude code, but wanted to avoid using the file system so that
    //   the final product could easily be shared via Greenfoot Gallery
    private void loadLevel (int levelNum)
    {
        if (levelNum == 1)
        {
            spawnRate = 100;
            vehicleSpeed = 3;
            chanceOfDouble = 0;
            chanceOfTriple = 0;
            froggerSpeed = 2;
        }
        else if (levelNum == 2)
        {
            spawnRate = 96;
            vehicleSpeed = 3;
            chanceOfDouble = 10;
            chanceOfTriple = 5;
            froggerSpeed = 2;
        }
        else if (levelNum == 3)
        {
            spawnRate = 90;
            vehicleSpeed = 4;
            chanceOfDouble = 15;
            chanceOfTriple = 10;
            froggerSpeed = 3;
        }
        else if (levelNum == 4)
        {
            spawnRate = 84;
            vehicleSpeed = 4; 
            chanceOfDouble = 25;
            chanceOfTriple = 10;
            froggerSpeed = 3;
        }
        else if (levelNum == 5)
        {
            spawnRate = 78;
            vehicleSpeed = 4; 
            chanceOfDouble = 30;
            chanceOfTriple = 15;
            froggerSpeed = 3;
        }
        else if (levelNum == 6)
        {
            spawnRate = 72;
            vehicleSpeed = 4; 
            chanceOfDouble = 30;
            chanceOfTriple = 15;
            froggerSpeed = 3;
        }            
        else if (levelNum == 7)
        {
            spawnRate = 70;
            vehicleSpeed = 5; 
            chanceOfDouble = 35;
            chanceOfTriple = 25;
            froggerSpeed = 4;
        }
        else if (levelNum == 8)
        {
            spawnRate = 64;
            vehicleSpeed = 5; 
            chanceOfDouble = 50;
            chanceOfTriple = 25;
            froggerSpeed = 4;
        }
        else if (levelNum == 9)
        {
            spawnRate = 50;
            vehicleSpeed = 6; 
            chanceOfDouble = 60;
            chanceOfTriple = 30;
            froggerSpeed = 5;
        }
        else if (levelNum >= 9)
        {
            spawnRate = 48;
            vehicleSpeed = 7; 
            chanceOfDouble = 60;
            chanceOfTriple = 30;
            froggerSpeed = 6;
        }
        

    }
    public int getSpawnRate ()
    {
        return spawnRate;
    }

    public int getVehicleSpeed ()
    {
        return vehicleSpeed;
    }

    public int getChanceOfDouble ()
    {
        return chanceOfDouble;
    }

    public int getChanceOfTriple ()
    {
        return chanceOfTriple;
    }
    
    public int getFroggerSpeed ()
    {
        return froggerSpeed;
    }

}
