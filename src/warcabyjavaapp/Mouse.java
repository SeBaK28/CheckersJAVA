/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warcabyjavaapp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Sebastian
 */
public class Mouse implements MouseListener {
    
    public Mouse(Gra gra, WarcabyJavaAPP panel) {
        this.gra = gra;
        this.panel = panel;
    }
    
    int x1=-1,y1=-1,i,j;
    int kolorInt;
    
    Plansza p1 = new Plansza();
    Gra gra = new Gra();
    WarcabyJavaAPP panel;
    int[][] kolor = p1.Pole();
    
    boolean pierwszyGracz = true;
    
    void zmianaTury(){
        pierwszyGracz = !pierwszyGracz;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int wartoscX=e.getX(); //-8
        int wartoscY=e.getY(); //-30
        System.out.println(wartoscX + ", " + wartoscY);        
        
        i=wartoscX/50;
        j=wartoscY/50;
        
        
        
        if(x1==-1 || y1==-1){
            x1=i;
            y1=j;
        }else{
            if(x1 == i && y1 ==j){
                System.out.println("Wybrano to samo pole");
                x1=-1;
                y1=-1;
                return;
            }
            
            int x2=i;
            int y2=j;
            

            boolean sukces = gra.wykonajRuch(x1, y1, x2, y2, pierwszyGracz);
            zmianaTury();
            
            if(!sukces){
                System.out.println(sukces);
                System.out.println("Nieprawidlowy ruch");
            }
            
            panel.repaint();
            
            

            System.out.println("Start: " + x1 + "," + y1 + " -> Cel: " + i + "," + j);
            System.out.println("Pionek: " + gra.plansza[y1][x1] + " | Cel: " + gra.plansza[y2][x2]);
            System.out.println(pierwszyGracz? "Player 1's Turn (zolty)" : "Player 2's Turn (czerwony)");
            
            x1=-1;
            y1=-1;
        }       
    }

    @Override
    public void mousePressed(MouseEvent e) {      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
