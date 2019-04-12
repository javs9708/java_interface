package vm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class window extends javax.swing.JFrame implements ActionListener, Runnable{
    
    JButton afButton;
    JButton avButton;
    JButton klmButton;
    String nameAirline;

    
        
    public window() throws FileNotFoundException, UnsupportedEncodingException  {
        initComponents();         
        //Color redColor = new Color(78,75,75);
        
        this.setTitle("Inkaviation");
        this.setIconImage(new ImageIcon(getClass().getResource("/files/InkIcon.png")).getImage());
        titleAlign(this); 
        
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setResizable(false);
        
        server s = new server();
        s.get_json();    
            
        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/ink.png")));
            
        if(s.jsonAirlines.length!=0){
            JLabel titleLabel;
            titleLabel = new JLabel("Select a virtual machine");
            titleLabel.setBounds(this.getWidth()/2-150,10, 400, 200);
            titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            this.add(titleLabel);
            
        }
        else{
            JLabel titleLabel;
            titleLabel = new JLabel("No there virtual machines");
            titleLabel.setBounds(this.getWidth()/2-150,10, 400, 200);
            titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            this.add(titleLabel);
        }
        
        
        for (int i=0;i<s.jsonAirlines.length;i++) {           
            switch (s.jsonAirlines[i]) {
                case "airFrance":
                    afButton=new JButton("");
                    afButton.setBounds(this.getWidth()/2-230,this.getHeight()/2,240,60);
                    afButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/af.png")));
                    afButton.setBorder(new LineBorder(Color.BLACK));
                    afButton.setBackground(Color.white);
                    add(afButton);
                    afButton.addActionListener(this);
                    break;
                case "avianca":
                    avButton=new JButton("");
                    avButton.setBounds(230,this.getHeight()/2,240,60);
                    avButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/av.png")));
                    avButton.setBorder(new LineBorder(Color.BLACK));
                    avButton.setBackground(Color.white);
                    add(avButton);
                    avButton.addActionListener(this);
                    break;
                case "klm":
                    klmButton=new JButton("");
                    klmButton.setBounds(1300,this.getHeight()/2,240,60);
                    klmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/KLM.jpg")));
                    klmButton.setBorder(new LineBorder(Color.BLACK));
                    klmButton.setBackground(Color.white);
                    add(klmButton);
                    klmButton.addActionListener(this);
                    break;
                default:                   
                    break;

            }
        }
        
         
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==afButton) {
            abrirarchivo("./src/files/inkairFrance.rdp");
        }
        
        if (e.getSource()==avButton) {
            abrirarchivo("./src/files/inkavianca.rdp");
        }
        if (e.getSource()==klmButton) {
            abrirarchivo("./src/files/inkklm.rdp");
        }
    }
    

    
    private void titleAlign(JFrame frame) { 

     Font font = frame.getFont(); 

     String currentTitle = frame.getTitle().trim(); 
     FontMetrics fm = frame.getFontMetrics(font); 
     int frameWidth = frame.getWidth(); 
     int titleWidth = fm.stringWidth(currentTitle); 
     int spaceWidth = fm.stringWidth(" "); 
     int centerPos = (frameWidth/2) - (titleWidth/2); 
     int spaceCount = centerPos/spaceWidth; 
     String pad = ""; 
     pad = String.format("%" + (spaceCount - 14) + "s", pad); 
     frame.setTitle(pad + currentTitle); 

    } 
    
    public void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

        }
    }
    
    public void server() throws FileNotFoundException, UnsupportedEncodingException{
        server s =new server();
        s.get_json();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(817, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(427, 427, 427))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new window().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
    }

    
}

