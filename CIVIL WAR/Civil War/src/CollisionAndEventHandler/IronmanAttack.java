/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionAndEventHandler;

import Characters.Captain;
import Characters.Ironman;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Walker;
import game.Game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *Ironman attacking Captain America
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.1
 */
public class IronmanAttack extends KeyAdapter  implements CollisionListener {

    private Ironman ironman;
    private Captain captain;
    private Game game;

    /**
     *Checks if the level is complete
     */
    public boolean levelDone;
  
    /**
     *
     * @param ironman
     * @param Captain
     * @param game
     */
    public IronmanAttack(Walker ironman, Walker Captain, Game game) {
        this.ironman = (Ironman) ironman;
        this.captain = (Captain) Captain;
        this.game = game;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        
         if(e.getOtherBody()==ironman) {
             if(e.getReportingBody() instanceof Captain){
           ironman.setColl(true);}
           
        }   
          
        
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_T && ironman.getColl() == true){
            captain.decLife(.7f);
        }else if (code == KeyEvent.VK_F && ironman.getColl() == true) { 
            captain.decLife(0.09f);
        }else if (code == KeyEvent.VK_G && ironman.getColl() == true) {
            captain.decLife(0.5f);
        }else if (code == KeyEvent.VK_H && ironman.getColl() == true) { 
            captain.decLife(0.1f);
        } if(captain.getLife()<=0) {
             System.out.println("IRONMAN WIN THIS LEVEL");  
             game.p1win++;
             game.world.sp.close();
              levelDone = true;
              if(game.next){
             game.goNextLevel();}
              else{System.exit(0);}
            
         }        
        game.world.player2 = captain.getLife();
       
    }
    
     @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_F) {
           ironman.setColl(false);
        }
        else if (code == KeyEvent.VK_T) {
           ironman.setColl(false); 
        }
        else if (code == KeyEvent.VK_G) {
          ironman.setColl(false); 
        }
        else if (code == KeyEvent.VK_H) {
           ironman.setColl(false);
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
