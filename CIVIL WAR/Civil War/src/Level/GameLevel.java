/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import EventHandler.GameController;
import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import city.cs.engine.Walker;
import city.cs.engine.World;
import game.Game;
import org.jbox2d.common.Vec2;

/**
 *Creates GameLevel Layer
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
 */
public abstract class GameLevel extends World  {
    
    /**
     *  Common ground
     */
    public Body ground;

    /**
     *  Team Ironman Score
     */
    public int p1win;

    /**
     * Team Captain America score
     */
    public int p2win;

    /**
     * Player 1 life
     */
    public float player1;

    /**
     * Player 2 life
     */
    public float player2;
    
    /**
     * Background Music for each level
     */
    public SoundClip sp;
    
    
    /**
     *
     * @param game
     */
    public void populate(Game game){
        
      
        // make the ground
        Shape groundShape = new BoxShape(27, 0.0f);
        ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        
       // walls
        Shape wallShape = new BoxShape(100f, 0);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-23f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(23f, -6));
        leftWall.setAngleDegrees(90);
        rightWall.setAngleDegrees(90);
    }
    
    /**
     * gets player 1
     * @return
     */
    public abstract Walker getPlayer1();
    
    /**
     * gets player 2
     * @return
     */
    public abstract Walker getPlayer2();
    
    /**
     * checks level complete
     * @return
     */
    public abstract boolean isCompleted();
    
    
    
}
