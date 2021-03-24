/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Individuo {
    
    int posX;
    int posY;
    int nAtaques;
   

    public Individuo(int tamTablero) {
        Random ran = new Random();

        this.posX = ran.nextInt(tamTablero);
        this.posY = ran.nextInt(tamTablero);
        this.nAtaques = 0;

    }

    public Individuo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.nAtaques = 0;
    }
    
    
    public void calcularFitness(PoblacionTablero tablero1){
        int [][] tablerito = tablero1.getMatrizTablero();
        
           for (int fila = 0; fila < tablero1.getTamTablero(); fila++) {
            for (int col = 0; col < tablero1.getTamTablero(); col++) {
                
                if(tablerito[fila][col] == 1){
                
                
                
                }
                
            }
            System.out.println();
        }
        
       
        
    }



    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getnAtaques() {
        return nAtaques;
    }

    public void setnAtaques(int nAtaques) {
        this.nAtaques = nAtaques;
    }
    
    
    
    
    
}
