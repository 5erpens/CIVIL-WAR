package Collision;

import Characters.*;
import city.cs.engine.*;

/**
 *Collision class between the ground and Hulk
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.0
 * @author Sai
 */

/**
 * Collision listener that allows the Hulk to collect things.
 */
public class HulkLanding implements CollisionListener {
    private Hulk hulk;
    private Body ground;
    
    //Image is taken from "comicheroes.co.uk/captain_america_gifs.htm"
    BodyImage image = new BodyImage("data/Hulk/stand.gif", 10.0f);
    
    /**
     *Passing Hulk and the ground in the HulkLanding class
     * @param hulk
     * @param ground
     */
    public HulkLanding(Walker hulk, Body ground) {
        this.hulk = (Hulk) hulk;
        this.ground = ground;
    }

    /**
     *Image changes to the Hulk normal image state when he collides with the ground
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ground) {
            hulk.removeAllImages();
            hulk.addImage(image);
            
        }
    }
    
}
