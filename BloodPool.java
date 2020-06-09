import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class BloodPool here.
 * 
 * @author ( Elysha Fitriana )
 * @version (a version number or a date)
 */
public class BloodPool extends Actor
{
    private GreenfootImage blood;
    private int counter = 0;
    private int size = 10;
    private int currentPos = 50;
    /**
     * BloodPool Constructor
     * Sets the color for the blood when the frogger is hit
     */
    public BloodPool()
    {
        blood = new GreenfootImage(100, 100);
        this.setImage (blood);
        Color bloodRed = new Color (127,0,0);
        blood.setColor (bloodRed);
    }
    
    public void AddedToWorld(World w)
    {
        act();
    }

    /**
     * Act - do whatever the BloodPool wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        while (size <= 80)
        {
            size += 2;
            currentPos -= 1;
            blood.fillOval(currentPos, currentPos, size, size);
            Greenfoot.delay (2);
        }
        getWorld().removeObject(this);
    }    
}
