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
 *Captain America attacking Ironman
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.0
 */
public class CaptainAttack extends KeyAdapter  implements CollisionListener{

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
    public CaptainAttack(Walker ironman, Walker Captain,Game game) {
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
        
         if(e.getOtherBody()==captain) {
             if(e.getReportingBody() instanceof Ironman){
           captain.setColl(true);}
        }
         
         
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_I && captain.getColl() == true ){
            ironman.decLife(.7f);
        }else if (code == KeyEvent.VK_J && captain.getColl() == true) { 
            ironman.decLife(0.09f);
        }else if (code == KeyEvent.VK_K && captain.getColl() == true) {
            ironman.decLife(0.5f);
        }else if (code == KeyEvent.VK_L && captain.getColl() == true ) { 
            ironman.decLife(0.1f);
        }         
        if(ironman.getLife()<=0) {
             System.out.println("CAPTAIN AMERICA WON THIS LEVEL");
             game.p2win++;
             game.world.sp.close();
             levelDone = true;
             if(game.next){
             game.goNextLevel();}
              else{System.exit(0);}
             
         }
        game.world.player1 =ironman.getLife();
    }
    
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
