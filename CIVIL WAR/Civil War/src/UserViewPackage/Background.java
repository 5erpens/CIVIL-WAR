package UserViewPackage;

import Level.GameLevel;
import city.cs.engine.UserView;
import game.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *Creates background for all levels
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.1
*/
public class Background extends UserView {
    private final Game game;
    private Image background;
    private int width, height;
    private int level = 1;
    private GameLevel world;
    
    /**
     *
     * @param world
     * @param game
     * @param width
     * @param height
     */
    public Background(GameLevel world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
        this.world = world;
        this.width = width;
        this.height = height;
        this.background = new ImageIcon("data/crp.png").getImage();
        this.background=background.getScaledInstance(width+20, height+20, width);
              
    }
    
    /**
     *
     * @param level
     */
    public void setBackground(int level){
        this.level = level;
       try {
           String filePath = "";
           if (level == 2) {
               filePath = "data/Level2.jpg";
            
          }
           if (level == 3) {
               filePath = "data/Level3.jpg";
               
           }
           if (level == 4) {
               filePath = "data/Level4.png";
                
           }
           
           background = ImageIO.read(new File(filePath));
           background=background.getScaledInstance(width+20, height+20, width);
       } catch (IOException e) {
           e.printStackTrace();

        }
          }
 
    /**
     *
     * @param g
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
       
        
    }

    /**
     *
     * @param g
     */
    @Override
   protected void paintForeground(Graphics2D g) {  
       if(level!=5){
       g.setColor(Color.YELLOW);
       g.fillRect(0, 0, 410, 70);
        g.setColor(Color.red);
        g.drawString("Player 1 Health: ", 10, 15);
       g.fillRect(10, 20, ((int) game.world.player1)*4, 15);
      
       g.setColor(Color.yellow);
       g.fillRect(495, 0, 470, 70);
       g.setColor(Color.blue);       
       g.drawString(game.p2win + " :Team Captain America Round Score", 650, 60);
       //g.drawString(game.world.player2 + " :Team Player 2 Health", 650, 50);
        g.drawString("Player 2 Health: ", 10, 47);
       g.fillRect(10, 50, ((int) game.world.player2)*4, 15);
       g.setColor(Color.red);
      g.drawString(game.p1win + " :Team Iron Man Round Score", 650, 20);
      
       }
       
   }
}