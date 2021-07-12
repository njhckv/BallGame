
package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 *
 * @author diary
 */
public class Projectile extends Sprite 
{
    private boolean isVisible;
    
    public Projectile(Game game)
    {
        super(game);
        width = height = 20;
        // Create a projectile
    }
    
    public Projectile(Game game, int x, int y, int xSpeed, int ySpeed, int width, int height)
    {
        super(game, x, y, xSpeed, ySpeed, width, height);
        // Create a projectile
    }
    
    public void paint(Graphics2D g)
    {
        if (!isVisible)
        {
            return;
        }
        
        g.fillOval(x, y, width, height);
    }
    
    public void fire(int x, int y)
    {
        if(isVisible) //Still firing
        {
            return;
        }
        
        isVisible = true;
        ySpeed = -10;
        xSpeed = 0;
        this.x = x;
        this.y = y;
    }
    
    
    public void stop()
    {
        isVisible = false;
        x = y = 0;
    }
    
    public void move()
    {
        if(!isVisible)
        {
            return;
        }
        
        super.move();
        
        if(y < 0)
        {
            stop();
        }
    }
    
    public boolean isVisible()
    {
        return isVisible;
    }
    
}
