/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warcabyjavaapp;

/**
 *
 * @author Sebastian
 */
public class Gra {
    public int[][] plansza;

    public Gra() {
        plansza = new int[8][8];
        ustawPionki();
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

        public boolean wykonajRuch(int x1, int y1, int x2, int y2,boolean pionekNr) {
        // Sprawdź, czy współrzędne są w zakresie
        if (!czyWZakresie(x1, y1) || !czyWZakresie(x2, y2)) return false;

        // Sprawdź, czy na polu startowym jest pionek
        int pionek = plansza[y1][x1];
        if (pionek == 0) return false;

        // Sprawdź, czy pole docelowe jest puste
        if (plansza[y2][x2] != 0) return false;

        // Sprawdź, czy ruch jest ukośny o jedno pole
        int dx = Math.abs(x2 - x1);
        int dy = y2 - y1;

        if (dx == 1 && ((pionek == 11 && dy == 1 && pionekNr==true) || (pionek == 22 && dy == -1 && pionekNr==false))) {
            // Ruch prosty
            plansza[y2][x2] = pionek;
            plansza[y1][x1] = 0;
            return true;
        }  
        if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
            int xSrodek = x1 + dx / 2;
            int ySrodek = y1 + dy / 2;
            int pionekSrodek = plansza[ySrodek][xSrodek];

            // Sprawdź, czy w środku jest pionek przeciwnika
            if ((pionek == 11 && pionekSrodek == 22 && pionekNr) || (pionek == 22 && pionekSrodek == 11 && !pionekNr)) {
                plansza[y2][x2] = pionek;
                plansza[y1][x1] = 0;
                plansza[ySrodek][xSrodek] = 0; // usuń zbitego pionka
                return true;
            }
        }
        return false;
    }
        

    
        
    private boolean czyWZakresie(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
