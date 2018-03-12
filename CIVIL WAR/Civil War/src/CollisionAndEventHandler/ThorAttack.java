/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionAndEventHandler;

import Characters.Hulk;
import Characters.Thor;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Walker;
import game.Game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *Collision class between the ground and Captain America
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
 */
public class ThorAttack extends KeyAdapter  implements CollisionListener {

    private Thor thor;
    private Hulk hulk;
    private Game game;

    /**
     * Check level is done
     */
    public boolean levelDone;
    
    /**
     *
     * @param thor
     * @param Hulk
     * @param game
     */
    public ThorAttack(Walker thor, Walker Hulk, Game game) {
        this.thor = (Thor) thor;
        this.hulk = (Hulk) Hulk;
        this.game = game;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        
         if(e.getOtherBody()==thor) {
             if(e.getReportingBody() instanceof Hulk){
           thor.setColl(true);}
           
        }   
          
        
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_T && thor.getColl() == true){
            hulk.decLife(.7f);
        }else if (code == KeyEvent.VK_F && thor.getColl() == true) { 
            hulk.decLife(0.09f);
        }else if (code == KeyEvent.VK_G && thor.getColl() == true) {
            hulk.decLife(0.5f);
        }else if (code == KeyEvent.VK_H && thor.getColl() == true) { 
            hulk.decLife(0.1f);
        }if(hulk.getLife()<=0) {
             System.out.println("THOR WIN THIS LEVEL");  
            
             game.p1win++;
             game.world.sp.close();
              levelDone = true;
             if(game.next){
             game.goNextLevel();}
              else{System.exit(0);}
            
         }         
      game.world.player2 = hulk.getLife();  
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
