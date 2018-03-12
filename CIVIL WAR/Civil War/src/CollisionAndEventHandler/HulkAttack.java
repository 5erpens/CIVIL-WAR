/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionAndEventHandler;

import Characters.*;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Walker;
import game.Game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *Hulk attacking Thor
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
 */
public class HulkAttack extends KeyAdapter  implements CollisionListener{

    private Thor thor;
    private Hulk hulk;
    private Game game;

    /**
     *Checks if the level is complete
     */
    public boolean levelDone;

    /**
     *
     * @param thor
     * @param hulk
     * @param game
     */
    public HulkAttack(Walker thor, Walker hulk,Game game) {
        this.thor = (Thor) thor;
        this.hulk = (Hulk) hulk;
        this.game = game;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        
         if(e.getOtherBody()==hulk) {
             if(e.getReportingBody() instanceof Thor){
           hulk.setColl(true);}
        }
         
         
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_I && hulk.getColl() == true ){
            thor.decLife(.7f);
        }else if (code == KeyEvent.VK_J && hulk.getColl() == true) { 
            thor.decLife(0.09f);
        }else if (code == KeyEvent.VK_K && hulk.getColl() == true) {
            thor.decLife(0.5f);
        }else if (code == KeyEvent.VK_L && hulk.getColl() == true ) { 
            thor.decLife(0.1f);
        }         
        if(thor.getLife()<=0) {
             System.out.println("HULK WON THIS LEVEL");
             game.p2win++;
             game.world.sp.close();
             levelDone = true;
            if(game.next){
             game.goNextLevel();}
              else{System.exit(0);}
             
         }
        game.world.player1 =thor.getLife();
    }
    
     @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_I) {
            hulk.setColl(false);
        }
        else if (code == KeyEvent.VK_K) {
            hulk.setColl(false);
        }
        else if (code == KeyEvent.VK_L) {
            hulk.setColl(false); 
        }else if (code == KeyEvent.VK_J) {
           hulk.setColl(false);
        }

    }
    
    /**
     *
     * @return
     */
    public boolean isComplete(){
         return levelDone;
    }
}
