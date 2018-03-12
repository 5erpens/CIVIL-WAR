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
 *Captain America attacking Thor
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
 */
public class Captain2Attack extends KeyAdapter  implements CollisionListener{

    private Thor thor;
    private Captain captain;
    private Game game;

    /**
     *Checks if the level is complete
     */
    public boolean levelDone;

    /**
     *Passing Thor, Captain and game into the Captain2Attack class 
     * @param thor
     * @param Captain
     * @param game
     */
    public Captain2Attack(Walker thor, Walker Captain,Game game) {
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
        
         if(e.getOtherBody()==captain) {
             if(e.getReportingBody() instanceof Thor){
           captain.setColl(true);}
        }
         
         
    }

     /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_I && captain.getColl() == true ){
            thor.decLife(.7f);
        }else if (code == KeyEvent.VK_J && captain.getColl() == true) { 
            thor.decLife(0.09f);
        }else if (code == KeyEvent.VK_K && captain.getColl() == true) {
            thor.decLife(0.5f);
        }else if (code == KeyEvent.VK_L && captain.getColl() == true ) { 
            thor.decLife(0.1f);
        }         
        if(thor.getLife()<=0) {
             System.out.println("CAPTAIN AMERICA WON THIS LEVEL");
             game.p2win++;
             game.world.sp.close();
             levelDone = true;
             
             if(game.next){
             game.goNextLevel();}
              else{System.exit(0);}
             
         }
        game.world.player1 =thor.getLife();
    }
    
    
     /**
     *
     * @param e
     */
     @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_I) {
            captain.setColl(false);
        }
        else if (code == KeyEvent.VK_K) {
            captain.setColl(false);
        }
        else if (code == KeyEvent.VK_L) {
            captain.setColl(false); 
        }else if (code == KeyEvent.VK_J) {
           captain.setColl(false);
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
