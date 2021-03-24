/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author KOKE
 */
public class PoblacionTablero {
    
    int[][] matrizTablero;
    ArrayList <Individuo> reinas;
    int tamTablero;

    public PoblacionTablero(int tamTablero) {

        this.tamTablero = tamTablero;
        matrizTablero = new int[tamTablero][tamTablero];
        reinas = new ArrayList<>();
       
        for (int i = 0; i < tamTablero; i++) {
            reinas.add(new Individuo(tamTablero));
        }

        int tamInicial = reinas.size();
        int cantidadEliminados = 0;
        do {

            eliminarRepetidos();
            cantidadEliminados = tamInicial - reinas.size();
            //System.out.println("Elimine..+ " + cantidadEliminados );

            if (cantidadEliminados > 0) {
                for (int i = 0; i < cantidadEliminados; i++) {
                    reinas.add(new Individuo(tamTablero));

                }
            }
            
            

        } while (cantidadEliminados > 0);

        
        
        for (int fila = 0; fila < tamTablero; fila++) {
            for (int col = 0; col < tamTablero; col++) {
                matrizTablero[fila][col] = 0;
            }
        }
        
        
        for(int i =0;  i<reinas.size(); i++){
            matrizTablero[reinas.get(i).getPosY()][reinas.get(i).getPosX()] = 1;
        
        }
        
        
        
         for (int fila = 0; fila < tamTablero; fila++) {
            for (int col = 0; col < tamTablero; col++) {
                System.out.print("  "+matrizTablero[fila][col]);
            }
            System.out.println();
        }



 
    }

    public void eliminarRepetidos() {        
       
        Set <Individuo> hashSet = new HashSet<>(reinas);
        reinas.clear();
        reinas.addAll(hashSet);

    }

    public int[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(int[][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }

    public ArrayList<Individuo> getReinas() {
        return reinas;
    }

    public void setReinas(ArrayList<Individuo> reinas) {
        this.reinas = reinas;
    }

    public int getTamTablero() {
        return tamTablero;
    }

    public void setTamTablero(int tamTablero) {
        this.tamTablero = tamTablero;
    }
    
    
    
    
    public static void main(String[] args) {
        
        PoblacionTablero tablero1 = new PoblacionTablero(8);
        for(int i = 0; i<tablero1.getReinas().size(); i++)
        System.out.println("Individuo "+ (i+1) +" con posX: " + tablero1.getReinas().get(i).getPosX()+ " con posY: " + tablero1.getReinas().get(i).getPosY() );
              
        
    }

}
