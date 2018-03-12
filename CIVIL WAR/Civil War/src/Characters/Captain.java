/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import city.cs.engine.*;
/**
 *Creates the Captain America character
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.0
 */
public class Captain extends Walker {
    private float life;
    private static final Shape ImShape = new PolygonShape( 
             -4.08f,4.95f, -4.09f,-4.2f, 4.08f,-4.2f, 4.05f,4.96f, -3.87f,4.96f);
    private boolean i;
    
    //Image is taken from "comicheroes.co.uk/captain_america_gifs.htm"
     private static final BodyImage image =   new BodyImage("data/Captain/standleft.gif", 9.0f);
     
     Fixture fix = new SolidFixture(this,ImShape);
     
    /**
     *Constructor showing inheritance from its superclass, World
     * @param world
     */
    public Captain(World world) {
        super(world, ImShape);
        addImage(image);
        
        
        life =100;
    }

    /**
     *Checks if a collision has taken place
     * @param i
     */
    public void setColl(boolean i){
         this.i=i;
     }

    /**
     * gets the collision event
     * @return
     */
    public boolean getColl(){
         return i;
     }

    /**
     *Gets the amount of health the player has
     * @return
     */
    public float getLife(){
        return life;
    }
    
    /**
     *Decreases the amount of health the Captain has when he gets hit by an enemy attack
     * @param r
     */
    public void decLife(float r){
        life = life - r;
        System.out.println("Captain America Life: " + life);
    }
    
    /**
     *Calls the jumping motion when the player presses jump for this character
     * @return
     */
    public String getJumpImage(){
        return "data/Captain/Jumpright.gif";
    }
}
