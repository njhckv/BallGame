package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball 
{
    private int x = 0;
    private int y = 0;
    private int diameter = 30;
    private int xSpeed = 1;
    private int ySpeed = 1;
    private Game game;
    
    public Ball(Game game)
    {
        this.game = game;
    }
    
    public void move()
    {
        if(x + xSpeed < 0) //left border
        {
            xSpeed = Math.abs(xSpeed);
        }
        
        if(x + xSpeed > game.getWidth() - diameter) // Right border
        {
            xSpeed = -xSpeed;
        }
        
        if(y + ySpeed < 0) //top border
        {
            ySpeed = Math.abs(ySpeed);
        }

        if(y + ySpeed > game.getHeight() - diameter)
        {
            game.gameOver();
        }
        
        if(collision() == true)
        {
            ySpeed = -ySpeed;
            y = game.getRacquet().getTopY() - diameter;
        }
        

        
        x = x + xSpeed;
        y = y + ySpeed;
    }
    
    public void paint(Graphics2D g)
    {
        g.fillOval(x, y, diameter, diameter);
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, diameter, diameter);
    }
    
    private boolean collision()
    {
        Rectangle racquetRect = game.getRacquet().getBounds();
        Rectangle ballRect = this.getBounds();
        
        boolean collision = ballRect.intersects(racquetRect);
        
        return collision;
    }

}
