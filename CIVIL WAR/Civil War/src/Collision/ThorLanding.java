package Collision;

import Characters.*;
import city.cs.engine.*;

/**
 *Collision class between the ground and Thor
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.1
 */

/**
 * Collision listener that allows the bird to collect things.
 */
public class ThorLanding implements CollisionListener {
    private Thor thor;
    private Body ground;
    
    //Image is taken from "comicheroes.co.uk/ironman_gifs.htm"
    BodyImage image = new BodyImage("data/Thor/Standing.gif", 10.0f);
    
    /**
     *Passing Thor and the ground in the CapLanding class
     * @param thor
     * @param ground
     */
    public ThorLanding(Walker thor, Body ground) {
        this.thor = (Thor) thor;
        this.ground = ground;
    }

    /**
     * Image changes to Thor's normal image state when he collides with the ground
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ground) {
            thor.removeAllImages();
            thor.addImage(image);
            
        }
    }
    
}
