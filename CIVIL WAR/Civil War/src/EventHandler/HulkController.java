/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandler;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Hulk Controller
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
 */
public class HulkController extends  KeyAdapter {
    
    private static final float WALKING_SPEED = 6;
    private static final float JUMPING_SPEED = 20;
    
    private Walker body;
    
    //Images are taken from "comicheroes.co.uk/captain_america_gifs.htm"
     BodyImage image = new BodyImage("data/Hulk/y.gif", 14.0f); 
     BodyImage image1 = new BodyImage("data/Hulk/stand.gif", 10.0f);
     BodyImage kick = new BodyImage("data/Hulk/A.gif", 15.0f);
     BodyImage rocket = new BodyImage("data/Hulk/h.gif", 16.0f);
     BodyImage eye = new BodyImage("data/Hulk/B.gif", 10.0f);
     BodyImage energy = new BodyImage("data/Hulk/X.gif", 12.0f);     
     BodyImage walk = new BodyImage("data/Hulk/Walk.gif", 12.0f);   
    
    /**
     *
     * @param body
     */
    public HulkController(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) { // ESCAPE = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // UP arrow = jump
                       
            Vec2 v = body.getLinearVelocity();
            //only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                
                body.jump(JUMPING_SPEED);
                 body.removeAllImages();
                 
                  body.addImage(image).flipHorizontal();
               
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.removeAllImages();
                  body.addImage(walk); // J - Shield punch 
            body.startWalking(-WALKING_SPEED); // LEFT arrow = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            body.removeAllImages();
                  body.addImage(walk).flipHorizontal(); // J - Shield punch 
            body.startWalking(WALKING_SPEED); // RIGHT arrow = walk right
        }else if (code == KeyEvent.VK_DOWN) {  
            
            body.setGravityScale(10); // DOWN arrow = instant drop
        }else if (code == KeyEvent.VK_J) {  
            
                   body.removeAllImages();
                  body.addImage(kick).flipHorizontal(); // J - Shield punch 
        }
        else if (code == KeyEvent.VK_I) {  
                   
                   body.removeAllImages();
                  body.addImage(rocket).flipHorizontal(); // I = Energy shield attack
                  
        }
        else if (code == KeyEvent.VK_K) {  
            
                   body.removeAllImages();
                  body.addImage(eye).flipHorizontal(); // K = Shield throw attack
        }
        else if (code == KeyEvent.VK_L) {  
               
                   body.removeAllImages();
                  body.addImage(energy); // L = instant drop
                  
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    
     // When release come to standing position
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_RIGHT) {
            body.removeAllImages();
                  body.addImage(image1); // J - Shield punch 
             body.stopWalking(); 
           
        }else if (code == KeyEvent.VK_DOWN) {
             body.setGravityScale(3);
        }
        else if (code == KeyEvent.VK_LEFT) {
            body.removeAllImages();
                  body.addImage(image1); // J - Shield punch 
            body.stopWalking(); 
        }
        else if (code == KeyEvent.VK_I) {
            body.removeAllImages();
                  body.addImage(image1); 
        }
        else if (code == KeyEvent.VK_K) {
            body.removeAllImages();
                  body.addImage(image1);
        }
        else if (code == KeyEvent.VK_L) {
            body.removeAllImages();
                  body.addImage(image1); 
        }else if (code == KeyEvent.VK_J) {
            body.removeAllImages();
                  body.addImage(image1); 
        }

    }
}