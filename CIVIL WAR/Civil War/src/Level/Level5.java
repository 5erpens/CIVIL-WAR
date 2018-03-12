/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Fixture;
import city.cs.engine.GhostlyFixture;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import city.cs.engine.Walker;
import game.Game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *Creates Gameover
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
*/
public class Level5 extends GameLevel{
    
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        try {
            
           sp = new SoundClip("data/theme.wav");
          sp.loop();
        sp.play();
            
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
    
     Shape Bg = new BoxShape(0,0);
        Body bg = new StaticBody(this, Bg);
        Fixture bgfix= new GhostlyFixture(bg,Bg); 
        BodyImage bgImg ;
           
            if(game.p1win>game.p2win){
            bgImg = new BodyImage("data/1.jpg",25.0f);
                
            }else if (game.p1win<game.p2win){
                bgImg = new BodyImage("data/2.jpg",25.0f);
            }else {
                bgImg = new BodyImage("data/3.jpg",25.0f);
                
            }
                
            bg.addImage(bgImg);
    }

    @Override
    public Walker getPlayer1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Walker getPlayer2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCompleted() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
