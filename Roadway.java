import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Controller Class. Owns and coordinates
 * 
 * @author ( Elysha Fitriana )
 * @version (a version number or a date)
 */
public class Roadway extends World
{
    private int counter = 0;
    private int spawnRate;
    private int spawnY;
    private int vehicleSpeed;
    private int lives = 3;
    private int level;
    private int autoCount;
    private boolean levelLoaded = false;
    private boolean spawning;
    private boolean actionPaused = false;
    private boolean showScore = false;
    private boolean deathSequenceActive = false;
    private int chanceOfDouble;
    private int chanceOfTriple;
    private GreenfootImage frogImage = new GreenfootImage ("frog.png");    
    private GreenfootImage splat = new GreenfootImage ("splat.png");
    private GreenfootSound smush;
    private GreenfootSound levelUpSound;
    private GreenfootSound gameOverSound;
    private LifeCounter lifeCounter = new LifeCounter ();
    private LevelCounter levelCounter = new LevelCounter ();
    private Frogger myFrog = new Frogger();
    private Level currentLevel;
    
    
    
    /**
     * Roadway Constructor
     * Adds the lifecounter and the sounds that occur when you level up, get smushed, or lose the game
     */
    public Roadway()
    {    
        super(600, 400, 1); 
        setPaintOrder(Frogger.class, BloodPool.class, Scoreboard.class, Enemy.class);
        addObject (lifeCounter, 67, 25);
        addObject (levelCounter, 530, 24);
        smush = new GreenfootSound("splat.wav");
        levelUpSound = new GreenfootSound("mariocoin.mp3");
        gameOverSound = new GreenfootSound("game-over.wav");
        smush.play();
        smush.stop();
        levelUpSound.play();
        levelUpSound.stop();
        gameOverSound.play();
        gameOverSound.stop();
        level = 1;
        autoCount = 0;
    }
   
    /**
     * Method act
     * Loads the scoreboard and the Game Over sign that comes up when you lose the game
     */
    public void act ()
    {
        if (levelLoaded == false)
        {
            if (lives > 0)
            {
                LevelLoader();
                levelLoaded = true;
            }
            else
            {
                Scoreboard s = new Scoreboard (level, "Game Over", "On Level ");
                addObject (s, 300,200);
                gameOverSound.play();
                Greenfoot.stop();
            }
        } 
        
        if (actionPaused == false && spawning == true)
        {
            SpawnCars();
        }
        
        if (deathSequenceActive)
        {
            if (autoCount == 0)
            {
                deathSequenceActive = false;
                levelLoaded = false;
            }
        }
    }
    
    /**
     * Method LevelLoader
     * Loads the level and sets the speed of the enemy based on the level
     */
    private void LevelLoader()
    {
        addObject(myFrog, 300, 370);
        currentLevel = new Level (level);
        levelCounter.SetLevel(level);
        myFrog.setImage(frogImage);
        actionPaused = false;
        spawning = true;
        spawnRate = currentLevel.getSpawnRate();
        vehicleSpeed = currentLevel.getVehicleSpeed();
        chanceOfDouble = currentLevel.getChanceOfDouble();
        chanceOfTriple = currentLevel.getChanceOfTriple();
        myFrog.SetSpeed(currentLevel.getFroggerSpeed());
        levelLoaded = true;
    }

    /**
     * Controlled spawning of new cars
     */
    private void SpawnCars()
    {
        int randVal = Greenfoot.getRandomNumber(3)+1;
        if (counter % spawnRate == 0)
        {
            if (randVal == 1)
                spawnY = 127;
            else if (randVal == 2)
                spawnY = 223;
            else
                spawnY = 320;
            addObject(new Bus(vehicleSpeed), 20, spawnY);
            autoCount++;
        }
        else if (counter % spawnRate == spawnRate / 2)
        {
            if (randVal == 1)
                spawnY = 78;
            else if (randVal == 2)
                spawnY = 173;
            else
                spawnY = 270;
            addObject(new Ambulance(vehicleSpeed), 578, spawnY);
            autoCount++;
        }
        counter++;
    }

    
    /**
     * Method endLevel
     * This method is used when the player dies or finishes a level
     * True = player completed level
     * False = player died on that level
     * 
     */
    public void EndLevel(boolean win)
    {
        Scoreboard s = null;
        actionPaused = true;
        spawning = false;
        if (win == true)
        {
            level++;
            levelUpSound.play();
            removeObject (myFrog);
            levelLoaded = false;
            Greenfoot.delay(50);
        }
        else
        {
            myFrog.setImage(splat);
            smush.play();
            BloodPool b = new BloodPool();
            addObject (b, myFrog.getX(), myFrog.getY());
            lives -= 1;
            lifeCounter.SubtractLife();
            actionPaused = false;
            deathSequenceActive = true;
            removeObject (myFrog);
        }
    }
    
    /**
     * Method isActionPaused
     * Returns wether the game is paused during live action
     * 
     */
    public boolean ActionPaused()
    {
        return actionPaused;
    }

    /**
     * Allows objects to inform this controller when they are about to 
     * remove themselves from the world.
     */
    public void ReduceAutoCount (int byHowMany)
    {
        autoCount -= byHowMany;
    }

}

