/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Characters.*;
import Collision.*;
import CollisionAndEventHandler.*;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;

import game.Game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *Creates Level 2
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
*/
public class Level2 extends GameLevel{
    
    private Thor thor;
    private Hulk hulk;
    private HulkAttack hulkAttack;
     private ThorAttack thorAttack;
    
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        try {
            
           sp = new SoundClip("data/tvsh.wav");
          sp.loop();
        sp.play();
            
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
        
         player1 = 100f;
        player2 = 100f;
        System.out.println(p1win +" "+ p2win );
        //game.frame.add(new Background(,game.i,game.j,2));
        thor = new Thor(this);
        thor.setGravityScale(3);
        thor.setPosition(new Vec2(-8, -7));
       thor.addCollisionListener(new ThorLanding(thor,ground));
        
        
         // make a character Captain
        hulk = new Hulk(this);
        hulk.setGravityScale(3);
        hulk.setPosition(new Vec2(8, -7));
        hulk.addCollisionListener(new HulkLanding(hulk,ground));
        
        hulkAttack = new HulkAttack(thor,hulk,game);
        thorAttack = new ThorAttack(thor,hulk,game);
        thor.addCollisionListener(hulkAttack);
        hulk.addCollisionListener(thorAttack);
    }

    @Override
    public Walker getPlayer1() {
        return thor;
    }

    @Override
    public Walker getPlayer2() {
       return hulk;
    }

    @Override
    public boolean isCompleted() {
      if(thorAttack.isComplete()==true){
          p1win++;
            return true;
            
        }
        else if(hulkAttack.isComplete() == true){
             p2win++;
            return true;
        }
        return false;
    }
    
}
