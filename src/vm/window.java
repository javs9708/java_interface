package vm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class window extends javax.swing.JFrame implements ActionListener, Runnable{
    
    JButton a;
    JButton b;
    JButton c;
    JButton d;
    
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    File fichero = new File(".");
        
    public window() throws FileNotFoundException, UnsupportedEncodingException  {
        this.setUndecorated(true);
        initComponents();         
        //Color redColor = new Color(78,75,75);   
        
        server s = new server();
        s.get_json();    
        
      
        if(s.jsonAirlines.length!=0){
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
        else{
            
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
        
        for (int i=0;i<s.jsonAirlines.length;i++) {  
            if(s.jsonAirlines.length==4){
                switch(s.jsonAirlines[i]){
                    case "airFrance":
                        a=new JButton("");
                        a.setBounds(ancho/2+40,alto/2-100,340,100);
                        a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                        a.setBorder(new LineBorder(Color.BLACK));
                        a.setBackground(Color.white);
                        add(a);
                        a.addActionListener(this);
                        break;
                    case "avianca":
                        b=new JButton("");
                        b.setBounds(ancho/2+40,alto/2+50,340,100);
                        b.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/av.png")));
                        b.setBorder(new LineBorder(Color.BLACK));
                        b.setBackground(Color.white);
                        add(b);
                        b.addActionListener(this);
                        break;
                    case "klm":
                        c=new JButton("");
                        c.setBounds(ancho/2-350,alto/2+50,340,100);
                        c.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/KLM.jpg")));
                        c.setBorder(new LineBorder(Color.BLACK));
                        c.setBackground(Color.white);
                        add(c);
                        c.addActionListener(this);
                        break;
                    case "aeroMexico":
                        d=new JButton("");
                        d.setBounds(ancho/2-350,alto/2-100,340,100);
                        d.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/aeroMexico.png")));
                        d.setBorder(new LineBorder(Color.BLACK));
                        d.setBackground(Color.white);
                        add(d);
                        d.addActionListener(this);
                        break;
                }
            }
            if(s.jsonAirlines.length==3){
                if(i==0) {
                     if(s.jsonAirlines[i].equals("airFrance")){
                        a=new JButton("");
                        a.setBounds(ancho/2-170,alto/2-60,340,100);
                        a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                        a.setBorder(new LineBorder(Color.BLACK));
                        a.setBackground(Color.white);
                        add(a);
                        a.addActionListener(this);                        
                     }
                     if(s.jsonAirlines[i].equals("avianca")){
                        b=new JButton("");
                        b.setBounds(ancho/2-170,alto/2-60,340,100);
                        b.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/av.png")));
                        b.setBorder(new LineBorder(Color.BLACK));
                        b.setBackground(Color.white);
                        add(b);
                        b.addActionListener(this);                        
                     }
                     if(s.jsonAirlines[i].equals("klm")){
                        c=new JButton("");
                        c.setBounds(ancho/2-170,alto/2-60,340,100);
                        c.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/KLM.jpg")));
                        c.setBorder(new LineBorder(Color.BLACK));
                        c.setBackground(Color.white);
                        add(c);
                        c.addActionListener(this);                        
                     }
                     if(s.jsonAirlines[i].equals("aeroMexico")){
                        d=new JButton("");
                        d.setBounds(ancho/2-170,alto/2-60,340,100);
                        d.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/aeroMexico.png")));
                        d.setBorder(new LineBorder(Color.BLACK));
                        d.setBackground(Color.white);
                        add(d);
                        d.addActionListener(this);                        
                     }
                }
                if(i==1){ 

                    if(s.jsonAirlines[i].equals("airFrance")){
                        a=new JButton("");
                        a.setBounds(ancho/2-520,alto/2-60,340,100);
                        a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                        a.setBorder(new LineBorder(Color.BLACK));
                        a.setBackground(Color.white);
                        add(a);
                        a.addActionListener(this);
                    }
                    
                    if(s.jsonAirlines[i].equals("avianca")){
                        b=new JButton("");
                        b.setBounds(ancho/2-520,alto/2-60,340,100);
                        b.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/av.png")));
                        b.setBorder(new LineBorder(Color.BLACK));
                        b.setBackground(Color.white);
                        add(b);
                        b.addActionListener(this);
                    }
                    
                    if(s.jsonAirlines[i].equals("klm")){
                        c=new JButton("");
                        c.setBounds(ancho/2-520,alto/2-60,340,100);
                        c.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/KLM.jpg")));
                        c.setBorder(new LineBorder(Color.BLACK));
                        c.setBackground(Color.white);
                        add(c);
                        c.addActionListener(this);
                    }
                    
                    if(s.jsonAirlines[i].equals("aeroMexico")){
                        d=new JButton("");
                        d.setBounds(ancho/2-520,alto/2-60,340,100);
                        d.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/aeroMexico.png")));
                        d.setBorder(new LineBorder(Color.BLACK));
                        d.setBackground(Color.white);
                        add(d);
                        d.addActionListener(this);
                    }
                }
                    if(i==2){
                        if(s.jsonAirlines[i].equals("airFrance")){
                            a=new JButton("");
                            a.setBounds(ancho/2+180,alto/2-60,340,100);
                            a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                            a.setBorder(new LineBorder(Color.BLACK));
                            a.setBackground(Color.white);
                            add(a);
                            a.addActionListener(this);
                        }
                    
                        if(s.jsonAirlines[i].equals("avianca")){
                            b=new JButton("");
                            b.setBounds(ancho/2+180,alto/2-60,340,100);
                            b.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/av.png")));
                            b.setBorder(new LineBorder(Color.BLACK));
                            b.setBackground(Color.white);
                            add(b);
                            b.addActionListener(this);
                        }

                        if(s.jsonAirlines[i].equals("klm")){
                            c=new JButton("");
                            c.setBounds(ancho/2+180,alto/2-60,340,100);
                            c.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/KLM.jpg")));
                            c.setBorder(new LineBorder(Color.BLACK));
                            c.setBackground(Color.white);
                            add(c);
                            c.addActionListener(this);
                        }

                        if(s.jsonAirlines[i].equals("aeroMexico")){
                            d=new JButton("");
                            d.setBounds(ancho/2+180,alto/2-60,340,100);
                            d.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/aeroMexico.png")));
                            d.setBorder(new LineBorder(Color.BLACK));
                            d.setBackground(Color.white);
                            add(d);
                            d.addActionListener(this);
                        }                       
                }
            }
            
            if(s.jsonAirlines.length==2){                      
                if(i==0){                  
                    if(s.jsonAirlines[i].equals("airFrance")){
                        a=new JButton(""); 
                        a.setBounds(ancho/2+10,alto/2-60,340,100);
                        a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                        a.setBorder(new LineBorder(Color.BLACK));
                        a.setBackground(Color.white);
                        add(a);
                        a.addActionListener(this);
                    }

                    if(s.jsonAirlines[i].equals("avianca")){
                        b=new JButton("");
                        b.setBounds(ancho/2+10,alto/2-60,340,100);
                        b.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/av.png")));
                        b.setBorder(new LineBorder(Color.BLACK));
                        b.setBackground(Color.white);
                        add(b);
                        b.addActionListener(this);
                    }

                    if(s.jsonAirlines[i].equals("klm")){
                        c=new JButton("");
                        c.setBounds(ancho/2+10,alto/2-60,340,100);
                        c.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/KLM.jpg")));
                        c.setBorder(new LineBorder(Color.BLACK));
                        c.setBackground(Color.white);
                        add(c);
                        c.addActionListener(this);
                    }
                    if(s.jsonAirlines[i].equals("aeroMexico")){
                        d=new JButton("");
                        d.setBounds(ancho/2+10,alto/2-60,340,100);
                        d.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/aeroMexico.png")));
                        d.setBorder(new LineBorder(Color.BLACK));
                        d.setBackground(Color.white);
                        add(d);
                        d.addActionListener(this);
                    }
                }
                
                if(i==1){
                    if(s.jsonAirlines[i].equals("airFrance")){
                        a=new JButton(""); 
                        a.setBounds(ancho/2-360,alto/2-60,340,100);
                        a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                        a.setBorder(new LineBorder(Color.BLACK));
                        a.setBackground(Color.white);
                        add(a);
                        a.addActionListener(this);
                   
                    }

                    if(s.jsonAirlines[i].equals("avianca")){
                        b=new JButton("");
                        b.setBounds(ancho/2-360,alto/2-60,340,100);
                        b.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/av.png")));
                        b.setBorder(new LineBorder(Color.BLACK));
                        b.setBackground(Color.white);
                        add(b);
                        b.addActionListener(this);
                  
                    }

                    if(s.jsonAirlines[i].equals("klm")){
                        c=new JButton("");
                        c.setBounds(ancho/2-360,alto/2-60,340,100);
                        c.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/KLM.jpg")));
                        c.setBorder(new LineBorder(Color.BLACK));
                        c.setBackground(Color.white);
                        add(c);
                        c.addActionListener(this);
               
                    }
                    if(s.jsonAirlines[i].equals("aeroMexico")){
                        d=new JButton("");
                        d.setBounds(ancho/2-360,alto/2-60,340,100);
                        d.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/aeroMexico.png")));
                        d.setBorder(new LineBorder(Color.BLACK));
                        d.setBackground(Color.white);
                        add(d);
                        d.addActionListener(this);
               
                    }
                }               
            }
            
             if(s.jsonAirlines.length==1){                                       
                if(s.jsonAirlines[i].equals("airFrance")){
                    a=new JButton(""); 
                    a.setBounds(ancho/2-170,alto/2-50,340,100);
                    a.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/af.png")));
                    a.setBorder(new LineBorder(Color.BLACK));
                    a.setBackground(Color.white);
                    add(a);
                    a.addActionListener(this);
                }

                if(s.jsonAirlines[i].equals("avianca")){
                    b=new JButton("");
                    b.setBounds(ancho/2-170,alto/2-50,340,100);
                    b.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/av.png")));
                    b.setBorder(new LineBorder(Color.BLACK));
                    b.setBackground(Color.white);
                    add(b);
                    b.addActionListener(this);
                }

                if(s.jsonAirlines[i].equals("klm")){
                    c=new JButton("");
                    c.setBounds(ancho/2-170,alto/2-50,340,100);
                    c.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/KLM.jpg")));
                    c.setBorder(new LineBorder(Color.BLACK));
                    c.setBackground(Color.white);
                    add(c);
                    c.addActionListener(this);
                }
                if(s.jsonAirlines[i].equals("aeroMexico")){
                    d=new JButton("");
                    d.setBounds(ancho/2-170,alto/2-50,340,100);
                    d.setIcon(new javax.swing.ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/aeroMexico.png")));
                    d.setBorder(new LineBorder(Color.BLACK));
                    d.setBackground(Color.white);
                    add(d);
                    d.addActionListener(this);
                }
                
             }
            this.setIconImage(new ImageIcon((fichero.getAbsolutePath()+"/build/classes/files/InkIcon.png")).getImage()); 
            this.getContentPane().setBackground(Color.white);
            //this.setResizable(false);
            this.setExtendedState(this.MAXIMIZED_BOTH);
            //this.setAlwaysOnTop(false);
            //this.setFocusable(false);
            //this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
 
        }             
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==a) {
            abrirarchivo(fichero.getAbsolutePath()+"/build/classes/files/inkairFrance.rdp");
        }
        
        if (e.getSource()==b) {
            abrirarchivo(fichero.getAbsolutePath()+"/build/classes/files/inkavianca.rdp");
        }
        if (e.getSource()==c) {
            abrirarchivo(fichero.getAbsolutePath()+"/build/classes/files/inkklm.rdp");
        }
        if (e.getSource()==d) {
            abrirarchivo(fichero.getAbsolutePath()+"/build/classes/files/inkaeroMexico.rdp");
        }
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
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
    }

    
}

