import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class Directions here.
 * 
 * @author ( Elysha Fitriana ) 
 * @version (a version number or a date)
 */
public class Directions1 extends Actor
{
    GreenfootImage MENU;
    
    public Directions1()
    {
         /**The main-menu background*/
    
            MENU = new GreenfootImage( 320,240 );
            MENU.setColor(Color.BLACK);
            MENU.fill();
            MENU.setColor(Color.DARK_GRAY);
            MENU.setColor(Color.LIGHT_GRAY);
            MENU.setFont(new Font(null, Font.BOLD, 20));
            MENU.drawString("Frogger", 100, 90);
            MENU.drawString("Use arrow keys to control frog", 20, 150);
            MENU.drawString("Press Space to Start", 50,200);
            setImage( MENU );
        }

    

    /**
     * Act - do whatever the Directions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
