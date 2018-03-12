/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionAndEventHandler;

import Characters.Captain;
import Characters.Thor;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Walker;
import game.Game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

  /**
 *Thor attacking Captain America
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
 */
public class Thor2Attack extends KeyAdapter  implements CollisionListener {

    private Thor thor;
    private Captain captain;
    private Game game;

    /**
     *Checks if the level is complete
     */
    public boolean levelDone;
  
    /**
     *
     * @param thor
     * @param Captain
     * @param game
     */
    public Thor2Attack(Walker thor, Walker Captain, Game game) {
        this.thor = (Thor) thor;
        this.captain = (Captain) Captain;
        this.game = game;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        
         if(e.getOtherBody()==thor) {
             if(e.getReportingBody() instanceof Captain){
           thor.setColl(true);}
           
        }   
          
        
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_T && thor.getColl() == true){
            captain.decLife(.7f);
        }else if (code == KeyEvent.VK_F && thor.getColl() == true) { 
            captain.decLife(0.09f);
        }else if (code == KeyEvent.VK_G && thor.getColl() == true) {
            captain.decLife(0.5f);
        }else if (code == KeyEvent.VK_H && thor.getColl() == true) { 
            captain.decLife(0.1f);
        } if(captain.getLife()<=0) {
             System.out.println("THOR WIN THIS LEVEL");  
             game.p1win++;
             game.world.sp.close();
              levelDone = true;
            if(game.next){
             game.goNextLevel();}
              else{System.exit(0);}
            
         }        
       game.world.player2 =captain.getLife();
    }
    
     @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_F) {
           thor.setColl(false);
        }
        else if (code == KeyEvent.VK_T) {
           thor.setColl(false); 
        }
        else if (code == KeyEvent.VK_G) {
          thor.setColl(false); 
        }
        else if (code == KeyEvent.VK_H) {
           thor.setColl(false);
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
