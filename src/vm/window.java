package vm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class window extends javax.swing.JFrame implements ActionListener
{
    
    JButton button;
  
    Toolkit t            = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int ancho            = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto             = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int i                = 0;
    int c                = 0;
    int x                = 300;
    int y                = 300;

    File fichero = new File(".");
        
    public window() throws FileNotFoundException, UnsupportedEncodingException  
    {
        this.setUndecorated(true);
        initComponents();         
        //Color redColor = new Color(78,75,75);   
        
        server s = new server();
        s.get_json();    
        
        if(s.json_airlines.length!=0)
        {
            JLabel titleLabel;
            JLabel icono;
            
            
            titleLabel = new JLabel("Select a virtual machine");
            
            ImageIcon icon = new ImageIcon(fichero.getAbsolutePath()+"/build/classes/files/ink.png");
            icono = new JLabel(icon);
            icono.setBounds(ancho/2-340,95, 50, 50);
     
            
            titleLabel.setBounds(ancho/2-260,20, 600, 200);
            titleLabel.setFont(new Font("Arial", Font.PLAIN, 50));
            
            this.add(titleLabel);
            this.add(icono);
            
        }
        else
        {
            
            this.setIconImage(new ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/InkIcon.png")).getImage()); 
            this.getContentPane().setBackground(Color.white);
            //this.setResizable(false);
            this.setExtendedState(this.MAXIMIZED_BOTH);
            //this.setAlwaysOnTop(false);
            //this.setFocusable(false);
            //this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
            
            JLabel titleLabel;
            JLabel icono;
            ImageIcon icon = new ImageIcon(fichero.getAbsolutePath()+"/build/classes/files/ink.png");
            icono = new JLabel(icon);
            icono.setBounds(ancho/2-240,alto/2-25, 50, 50);
            titleLabel = new JLabel("No there virtual machines");
            titleLabel.setBounds(ancho/2-170,alto/2-100, 400, 200);
            titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            this.add(titleLabel);
            this.add(icono);
        }
        
        while (i<s.json_airlines.length) 
        {  
            if(s.json_airlines.length>4)
            {   
                button = new JButton(s.json_airlines[i]);              
                button.setBounds(x,y,240,80);
                //a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                button.setBorder(new LineBorder(Color.BLACK));
                button.setBackground(Color.white);
                if(ancho-(button.getX()+240)<=300)
                {
                  y+=140;  
                  x=300;
                  button.setBounds(x,y,240,80);
                }   
                add(button);
                button.addActionListener(this);
                            
                x+=300;
                                
            }
            if(s.json_airlines.length==4)
            {               
                if (i==0)
                {
                    button = new JButton(s.json_airlines[i]);              
                    button.setBounds(ancho/2+40,alto/2-100,340,100);
                    //a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);                    
                    
                }
                
           
                if(i==1)
                {
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2+40,alto/2+50,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);                       
                }
                if(i==2)
                {
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2-350,alto/2+50,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);	                       
                }
                if(i==3)
                {
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2-350,alto/2-100,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);	                        
                }           
            }
            
            
            if(s.json_airlines.length == 3)
            {
                if(i==0) 
                {
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2-170,alto/2-60,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);                                                                         
                }
                if(i==1)
                { 
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2-520,alto/2-60,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);       
                }
                if(i==2)
                {
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2+180,alto/2-60,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);                              
                }
            }
            
            if(s.json_airlines.length==2)
            {                      
                if(i==0)
                {                  
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2+10,alto/2-60,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);
                }
                
                if(i==1)
                {        
                    button = new JButton(s.json_airlines[i]);  
                    button.setBounds(ancho/2-360,alto/2-60,340,100);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setBackground(Color.white);
                    add(button);
                    button.addActionListener(this);                                       
                }               
            }
            
             if(s.json_airlines.length==1)
             {                                       
                button = new JButton(s.json_airlines[i]);  
                button.setBounds(ancho/2-170,alto/2-50,340,100);
                button.setBorder(new LineBorder(Color.BLACK));
                button.setBackground(Color.white);
                add(button);
                button.addActionListener(this);
             }
                      
            this.setIconImage(new ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/InkIcon.png")).getImage()); 
            this.getContentPane().setBackground(Color.white);
            //this.setResizable(false);
            this.setExtendedState(this.MAXIMIZED_BOTH);
            //this.setAlwaysOnTop(false);
            //this.setFocusable(false);
            //this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);           
            i++;
        }       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        open_file(fichero.getAbsolutePath()+"/build/classes/files/ink"+e.getActionCommand()+".rdp");	
    }
    
    public void open_file(String archivo)
    {

     try 
     {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) 
     {

            System.out.println(ex);

        }
    }
    
    public void server() throws FileNotFoundException, UnsupportedEncodingException
    {
        server s = new server();
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
            .addGap(0, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    new window().setVisible(true);
                } catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void run() 
    {
        
    }

    


    
}

