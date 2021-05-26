/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSPinclinaciones;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Cruza {
    //genotipo length 5
    //maskIndices[4]= [-1,-1,-1,-1]
    //maskIndices[4]= [-1,-1, 1,-1] al final va ser-----> [x,x,x,x]
    //maskIndices[4]= [-1, 2,-1,-1]
    //maskIndices[4]= [-1, 2, 1,-1]
    //maskIndices[4]= [-1, 2, 1, 4] 
    //maskIndices[4]= [ 3, 2, 1, 4]

    public static Individuo cruzaAsexual(Individuo padre, Individuo madre, int matrizCargada[][], int[] inclinaciones) {
        int maskIndices[] = new int[padre.getGenotipo().length - 1];
        // creo la mascara de índices 
        for (int ii = 0; ii < maskIndices.length; ii++) {
            maskIndices[ii] = -1;
        }
        for (int i = 1; i <= maskIndices.length; i++) {
            int ind = generarIndiceValido(maskIndices);
            maskIndices[ind] = i;
        }
        int[] genotipoNuevo1 = new int[padre.getGenotipo().length];
        int[] genotipoNuevo2 = new int[madre.getGenotipo().length];
        genotipoNuevo1[0] = padre.getGenotipo()[0];
        genotipoNuevo2[0] = madre.getGenotipo()[0];
        // construimos los nuevos genotipos
        for (int x = 1; x < genotipoNuevo1.length; x++) {
            genotipoNuevo1[maskIndices[x - 1]] = padre.getGenotipo()[x];
            genotipoNuevo2[maskIndices[x - 1]] = madre.getGenotipo()[x];
        }
        Individuo hijo1 = new Individuo(genotipoNuevo1,matrizCargada, inclinaciones);
        Individuo hijo2 = new Individuo(genotipoNuevo2, matrizCargada,inclinaciones);

        ArrayList<Individuo> lista = new ArrayList<>();
        lista.add(madre);
        lista.add(padre);
        lista.add(hijo1);
        lista.add(hijo2);
        return retornaMejor(lista);
    }

    private static Individuo retornaMejor(ArrayList<Individuo> lista) {
        Individuo mejor = lista.get(0);

        for (int x = 1; x < lista.size(); x++) {
            if (lista.get(x).getFitnessGeneral() < mejor.getFitnessGeneral()) {
                mejor = lista.get(x);
            }
        }
        return mejor;
    }

    public static int generarIndiceValido(int[] ruta) {
        Random r = new Random();
        int indice = r.nextInt(ruta.length);
        while (ruta[indice] != -1) {
            indice = r.nextInt(ruta.length);
        }

        return indice;
    }

}
   


    

