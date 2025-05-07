/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warcabyjavaapp;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Sebastian
 */
public class Plansza{
    
    boolean[][] czyZajetePole;
    int[][] kolorPola; //1-czarny 2-bialy
    
    
    
    public int[][] Pole(){
        int[][] kolorPola = new int[8][8];//2-bialy,1-czarny
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2==1) kolorPola[i][j]=1;                
            }
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2==0) kolorPola[i][j] =2;
                
            }
        }
    return kolorPola;
    }

}
