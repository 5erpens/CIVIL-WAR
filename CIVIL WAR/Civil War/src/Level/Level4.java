/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Characters.Captain;
import Characters.Thor;
import Collision.CapLanding;
import Collision.ThorLanding;
import CollisionAndEventHandler.Captain2Attack;
import CollisionAndEventHandler.Thor2Attack;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import game.Game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *Creates Level 4
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
*/
public class Level4 extends GameLevel{
    
    private Thor thor;
    private Captain captain;
    private Captain2Attack captain2Attack;
    private Thor2Attack thor2Attack;
    
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        try {
            
           sp = new SoundClip("data/tvsc.wav");
          sp.loop();
        sp.play();
            
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
        player1 = 100f;
        player2 = 100f;
        thor = new Thor(this);
        thor.setGravityScale(3);
        thor.setPosition(new Vec2(-8, -7));
        thor.addCollisionListener(new ThorLanding(thor,ground));
        
         // make a character Captain
        captain = new Captain(this);
        captain.setGravityScale(3);
        captain.setPosition(new Vec2(8, -7));
        captain.addCollisionListener(new CapLanding(captain,ground));
        
        captain2Attack = new Captain2Attack(thor,captain,game);
        thor2Attack = new Thor2Attack(thor,captain,game);
        thor.addCollisionListener(captain2Attack);
        captain.addCollisionListener(thor2Attack);
         
    }

    @Override
    public Walker getPlayer1() {
        return thor;
    }

    @Override
    public Walker getPlayer2() {
        return captain;
    }

    @Override
    public boolean isCompleted() {
       if(thor2Attack.isComplete()==true){
            return true;
        }
        else if(captain2Attack.isComplete() == true){
            return true;
        }
        return false;
    }
    
    
}
