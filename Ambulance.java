import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * West-bound cars - Ambulance
 * @author ( Elysha Fitriana )
 * 
 */
public class Ambulance extends Enemy
{
    private int speed;
    private Roadway d;
    /**
     * WestboundAuto Constructor
     *
     * Sets the speed of the Ambulance
     */
    public Ambulance(int speed)
    {
        this.speed = -speed;
    }

    /**
     * Method addedToWorld
     *
     * Adds the ambulance to the world
     */
    public void addedToWorld(World w)
    {
        d = (Roadway)getWorld();
        setRotation(180);
    }

    /**
     * The act method checks for cars in front and adjusts speed when necessary. It also removes
     * the ambulance when it reaches the edge of the screen (World)
     */
    public void act() 
    {
        if (d.ActionPaused() == false)
        {
            if (!(atWorldEdge()))
            {
                Enemy carDirectlyInFrontOfMe = (Enemy)getOneObjectAtOffset (-getImage().getWidth()/2 + speed, 0, Enemy.class);
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
     * Removes the ambulance once it reaches the end of the screen
     */
    public boolean atWorldEdge()
    {
        if(getX() < (getImage().getWidth() / 2) - 20)
            return true;
        else
            return false;
    } 

    /**
     * Allows other cars to see how fast the player is moving. Returns speed in pixels-per-act
     */
    public int getSpeed()
    {
        return speed;
    }
}
