/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Muta {

    public static void  mutarGenotipo(double prob, Individuo ind) {
        double aux = Math.random();
        if (aux <= prob) {
            
            Random ran = new Random();
            int pos1 = ran.nextInt(ind.getGenotipo().length - 1) + 1;
            int pos2 = ran.nextInt(ind.getGenotipo().length - 1) + 1;
            
            int auxPos1 = ind.getGenotipo()[pos1];
            
            ind.getGenotipo()[pos1] = ind.getGenotipo()[pos2];
            ind.getGenotipo()[pos2] = auxPos1;

            //System.out.print("ANTES>> "+ind.getFitness());
            ind.actualizarIndividuo();
            //System.out.println(" DESPUES>> "+ind.getFitness());

        }

    }
}
