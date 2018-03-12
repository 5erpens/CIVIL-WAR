package Collision;

import Characters.Ironman;
import city.cs.engine.*;

/**
 Collision class between the ground and Iron Man
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.0
 */

/**
 * Collision listener that allows the bird to collect things.
 */
public class IMLanding implements CollisionListener {
    private Ironman ironman;
    private Body ground;
    
    //Image is taken from "comicheroes.co.uk/ironman_gifs.htm"
    BodyImage image = new BodyImage("data/Ironman/standing.gif", 10.0f);
    
    /**
     *Passing Iron Man and the ground in the CapLanding class
     * @param ironman
     * @param ground
     */
    public IMLanding(Walker ironman, Body ground) {
        this.ironman = (Ironman) ironman;
        this.ground = ground;
    }

    /**
     *Image changes to Iron man's normal image state when he collides with the ground
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ground) {
            ironman.removeAllImages();
            ironman.addImage(image);
        }
    }
    
}
