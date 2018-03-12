/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import city.cs.engine.*;
import Level.GameLevel;

/**
 **Creates the Iron Man character
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.0
 * @author Sai
 */
public class Ironman extends Walker{
   
    private float life;
    private boolean i;
    private static final Shape ImShape = new PolygonShape( 
             -1.93f,4.5f, -4.42f,-4.16f, 4.26f,-4.16f, 2.55f,4.41f);
     Fixture fix = new SolidFixture(this,ImShape);
     
     //Image is taken from "comicheroes.co.uk/ironman_gifs.htm"
     private   BodyImage image = new BodyImage("data/Ironman/standing.gif",09f);
      
    /**
     *Constructor showing inheritance from its superclass, World
     * @param world
     */
    public Ironman(GameLevel world){
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
        System.out.println("Ironman Life: " + life);
    }

    /**
     *Calls the jumping motion when the player presses jump for this character
     * @param Image
     */
    public void addImage(String Image) {
       this.addImage(Image);
    }
}

   
    

