/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Characters.Hulk;
import Characters.Ironman;
import Collision.HulkLanding;
import Collision.IMLanding;
import CollisionAndEventHandler.CaptainAttack;
import CollisionAndEventHandler.Hulk2Attack;
import CollisionAndEventHandler.Ironman2Attack;
import CollisionAndEventHandler.ThorAttack;
import city.cs.engine.Walker;
import UserViewPackage.Background;
import city.cs.engine.SoundClip;
import game.Game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *Creates Level 3
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
*/
public class Level3 extends GameLevel {

     private Ironman ironman;
     private Hulk hulk;
     private Hulk2Attack hulk2Attack;
     private Ironman2Attack Ironman2Attack;
     
    @Override
    public void populate(Game game) {
        super.populate(game);
        
         try {
            
        sp = new SoundClip("data/ivsh.wav");
        sp.loop();
        sp.play();
            
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
         player1 = 100f;
        player2 = 100f;
        ironman = new Ironman(this);
        ironman.setGravityScale(3);
        ironman.setPosition(new Vec2(-8, -7));
        ironman.addCollisionListener(new IMLanding(ironman,ground));
        
         // make a character Captain
        hulk = new Hulk(this);
        hulk.setGravityScale(3);
        hulk.setPosition(new Vec2(8, -7));
        hulk.addCollisionListener(new HulkLanding(hulk,ground));
        
        hulk2Attack = new Hulk2Attack(ironman,hulk,game);
        Ironman2Attack = new Ironman2Attack(ironman,hulk,game);
        ironman.addCollisionListener(hulk2Attack);
        hulk.addCollisionListener(Ironman2Attack);
    }
    
    @Override
    public Walker getPlayer1() {
        return ironman;
    }

    @Override
    public Walker getPlayer2() {
       return hulk;
    }

    @Override
    public boolean isCompleted() {
       
      if(Ironman2Attack.isComplete()==true){
            return true;
        }
        else if(hulk2Attack.isComplete() == true){
            return true;
        }
        return false;
    }
    
    
}
