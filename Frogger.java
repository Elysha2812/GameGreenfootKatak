import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The Frogger
 * 
 * @author ( Elysha Fitriana )
 */
public class Frogger extends Actor
{
    private int speed;
    private boolean active;
    public Frogger ()
    {
        active = true;
        speed = 2;
    }

    /**
     * Act - do whatever the Frogger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CheckKeyPress();
        if (CheckWin() )
        {
            EndGame(true);
        }
        else if(CheckDeath() && active == true)
        {
            active = false;
            EndGame(false);
        }
    }   

    public void addedToWorld (World w)
    {
        active = true;
    }

    /**
     * Method checkKeys
     * Controls the frogger by hitting the corrisponding keys
     */
    private void CheckKeyPress()
    {
        if (active == true)
        {
            if (Greenfoot.isKeyDown("up"))
            {
                setLocation (getX(), getY() - speed);
            }
            if (Greenfoot.isKeyDown("down"))
            {
                setLocation (getX(), getY() + speed);
            }
            if (Greenfoot.isKeyDown("left"))
            {
                setLocation (getX() - speed, getY());
            }
            if (Greenfoot.isKeyDown("right"))
            {
                setLocation (getX()  + speed, getY());
            }
        }
    }

    /**
     * Method checkDeath
     *
     * checks to see if the frogger has been hit by the enemy
     */
    private boolean CheckDeath()
    {
        Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
        if (e != null)
        {
            return true;
        }
        return false;
    }

    /**
     * Method checkWin
     *
     * Checks to see if the player has won
     */
    private boolean CheckWin()
    {
        if (getY() <= 32)
        {
            active = false;
            return true;  
        }
        else
            return false;
    }

    /**
     * endGame method will expect true (for success) or false (for failure!)
     */
    private void EndGame(boolean win)
    {
        Roadway d = (Roadway)getWorld();
        d.EndLevel (win);
    }

    public void SetSpeed(int speed)
    {
        this.speed = speed;
    }
}
