package Collision;

import Characters.Captain;
import city.cs.engine.*;

/**
 *Collision class between the ground and Captain America
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.0
 */

/**
 * Collision listener that allows the Captain to collect things.
 */
public class CapLanding implements CollisionListener {
    private Captain cap;
    private Body ground;
    
    //Image is taken from "comicheroes.co.uk/captain_america_gifs.htm"
    BodyImage image = new BodyImage("data/Captain/standleft.gif", 10.0f);
    
    /**
     *Passing Captain America and the ground in the CapLanding class
     * @param cap
     * @param ground
     */
    public CapLanding(Walker cap, Body ground) {
        this.cap = (Captain) cap;
        this.ground = ground;
    }

    /**
     *Image changes to Thors normal image state when he collides with the ground
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ground) {
            cap.removeAllImages();
            cap.addImage(image);
            
        }
    }
    
}
