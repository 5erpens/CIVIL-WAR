/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import Level.GameLevel;
import city.cs.engine.BodyImage;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;


/**
 *Creates the Hulk character
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.1
 */
public class Hulk extends Walker{
    
    private float life;
    private boolean i;
    private static final Shape ImShape = new PolygonShape( 
             -1.93f,4.5f, -4.42f,-4.16f, 4.26f,-4.16f, 2.55f,4.41f);
     Fixture fix = new SolidFixture(this,ImShape);
     
     //Image is taken from "comicheroes.co.uk/ironman_gifs.htm"
     private   BodyImage image = new BodyImage("data/Hulk/stand.gif",09f);
    
    /**
     *Constructor showing inheritance from its superclass, World
     * The amount of health for the Hulk character is also set here
     * @param world
     */
    public Hulk(GameLevel world) {
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
     *gets the collision event
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
     *Decreases the amount of health Hulk has when he gets hit by an enemy attack
     * @param r
     */
    public void decLife(float r){
        life = life - r;
        System.out.println("Hulk " + life);
    }

    /**
     *Adds my chosen image to the Hulk character
     * @param Image
     */
    public void addImage(String Image) {
       this.addImage(Image);
    }
    
}
