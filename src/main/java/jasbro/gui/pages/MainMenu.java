/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jasbro.gui.pages;

import jasbro.Jasbro;
import jasbro.gui.objects.div.MyImage;
import jasbro.gui.pictures.ImageData;
import jasbro.texts.TextUtil;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 *
 * @author Azrael
 */
public class MainMenu extends MyImage {
	private ImageData imageData = new ImageData("images/backgrounds/sky.jpg");

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
    	setVisible(false);
        initComponents();
        setVisible(true);
        repaint();
        setBackgroundImage(imageData);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setLayout(new FormLayout(new ColumnSpec[] {
                ColumnSpec.decode("1dlu:grow(5)"),
                ColumnSpec.decode("1dlu:grow(2)"),
                ColumnSpec.decode("1dlu:grow(5)"),},
            new RowSpec[] {
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("15dlu"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("15dlu"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),
                RowSpec.decode("1dlu:grow"),}));
                newGameButton = new javax.swing.JButton();
                newGameButton.setFont(newGameButton.getFont().deriveFont(newGameButton.getFont().getSize() + 5f));
                add(newGameButton, "2, 6");
                
                        newGameButton.setText(TextUtil.t("ui.newgame"));
                        continueButton = new javax.swing.JButton();
                        continueButton.setFont(continueButton.getFont().deriveFont(continueButton.getFont().getSize() + 5f));
                        add(continueButton, "2, 8");
                        
                                continueButton.setText(TextUtil.t("ui.continue"));
                                quitButton = new javax.swing.JButton();
                                quitButton.setFont(quitButton.getFont().deriveFont(quitButton.getFont().getSize() + 5f));
                                add(quitButton, "2, 10");
                                
                                        quitButton.setText(TextUtil.t("ui.quit"));
                                        quitButton.addActionListener(new ActionListener() {
                                            
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                Jasbro.getInstance().getGui().dispose();
                                            }
                                        });
                                continueButton.addActionListener(new ActionListener() {            
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (Jasbro.getInstance().getData() == null) {
                                            Jasbro.getInstance().continueLastGame();
                                        }
                                        else {
                                            Jasbro.getInstance().getGui().showHouseManagementScreen();
                                        }
                                    }
                                });
                        newGameButton.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                Jasbro.getInstance().getGui().showStartScreen();
                            }
                        });
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continueButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton quitButton;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
