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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *Creates Level 1
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
*/
public class Level1 extends GameLevel {
    
    private Ironman ironman;
    private Captain captain;
    private CaptainAttack captainAttack;
    private IronmanAttack ironmanAttack;
    
    @Override
    public void populate(Game game) {
        super.populate(game);
        player1 = 100f;
        player2 = 100f;
        
        ironman = new Ironman(this);
        ironman.setGravityScale(3);
        ironman.setPosition(new Vec2(-8, -7));
        ironman.addCollisionListener(new IMLanding(ironman,ground));
        
        
         // make a character Captain
        captain = new Captain(this);
        captain.setGravityScale(3);
        captain.setPosition(new Vec2(8, -7));
        captain.addCollisionListener(new CapLanding(captain,ground));
        
        captainAttack = new CaptainAttack(ironman,captain,game);
        ironmanAttack = new IronmanAttack(ironman,captain,game);
        ironman.addCollisionListener(captainAttack);
        captain.addCollisionListener(ironmanAttack);
        
        try {
        sp = new SoundClip("data/im.wav");
        sp.loop();
        sp.play();
            
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
        
          
           
          
        
    
    }

    @Override
    public Walker getPlayer1() {
        return ironman;
    }

    @Override
    public Walker getPlayer2() {
       return captain;
    }

    @Override
    public boolean isCompleted() {
        if(ironmanAttack.isComplete()==true){
             p1win++;
            return true;
        }
        else if(captainAttack.isComplete() == true){
             p2win++;
            return true;
        }
        return false;
    }
}
