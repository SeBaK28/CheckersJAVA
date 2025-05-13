/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package warcabyjavaapp;

import java.awt.*;
import java.awt.event.*;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author Sebastian
 */
public class WarcabyJavaAPP extends JPanel{
    
    
    public static void main(String[] args) {
        JFrame okno = new JFrame("Warcaby");
        Gra gra = new Gra();
        WarcabyJavaAPP panel = new WarcabyJavaAPP(gra);
        okno.add(panel);
        okno.pack();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        okno.setVisible(true);
        okno.setResizable(false);
    }
    
    public Gra gra;
    int wys = 450;
    int szer = 600;
    
    public WarcabyJavaAPP(Gra gra){
        this.gra = gra;
        this.setPreferredSize(new Dimension(wys,szer));
        this.addMouseListener(new Mouse(gra,this));
    }
    
    
    @Override
     public void paintComponent(Graphics g){
        super.paintComponent(g);        
        
        setBackground(Color.GRAY);
        
        //Plansza
        for(int i =0; i<8;i++){
            for (int j = 0; j < 8; j++) {
                if((i+j)%2==0){
                    g.setColor(Color.WHITE);
                    
                }else{
                    g.setColor(Color.BLACK);
                }
                g.fillRect(0+(i*50),0+(j*50),50,50);
                
            }
        }
        
        //Pionki
        int temp[][] = gra.plansza;

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(temp[j][i] == 22)
                {
                    g.setColor(Color.red);
                    g.fillOval(5 + (i * 50), 5 + (j * 50), 40, 40); 
                }
                else if(temp[j][i] == 11)
                {
                    g.setColor(Color.YELLOW);                   
                    g.fillOval(5 + (i * 50), 5 + (j * 50), 40, 40);
                }
            }
        } 
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(temp[j][i] == 222)
                {
                    g.setColor(Color.red);
                    g.fillOval(5 + (i * 50), 5 + (j * 50), 40, 40); 
                    g.setColor(Color.WHITE);
                    g.fillOval(5 + (i * 50), 5 + (j * 50), 20, 20); 
                }
                else if(temp[j][i] == 111)
                {                                        
                    g.setColor(Color.YELLOW);                   
                    g.fillOval(5 + (i * 50), 5 + (j * 50), 40, 40);
                    g.setColor(Color.BLACK);
                    g.fillOval(5 + (i * 50), 5 + (j * 50), 20, 20); 
                }
            }
        } 
        
        
        g.setFont(new Font("Arial", Font.BOLD, 16));
        String kolej ="Kolej: " + (gra.pierwszyGracz? "Zolty": "Czerwony");        
        if(!gra.wygranyKolor().isEmpty()){
            kolej = "Wygrywa" + gra.wygranyKolor();
        }
        g.setColor(Color.BLACK);
        g.drawString(kolej, szer/4, 420);
        g.drawString(gra.informacja, (szer/4)-gra.informacja.length(), 440);
     }
}
     



//    /**
//     * @param args the command line arguments
//     */
//    
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        
//        Plansza pl = new Plansza();
//        int tmp[][] = pl.Pole();
//        
//        setBackground(Color.BLACK);
//        
//        //Plansza
//        for(int i =0; i<8;i++){
//            for (int j = 0; j < 8; j++) {
//                if(tmp[i][j]==1){
//                    g.setColor(Color.BLACK);
//                    
//                }else{
//                    g.setColor(Color.WHITE);
//                }
//                g.fillRect(0+(i*50),0+(j*50),50,50);
//                
//            }
//        }
//        
//        //Pionki
//        Pionki p = new Pionki(); 
//        int temp[][] = p.ustawPionek();
//
//        for(int i = 0; i < 8; i++)
//        {
//            for(int j = 0; j < 8; j++)
//            {
//                if(temp[j][i] == 2)
//                {
//                    g.setColor(Color.red);
//                    g.fillOval(5 + (i * 50), 5 + (j * 50), 40, 40); 
//                }
//                else if(temp[j][i] == 1)
//                {
//                    g.setColor(Color.white);                   
//                    g.fillOval(5 + (i * 50), 5 + (j * 50), 40, 40);
//                }
//            }
//        }        
//    }
//    
//    public static void main(String[] args) {
//        WarcabyJavaAPP w = new WarcabyJavaAPP();
//        JFrame frame = new JFrame("Szachownica");
//        frame.setSize(416,438);
//        frame.setResizable(false);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Mouse m = new Mouse();
//        frame.addMouseListener(m);
//        frame.add(w);
//        while(true)
//        {
//            frame.repaint();
//        }
//        
//        
//    }
     
    