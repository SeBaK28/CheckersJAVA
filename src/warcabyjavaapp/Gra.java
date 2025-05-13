/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warcabyjavaapp;

import java.awt.*;
import java.awt.font.NumericShaper.Range;

/**
 *
 * @author Sebastian
 */
public class Gra {
    public int[][] plansza;

    public String informacja = " ";    
    
    public Gra() {
        plansza = new int[8][8];
        ustawPionki();
    }
    
    boolean pierwszyGracz = true;
    boolean koniecGry = false;
    
    void zmianaTury(){
        pierwszyGracz = !pierwszyGracz;
    }

    private void ustawPionki() {
        // Białe pionki (1)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    plansza[i][j] = 11;
                }
            }
        }
        
        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    plansza[i][j] = 0;
                }
            }
        }

        // Czerwone pionki (2)
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    plansza[i][j] = 22;
                }
            }
        }
    }
    
//    public boolean CzyJestPionek(int x11,int y11){
//        int pole = plansza[x11][y11];
//        if(pole == 0) return false;
//        return true;
//    };
    
    

    public boolean wykonajRuch(int x1, int y1, int x2, int y2,boolean twojRuch) {
        //Czy w zakresie
        if (!czyWZakresie(x1, y1) || !czyWZakresie(x2, y2)) return false;

        //Czy na pierwszym polu jest pionek
        int pionek = plansza[y1][x1];
        if(pionek == 0) return false;        

        //Czy pole docelowe jest puste
        if (plansza[y2][x2] != 0) return false;        

        // Sprawdź, czy ruch jest ukośny
        int dx = Math.abs(x2 - x1);
//        int dy = y2-y1;
        int dy = Math.abs(y2 - y1);       
                        
        
        if (dx == 1 && ((pionek == 11 && twojRuch) || (pionek == 22  && !twojRuch))) {            
            plansza[y2][x2] = pionek;
            plansza[y1][x1] = 0;
            promujDoKrola(x2, y2, pionek);
            System.out.println(1);
            return true;
        }  
        if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
            int xSrodek=0;
            int ySrodek=0;
            //czerwony na prawy gore
            if((x1<x2) && (y1>y2) ){
                xSrodek = x1 + dx/2;
                ySrodek = y1 - dy/2; 
                promujDoKrola(x2, y2, pionek);
                System.out.println(2);
//                System.out.println(1);
            }            
            //zolty na prawy dol
            if((x1<x2)&&(y1<y2)){
                xSrodek = x1 + dx/2;
                ySrodek = y1 + dy/2; 
                promujDoKrola(x2, y2, pionek);
                System.out.println(3);
            }            
            //zolty na lewy dol
            if((x1>x2)&&(y1<y2)){
                xSrodek = x1 - dx/2;
                ySrodek = y1 + dy/2; 
                promujDoKrola(x2, y2, pionek);
                System.out.println(4);
            }             
            //czerwony na lewa gore
            if((x1>x2)&&(y1>y2)){
                xSrodek = x1 - dx/2;
                ySrodek = y1 - dy/2;
                promujDoKrola(x2, y2, pionek);
                System.out.println(5);
            }            
            int pionekSrodek = plansza[ySrodek][xSrodek];
           

            // Sprawdź, czy w środku jest pionek przeciwnika
            if ((pionek == 11 && pionekSrodek == 22 && twojRuch) || (pionek == 22 && pionekSrodek == 11 && !twojRuch)) {
                plansza[y2][x2] = pionek;
                plansza[y1][x1] = 0;
                plansza[ySrodek][xSrodek] = 0; // usuń zbitego pionka
                promujDoKrola(x2, y2, pionek);
                System.out.println(6);
                return true;
            }
        }
        if((pionek == 111 && twojRuch) || (pionek == 222 && !twojRuch)){
            int dX = x2-x1;
            int dY = y2-y1;
            
            if(Math.abs(dX) == Math.abs(dY)){
                int iloscOczekX = dX/Math.abs(dX);
                int iloscOczekY = dY/Math.abs(dY);
                
                int XX = x1+iloscOczekX;
                int YY = y1+iloscOczekY;
                boolean czyJestPrzeciwnik = false;
                int xZbity = -1;
                int yZbity = -1;
                
                while(XX!=x2 && YY!= y2){
                    int pole = plansza[YY][XX];
                    if(pole !=0){
                        if((czyJestPrzeciwnik)|| 
                        (twojRuch&&(pole ==11 || pole ==111))||
                        (!twojRuch && pole ==22 || pole == 222)){
                            System.out.println(7);
                            return false;
                        }
                        czyJestPrzeciwnik =true;
                        xZbity = XX;
                        yZbity = YY;
                    }
                    XX+=iloscOczekX;
                    YY+=iloscOczekY;
                }
                if(czyJestPrzeciwnik && plansza[y2][x2] == 0){
                    plansza[y2][x2] = pionek;
                    plansza[y1][x1] = 0;
                    plansza[yZbity][xZbity] = 0; // usuń zbitego pionka
                    System.out.println(8);
                    return true;
                }else{
                    // Normalny ruch króla po pustej przekątnej
                    plansza[y2][x2] = pionek;
                    plansza[y1][x1] = 0;
                    return true;
                }
            }
        }
                                          
        return false;
    }
    
    
    public void promujDoKrola(int x, int y, int pionek){
        if(pionek == 11 && y==plansza.length -1){
            plansza[y][x] = 111;
        }
        else if(pionek == 22 && y == 0){
            plansza[y][x]=222;
        }
    }
        
    public int ilePionkow(int kolor){
        int liczba=0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(plansza[i][j] == kolor){
                    liczba++;
                }
            }
        }
        return liczba;
    }    
    
    public String wygranyKolor(){
        if(ilePionkow(11)==0){
            koniecGry=true;
            return "Czerwony";
        }
        if(ilePionkow(22)==0){
            koniecGry=true;
            return "Zolty";
        }     
        return "";
    }
    
    
        
    private boolean czyWZakresie(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
