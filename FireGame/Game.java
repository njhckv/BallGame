
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class Game extends JPanel
{

    //private Ball bb = new Ball(this);
    private Racquet rr = new Racquet(this);
    //private Sprite ss =new Sprite(this, 100, 100, 0, 2, 50, 70);
    private Target tt = new Target(this, 200, 200, 5, -5, 30 ,30);
    private Player pp = new Player(this, 200, 600, 0, 0, 60, 20);
    
    
    
    public Game()
    {
        KeyListener ll = new KeyListener()
        {
            public void keyPressed(KeyEvent e)
            {
                //rr.keyPressed(e);
                pp.keyPressed(e);
            }
            
            public void keyReleased(KeyEvent e)
            {
                //rr.keyReleased(e);
                pp.keyReleased(e);
            }
            
            public void keyTyped(KeyEvent e)
            {
                
            }
        };
        
        addKeyListener(ll);
        setFocusable(true);
        
        tt.randomize();
    }
    
    private void animate()
    {
        //bb.move();
        //rr.move();
        //ss.move();
        tt.move();
        pp.move();
        pp.getProjectile().move();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.pink);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //bb.paint(g2d);
        //rr.paint(g2d);
        //ss.paint(g2d);
        tt.paint(g2d);
        pp.paint(g2d);
        pp.getProjectile().paint(g2d);

    }
    
    /*
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.pink);
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
        g2d.fillRect(50, 0, 30, 30);
        g2d.drawRect(50, 50, 30, 30);
    }
    */
    
    public static void main(String[] args) throws InterruptedException
    {
        

    

        
        // Fisrt try JFrame frame = new JFrame("Simple game");
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(500, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true)
        {
            game.animate();
            game.checkCollisions();
            game.repaint();
            Thread.sleep(5);
        }
    }
    
    
    public Racquet getRacquet()
    {
        return rr;
    }

    
    public void gameOver()
    {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
    
    
    public void checkCollisions()
    {
        if(tt.collision(pp.getProjectile()))
        {
            tt.kill();
            pp.getProjectile().stop();
        }
    }
}
