
package game;

import java.awt.Graphics2D;


public class Target extends Sprite
{
    public Target(Game game)
    {
        super(game);
    }
    
    public Target(Game game, int x, int y, int xSpeed, int ySpeed, int width, int height)
    {
        super(game, x, y, xSpeed, ySpeed, width, height);
    }
    
    public void move()
    {
        //Left border
        if (x + xSpeed < 0)
        {
            x = game.getWidth() - width;
        }
        
        //Right
        if (x + xSpeed + width > game.getWidth())
        {
            x = 0;
        }
        
        //top
        if (y + ySpeed < 0)
        {
            y = game.getHeight() - height;
        }
        
        //bottom
        if(y + ySpeed + width > game.getHeight())
        {
            y = 0;
        }
        
        //move sprite
        super.move();
        

    }
    
        public void paint(Graphics2D g)
        {
            if(!isAlive)
            {
                return;
            }
            
            super.paint(g);
        }
        
        public void randomize()
        {
            x = randomGenerator(0, game.getWidth());
            y = randomGenerator(0, game.getHeight());
            
            xSpeed = randomGenerator(-3, 3);
            ySpeed = randomGenerator(-5, 5);
            
            width = 30;
            height = 30;
        }
}
