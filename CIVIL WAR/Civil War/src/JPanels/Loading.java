/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPanels;

import game.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author CodeX
 */
public class Loading extends javax.swing.JPanel {
    
    private Timer timer;
    private ActionListener al;
    private int i = 0;
    /**
     * Creates new form Loading
     */
    public Loading(Game game) {
        
        initComponents();
        
        al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                pbar.setValue(i);
                if(pbar.getValue() == 100){
                 timer.stop();
                timer.removeActionListener(al);
                game.openpanel();}
            }
        };
        timer = new Timer(50,al);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pbar.setForeground(new java.awt.Color(0, 0, 102));
        add(pbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 250, 470, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Loading your account ....");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/giphy.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar pbar;
    // End of variables declaration//GEN-END:variables
}
