import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class LifeCounter here.
 * 
 * @author ( Elysha Fitriana )
 * @version (a version number or a date)
 */
public class LifeCounter extends Actor
{
    private int livesLeft;
    private GreenfootImage frog = new GreenfootImage ("frog.png");
    private GreenfootImage splat = new GreenfootImage ("splat.png");
    private GreenfootImage lives = new GreenfootImage (126,40);
    /**
     * LifeCounter Constructor
     * counts the amount of lives left starting at 3
     */
    public LifeCounter()
    {
        lives.drawImage (frog, 1, 1);
        lives.drawImage (frog, 43, 1);
        lives.drawImage (frog, 85, 1);
        this.setImage (lives);
        livesLeft = 3;
    }

    /**
     * Method subtractLife
     * subtracts a life when the frogger is hit by a ambulance or bus and splats
     */
    public void SubtractLife()
    {
        livesLeft--;
        lives.drawImage (splat, 1 + (livesLeft) * 42, 1);
    }
}
