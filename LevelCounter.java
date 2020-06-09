import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
/**
 * Write a description of class LevelCounter here.
 * 
 * @author ( Elysha Fitriana )
 * @version (a version number or a date)
 */
public class LevelCounter extends Actor
{
    private GreenfootImage levelBoard = new GreenfootImage (132, 40);
    private Color backgroundColor = new Color (108, 108, 108);
    private Color textColor = new Color (255,216,0);
    private Font textFont = new Font ("Helvetica", Font.BOLD, 28);
    /**
     * LevelCounter Constructor
     * counts the number of lives that are left
     */
    public LevelCounter()
    {
        levelBoard.setColor (backgroundColor);
        levelBoard.setFont (textFont);
        levelBoard.fill();
        this.setImage (levelBoard);
        SetLevel(0);
    }
    /**
     * Method setLevel
     *
     * Sets the amount of lives
     */
    public void SetLevel(int level)
    {
        levelBoard.setColor (backgroundColor);
        levelBoard.fill();
        levelBoard.setColor (textColor);
        String s = "LEVEL " + level;
        levelBoard.drawString(s, 1, 32);
    }
}
