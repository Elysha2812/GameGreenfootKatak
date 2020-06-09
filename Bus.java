import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author ( Elysha Fitriana ) 
 * @version (a version number or a date)
 */
public class Bus extends Enemy
{
    private int speed;
    private Roadway d;
    /**
     * EastboundAuto Constructor
     *
     * Sets the speed of the Bus
     */
    public Bus(int speed)
    {
        this.speed = speed;
    }

    /**
     * Method addedToWorld
     *
     * Adds the bus to the world
     */
    public void addedToWorld(World w)
    {
        d = (Roadway)getWorld();
    }

    /**
     * Method act
     * The act method checks for cars in front and adjusts speed when necessary. It also removes
     * the bus when it reaches the edge of the screen (World)
     */
    public void act() 
    {
        if (d.ActionPaused() == false)
        {
            if (!(atWorldEdge()))
            {
                Enemy carDirectlyInFrontOfMe = (Enemy)getOneObjectAtOffset (getImage().getWidth()/2 + speed, 0, Enemy.class);
                if (carDirectlyInFrontOfMe == null)
                    setLocation (getX() + speed, getY());
                else
                    speed = carDirectlyInFrontOfMe.GetSpeed();
            }
            else 
            {
                d.ReduceAutoCount(1);
                d.removeObject(this);
            }
        }
    }    

    /**
     * Method atWorldEdge
     *
     * Removes the bus once it reaches the end of the screen
     */
    public boolean atWorldEdge()
    {
        if(getX() > getWorld().getWidth() - (getImage().getWidth() / 2) + 20)
            return true;
        else
            return false;
    }
    
    /**
     * Method getSpeed
     *
     * Allows other cars to see how fast the player is moving. Returns speed in pixels-per-act
     */
    public int getSpeed()
    {
        return speed;
    }
}
