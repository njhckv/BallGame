
package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Player extends Sprite 
{
    private Projectile ppp;
    
    public Player(Game game)
    {
        super(game);
        ppp = new Projectile(game);
    }
    
    public Player(Game game, int x, int y, int xSpeed, int ySpeed, int width, int height)
    {
        super(game, x, y, xSpeed, ySpeed, width, height);
        ppp = new Projectile(game);
    }
    
    public void paint(Graphics2D g)
    {
        super.paint(g); //paint the bottom rectangle
        g.fillRect(x + width / 4, y - height, width / 2, height);
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            xSpeed = -3;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            xSpeed = 3;
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            xSpeed = 0;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            xSpeed = 0;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            fire();
        }
    }
    
    private void fire()
    {
        // Determine the coordinate of the projectile
        int xProj = x + width / 4;
        int yProj = y - height;
        
        ppp.fire(xProj, yProj);
    }
    
    public Projectile getProjectile()
    {
        return ppp;
    }
    
    public void move()
    {
        if((x + xSpeed > 0) && (x + xSpeed < game.getWidth() - width))
        {
            x = x + xSpeed;
        }
    }
    
    
    
}
