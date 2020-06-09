import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
/**
 * The ScoreBoard is used to display the score on the screen.
 *
 * @author ( Elysha Fitriana )
 * 
 * 
 */
public class Scoreboard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    /**
     * Creates a scoreboard
     */
    public Scoreboard()
    {
        this(100);
    }

    /**
     * Creates a scoreboard for the final result once player is out of lives
     */
    public Scoreboard(int score)
    {
        makeImage("Game Over", "Score: ", score);
    }
    public Scoreboard(int score, String mess)
    {
        makeImage (mess, "Score: ", score);
    }
    public Scoreboard(int score, String mess, String desc)
    {
        makeImage (mess, desc, score);
    }

    /**
     * Makes the scoreboard image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
}