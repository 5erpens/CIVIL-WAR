/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandler;

import Characters.Ironman;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Thor Controller
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.2
 */
public class ThorController extends  KeyAdapter {
    
    private static final float WALKING_SPEED = 6;
    private static final float JUMPING_SPEED = 25;
    
    private Walker body;
    

      //Image is taken from "comicheroes.co.uk/ironman_gifs.htm"
     BodyImage image = new BodyImage("data/Thor/Jump.gif", 11.0f); 
     BodyImage image1 = new BodyImage("data/Thor/Standing.gif", 10.0f);
     BodyImage kick = new BodyImage("data/Thor/B.gif", 10.0f);
     BodyImage rocket = new BodyImage("data/Thor/A.gif", 13.0f);
     BodyImage eye = new BodyImage("data/Thor/X.gif", 11.0f);
     BodyImage energy = new BodyImage("data/Thor/Y.gif", 11.0f);
    
    /**
     *
     * @param body
     */
    public ThorController(Walker body) {
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
        } else if (code == KeyEvent.VK_W) { // W = jump
                       
            Vec2 v = body.getLinearVelocity();
            //only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                
                body.jump(JUMPING_SPEED);
                 body.removeAllImages();
                 
                  body.addImage(image);
               
            }
        } else if (code == KeyEvent.VK_A) {
           
            body.startWalking(-WALKING_SPEED); // A = walk left
        } else if (code == KeyEvent.VK_D) {
            
            body.startWalking(WALKING_SPEED); // D = walk right
        }else if (code == KeyEvent.VK_S) {  
            
            body.setGravityScale(10); 
        }else if (code == KeyEvent.VK_F) {  
            
                   body.removeAllImages();
                  body.addImage(kick); // F = kick
        }
        else if (code == KeyEvent.VK_T) {  
            
                   body.removeAllImages();
                  body.addImage(rocket); // T = heavy attack
        }
        else if (code == KeyEvent.VK_G) {  
            
                   body.removeAllImages();
                  body.addImage(eye); // G = eye attack
        }
        else if (code == KeyEvent.VK_H) {  
            
                   body.removeAllImages();
                  body.addImage(energy); // H = energy attack
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
        if (code == KeyEvent.VK_A) {
            body.removeAllImages();
                  body.addImage(image1); // J - Shield punch 
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.removeAllImages();
                  body.addImage(image1); // J - Shield punch 
            body.stopWalking();
        }else if (code == KeyEvent.VK_S) {
             body.setGravityScale(3);
        }
        
        else if (code == KeyEvent.VK_F) {
            body.removeAllImages();
                  body.addImage(image1); 
        }
        else if (code == KeyEvent.VK_T) {
            body.removeAllImages();
                  body.addImage(image1); 
        }
        else if (code == KeyEvent.VK_G) {
            
            
            body.removeAllImages();
                  body.addImage(image1); 
        }
        else if (code == KeyEvent.VK_H) {
            body.removeAllImages();
                  body.addImage(image1); 
        }

    }
    
   
}