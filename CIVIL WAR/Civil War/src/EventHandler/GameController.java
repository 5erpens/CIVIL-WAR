/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandler;

import JPanels.CheatCode;
import JPanels.Menu;
import city.cs.engine.*;
import game.Game;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Sai
 */
public class GameController extends  KeyAdapter {

    /**
     *
     */
    public Game game;

    /**
     *
     */
    public BufferedImage logo;
    
    /**
     *
     * @param game
     */
    public GameController(Game game) {
        this.game = game;
         
    }
    
    /**
     * Handles Game control
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) { // P = QuickMenu
           System.exit(0);
        } else if (code == KeyEvent.VK_ENTER) { // ENTER  = cheat code
                      
             
          try {
             logo=ImageIO.read(new File("data/c.png"));
         } catch (IOException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
        CheatCode cc = new CheatCode(game);
       
        // display the view in a frame
        JFrame frame1 = new JFrame("CheatCode");

        //  Logo for titlebar
        frame1.setIconImage(logo);
        // quit the application when the game window is closed
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLocationByPlatform(true);
        // display the world in the window
        frame1.getContentPane().add(cc);
       // frame.add(view);
        
        // don't let the game window be resized
        frame1.setResizable(false);
        // size the game window to fit the world view
        frame1.pack();
        
        // make the window visiblew
        frame1.setVisible(true);
        }
        
    }
    
    
}